package com.newcloud.waf.service;

import com.newcloud.waf.storage.entity.info.InfoOperator;

public interface IUserService extends IBaseService{
	
	/**
	 * 账号名称查询账号信息
	 * 
	 * @param userName
	 * @return
	 */
	public InfoOperator findUserByName(String userName) throws Exception;
	
}
