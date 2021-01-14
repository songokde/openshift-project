package com.newcloud.waf.service;

import java.util.List;

import com.newcloud.waf.storage.entity.BaseEntity;

public interface IDomainConfigService extends IBaseService{

	/**
	 * 分页模糊查询
	 * @param custId
	 * @param domain
	 * @param offset
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public List<BaseEntity> findDomainList(Integer custId, String domain, Integer offset, Integer limit) throws Exception;

	public Long findDomainCount(Integer custId, String domain) throws Exception;
	
	
	/**
	 * 通过id 查询是否有域名关联
	 * @param rule
	 * @return
	 * @throws Exception
	 */
	public boolean findDomainByRuleId(Integer ruleId,String type) throws Exception;
	
	
}
