package com.newcloud.waf.service;

import java.util.List;

import com.newcloud.waf.storage.entity.BaseEntity;

public interface ICcConfigService extends IBaseService{

	/**
	 * 分页模糊查询
	 * @param custId
	 * @param domain
	 * @param offset
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public List<BaseEntity> findCcConfigList(Integer custId, String name, Integer offset, Integer limit) throws Exception;

	public Long findCcConfigCount(Integer custId, String name) throws Exception;
	
	
	
}
