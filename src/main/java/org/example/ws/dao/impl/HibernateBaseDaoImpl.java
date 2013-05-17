package org.example.ws.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.lang.reflect.ParameterizedType;

import org.example.ws.dao.GenericDAO;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

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
	public T getObjectById(ID id) {
		return (T) this.getHibernateTemplate().get(this.getPersistentClass(),
				id);
	}

	// @Override
	// public T loadObjectById(ID id) {
	// return (T) this.getHibernateTemplate().load(this.getPersistentClass(),
	// id);
	// }

	@Override
	public T save(T entity) {
		Assert.notNull(entity);
		this.getHibernateTemplate().save(entity);
		return entity;
	}

	@Override
	public T saveOrUpdate(T entity) {
		Assert.notNull(entity);
		this.getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		Assert.notNull(entity);
		this.getHibernateTemplate().update(entity);
		return entity;
	}

	@Override
	public void executeDelOrUpdateCmd(final String cmd, final boolean isHql) {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = isHql ? session.createQuery(cmd) : session
						.createSQLQuery(cmd);
				query.executeUpdate();
				return null;
			}
		});
	}

	@Override
	public void executeDelOrUpdateCmdAndParams(final String cmd,
			final Object[] params, final boolean isHql) {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = isHql ? session.createQuery(cmd) : session
						.createSQLQuery(cmd);
				if (params != null) {
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
					}
				}
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
	public List<T> findListByParams(final String hql, final Object[] params) {
		List<T> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (params != null) {
							for (int i = 0; i < params.length; i++) {
								query.setParameter(i, params[i]);
							}
						}
						List<T> list = query.list();
						return list;
					}
				});
		return list;
	}

	@Override
	public List<T> findListByLength(final String hql, final int firstResult,
			final int maxResults) {
		List<T> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setFirstResult(firstResult);
						query.setMaxResults(maxResults);
						List<T> list = query.list();
						return list;
					}
				});
		return list;
	}

	@Override
	public List<T> findListByLengthAndParams(final String hql,
			final Object[] params, final int firstResult, final int maxResults) {
		List<T> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setFirstResult(firstResult);
						query.setMaxResults(maxResults);
						if (params != null) {
							for (int i = 0; i < params.length; i++) {
								query.setParameter(i, params[i]);
							}
						}
						List<T> list = query.list();
						return list;
					}
				});
		return list;
	}

	@Override
	public List<T> findListByPage(final String hql, final int pageNum,
			final int pageSize) {
		List<T> result = null;
		Object object = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query;
						try {
							query = session.getNamedQuery(hql);
						} catch (HibernateException e) {
							query = session.createQuery(hql);
						}
						if (pageNum > 0) {
							int maxResult = pageSize;
							if (pageSize < 1)
								maxResult = 1;
							int first = (pageNum - 1) * maxResult;
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
	public List<T> findListByPageAndParams(final String hql,
			final Object[] params, final int pageNum, final int pageSize) {
		List<T> result = null;
		Object object = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query;
						try {
							query = session.getNamedQuery(hql);
						} catch (HibernateException e) {
							query = session.createQuery(hql);
						}
						if (params != null) {
							int len = params.length;
							for (int i = 0; i < len; i++) {
								query.setParameter(i, params[i]);
							}
						}
						if (pageNum > 0) {
							int maxResult = pageSize;
							if (pageSize < 1)
								maxResult = 1;
							int first = (pageNum - 1) * maxResult;
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
	public T queryByHql(final String hql) {
		List<T> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						List<T> list = query.list();
						return list;
					}
				});
		if (list != null && list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public T queryByHqlAndParams(final String hql, final Object[] params) {
		List<T> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (params != null) {
							int len = params.length;
							for (int i = 0; i < len; i++) {
								query.setParameter(i, params[i]);
							}
						}
						List<T> list = query.list();
						return list;
					}
				});
		if (list != null && list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void refresh(T entity) {
		Assert.notNull(entity);
		getHibernateTemplate().refresh(entity);
	}

	@Override
	public void evict(T entity) {
		Assert.notNull(entity);
		getHibernateTemplate().evict(entity);
	}

	@Override
	public void clear() {
		getHibernateTemplate().clear();
	}

	@Override
	public void flush() {
		getHibernateTemplate().flush();
	}
}
