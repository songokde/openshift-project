package com.newcloud.waf.storage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.newcloud.waf.connection.ConnectionFactory;
import com.newcloud.waf.storage.dao.IOverViewDAO;
import com.newcloud.waf.storage.dao.util.DateUtil;
import com.newcloud.waf.storage.dao.util.OverViewSqlUtil;
import com.newcloud.waf.storage.dao.util.ShyyDataUtil;
import com.newcloud.waf.storage.entity.info.InfoDatabase;
import com.newcloud.waf.storage.entity.waf.WafAttackInfo;
import com.newcloud.waf.util.ShyyConstant;
import com.newcloud.waf.util.ShyyDateUtil;

@Repository
public class OverViewDAO implements IOverViewDAO{
	//-------------------------------------------------总览-----------------------------------------------------------------
	@Override
	public Map<String, Map<String, Long>> findRecentMapByTime(long begin, long end,Integer custId)
			throws Exception {
		Map<String, Map<String, Long>> resultMap = new TreeMap<String, Map<String,Long>>();
		
		//其他时间补0
		List<String> cctimeList =new ArrayList<>();
		List<String> visittimeList =new ArrayList<>();
		List<String> webtimeList =new ArrayList<>();
		long checkTime = begin;
		while(checkTime < end) {
			cctimeList.add(ShyyDateUtil.getDateTime(checkTime));
			visittimeList.add(ShyyDateUtil.getDateTime(checkTime));
			webtimeList.add(ShyyDateUtil.getDateTime(checkTime));
			checkTime +=86400;
		}
		//其他时间补0
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sqlSelect=OverViewSqlUtil.findRecentMapSql(begin, end, custId);
			conn = ConnectionFactory.getFactory().getOtherDatabaseConnection("WAF");
			ps = conn.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				String key = ShyyConstant.typeMap.get(rs.getInt("wai_type"));
				String time = ShyyDateUtil.getDateTime(rs.getLong("wai_timestamp"));
				Long count = rs.getLong("count");
				if(resultMap.containsKey(key)) {
					if(resultMap.get(key).containsKey(time)) {
						Long newCount = resultMap.get(key).get(time)+count;
						resultMap.get(key).put(time,newCount);
					}else {
						resultMap.get(key).put(time, count);
					}
				}else {
					 Map<String, Long> map =new TreeMap<>();
					 map.put(time, count);
					 resultMap.put(key, map);
				}
				if(key.equals("cc")) {
					cctimeList.remove(time);
				}else if(key.equals("visit")) {
					visittimeList.remove(time);
				}else {
					webtimeList.remove(time);
				}
			}
			
			for(String ccTime:cctimeList) {
				if(resultMap.containsKey("cc")) {
					resultMap.get("cc").put(ccTime, 0l);
				}else {
					Map<String,Long> map =new TreeMap<>();
					map.put(ccTime, 0l);
					resultMap.put("cc", map);
				} 
			}
			for(String visitTime:visittimeList) {
				 if(resultMap.containsKey("visit")) {
					 resultMap.get("visit").put(visitTime, 0l);
				 }else {
					 Map<String,Long> map =new TreeMap<>();
					 map.put(visitTime, 0l);
					 resultMap.put("visit", map);
				 } 
			}
			for(String webTime:webtimeList) {
				 if(resultMap.containsKey("web")) {
					 resultMap.get("web").put(webTime, 0l);
				 }else {
					 Map<String,Long> map =new TreeMap<>();
					 map.put(webTime, 0l);
					 resultMap.put("web", map);
				 } 
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		return resultMap;
	}
	
