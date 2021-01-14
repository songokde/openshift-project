package com.newcloud.waf.job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.newcloud.waf.job.util.ParamJsonUtil;
import com.newcloud.waf.service.IBaseService;
import com.newcloud.waf.storage.entity.waf.WafCcInfo;
import com.newcloud.waf.storage.entity.waf.WafDomainInfo;
import com.newcloud.waf.storage.entity.waf.WafExactInfo;
import com.newcloud.waf.util.ShyyConstant;

@Component("reloadJob")
public class RedisReloadJob{
	private static Logger log = Logger.getLogger("LOGFILE");
	
	@Resource
	private IBaseService baseService;
	
	@Resource
	private RedisTemplate<String, ?> redisTemplate  ;
	
	/**
	 * 主任务
	 */
	public void reloadRedis(){
		log.info("--------------------begin--------------------");
		try {
			List<WafCcInfo> ccList = new ArrayList<>();
			List<WafExactInfo> visitList = new ArrayList<>();
			Map<String,Object> result =new HashMap<String, Object>();

			Map<Integer,WafCcInfo> ccMap = new HashMap<Integer, WafCcInfo>();
			Map<Integer,WafExactInfo> visitMap = new HashMap<Integer, WafExactInfo>();
			List<WafCcInfo> ccInfoList = baseService.findHQL("from WafCcInfo");
			for(WafCcInfo cc: ccInfoList) {
				ccMap.put(cc.getWciId(), cc);
			}
			List<WafExactInfo> visitInfoList = baseService.findHQL("from WafExactInfo");
			for(WafExactInfo visit: visitInfoList) {
				visitMap.put(visit.getWeiId(), visit);
			}
			
			List<WafDomainInfo> list = baseService.findHQL("from WafDomainInfo");
			for(WafDomainInfo info :list) {
				if(!StringUtils.isEmpty(info.getWdiCcIds())) {
					for(String ccId:info.getWdiCcIds().split(",")) {
						Integer id = Integer.valueOf(ccId);
						if(ccMap.containsKey(id)) {
							ccList.add(ccMap.get(id));
						}
					}
				}

				if(!StringUtils.isEmpty(info.getWdiExactIds())) {
					for(String visitId:info.getWdiExactIds().split(",")) {
						Integer id = Integer.valueOf(visitId);
						if(visitMap.containsKey(id)) {
							visitList.add(visitMap.get(id));
						}
					}
		    	}
				result.put(info.getWdiDname(), ParamJsonUtil.analysisVOtoJson(info,ccList,visitList));
			}
			redisTemplate.opsForHash().putAll(ShyyConstant.REDIS_KEY_DOMAIN, result);
			log.info("--------------------end--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
