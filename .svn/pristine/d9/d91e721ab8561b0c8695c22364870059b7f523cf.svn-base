package com.newcloud.waf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.newcloud.waf.service.IDomainConfigService;
import com.newcloud.waf.storage.entity.BaseEntity;

@Service
public class DomainConfigService extends BaseService implements IDomainConfigService {

	@Override
	public List<BaseEntity> findDomainList(Integer custId, String domain, Integer offset, Integer limit)
			throws Exception {
		String hql = "from WafDomainInfo  where 1=1 ";
		Map<String,Object> param = new HashMap<String, Object>();
		if(!StringUtils.isEmpty(custId)){
			hql += " and wdiCusId =:custId";
			param.put("custId", custId);
		}
		if(!StringUtils.isEmpty(domain)){
			hql += " and wdiDname like :name";
			param.put("name", "%"+domain+"%");
		}
		return  baseDAO.findHQL(hql,offset, limit,param);
	}

	@Override
	public Long findDomainCount(Integer custId, String domain) throws Exception {
		String hql = "select count(*) from WafDomainInfo  where 1=1 ";
		Map<String,Object> param = new HashMap<String, Object>();
		if(!StringUtils.isEmpty(custId)){
			hql += " and wdiCusId =:custId";
			param.put("custId", custId);
		}
		if(!StringUtils.isEmpty(domain)){
			hql += " and wdiDname like :name";
			param.put("name", "%"+domain+"%");
		}
		return  baseDAO.findHQLCount(hql,param);
	}

	@Override
	public boolean findDomainByRuleId(Integer ruleId, String type) throws Exception {
		String hql = "from WafDomainInfo  where 1=1 ";
		Map<String,Object> param = new HashMap<String, Object>();
		if(type.equals("cc")){
			hql += " and wdiCcIds like :ruleId";
		}else {
			hql += " and wdiExactIds like :ruleId";
		}
		param.put("ruleId", "%"+ruleId+"%");
		List<BaseEntity> list = baseDAO.findHQL(hql,param);
		if(list.size()>0) {
			return true;
		}
		return false;
	}
	
	

}
