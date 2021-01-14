package com.newcloud.waf.storage.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.newcloud.waf.storage.dao.IBaseDAO;
import com.newcloud.waf.storage.entity.BaseEntity;
import com.newcloud.waf.storage.entity.ComBox;

@Repository
public class BaseDAO implements IBaseDAO{
	
	private SessionFactory sessionFactory;
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean save(BaseEntity o) throws Exception {
		this.openSession().save(o);
		return true;
	}

	@Override
	public boolean saveList(List<?> list) throws Exception {
		Session session = this.openSession();
		int i = 1;
		for(Object obj : list) {
			session.save(obj);
			i++;
			if (i % 20 == 0) {
				session.flush();
				session.clear();
			}
		}
		return true;
	}

	@Override
	public boolean delete(BaseEntity o) throws Exception {
		this.openSession().delete(o);
		return true;
	}

	@Override
	public boolean update(BaseEntity o) throws Exception {
		this.openSession().update(o);
		return true;
	}
	
	@Override
	public boolean updateList(List<?> list) throws Exception {
		Session session = this.openSession();
		int i = 1;
		for(Object obj : list) {
			session.update(obj);
			i++;
			if (i % 20 == 0) {
				session.flush();
				session.clear();
			}
		}
		return true;
	}

	@Override
	public boolean saveOrUpdate(BaseEntity o) throws Exception {
		this.openSession().saveOrUpdate(o);
		return true;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T findInfo(Class<?> c, Serializable id) throws Exception {
		return (T) this.openSession().get(c, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T findInfo(String hql, String alias, Object param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if(alias.endsWith("List")){
			query.setParameterList(alias,(Collection<Object>)param);
		}else{
			query.setParameter(alias,param);
		}
		return (T) query.uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T findInfoLimit(String hql, String alias, Object param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if(alias.endsWith("List")){
			query.setParameterList(alias,(Collection<?>)param);
		}else{
			query.setParameter(alias,param);
		}
		query.setFirstResult(0);
		query.setMaxResults(1);
		return (T) query.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T findInfo(String hql, Map<String, Object> param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (Entry<String, Object> entry : param.entrySet()) {
				if (entry.getKey().endsWith("List")) {
					query.setParameterList(entry.getKey(),(Collection<?>)entry.getValue());
					continue;
				}
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return (T) query.uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> findHQL(String hql) throws Exception {
		return this.openSession().createQuery(hql).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> findHQL(String hql, String alias, Object param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if(alias.endsWith("List")){
			query.setParameterList(alias,(Collection<?>)param);
		}else{
			query.setParameter(alias,param);
		}
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> findHQL(String hql, Integer offset, Integer limit, String alias, Object param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if(alias.endsWith("List")){
			query.setParameterList(alias,(Collection<?>)param);
		}else{
			query.setParameter(alias,param);
		}
		return query.setFirstResult((offset-1)*limit).setMaxResults(limit).list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> findHQL(String hql, Map<String, Object> param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (Entry<String, Object> entry : param.entrySet()) {
				if (entry.getKey().endsWith("List")) {
					query.setParameterList(entry.getKey(),(Collection<?>)entry.getValue());
					continue;
				}
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> findHQL(String hql, Integer offset, Integer limit, Map<String, Object> param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (Entry<String, Object> entry : param.entrySet()) {
				if (entry.getKey().endsWith("List")) {
					query.setParameterList(entry.getKey(),(Collection<?>) entry.getValue());
					continue;
				}
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return query.setFirstResult((offset-1)*limit).setMaxResults(limit).list();
	}
	
	@Override
	public Long findHQLCount(String hql, String alias, Object param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if(alias.endsWith("List")){
			query.setParameterList(alias,(Collection<?>)param);
		}else{
			query.setParameter(alias,param);
		}
		return (Long) query.uniqueResult();
	}
	
	@Override
	public Long findHQLCount(String hql, Map<String, Object> param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (Entry<String, Object> entry : param.entrySet()) {
				if (entry.getKey().endsWith("List")) {
					query.setParameterList(entry.getKey(),(Collection<?>) entry.getValue());
					continue;
				}
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return (Long) query.uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Map<Integer,Long> findHQLGroupCount(String hql,Map<String, Object> param) throws Exception {
		Map<Integer,Long> map = new HashMap<Integer, Long>();
		Query query = this.openSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (Entry<String, Object> entry : param.entrySet()) {
				if (entry.getKey().endsWith("List")) {
					query.setParameterList(entry.getKey(),(Collection<?>) entry.getValue());
					continue;
				}
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		List<Object[]> list = query.list();
		for(Object[] obj : list){
			map.put((Integer)obj[0],(Long)obj[1]); 
		}
		return map;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Map<String,Integer> findHQLGroupCountString(String hql,Map<String, Object> param) throws Exception {
		Map<String,Integer> map = new HashMap<String, Integer>();
		Query query = this.openSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (Entry<String, Object> entry : param.entrySet()) {
				if (entry.getKey().endsWith("List")) {
					query.setParameterList(entry.getKey(),(Collection<?>) entry.getValue());
					continue;
				}
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		List<Object[]> list = query.list();
		for(Object[] obj : list){
			map.put((String)obj[0],(Integer)obj[1]); 
		}
		return map;
	}
	
	@Override
	public Integer updateHql(String hql, String alias, Object param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if(alias.endsWith("List")){
			query.setParameterList(alias,(Collection<?>)param);
		}else{
			query.setParameter(alias,param);
		}
		return query.executeUpdate();
	}
	
	@Override
	public Integer updateHql(String hql, Object[] param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for(int i=0;i<param.length;i++){
				query.setParameter(i, param[i]);
			}
		}
		return query.executeUpdate();
	}
	
	@Override
	public Integer updateHql(String hql, Map<String, Object> param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (Entry<String, Object> entry : param.entrySet()) {
				if (entry.getKey().endsWith("List")) {
					query.setParameterList(entry.getKey(),(Collection<?>) entry.getValue());
					continue;
				}
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return query.executeUpdate();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ComBox> findCombox(Class<?> c, String fieldId,String fieldName) throws Exception{
		Query query = this.openSession().createQuery("select new com.newcloud.waf.storage.entity.ComBox("+fieldId+","+fieldName+") from "+c.getName());
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ComBox> findCombox(Class<?> c, String fieldId,String fieldName,Map<String, Object> param) throws Exception {
		Query query = this.openSession().createQuery("select new com.newcloud.waf.storage.entity.ComBox("+fieldId+","+fieldName+") from "+c.getName());
		if (param != null && param.size() > 0) {
			for (Entry<String, Object> entry : param.entrySet()) {
				if (entry.getKey().endsWith("List")) {
					query.setParameterList(entry.getKey(),(Collection<?>) entry.getValue());
					continue;
				}
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ComBox> findCombox(Class<?> c, String fieldId,String fieldName,String condition, String alias, Object param) throws Exception {
		Query query = this.openSession().createQuery("select new com.newcloud.waf.storage.entity.ComBox("+fieldId+","+fieldName+") from "+c.getName()+" where "+condition);
		if(alias.endsWith("List")){
			query.setParameterList(alias,(Collection<BaseEntity>)param);
		}else{
			query.setParameter(alias,param);
		}
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ComBox> findCombox(Class<?> c, String fieldId,String fieldName,String condition, Map<String, Object> param) throws Exception {
		Query query = this.openSession().createQuery("select new com.newcloud.waf.storage.entity.ComBox("+fieldId+","+fieldName+") from "+c.getName()+" where "+condition);
		if (param != null && param.size() > 0) {
			for (Entry<String, Object> entry : param.entrySet()) {
				if (entry.getKey().endsWith("List")) {
					query.setParameterList(entry.getKey(),(Collection<?>) entry.getValue());
					continue;
				}
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ComBox> findCombox(Class<?> c, String fieldId,String fieldName,String condition,Object[] param) throws Exception{
		Query query = this.openSession().createQuery("select new com.newcloud.waf.storage.entity.ComBox("+fieldId+","+fieldName+") from "+c.getName()+" where "+condition);
		if (param != null && param.length > 0) {
			for(int i=0;i<param.length;i++){
				query.setParameter(i, param[i]);
			}
		}
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> findClomnHQL(String hql, String alias, Object param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if(alias.endsWith("List")){
			query.setParameterList(alias,(Collection<?>)param);
		}else{
			query.setParameter(alias,param);
		}
		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object> findClomnHQL(String hql, Map<String, Object> param) throws Exception {
		Query query = this.openSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (Entry<String, Object> entry : param.entrySet()) {
				if (entry.getKey().endsWith("List")) {
					query.setParameterList(entry.getKey(),(Collection<?>) entry.getValue());
					continue;
				}
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> findSQLString(String sql) throws Exception {
		Query query = this.openSession().createSQLQuery(sql);
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> findCloumnSQLString(String sql) throws Exception {
		Query query = this.openSession().createSQLQuery(sql);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public Map<Integer,String> findComboxMap(Class<?> c, String fieldId,String fieldName) throws Exception{
		Map<Integer,String> map = new TreeMap<Integer, String>();
		Query query = this.openSession().createQuery("select new com.newcloud.waf.storage.entity.ComBox("+fieldId+","+fieldName+") from "+c.getName());
		List<ComBox> list = query.list();
		for(ComBox box:list){
			map.put(box.getId(), box.getText());
		}
		return map;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Map<Integer,String> findComboxMap(Class<?> c, String fieldId,String fieldName,String condition,Object[] param) throws Exception{
		Map<Integer,String> map = new TreeMap<Integer, String>();
		Query query = this.openSession().createQuery("select new com.newcloud.waf.storage.entity.ComBox("+fieldId+","+fieldName+") from "+c.getName()+" where "+condition);
		if (param != null && param.length > 0) {
			for(int i=0;i<param.length;i++){
				query.setParameter(i, param[i]);
			}
		}
		List<ComBox> list = query.list();
		for(ComBox box:list){
			map.put(box.getId(), box.getText());
		}
		return map;
	}
	
}
