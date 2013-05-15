package org.example.ws.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	/**
	 * @declare ���ݶ���id���һ������
	 * 
	 * @example
	 * @param id
	 * @return
	 */
	T loadObjectById(ID id);

	/**
	 * @declare ����һ����¼
	 * 
	 * @example
	 * @param entity
	 * @return
	 */
	T save(T entity);

	/**
	 * @declare ����һ���µļ�¼���߸���һ���µļ�¼
	 * 
	 * @example
	 * @param entity
	 * @return
	 */
	T saveOrUpdate(T entity);

	/**
	 * @declare ����һ����¼
	 * 
	 * @example
	 * @param entity
	 * @return
	 */
	T update(T entity);

	/**
	 * @declare ִ�� del ���� update���
	 * 
	 * @example delete from Article article where article.r__id>0
	 * @example update Article article set article.author = 'admin' where r__id
	 *          in (0,1,2,3,4)
	 * @param hql
	 * @param isHql
	 *            True->ִ��Hql False->ִ��Sql
	 */
	void executeDelOrUpdateHql(String hql, boolean isHql);

	/**
	 * @declare ɾ��һ������ʵ��
	 * 
	 * @example
	 * @param entity
	 */
	void delete(T entity);

	/**
	 * @declare ��ѯ�����еĶ��󼯺�
	 * 
	 * @example
	 */
	List<T> findAll();

	/**
	 * @declare1 ���������г�����ʵ�弯�ϵ�ǰ��������
	 * @example
	 * @param cmd
	 * @param params
	 * @param page
	 * @param count
	 * @return
	 */
	List<T> findAllByLength(final String hql, final int offset, final int length);

	/**
	 * @declare: ����������hql������length���ȵļ���
	 * @param hql
	 * @param params
	 * @param offset
	 * @param length
	 * @return
	 */
	List<T> findAllByLengthCmd(String hql, Object[] params, int offset,
			int length);

	/**
	 * @declare1 ���������г�����ʵ�弯��
	 * @declare2 ���Page>0 ��count�����ò����� ���Page=0�򷵻�ǰ�������������List����
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
	 * @declare-HQL ���ݶ�̬queryHql���г�����ʵ�弯��
	 * 
	 * @example-HQL from Article as article where article.author like '%�ӵ�%'
	 * 
	 * @example-SQL select category,content_body,create_dt����* from Article as
	 *              article where article.author = '�ӵ�' //����Ϊ���ݿ��е�����
	 * @param queryHql
	 * @param isHql
	 * @param page
	 * @param count
	 * @return
	 */
	List<Object> findListByDynHql(String queryHql, boolean isHql, int page,
			int count);

	/**
	 * @declare ���ݶ�̬hql/sql��ȡ����ʵ�������
	 * 
	 * @example from Article as article where article.author = '����' and ...
	 * @example select count(*) from Article as article
	 * @example
	 * @param queryHql
	 * @param isHql
	 * @return
	 */
	Object queryByDynHql(String queryHql, boolean isHql);

	/**
	 * @declare: ����cmd��Ӧ������ʵ��
	 * 
	 * @example from Article as article where article.author = ?
	 * @param cmd
	 * @param params
	 * @return
	 */
	Object queryByCmd(String cmd, Object[] params);

	/**
	 * ��ҳ����
	 */
	// PageModel<T> queryPage(String cmd, Object[] params, int offset, int
	// pagesize);

	/**
	 * ��ҳ����
	 */
	// PageModel<T> queryPageBySQL(String cmd, Object[] params, int offset,int
	// pagesize);

	/**
	 * ��ȡ��ѯ��¼������hql
	 * 
	 * @param hql
	 * @return
	 */
	String getCountHql(String hql);

	/**
	 * ��ѯ��¼����
	 * 
	 * @param hql
	 * @return
	 */
	public Long getCount(String hql);
}
