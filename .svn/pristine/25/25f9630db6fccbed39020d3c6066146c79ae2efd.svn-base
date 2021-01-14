package com.newcloud.waf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.newcloud.waf.service.ICcConfigService;
import com.newcloud.waf.storage.entity.BaseEntity;

@Service
public class CcConfigService extends BaseService implements ICcConfigService {

	@Override
	public List<BaseEntity> findCcConfigList(Integer custId, String name, Integer offset, Integer limit)
			throws Exception {
		String hql = "from WafCcInfo  where 1=1 ";
		Map<String,Object> param = new HashMap<String, Object>();
		if(!StringUtils.isEmpty(custId)){
			hql += " and wciCusId =:custId";
			param.put("custId", custId);
		}
		if(!StringUtils.isEmpty(name)){
			hql += " and wciRuleName like :name";
			param.put("name", "%"+name+"%");
		}
		return  baseDAO.findHQL(hql,offset, limit,param);
	}

	@Override
	public Long findCcConfigCount(Integer custId, String name) throws Exception {
		String hql = "select count(*) from WafCcInfo  where 1=1 ";
		Map<String,Object> param = new HashMap<String, Object>();
		if(!StringUtils.isEmpty(custId)){
			hql += " and wciCusId =:custId";
			param.put("custId", custId);
		}
		if(!StringUtils.isEmpty(name)){
			hql += " and wciRuleName like :name";
			param.put("name", "%"+name+"%");
		}
		return  baseDAO.findHQLCount(hql,param);
	}
	
	

}
