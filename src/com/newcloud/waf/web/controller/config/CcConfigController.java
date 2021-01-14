package com.newcloud.waf.web.controller.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newcloud.waf.service.ICcConfigService;
import com.newcloud.waf.service.IDomainConfigService;
import com.newcloud.waf.storage.entity.BaseEntity;
import com.newcloud.waf.storage.entity.waf.WafCcInfo;
import com.newcloud.waf.web.controller.BaseController;

/**
 * cc规则
 * @author song
 *
 */
@Controller
@RequestMapping("/cc")
public class CcConfigController extends BaseController{
	@Resource
	private ICcConfigService ccConfigService;
	
	@Resource
	private IDomainConfigService domainConfigService;
	
	/**
     * 查询cc规则列表
     * @param domain
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
	public Map<String,Object> getCcConfigList(String name,Integer offset,Integer limit){
    	Integer custId = getNowCompany().getCusId();
    	name = name==null?"":name;
		offset = offset==null?0:(offset/limit)+1;
		limit = limit==null?10:limit;
		Map<String,Object> map = new HashMap<String, Object>();
		try{
			map.put("rows",ccConfigService.findCcConfigList(custId,name, offset, limit));
			map.put("total", ccConfigService.findCcConfigCount(custId,name));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
    }
    
    /**
     * cc规则详情
     * @param id
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
	public BaseEntity getCcConfigInfo(Integer id){
		try{
			return baseService.findInfo(WafCcInfo.class, id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    /**
     * 更新cc规则
     * @param info
     * @return
     */
    @RequestMapping("/up")
    @ResponseBody
	public String updateCcConfigInfo(WafCcInfo info){
		boolean flag=false;
    	try{
    		info.setWciCusId(getNowCompany().getCusId());
    		flag = baseService.saveOrUpdate(info);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag?"OK":"ERROR";
    }
    
    /**
     * 删除cc规则详情
     * @param id
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
	public String deleyeCcConfigInfo(Integer wciId){
		boolean flag=false;
    	try{
    		WafCcInfo info =  baseService.findInfo(WafCcInfo.class, wciId);
    		flag = domainConfigService.findDomainByRuleId(info.getWciId(), "cc");
    		if(flag) {
    			return "NO";   //有关联，不让删
    		}
    		flag = baseService.delete(info);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag?"OK":"ERROR";
    }
    
}
