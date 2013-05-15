package org.example.ws.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.lang.reflect.ParameterizedType;

import org.example.ws.dao.GenericDAO;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@SuppressWarnings("unchecked")
public class HibernateBaseDaoImpl<T, ID extends Serializable> extends
		HibernateDaoSupport implements GenericDAO<T, ID> {

	private Class<T> persistentClass = null;

	protected Class<T> getPersistentClass() {
		if (this.persistentClass == null) {
			this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return this.persistentClass;
	}

	@Override
	public T loadObjectById(ID id) {
		return (T) this.getHibernateTemplate().get(this.getPersistentClass(),
				id);
	}

	@Override
	public T save(T entity) {
		try {
			this.getHibernateTemplate().save(entity);
			return entity;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public T saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		this.getHibernateTemplate().update(entity);
		return entity;
	}

	@Override
	public void executeDelOrUpdateHql(final String hql, final boolean isHql) {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = isHql ? session.createQuery(hql) : session
						.createSQLQuery(hql);
				query.executeUpdate();
				return null;
			}
		});

	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
		this.getSession().flush();
	}

	@Override
	public List<T> findAll() {
		List<T> list = this.getHibernateTemplate().loadAll(
				this.getPersistentClass());
		org.hibernate.Hibernate.initialize(list);
		return list;
	}

	@Override
	public List<T> findAllByLength(String hql, int offset, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAllByLengthCmd(final String hql, Object[] params,
			final int offset, final int length) {
		List<T> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setFirstResult(offset);
						query.setMaxResults(length);
						List<T> list = query.list();
						return list;
					}
				});
		return list;
	}

	@Override
	public List<T> findListByCmd(final String cmd, final Object[] params,
			final int page, final int count) {
		List<T> result = null;
		Object object = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query;
						try {
							query = session.getNamedQuery(cmd);
						} catch (HibernateException e) {
							query = session.createQuery(cmd);
						}
						if (params != null) {
							int len = params.length;
							for (int i = 0; i < len; i++) {
								query.setParameter(i, params[i]);
							}
						}
						if (page > 0) {
							int maxResult = count;
							if (count < 1)
								maxResult = 1;
							int first = (page - 1) * maxResult;
							query.setFirstResult(first);
							query.setMaxResults(maxResult);
						} else {
						}
						List<T> list = query.list();
						org.hibernate.Hibernate.initialize(list);
						return list;
					}
				});
		if (object != null)
			result = (List<T>) object;
		return result;
	}

	@Override
	public List<Object> findListByDynHql(String queryHql, final boolean isHql,
			final int page, final int count) {
		List<Object> result = null;
		final String fullHql = queryHql;
		if (fullHql != null) {
			Object object = this.getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException {

							Query query = isHql ? session.createQuery(fullHql)
									: session.createSQLQuery(fullHql);

							if (page > 0) {
								int maxResult = count;
								if (count < 1)
									maxResult = 1;
								int first = (page - 1) * maxResult;
								query.setFirstResult(first);
								query.setMaxResults(maxResult);
							}
							if (isHql) {
								return query.list();
							} else {
								return (List<Object[]>) query.list();
							}
						}
					});
			if (object != null)
				result = (List<Object>) object;
		}
		return result;
	}

	@Override
	public Object queryByDynHql(String queryHql, final boolean isHql) {
		Object result = null;
		final String fullHql = queryHql;
		if (fullHql != null) {
			Object object = this.getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException {
							Query query = isHql ? session.createQuery(fullHql)
									: session.createSQLQuery(fullHql);
							Object obj = query.list();
							return obj;
						}
					});
			if (object != null)
				result = object;
		}
		return result;
	}

	@Override
	public Object queryByCmd(final String cmd, final Object[] params) {
		Object avg = null;
		Object avgTemp = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query;
						try {
							query = session.getNamedQuery(cmd);
						} catch (HibernateException e) {
							query = session.createQuery(cmd);
						}

						if (params != null) {
							int len = params.length;
							for (int i = 0; i < len; i++) {
								query.setParameter(i, params[i]);
							}
						}
						return query.uniqueResult();
					}
				});
		if (avgTemp != null)
			avg = avgTemp;
		return avg;
	}

	@Override
	public String getCountHql(String hql) {
		int index = hql.indexOf("from");
		int endIndex = hql.indexOf("order by");
		endIndex = endIndex == -1 ? hql.length() : endIndex;
		if (index != -1) {
			return "select count(*) " + hql.substring(index, endIndex);
		}
		throw new RuntimeException();
	}

	@Override
	public Long getCount(String hql) {
		Query query = this.getSession().createQuery(hql);
		return (Long) query.uniqueResult();
	}

}
