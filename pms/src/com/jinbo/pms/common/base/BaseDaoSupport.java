package com.jinbo.pms.common.base;

import java.util.List;


public interface BaseDaoSupport<T> {
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> find();
	
	/**
	 * 带条件查询所有
	 * @return
	 */
	public List<T> findWithWhere(String where);
	
	/**
	 * 根据hql语句查询所有
	 * @param hql
	 * @return
	 */
	public List<T> findByHQL(String hql);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public T get(Integer id);
	
	/**
	 * 保存实体类，返回主键ID
	 * @param <T>
	 * @param entity 实体类
	 * @return
	 */
	public void save(T entity);
	
	/**
	 *
	 * @param list
	 */
	public void saveBatch(List<T> list);
	
	/**
	 * 根据id单条删除
	 * @param <T>
	 * @param entity
	 */
	public void delete(Integer id);
	
	/**
	 * 删除实体类
	 * @param <T>
	 * @param entity
	 */
	public void delete(T entity);
	
	/**
	 * 删除集合
	 * @param <T>
	 * @param entityList
	 */
	public void delete(List<T> entityList);
	
	/**
	 * 根据多个id进行删除
	 * @param ids
	 */
	public void delete(Integer... ids);
	/**
	 * 更新实体类
	 * @param <T>
	 * @param entity
	 */
	public void update(T entity);
	
	
	
}
