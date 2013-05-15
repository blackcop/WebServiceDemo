package org.example.ws.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	/**
	 * @declare 根据对象id获得一个对象
	 * 
	 * @example
	 * @param id
	 * @return
	 */
	T loadObjectById(ID id);

	/**
	 * @declare 保存一条记录
	 * 
	 * @example
	 * @param entity
	 * @return
	 */
	T save(T entity);

	/**
	 * @declare 保存一条新的记录或者跟新一条新的记录
	 * 
	 * @example
	 * @param entity
	 * @return
	 */
	T saveOrUpdate(T entity);

	/**
	 * @declare 更新一条记录
	 * 
	 * @example
	 * @param entity
	 * @return
	 */
	T update(T entity);

	/**
	 * @declare 执行 del 或者 update语句
	 * 
	 * @example delete from Article article where article.r__id>0
	 * @example update Article article set article.author = 'admin' where r__id
	 *          in (0,1,2,3,4)
	 * @param hql
	 * @param isHql
	 *            True->执行Hql False->执行Sql
	 */
	void executeDelOrUpdateHql(String hql, boolean isHql);

	/**
	 * @declare 删除一个对象实体
	 * 
	 * @example
	 * @param entity
	 */
	void delete(T entity);

	/**
	 * @declare 查询出所有的对象集合
	 * 
	 * @example
	 */
	List<T> findAll();

	/**
	 * @declare1 根据条件列出对象实体集合的前几条数据
	 * @example
	 * @param cmd
	 * @param params
	 * @param page
	 * @param count
	 * @return
	 */
	List<T> findAllByLength(final String hql, final int offset, final int length);

	/**
	 * @declare: 带参数根据hql语句查找length长度的集合
	 * @param hql
	 * @param params
	 * @param offset
	 * @param length
	 * @return
	 */
	List<T> findAllByLengthCmd(String hql, Object[] params, int offset,
			int length);

	/**
	 * @declare1 根据条件列出对象实体集合
	 * @declare2 如果Page>0 ，count的设置才又用 如果Page=0则返回前两个参数查出的List对象
	 * 
	 * @example from Article as article where article.r__id = ?
	 * @param cmd
	 * @param params
	 * @param page
	 * @param count
	 * @return
	 */
	List<T> findListByCmd(String cmd, Object[] params, int page, int count);

	/**
	 * @declare-HQL 根据动态queryHql来列出对象实体集合
	 * 
	 * @example-HQL from Article as article where article.author like '%坑爹%'
	 * 
	 * @example-SQL select category,content_body,create_dt或者* from Article as
	 *              article where article.author = '坑爹' //表名为数据库中的名称
	 * @param queryHql
	 * @param isHql
	 * @param page
	 * @param count
	 * @return
	 */
	List<Object> findListByDynHql(String queryHql, boolean isHql, int page,
			int count);

	/**
	 * @declare 根据动态hql/sql获取返回实体类对象
	 * 
	 * @example from Article as article where article.author = '刘玉华' and ...
	 * @example select count(*) from Article as article
	 * @example
	 * @param queryHql
	 * @param isHql
	 * @return
	 */
	Object queryByDynHql(String queryHql, boolean isHql);

	/**
	 * @declare: 根据cmd对应语句查找实体
	 * 
	 * @example from Article as article where article.author = ?
	 * @param cmd
	 * @param params
	 * @return
	 */
	Object queryByCmd(String cmd, Object[] params);

	/**
	 * 分页查找
	 */
	// PageModel<T> queryPage(String cmd, Object[] params, int offset, int
	// pagesize);

	/**
	 * 分页查找
	 */
	// PageModel<T> queryPageBySQL(String cmd, Object[] params, int offset,int
	// pagesize);

	/**
	 * 获取查询记录总数的hql
	 * 
	 * @param hql
	 * @return
	 */
	String getCountHql(String hql);

	/**
	 * 查询记录总数
	 * 
	 * @param hql
	 * @return
	 */
	public Long getCount(String hql);
}
