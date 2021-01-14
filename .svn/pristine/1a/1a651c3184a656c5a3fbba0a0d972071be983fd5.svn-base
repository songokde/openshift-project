package com.newcloud.waf.storage.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.newcloud.waf.storage.entity.info.InfoDatabase;
import com.newcloud.waf.storage.entity.waf.WafAttackInfo;

@Repository
public interface IOverViewDAO {

	//-------------------------------------------------总览---------------------------------------------------------------
	
	/**
	 * 获取最近一周的 天数据汇总 
	 * @param begin7Timestamp
	 * @param endTimestamp
	 * @return
	 * @throws Exception
	 */
	public Map<String, Map<String, Long>> findRecentMapByTime(long begin, long end,Integer custId)  throws Exception;

	/**
	 * 查询带宽
	 * @param begin7Timestamp
	 * @param endTimestamp
	 * @param custId
	 * @return
	 */
	public Map<String, Double> findBandWidthMap(Long beginTimestamp, Long endTimestamp, Integer custId,String type,Integer domainId) throws Exception;
	
	//-------------------------------------------------报表----------------------------------------------------------------
	
	/**
	 * 查询ip top 5
	 * @param domainId
	 * @param type
	 * @param beginTime
	 * @param endTime
	 * @param custId
	 * @return
	 * @throws Exception
	 */
	public Map<String, Long> findAttackIpTopList(Integer domainId, String type, Integer beginTime, Integer endTime,Integer custId)  throws Exception;

	
	
	/**
	 * 查询topip
	 * @param domainId
	 * @param type
	 * @return
	 * @throws Exception
	 *//*
	public Map<String,Map<String, Object>> findTopIp(Integer domainId,Long beginTime,Long endTime,Integer custId) throws Exception;*/

	/**
	 * 查询最新ip攻击20条 
	 * @param domainId
	 * @param type
	 * @param beginTime
	 * @param endTime
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<WafAttackInfo> findAttackList(Integer domainId, String type, Integer beginTime, Integer endTime,Integer custId) throws Exception;


	/**
	 * 根据时间戳查询状态码 
	 * @param beginTimestamp
	 * @param endTimestamp
	 * @param custId
	 * @return
	 */
	public Map<Integer,Long> findCodeMap(long beginTimestamp, long endTimestamp,String type,Integer domainId,Integer custId) throws Exception ;

	/**
	 * 查询攻击总数与ip个数  
	 * @param domainId
	 * @param type
	 * @param beginTimestamp
	 * @param endTimestamp
	 * @param custId
	 * @return
	 * @throws Exception
	 */
	public Map<String, Integer> findCountByType(Integer domainId, String type, Integer beginTimestamp,
			Integer endTimestamp, Integer custId) throws Exception;

	/**
	 * 查询url的个数 
	 * @param domainId
	 * @param type
	 * @param beginTimestamp
	 * @param endTimestamp
	 * @param custId
	 * @return
	 * @throws Exception
	 */
	public Integer findUrlCountByType(Integer domainId, String type, Integer beginTimestamp, Integer endTimestamp,
			Integer custId) throws Exception;

	/**
	 * 查询区域 、攻击数  
	 * @param beginTimestamp
	 * @param endTimestamp
	 * @param type
	 * @param domainId
	 * @param custId
	 * @return
	 * @throws Exception
	 */
	public Map<Integer, Long> findAreaMap(Integer beginTimestamp, Integer endTimestamp, String type, Integer domainId,
			Integer custId) throws Exception;

	/**
	 * 查询域名总带宽
	 * @param beginTime
	 * @param endTime
	 * @param domainId
	 * @param custId
	 * @param db
	 * @return
	 * @throws Exception
	 */
	public Map<String, Double> findCompareBandwidthMap(String beginTime, String endTime, Integer domainId, Integer custId,
			InfoDatabase db, Long dniBwratio) throws Exception;

	/**
	 * 查询攻击带宽
	 * @param begin
	 * @param end
	 * @param custId
	 * @param type
	 * @param domainId
	 * @return
	 */
	public Map<String, Double> findAttackBandWidthMap(String begin, String end, Integer custId, String type,
			Integer domainId) throws Exception;

	


}
