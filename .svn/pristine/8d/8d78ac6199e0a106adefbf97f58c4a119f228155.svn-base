package com.newcloud.waf.web.controller.overview;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newcloud.waf.service.IAreaService;
import com.newcloud.waf.service.ICcConfigService;
import com.newcloud.waf.service.IOverViewService;
import com.newcloud.waf.storage.entity.info.InfoDatabase;
import com.newcloud.waf.storage.entity.info.InfoDomainname;
import com.newcloud.waf.storage.entity.waf.WafAttackInfo;
import com.newcloud.waf.util.ShyyConstant;
import com.newcloud.waf.util.ShyyDateUtil;
import com.newcloud.waf.web.controller.BaseController;
import com.newcloud.waf.web.controller.overview.vo.AreaVO;

/**
 * 主页-主页展示
 * @author song
 *
 */
@Controller
@RequestMapping("/over")
public class OverViewController extends BaseController{
	
	@Resource
	private IOverViewService overViewService;
	
	@Resource
	private ICcConfigService ccConfigService;
	
	@Resource
	private IAreaService areaService;
//------------------------------------------------------------主页方法---------------------------------------------------
    @RequestMapping("/allMap")
    @ResponseBody
	public Map<String,Map<String,Object>> getViewMap(){
    	Integer custId = getNowCompany().getCusId();
    	Map<String,Map<String,Object>> resultMap = new HashMap<>();
    	try {
			long endTimestamp = System.currentTimeMillis() / 1000;
			long beginTimestamp =ShyyDateUtil.getZeroDate(new Date().getTime());
			//昨天时间  0点
			long oneTime =ShyyDateUtil.getZeroDate((ShyyDateUtil.getPastDate(1)));
			long sixTime = ShyyDateUtil.getZeroDate((ShyyDateUtil.getPastDate(6)));
			//今天  今天0点到当前时间
			Map<String,Long> todayMap = overViewService.findCountByTime(beginTimestamp,endTimestamp,custId);
			//昨天 昨天0点到今天0点
			Map<String,Long> yesterdayMap = overViewService.findCountByTime(oneTime,beginTimestamp,custId);
			
			Map<String,Object> countTitle = new HashMap<String, Object>();
			for(Entry<Integer, String> entrty:ShyyConstant.typeMap.entrySet()) {
				countTitle.put("yesterday", yesterdayMap.get(entrty.getValue())==null?0:yesterdayMap.get(entrty.getValue()));
				countTitle.put("today", todayMap.get(entrty.getValue())==null?0:todayMap.get(entrty.getValue()));
				resultMap.put(entrty.getValue(), countTitle);
			}
			
			//7天数据 按天统计  map<类型,map<时间,请求>>  画图
			Map<String,Map<String,Long>> recentMap = overViewService.findRecentMapByTime(sixTime,endTimestamp,custId);
			for(Entry<Integer, String> entrty:ShyyConstant.typeMap.entrySet()) {
				if(recentMap.get(entrty.getValue()) == null) {
					resultMap.put(entrty.getValue()+"Char", new HashMap<String,Object>());
				}else {
					Map<String,Long> bandwidthMap = recentMap.get(entrty.getValue());
					Map<String,Object> map = new TreeMap<String, Object>();
					map.put("time",bandwidthMap.keySet());
					map.put("value", bandwidthMap.values());
					resultMap.put(entrty.getValue()+"Char", map);
				}
			}
			//带宽图 
			Map<String,Double> bandWidthMap = overViewService.findBandWidthMap(sixTime,endTimestamp,custId,"",-1);
			Map<String,Object> childMap = new TreeMap<String, Object>();
			childMap.put("time", bandWidthMap.keySet());
			childMap.put("value", bandWidthMap.values());
			resultMap.put("bandwidth", childMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return resultMap;
	}
    
    
//----------------------------------------------------------------------报表中方法--------------------------------------------------------------
    @RequestMapping("/reportMap")
    @ResponseBody
	public Map<String,Integer> getReportMap(Integer domainId,String type,String beginTime,String endTime){
    	Integer custId = getNowCompany().getCusId();
    	Integer begin = Integer.valueOf(beginTime.replace("-", ""));
    	Integer end = Integer.valueOf(endTime.replace("-", ""));
    	try {
    		Map<String,Integer> map = overViewService.findCountByType(domainId,type,begin,end,custId);
			Integer urlCount = overViewService.findUrlCountByType(domainId,type,begin,end,custId);
			map.put("urlCount", urlCount);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
	}
    
    
    /**
     * 报表 iptable 最新20条 
     */
	@ResponseBody
	@RequestMapping("ipList")
	public List<WafAttackInfo> AttackIpList(Integer domainId,String type,String beginTime,String endTime){
		Integer custId = getNowCompany().getCusId();
		Integer begin = Integer.valueOf(beginTime.replace("-", ""));
    	Integer end = Integer.valueOf(endTime.replace("-", ""));
		try{
			Map<Integer,String> areaMap = areaService.getAreaMap();
			List<WafAttackInfo> list =overViewService.findAttackList(domainId,type,begin,end,custId);
			for(WafAttackInfo info:list) {
				info.setAreaName(areaMap.get(info.getWaiArea())==null?"其他":areaMap.get(info.getWaiArea()));
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
	/**
     * 报表 ip top 5
     */
	@ResponseBody
	@RequestMapping("ipTop")
	public Map<String,Object> AttackIpTopList(Integer domainId,String type,String beginTime,String endTime){
		Integer custId = getNowCompany().getCusId();
		Integer begin = Integer.valueOf(beginTime.replace("-", ""));
    	Integer end = Integer.valueOf(endTime.replace("-", ""));
		Map<String,Object> resultMap = new HashMap<>();
		try{
			 Map<String,Long> map = overViewService.findAttackIpTopList(domainId,type,begin,end,custId);
			 resultMap.put("ip", map.keySet());
			 resultMap.put("value", map.values());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 状态码图   
	 * code
	 */
	@ResponseBody
	@RequestMapping("codeMap")
	public Map<Integer,Long> findCodeMap(Integer domainId,String type,String beginTime,String endTime){
		Integer custId = getNowCompany().getCusId();
		Integer begin = Integer.valueOf(beginTime.replace("-", ""));
    	Integer end = Integer.valueOf(endTime.replace("-", ""));
		try{
			return overViewService.findCodeMap(begin, end, type, domainId, custId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 区域图
	 */
	@ResponseBody
	@RequestMapping("areaMap")
	public List<AreaVO> findAreaMap(Integer domainId,String type,String beginTime,String endTime){
		Integer custId = getNowCompany().getCusId();
		Integer begin = Integer.valueOf(beginTime.replace("-", ""));
    	Integer end = Integer.valueOf(endTime.replace("-", ""));
    	List<AreaVO> list =new ArrayList<>();
    	try{
			Map<Integer,Long> map = overViewService.findAreaMap(begin, end, type, domainId, custId);
			if(map.size()>0) {
				Map<Integer,String> areaMap = areaService.getAreaMap();
				for(Entry<Integer, Long> entity:map.entrySet()) {
					list.add(new AreaVO(areaMap.get(entity.getKey())==null?"其他":areaMap.get(entity.getKey()),entity.getValue()));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 查询带宽图 两条线
	 */
	@ResponseBody
	@RequestMapping("bandwidthMap")
	public Map<String,Object> findCompareBandwidthMap(Integer domainId,String type,String beginTime,String endTime){
		 Map<String,Object> resultMap = new HashMap<>();
		Integer custId = getNowCompany().getCusId();
		try{
			beginTime = beginTime.replace("-", "");
			endTime = endTime.replace("-", "");
			InfoDatabase db = areaService.findInfo(InfoDatabase.class, getNowCompany().getCusCdndb());
			InfoDomainname domain = areaService.findInfo(InfoDomainname.class, domainId);
			Map<String,Double> bandWidthMap = overViewService.findAttackBandWidthMap(beginTime,endTime,custId,type,domainId);
			Map<String,Double> compareBandwidthMap = overViewService.findCompareBandwidthMap(beginTime, endTime, domainId, custId,db,domain.getDniBwratio());
			resultMap.put("time",bandWidthMap.keySet() );
			resultMap.put("bandWidth",bandWidthMap.values() );
			resultMap.put("attackBandWidth",compareBandwidthMap.values());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	
}
