package com.newcloud.waf.storage.dao.util;

import org.springframework.util.StringUtils;



public class OverViewSqlUtil {
	
	/**
	 * 概览首页map
	 * @param begin
	 * @param end
	 * @param custId
	 * @return
	 */
	public static String findRecentMapSql(long begin,long end,int custId){
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select wai_type,sum(wai_count) as count,wai_timestamp from ")
				 .append(ShyyDataUtil.formatCustomerID(custId))
				 .append(".waf_attack_info")
				 .append(" WHERE wai_timestamp between ")
				 .append(begin) 
				 .append(" and ")
				 .append(end)
				 .append(" group by wai_type order by wai_timestamp");
		return sqlBuffer.toString();
	}

	/**
	 * 查询top 5  ip
	 * @param domainId
	 * @param type
	 * @param beginTime
	 * @param endTime
	 * @param custId
	 * @return
	 */
	public static String findTopIpSql(Integer domainId, Integer beginTime, Integer endTime, Integer custId,String type) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select sum(wai_count) as count, wai_nodeip from ")
			     .append(ShyyDataUtil.formatCustomerID(custId))
			     .append(".waf_attack_info")
			     .append(" where 1=1 ");
		if(StringUtils.isEmpty(domainId)) {
			sqlBuffer.append(" and wai_dniid = ")
			         .append(domainId);
		}
		if(StringUtils.isEmpty(type)) {
			sqlBuffer.append(" and wai_type = ")
			         .append(type);
		}
		if(!StringUtils.isEmpty(beginTime) &&!StringUtils.isEmpty(endTime)) {
			if(beginTime.equals(endTime)) {
				sqlBuffer.append(" and wai_date = ")
				         .append(beginTime);
			}else {
				sqlBuffer.append(" and wai_date between ")
                .append(beginTime)
                .append(" and ")
                .append(endTime);
			}
		}
		sqlBuffer.append(" group by wai_nodeip order by count desc limit 0,5");
		return sqlBuffer.toString();
	}

	/**
	 * 查询top5 区域
	 * @param domainId
	 * @param type
	 * @param beginTime
	 * @param endTime
	 * @param custId
	 * @return
	 */
	public static String findTopAreaSql(Integer domainId,  Long beginTime, Long endTime, Integer custId) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select sum(wai_count) as count, wai_area,wai_type from ")
			     .append(ShyyDataUtil.formatCustomerID(custId))
			     .append(".waf_attack_info")
			     .append(" where 1=1 ");
		if(StringUtils.isEmpty(domainId)) {
			sqlBuffer.append(" and wai_dniid = ")
			         .append(domainId);
		}
		if(!StringUtils.isEmpty(beginTime) &&!StringUtils.isEmpty(endTime)) {
			sqlBuffer.append(" and wai_timestamp between ")
	                 .append(beginTime)
	                 .append(" and ")
	                 .append(endTime);
		}
		sqlBuffer.append(" group by wai_area order by count desc limit 0,5");
		return sqlBuffer.toString();
	}
	
	/**
	 * 查询top5 区域
	 * @param domainId
	 * @param type
	 * @param beginTime
	 * @param endTime
	 * @param custId
	 * @return
	 */
	public static String findTopCodeSql(Integer domainId,  Long beginTime, Long endTime, Integer custId) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select sum(wai_count) as count, wai_code,wai_type from ")
			     .append(ShyyDataUtil.formatCustomerID(custId))
			     .append(".waf_attack_info")
			     .append(" where 1=1 ");
		if(StringUtils.isEmpty(domainId)) {
			sqlBuffer.append(" and wai_dniid = ")
			         .append(domainId);
		}
		if(!StringUtils.isEmpty(beginTime) &&!StringUtils.isEmpty(endTime)) {
			sqlBuffer.append(" and wai_timestamp between ")
	                 .append(beginTime)
	                 .append(" and ")
	                 .append(endTime);
		}
		sqlBuffer.append(" group by wai_code order by count desc limit 0,5");
		return sqlBuffer.toString();
	}
	
	/**
	 * 查询最新20条 ip攻击记录
	 * @param domainId
	 * @param type
	 * @param beginTime
	 * @param endTime
	 * @param custId
	 * @return
	 */
	public static String findAttackIpSql(Integer domainId, String type, Integer beginTime, Integer endTime, Integer custId) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select * from ")
			     .append(ShyyDataUtil.formatCustomerID(custId))
			     .append(".waf_attack_info")
			     .append(" where wai_type = ")
			     .append(type);
		if(StringUtils.isEmpty(domainId)) {
			sqlBuffer.append(" and wai_dniid = ")
			         .append(domainId);
		}
		if(!StringUtils.isEmpty(beginTime) &&!StringUtils.isEmpty(endTime)) {
			sqlBuffer.append(" and wai_date between ")
	                 .append(beginTime)
	                 .append(" and ")
	                 .append(endTime);
		}
		sqlBuffer.append(" order by wai_timestamp desc limit 0,20");
		return sqlBuffer.toString();
	}

	/**
	 * 查询7天带宽sql
	 * @param begin7Timestamp
	 * @param endTimestamp
	 * @param custId
	 * @return
	 */
	public static String findBandWidthSql(Long beginTime, Long endTime, Integer custId,String type,Integer domainId) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select wai_timestamp,wai_bandwidth from ")
			     .append(ShyyDataUtil.formatCustomerID(custId))
			     .append(".waf_attack_info")
			     .append(" where 1=1");
		if(!StringUtils.isEmpty(beginTime) &&!StringUtils.isEmpty(endTime)) {
			if(beginTime == endTime ) {
				sqlBuffer.append(" and wai_timestamp = ")
                         .append(beginTime);
			}else {
				sqlBuffer.append(" and wai_timestamp between ")
                         .append(beginTime)
                         .append(" and ")
                         .append(endTime);
			}
			
		}
		if(!StringUtils.isEmpty(type)) {
			sqlBuffer.append(" and wai_type = ")
	                 .append(type);
		}
		if(!StringUtils.isEmpty(domainId) && domainId != -1) {
			sqlBuffer.append(" and wai_dniid = ")
	                 .append(domainId);
		}
		sqlBuffer.append(" order by wai_timestamp ");
		return sqlBuffer.toString();
	}


	/**
	 * 获取code数  code分组
	 * @param beginTime
	 * @param endTime
	 * @param type
	 * @param domainId
	 * @param custId
	 * @return
	 */
	public static String findCodeMapSql(long beginTime, long endTime,String type, Integer domainId,Integer custId) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select sum(wai_count) as count,wai_code from ")
			     .append(ShyyDataUtil.formatCustomerID(custId))
			     .append(".waf_attack_info")
			     .append(" where wai_type = ")
			     .append(type);
		if(StringUtils.isEmpty(domainId)) {
			sqlBuffer.append(" and wai_dniid = ")
			         .append(domainId);
		}
		if(!StringUtils.isEmpty(beginTime) &&!StringUtils.isEmpty(endTime)) {
			if(beginTime == endTime) {
				sqlBuffer.append(" and wai_timestamp = ")
                .append(beginTime);
			}else {
				sqlBuffer.append(" and wai_timestamp between ")
                .append(beginTime)
                .append(" and ")
                .append(endTime);
			}
		}
		sqlBuffer.append(" group by wai_code ");
		return sqlBuffer.toString();
	}

	public static String findCountByTypeSql(Integer beginTime, Integer endTime, String type, Integer domainId,
			Integer custId) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select sum(wai_count) as count from ")
			     .append(ShyyDataUtil.formatCustomerID(custId))
			     .append(".waf_attack_info")
			     .append(" where wai_type = ")
			     .append(type);
		if(StringUtils.isEmpty(domainId)) {
			sqlBuffer.append(" and wai_dniid = ")
			         .append(domainId);
		}
		if(!StringUtils.isEmpty(beginTime) &&!StringUtils.isEmpty(endTime)) {
			if(beginTime.equals(endTime)) {
				sqlBuffer.append(" and wai_date = ")
				         .append(beginTime);
			}else {
				sqlBuffer.append(" and wai_date between ")
                         .append(beginTime)
                         .append(" and ")
                         .append(endTime);
			}
		}
		sqlBuffer.append(" group by wai_attackip");
		return sqlBuffer.toString();
	}

	public static String findUrlCountByType(Integer beginTime, Integer endTime, String type, Integer domainId,
			Integer custId) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select count(wai_url) as count from ")
			     .append(ShyyDataUtil.formatCustomerID(custId))
			     .append(".waf_attack_info")
			     .append(" where wai_type = ")
			     .append(type);
		if(StringUtils.isEmpty(domainId)) {
			sqlBuffer.append(" and wai_dniid = ")
			         .append(domainId);
		}
		if(!StringUtils.isEmpty(beginTime) &&!StringUtils.isEmpty(endTime)) {
			if(beginTime.equals(endTime)) {
				sqlBuffer.append(" and wai_date = ")
				         .append(beginTime);
			}else {
				sqlBuffer.append(" and wai_date between ")
                         .append(beginTime)
                         .append(" and ")
                         .append(endTime);
			}
			
		}
		return sqlBuffer.toString();
	}

	public static String findAreaMapSql(Integer beginTime, Integer endTime, String type, Integer domainId,
			Integer custId) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select sum(wai_area) as count,wai_area from ")
			     .append(ShyyDataUtil.formatCustomerID(custId))
			     .append(".waf_attack_info")
			     .append(" where wai_type = ")
			     .append(type);
		if(StringUtils.isEmpty(domainId)) {
			sqlBuffer.append(" and wai_dniid = ")
			         .append(domainId);
		}
		if(!StringUtils.isEmpty(beginTime) &&!StringUtils.isEmpty(endTime)) {
			if(beginTime.equals(endTime)) {
				sqlBuffer.append(" and wai_date = ")
				         .append(beginTime);
			}else {
				sqlBuffer.append(" and wai_date between ")
                .append(beginTime)
                .append(" and ")
                .append(endTime);
			}
			
		}
		sqlBuffer.append(" group by wai_area");
		return sqlBuffer.toString();
	}
	
	/**
	 * 查询域名带宽
	 * @param beginTime
	 * @param endTime
	 * @param type
	 * @param domainId
	 * @param custId
	 * @return
	 */
	public static String findDomainBandWidthSql(String beginTime, String endTime, Integer domainId, Integer custId,Long rates,Object[] obj) {
		StringBuffer sqlBuffer = new StringBuffer();
		String table = obj[0].toString();
		long split = (Long)obj[1];
		boolean group = (Boolean)obj[2];
		if(group){
			sqlBuffer.append("SELECT a.times,MAX(a.allflux) as flux FROM (SELECT FLOOR(BW_TIMESTAMP/")
			 	 	 .append(split)
			 	 	 .append(")*")
					 .append(split).append("+").append(split)
					 .append(" AS times,round(SUM(BW_BANDWIDTH)*8/");
		}else{
			sqlBuffer.append("SELECT BW_TIMESTAMP,round(SUM(BW_BANDWIDTH)*8/");
		}
		sqlBuffer.append(ShyyDataUtil.getBandwidthRate(custId,rates))
		 		 .append(",3) AS allflux FROM ")
		 		 .append(ShyyDataUtil.formatCustomerID(custId))
		 		 .append(".")
		 		 .append(table)
		 		 .append(" WHERE ");
		if(beginTime.equals(endTime)){
			sqlBuffer.append(" BW_DATE =")
			         .append(beginTime);
		}else{
			sqlBuffer.append(" BW_DATE BETWEEN ")
	                 .append(beginTime)
	                 .append(" and ")
	                 .append(endTime);
		}
		sqlBuffer.append("AND BW_DNI = ")
				 .append(domainId);
		if(group){
			sqlBuffer.append(" GROUP BY BW_TIMESTAMP) a GROUP BY a.times");
		}else{
			sqlBuffer.append(" GROUP BY BW_TIMESTAMP");
		}
		return sqlBuffer.toString();
	}
	

	public static Object[] getBandwidthSqlUtil(String beginTime, String endTime) {
		Object[] object = new Object[3];
		int day = DateUtil.getDateSpace(beginTime, endTime);
		if(day<3){
			//近3天内查询分时表
			object[1] = 300L;
			object[2] = false;
			object[0] = "bandwidth_bill";
			return object;
		}else if(day<=31){		//1个月内，能聚合就聚合，不能查询月表
			object[1] = 3600L;
			object[0] = "bandwidth_bill";
			object[2] = true;
			return object;
		}else{		//2个月内，能聚合就聚合，不能查询季表
			object[0] = "bandwidth_season";
			object[1] = 7200L;
			object[2] = false;
			return object;
		}
	}
	
	public static String findAttackBandWidthSql(String beginTime, String endTime, Integer custId,String type,Integer domainId) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select wai_timestamp,wai_bandwidth from ")
			     .append(ShyyDataUtil.formatCustomerID(custId))
			     .append(".waf_attack_info")
			     .append(" where 1=1");
		if(!StringUtils.isEmpty(beginTime) &&!StringUtils.isEmpty(endTime)) {
			if(beginTime.equals(endTime)) {
				sqlBuffer.append(" and wai_timestamp = ")
                         .append(beginTime);
			}else {
				sqlBuffer.append(" and wai_timestamp between ")
                         .append(beginTime)
                         .append(" and ")
                         .append(endTime);
			}
			
		}
		if(!StringUtils.isEmpty(type)) {
			sqlBuffer.append(" and wai_type = ")
	                 .append(type);
		}
		if(!StringUtils.isEmpty(domainId)) {
			sqlBuffer.append(" and wai_dniid = ")
	                 .append(domainId);
		}
		return sqlBuffer.toString();
	}

}