	//--------------------------------------------------------------报表---------------------------------------------------------------
	@Override
	public Map<String, Long> findAttackIpTopList(Integer domainId, String type, Integer beginTime, Integer endTime,
			Integer custId) throws Exception {
		Map<String,Long> resultMap = new HashMap<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sqlSelect=OverViewSqlUtil.findTopIpSql(domainId,beginTime,endTime, custId,type);
			conn = ConnectionFactory.getFactory().getOtherDatabaseConnection("WAF");
			ps = conn.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				resultMap.put(rs.getString("wai_nodeip"), rs.getLong("count"));
			}
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		return resultMap;
	}


	@Override
	public List<WafAttackInfo> findAttackList(Integer domainId, String type, Integer beginTime, Integer endTime,Integer custId) throws Exception {
		List<WafAttackInfo> list =new ArrayList<WafAttackInfo>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sqlSelect=OverViewSqlUtil.findAttackIpSql(domainId, type,beginTime,endTime, custId);
			conn = ConnectionFactory.getFactory().getOtherDatabaseConnection("WAF");
			ps = conn.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				WafAttackInfo info = new WafAttackInfo();
				info.setWaiArea(rs.getInt("wai_area"));
				info.setWaiAttackIp(rs.getString("wai_attackip"));
				info.setWaiBandwidth(rs.getLong("wai_bandwidth"));
				info.setWaiCount(rs.getLong("wai_count"));
				info.setWaiDate(rs.getLong("wai_date"));
				info.setWaiDniId(rs.getInt("wai_dniid"));
				info.setWaiMethod(rs.getInt("wai_method"));
				info.setWaiNodeIp(rs.getString("wai_nodeip"));
				info.setWaiTimeStamp(rs.getLong("wai_timestamp"));
				info.setWaiType(rs.getInt("wai_type"));
				info.setWaiCode(rs.getInt("wai_code"));
				info.setWaiIsp(rs.getInt("wai_isp"));
				info.setWaiUrl(rs.getString("wai_url"));
				list.add(info);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public Map<String, Double> findBandWidthMap(Long beginTime, Long endTimestamp, Integer custId,String type,Integer domainId)
			throws Exception {
		Map<String, Double>  resultMap = new TreeMap<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sqlSelect=OverViewSqlUtil.findBandWidthSql(beginTime, endTimestamp,custId,type,domainId);
			conn = ConnectionFactory.getFactory().getOtherDatabaseConnection("WAF");
			ps = conn.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				Double bandWidth = rs.getDouble("wau_bandwidth");
				String time = ShyyDateUtil.getDateTime(rs.getLong("wau_timestamp"));
				if(resultMap.containsKey(time)) {
					resultMap.put(time, resultMap.get(time)+bandWidth);
				}else {
					resultMap.put(time, bandWidth);
				}
			}
			//其他时间补0
			while(beginTime<endTimestamp){
				String time = ShyyDateUtil.getDateTime(beginTime);
				if(!resultMap.containsKey(time)){
					resultMap.put(time, 0d);
				}
				beginTime +=86400;
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		return resultMap;
	}


	@Override
	public Map<Integer, Long> findCodeMap(long beginTimestamp, long endTimestamp,String type,Integer domainId, Integer custId) throws Exception {
		Map<Integer, Long>  resultMap = new HashMap<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sqlSelect=OverViewSqlUtil.findCodeMapSql(beginTimestamp, endTimestamp,type,domainId,custId);
			conn = ConnectionFactory.getFactory().getOtherDatabaseConnection("WAF");
			ps = conn.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				resultMap.put(rs.getInt("wac_code"), rs.getLong("wac_count"));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		return resultMap;
	}

	@Override
	public Map<String, Integer> findCountByType(Integer domainId, String type, Integer beginTimestamp,
			Integer endTimestamp, Integer custId) throws Exception {
		Map<String, Integer>  resultMap = new HashMap<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sqlSelect=OverViewSqlUtil.findCountByTypeSql(beginTimestamp, endTimestamp,type,domainId,custId);
			conn = ConnectionFactory.getFactory().getOtherDatabaseConnection("WAF");
			ps = conn.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
			Integer count=0;
			Integer ipCount=0;
			while (rs.next()) {
				count+= rs.getInt("count");
				ipCount++;
			}
			resultMap.put("count", count);
			resultMap.put("ipCount", ipCount);
		} catch (SQLException e) {
			throw e;
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		return resultMap;
	}

	@Override
	public Integer findUrlCountByType(Integer domainId, String type, Integer beginTimestamp, Integer endTimestamp,
			Integer custId) throws Exception {
		Integer count=0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sqlSelect=OverViewSqlUtil.findUrlCountByType(beginTimestamp, endTimestamp,type,domainId,custId);
			conn = ConnectionFactory.getFactory().getOtherDatabaseConnection("WAF");
			ps = conn.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		return count;
	}

	@Override
	public Map<Integer, Long> findAreaMap(Integer beginTimestamp, Integer endTimestamp, String type, Integer domainId,
			Integer custId) throws Exception {
		Map<Integer, Long>  resultMap = new HashMap<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sqlSelect=OverViewSqlUtil.findAreaMapSql(beginTimestamp, endTimestamp,type,domainId,custId);
			conn = ConnectionFactory.getFactory().getOtherDatabaseConnection("WAF");
			ps = conn.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				resultMap.put(rs.getInt("wai_area"), rs.getLong("count"));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		return resultMap;
	}

	@Override
	public Map<String, Double> findCompareBandwidthMap(String beginTime, String endTime, Integer domainId, Integer custId,
			InfoDatabase db, Long dniBwratio) throws Exception {
		Map<String, Double>  resultMap = new TreeMap<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Object[] obj = OverViewSqlUtil.getBandwidthSqlUtil(beginTime,endTime);
			String sqlSelect=OverViewSqlUtil.findDomainBandWidthSql(beginTime, endTime,domainId,custId,dniBwratio,obj);
			conn = ConnectionFactory.getFactory().getDynicBandwidthConnection(db);
			ps = conn.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				String time = DateUtil.fromUnixtime(rs.getLong(1), "yyyy-MM-dd HH:mm:ss");
				Double value = rs.getDouble(2);
				if(resultMap.containsKey(time)){
					resultMap.put(time, resultMap.get(time)+value);
				}else{
					resultMap.put(time, value);
				}
			}
			//补0
			long minuteGap = (Long)obj[1];
			long begin = DateUtil.getLongTimeStamp(beginTime);
			long end = DateUtil.getLongTimeStamp(endTime)+86400L;
			while(begin<end){
				if(!resultMap.containsKey(begin)){
					resultMap.put(DateUtil.fromUnixtime(begin, "yyyy-MM-dd HH:mm:ss"), 0D);
				}
				beginTime = beginTime + minuteGap;
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		return resultMap;
	}

	@Override
	public Map<String, Double> findAttackBandWidthMap(String beginTime, String endTime, Integer custId, String type,Integer domainId) throws SQLException {
		Map<String, Double>  resultMap = new TreeMap<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Object[] obj = OverViewSqlUtil.getBandwidthSqlUtil(beginTime,endTime);
			String sqlSelect=OverViewSqlUtil.findAttackBandWidthSql(beginTime, endTime,custId,type,domainId);
			conn = ConnectionFactory.getFactory().getOtherDatabaseConnection("WAF");
			ps = conn.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				String time = DateUtil.fromUnixtime(rs.getLong(1), "yyyy-MM-dd HH:mm:ss");
				Double value = rs.getDouble(2);
				if(resultMap.containsKey(time)){
					resultMap.put(time, resultMap.get(time)+value);
				}else{
					resultMap.put(time, value);
				}
			}
			//补0
			long minuteGap = (Long)obj[1];
			long begin = DateUtil.getLongTimeStamp(beginTime);
			long end = DateUtil.getLongTimeStamp(endTime)+86400L;
			while(begin<end){
				if(!resultMap.containsKey(DateUtil.fromUnixtime(begin, "yyyy-MM-dd HH:mm:ss"))){
					resultMap.put(DateUtil.fromUnixtime(begin, "yyyy-MM-dd HH:mm:ss"), 0D);
				}
				beginTime = beginTime + minuteGap;
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		return resultMap;
		
	}


	
	
}
