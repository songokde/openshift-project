package com.newcloud.waf.service.info;

import org.springframework.stereotype.Service;

import com.newcloud.waf.service.IUserService;
import com.newcloud.waf.service.impl.BaseService;
import com.newcloud.waf.storage.entity.BaseEntity;
import com.newcloud.waf.storage.entity.info.InfoOperator;

@Service
public class UserService extends BaseService implements IUserService {

	@Override
	public InfoOperator findUserByName(String userName) throws Exception {
		BaseEntity entity = baseDAO.findInfo("from InfoOperator where opName = :userName and opState=1", "userName", userName);
		if (entity != null) {
			return (InfoOperator) entity;
		}
		return null;
	}

}
