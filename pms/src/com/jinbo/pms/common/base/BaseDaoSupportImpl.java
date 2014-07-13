package com.jinbo.pms.common.base;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BaseDaoSupportImpl<T> implements BaseDaoSupport<T> {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected String getEntityName() {
		return getEntityClass().getSimpleName();
	}

	@SuppressWarnings("unchecked")
	public List<T> find() {
		return getSession().createQuery(buildHQLByClass(this.getEntityClass()))
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findWithWhere(String where) {
		return getSession().createQuery(
				buildHQLByClass(this.getEntityClass()) + " where" + where)
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByHQL(String hql) {
		return getSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public T get(Integer id) {
		return (T) getSession().get(this.getEntityClass(), id);
	}

	public void save(T entity) {
		if (entity instanceof BaseDataEntity) {
			((BaseDataEntity) entity).setCreateDate(new Date());
			((BaseDataEntity) entity).setVersion(0);
			((BaseDataEntity) entity).setModifyDate(new Date());
			((BaseDataEntity) entity).setCreateUserId(-1);
			((BaseDataEntity) entity).setModifyUserId(-1);
		}
		getSession().save(entity);
	}
	
	public void saveBatch(List<T> list){
		for(T entity:list){
			if (entity instanceof BaseDataEntity) {
				((BaseDataEntity) entity).setCreateDate(new Date());
				((BaseDataEntity) entity).setVersion(0);
				((BaseDataEntity) entity).setModifyDate(new Date());
				((BaseDataEntity) entity).setCreateUserId(-1);
				((BaseDataEntity) entity).setModifyUserId(-1);
			}
			getSession().save(entity);
		}
		
	}
	
	public void delete(Integer id) {
		this.delete(this.get(id));
	}
	
	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	public void delete(List<T> entityList) {
		for (T t : entityList) {
			delete(t);
		}
	}
	public void delete(Integer... ids) {
		for (Integer id : ids) {
			this.delete(this.get(id));
		}
	}

	@Override
	public void update(T entity) {
		if (entity instanceof BaseDataEntity) {
			((BaseDataEntity) entity).setModifyDate(new Date());
			((BaseDataEntity) entity).setModifyUserId(-1);
		}
		getSession().update(entity);
	}


	protected Query setParameters(Query query, Object... params) {
		int i = 0;
		for (Object object : params) {
			query.setParameter(i, object);
		}
		return query;
	}

	public SQLQuery createSQLQuery(String sql, Object... params) {
		return (SQLQuery)setParameters(getSession().createSQLQuery(sql), params);
	}

	public Query createHQLQuery(String hql, Object... params) {
		return setParameters(getSession().createQuery(hql),params);
	}

	public static String buildHQLByClass(Class<?> clazz) {
		return "from " + clazz.getSimpleName() + " t";
	}
}
