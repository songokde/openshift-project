package com.newcloud.waf.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newcloud.waf.service.IBaseService;
import com.newcloud.waf.storage.dao.IBaseDAO;
import com.newcloud.waf.storage.entity.BaseEntity;
import com.newcloud.waf.storage.entity.ComBox;

@Service
public class BaseService implements IBaseService {
	
	@Resource
	protected IBaseDAO baseDAO;

	@Override
	public boolean save(BaseEntity o) throws Exception {
		baseDAO.save(o);
		return true;
	}

	@Override
	public boolean saveList(List<?> list) throws Exception {
		baseDAO.saveList(list);
		return true;
	}

	@Override
	public boolean delete(BaseEntity o) throws Exception {
		baseDAO.delete(o);
		return true;
	}

	@Override
	public boolean update(BaseEntity o) throws Exception {
		baseDAO.update(o);
		return true;
	}
	
	@Override
	public boolean updateList(List<?> list) throws Exception {
		return baseDAO.updateList(list);
	}

	@Override
	public boolean saveOrUpdate(BaseEntity o) throws Exception {
		baseDAO.saveOrUpdate(o);
		return true;
	}

	@Override
	public <T> T findInfo(Class<?> c, Serializable id) throws Exception {
		return baseDAO.findInfo(c, id);
	}

	@Override
	public <T> T findInfo(String hql, String alias, Object param) throws Exception {
		return baseDAO.findInfo(hql, alias, param);
	}
	
	@Override
	public <T> T findInfoLimit(String hql, String alias, Object param) throws Exception {
		return baseDAO.findInfoLimit(hql, alias, param);
	}

	@Override
	public <T> T findInfo(String hql, Map<String, Object> param) throws Exception {
		return baseDAO.findInfo(hql, param);
	}

	@Override
	public <T> List<T> findHQL(String hql) throws Exception {
		return baseDAO.findHQL(hql);
	}

	@Override
	public <T> List<T> findHQL(String hql, String alias, Object param) throws Exception {
		return baseDAO.findHQL(hql, alias, param);
	}
	
	@Override
	public <T> List<T> findHQL(String hql, Integer offset, Integer limit, String alias, Object param) throws Exception {
		return baseDAO.findHQL(hql, offset, limit, alias, param);
	}

	@Override
	public <T> List<T> findHQL(String hql, Map<String, Object> param) throws Exception {
		return baseDAO.findHQL(hql, param);
	}
	
	@Override
	public <T> List<T> findHQL(String hql, Integer offset, Integer limit, Map<String, Object> param) throws Exception {
		return baseDAO.findHQL(hql, offset, limit, param);
	}

	@Override
	public Long findHQLCount(String hql, String alias, Object param) throws Exception {
		return baseDAO.findHQLCount(hql, alias, param);
	}
	
	@Override
	public Long findHQLCount(String hql, Map<String, Object> param) throws Exception {
		return baseDAO.findHQLCount(hql, param);
	}
	
	@Override
	public Map<Integer, Long> findHQLGroupCount(String hql,Map<String, Object> param) throws Exception {
		return baseDAO.findHQLGroupCount(hql,param);
	}
	
	@Override
	public Integer updateHql(String hql, String alias, Object param) throws Exception {
		return baseDAO.updateHql(hql, alias, param);
	}
	
	@Override
	public Integer updateHql(String hql,Map<String, Object> param) throws Exception {
		return baseDAO.updateHql(hql, param);
	}

	@Override
	public List<ComBox> findCombox(Class<?> c, String fieldId, String fieldName) throws Exception {
		return baseDAO.findCombox(c, fieldId, fieldName);
	}
	
	@Override
	public List<ComBox> findCombox(Class<?> c, String fieldId, String fieldName, Map<String, Object> param)
			throws Exception {
		return baseDAO.findCombox(c, fieldId, fieldName, param);
	}

	@Override
	public List<ComBox> findCombox(Class<?> c, String fieldId, String fieldName, String condition,String alias, Object param)
			throws Exception {
		return baseDAO.findCombox(c, fieldId, fieldName, condition, alias, param);
	}
	
	@Override
	public List<ComBox> findCombox(Class<?> c, String fieldId, String fieldName, String condition,
			Map<String, Object> param) throws Exception {
		return baseDAO.findCombox(c, fieldId, fieldName, condition, param);
	}
	
	@Override
	public List<ComBox> findCombox(Class<?> c, String fieldId, String fieldName, String condition, Object[] param)
			throws Exception {
		return baseDAO.findCombox(c, fieldId, fieldName, condition, param);
	}

	@Override
	public Integer updateHql(String hql, Object[] param) throws Exception {
		return baseDAO.updateHql(hql, param);
	}

	@Override
	public List<Object> findClomnHQL(String hql, String alias, Object param) throws Exception {
		return baseDAO.findClomnHQL(hql, alias, param);
	}

	@Override
	public List<Object> findClomnHQL(String hql, Map<String, Object> param) throws Exception {
		return baseDAO.findClomnHQL(hql, param);
	}

	@Override
	public List<Object[]> findSQLString(String sql) throws Exception {
		return baseDAO.findSQLString(sql);
	}

	@Override
	public List<Object> findCloumnSQLString(String sql) throws Exception {
		return baseDAO.findCloumnSQLString(sql);
	}

	@Override
	public Map<Integer, String> findComboxMap(Class<?> c, String fieldId, String fieldName) throws Exception {
		return baseDAO.findComboxMap(c, fieldId, fieldName);
	}

	@Override
	public Map<Integer, String> findComboxMap(Class<?> c, String fieldId, String fieldName, String condition,
			Object[] param) throws Exception {
		return baseDAO.findComboxMap(c, fieldId, fieldName, condition, param);
	}

	@Override
	public Map<String, Integer> findHQLGroupCountString(String hql, Map<String, Object> param) throws Exception {
		return baseDAO.findHQLGroupCountString(hql, param);
	}
	
}
