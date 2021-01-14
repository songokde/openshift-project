package com.newcloud.waf.service.info;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.newcloud.waf.service.IAreaService;
import com.newcloud.waf.service.impl.BaseService;
import com.newcloud.waf.storage.entity.info.InfoArea;

@Service
public class AreaService extends BaseService implements IAreaService {

	@Override
	public Map<Integer, String> getAreaMap() throws Exception {
		return baseDAO.findComboxMap(InfoArea.class, "ariId", "ariProvice");
	}

	

}
