package org.example.ws.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	/**
	 * 根据ID获取一个对象,获取最新
	 * 
	 * @param id
	 * @return
	 */
	T getObjectById(ID id);

	// /**
	// * 根据ID获取一个对象
	// *
	// * @param id
	// * @return
	// */
	// T loadObjectById(ID id);

	/**
	 * 保存对象
	 * 
	 * @param entity
	 * @return
	 */
	T save(T entity);

	/**
	 * 如果对象存在则更新该对象，如果不存在，则保存该对象
	 * 
	 * @param entity
	 * @return
	 */
	T saveOrUpdate(T entity);

	/**
	 * 更新对象数据
	 * 
	 * @param entity
	 * @return
	 */
	T update(T entity);

	/**
	 * 执行SQL/HQL删除或更新语句，当isHql=true的时候，执行hql，当isHql=sql的时候，执行sql。
	 * 
	 * @param cmd
	 * @param isHql
	 *            true-->cmd:hql false-->cmd:sql
	 */
	void executeDelOrUpdateCmd(String cmd, boolean isHql);

	void executeDelOrUpdateCmdAndParams(String cmd, Object[] params,
			boolean isHql);

	/**
	 * 删除该对象
	 * 
	 * @param entity
	 */
	void delete(T entity);

	/**
	 * 获取是所有的对象
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	List<T> findListByParams(String hql, Object[] params);

	/**
	 * 执行HQL查询语句，返回从firstResult到firstResult+maxResults-1的对象列表
	 * 
	 * @param hql
	 * @param firstResult
	 *            第几个开始
	 * @param maxResults
	 *            获取几个
	 * @return
	 */
	List<T> findListByLength(String hql, int firstResult, int maxResults);

	/**
	 * 执行HQL查询语句，返回从firstResult到firstResult+maxResults-1的对象列表
	 * 
	 * @param hql
	 * @param params
	 * @param firstResult
	 *            第几个开始
	 * @param maxResults
	 *            获取几个
	 * @return
	 */
	List<T> findListByLengthAndParams(String hql, Object[] params,
			int firstResult, int maxResults);

	/**
	 * 执行HQL查询语句， 获取第pageNum页的数据，pageSize表示一页共有多少条数据
	 * 
	 * @param hql
	 * @param pageNum
	 *            获取第几页的数据
	 * @param pageSize
	 *            一页最多有几条数据
	 * @return
	 */
	List<T> findListByPage(String hql, int pageNum, int pageSize);

	/**
	 * 执行HQL查询语句， 获取第pageNum页的数据，pageSize表示一页共有多少条数据
	 * 
	 * @param hql
	 * @param params
	 * @param pageNum
	 *            获取第几页的数据
	 * @param pageSize
	 *            一页最多有几条数据
	 * @return
	 */
	List<T> findListByPageAndParams(String hql, Object[] params, int pageNum,
			int pageSize);

	/**
	 * 通过hql查询语句，查询对象
	 * 
	 * @param hql
	 * @return
	 */
	T queryByHql(String hql);

	/**
	 * 通过hql查询语句，查询对象
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	T queryByHqlAndParams(String hql, Object[] params);

	void refresh(T entity);

	void evict(T entity);

	void clear();

	void flush();
}
