package com.newcloud.waf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newcloud.waf.service.IOverViewService;
import com.newcloud.waf.storage.dao.IOverViewDAO;
import com.newcloud.waf.storage.entity.info.InfoDatabase;
import com.newcloud.waf.storage.entity.waf.WafAttackInfo;

@Service
public class OverViewService extends BaseService implements IOverViewService {
	@Resource
	private IOverViewDAO overViewDAO;
	
	@Override
	public Map<String,Long>  findCountByTime(long beginTimestamp, long endTimestamp,Integer custId) throws Exception {
		Map<String,Long> resultMap = new HashMap<>();
		Map<String, Map<String, Long>> map = overViewDAO.findRecentMapByTime(beginTimestamp,endTimestamp,custId);
		for(Entry<String, Map<String, Long>> entry:map.entrySet()) {
			Long count =0l;
			Map<String, Long> childMap = entry.getValue();
			for( Entry<String, Long> child:childMap.entrySet()) {
				count+=child.getValue();
			}
			resultMap.put(entry.getKey(), count);
		}
		return resultMap;
	}

	@Override
	public Map<String, Map<String, Long>> findRecentMapByTime(long begin, long end,Integer custId) throws Exception {
		return overViewDAO.findRecentMapByTime(begin, end,custId);
	}
	
	
	@Override
	public Map<String, Double> findBandWidthMap(Long beginTime, Long endTime,Integer custId,String type,Integer domainId) throws Exception {
		return overViewDAO.findBandWidthMap(beginTime,endTime,custId,type,domainId);
	}

	//-------------------------------------------------------------报表--------------------------------------------------------------------
	
	@Override
	public Map<String, Long> findAttackIpTopList(Integer domainId, String type, Integer beginTime, Integer endTime,
			Integer custId) throws Exception {
		return overViewDAO.findAttackIpTopList(domainId,type,beginTime,endTime,custId);
	}
	
	
	@Override
	public Map<String,Integer> findCountByType(Integer domainId, String type,Integer beginTimestamp, Integer endTimestamp,Integer custId)
			throws Exception {
		return overViewDAO.findCountByType(domainId,type,beginTimestamp,endTimestamp,custId);
	}

	@Override
	public Integer findUrlCountByType(Integer domainId, String type, Integer beginTimestamp, Integer endTimestamp,Integer custId)
			throws Exception {
		return overViewDAO.findUrlCountByType(domainId,type,beginTimestamp,endTimestamp,custId);
	}

	@Override
	public List<WafAttackInfo> findAttackList(Integer domainId, String type, Integer beginTime, Integer endTime,Integer custId) throws Exception {
		return overViewDAO.findAttackList(domainId,type,beginTime,endTime,custId);
	}
	
	@Override
	public Map<Integer, Long> findCodeMap(Integer beginTimestamp, Integer endTimestamp,String type,Integer domainId,Integer custId) throws Exception {
		return overViewDAO.findCodeMap(beginTimestamp,endTimestamp,type,domainId,custId);
	}

	@Override
	public Map<Integer, Long> findAreaMap(Integer beginTimestamp, Integer endTimestamp,String type,Integer domainId,Integer custId) throws Exception {
		return overViewDAO.findAreaMap(beginTimestamp,endTimestamp,type,domainId,custId);
	}

	@Override
	public Map<String, Double> findCompareBandwidthMap(String beginTime, String endTime, Integer domainId, Integer custId,
			InfoDatabase db, Long dniBwratio) throws Exception{
		 Map<String, Double> map = overViewDAO.findCompareBandwidthMap(beginTime,endTime,domainId,custId,db,dniBwratio);
		 return map;
	}


	@Override
	public Map<String, Double> findAttackBandWidthMap(String begin, String end, Integer custId, String type,
			Integer domainId) throws Exception {
		return overViewDAO.findAttackBandWidthMap(begin,end,custId,type,domainId);
	}




	

}
