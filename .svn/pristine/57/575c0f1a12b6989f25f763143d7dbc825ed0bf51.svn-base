package com.newcloud.waf.service;

import java.util.List;
import java.util.Map;

import com.newcloud.waf.storage.entity.info.InfoDatabase;
import com.newcloud.waf.storage.entity.waf.WafAttackInfo;

public interface IOverViewService extends IBaseService{
    //-----------------------------------------------------总览-------------------------------------------------------------

	/**
	 * 根据时间戳获取请求数 1
	 * @param beginTimestamp
	 * @param endTimestamp
	 * @return
	 */
	public Map<String,Long>  findCountByTime(long beginTimestamp, long endTimestamp,Integer custId) throws Exception;

	/**
	 * 获取最近一周的 天数据汇总 1
	 * @param begin
	 * @param end
	 * @return
	 * @throws Exception
	 */
	public Map<String, Map<String, Long>> findRecentMapByTime(long begin, long end,Integer custId) throws Exception;

	/**
	 * 查询一周带宽 1
	 * @param begin7Timestamp
	 * @param endTimestamp
	 * @return
	 * @throws Exception
	 */
	public Map<String, Double> findBandWidthMap(Long beginTime, Long endTime,Integer custId,String type,Integer domainId)  throws Exception;
	
	//-----------------------------------------------------------------报表------------------------------------------------------------------------
	/**
	 * 查询IP top5
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
	 * 查询攻击次数 1
	 * @param domainId
	 * @param type
	 * @param beginTimestamp
	 * @param endTimestamp
	 * @return
	 */
	public Map<String,Integer> findCountByType(Integer domainId, String type, Integer beginTimestamp, Integer endTimestamp,Integer custId) throws Exception;

	
	/**
	 * 查询攻击URL数 1
	 * @param domainId
	 * @param type
	 * @param beginTimestamp
	 * @param endTimestamp
	 * @return
	 * @throws Exception
	 */
	public Integer findUrlCountByType(Integer domainId, String type, Integer beginTimestamp, Integer endTimestamp,Integer custId) throws Exception;

	/**
	 * ip查询 1
	 * @param domainId
	 * @param beginTime
	 * @param endTime
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<WafAttackInfo> findAttackList(Integer domainId,String type, Integer beginTime, Integer endTime,Integer custId) throws Exception;

	
	/**
	 * 查询状态码数 1
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public  Map<Integer, Long> findCodeMap(Integer beginTime,Integer endTime,String type,Integer domainId,Integer custId)  throws Exception;

	/**
	 * 查询区域 1
	 * @param beginTime
	 * @param endTime
	 * @param type
	 * @param domainId
	 * @param custId
	 * @return
	 */
	public Map<Integer, Long> findAreaMap(Integer beginTime, Integer endTime, String type, Integer domainId,
			Integer custId)  throws Exception;

	/**
	 * 查询对比带宽1
	 * @param beginTime
	 * @param endTime
	 * @param domainId
	 * @param domainId
	 * @param db
	 * @return
	 */
	public Map<String, Double> findCompareBandwidthMap(String beginTime, String endTime, Integer domainId, Integer custId,
			InfoDatabase db, Long dniBwratio)throws Exception;

	/**
	 * 查询对比带宽2
	 * @param begin
	 * @param end
	 * @param custId
	 * @param type
	 * @param domainId
	 * @return
	 * @throws Exception
	 */
	public Map<String, Double> findAttackBandWidthMap(String begin, String end, Integer custId, String type,
			Integer domainId)throws Exception;

}
