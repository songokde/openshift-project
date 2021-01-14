package com.newcloud.waf.web.controller.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newcloud.waf.service.IDomainConfigService;
import com.newcloud.waf.storage.entity.BaseEntity;
import com.newcloud.waf.storage.entity.ComBox;
import com.newcloud.waf.storage.entity.waf.WafCcInfo;
import com.newcloud.waf.storage.entity.waf.WafDomainInfo;
import com.newcloud.waf.storage.entity.waf.WafExactInfo;
import com.newcloud.waf.web.controller.BaseController;
import com.newcloud.waf.web.controller.config.vo.DomainConfigVO;
import com.newcloud.waf.web.controller.config.vo.RulesVO;

/**
 * 域名-域名配置
 * @author song
 *
 */
@Controller
@RequestMapping("/config")
public class DomainConfigController extends BaseController{

	@Resource
	private IDomainConfigService domainConfigService;
	
	/**
	 * 已添加域名下拉框
	 * @return
	 */
    @RequestMapping("/combox")
    @ResponseBody
	public List<ComBox> getDomainCom(){
    	try {
			return baseService.findCombox(WafDomainInfo.class, "wdiDniId", "wdiDname");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<ComBox>();
    }
    
    
    /**
	 * session域名下拉框
	 * @return
	 */
    @RequestMapping("/sessionCom")
    @ResponseBody
	public List<ComBox> getSessionDomainCom(String type){
    	try {
    		List<ComBox> list = baseService.findCombox(WafDomainInfo.class, "wdiDniId", "wdiDname");
    		List<ComBox> comxList = new ArrayList<>();
    		Map<Integer,String> map =getNowDomainMap();
    		for(ComBox com:list) {
    			map.remove(com.getId());
    		}
    		if(null!=map) {
    			for(Entry<Integer, String> entry:map.entrySet()) {
        			comxList.add(new ComBox(entry.getKey(), entry.getValue()));
        		}
    		}
    		
			return comxList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<ComBox>();
    }
    
    /**
     * 查询域名列表
     * @param domain
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
	public Map<String,Object> getDomainList(String domain,Integer offset,Integer limit){
    	Integer custId = getNowCompany().getCusId();
    	domain = domain==null?"":domain;
		offset = offset==null?0:(offset/limit)+1;
		limit = limit==null?10:limit;
		Map<String,Object> map = new HashMap<String, Object>();
		try{
			map.put("rows",domainConfigService.findDomainList(custId,domain, offset, limit));
			map.put("total", domainConfigService.findDomainCount(custId,domain));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
    }
    
    /**
     * 查询防护详情
     */
    @RequestMapping("/info")
    @ResponseBody
	public DomainConfigVO getDomainInfo(Integer id){
		try{
			DomainConfigVO vo = new DomainConfigVO();
			Integer custId =getNowCompany().getCusId();
			Map<Integer,String> ccMap = baseService.findComboxMap(WafCcInfo.class, "wciId", "wciRuleName","wciCusId =?",new Object[] {custId});
			Map<Integer,String> wxactMap = baseService.findComboxMap(WafExactInfo.class, "weiId", "weiRuleName","weiCusId=?",new Object[] {custId});
			WafDomainInfo info = baseService.findInfo(WafDomainInfo.class, id);
			vo.setDomainId(info.getWdiDniId());
			vo.setDomainName(info.getWdiDname());
			if(!StringUtils.isEmpty(info.getWdiCcIds())) {
				String ccName="";
				for(String cc:info.getWdiCcIds().split(",")) {
					if(!StringUtils.isEmpty(ccName)) {
						ccName+=","+ccMap.get(Integer.valueOf(cc));
					}else {
						ccName=ccMap.get(Integer.valueOf(cc));
					}
				}
				vo.setCcStatus("Y");
				vo.setCcRuleNames(ccName);
				vo.setCcRuleIds(info.getWdiCcIds());
			}else {
				vo.setCcStatus("N");
			}
			if(!StringUtils.isEmpty(info.getWdiExactIds())) {
				String exactName="";
				for(String exact:info.getWdiExactIds().split(",")) {
					if(!StringUtils.isEmpty(exactName)) {
						exactName+=","+wxactMap.get(Integer.valueOf(exact));
					}else {
						exactName=wxactMap.get(Integer.valueOf(exact));
					}
				}
				vo.setExactStatus("Y");
				vo.setExactRuleIds(info.getWdiExactIds());
				vo.setExactRuleNames(exactName);
			}else {
				vo.setExactStatus("N");
			}
			if(!StringUtils.isEmpty(info.getWdiIpSegment())) {
				vo.setIpStatus("Y");
				vo.setIpSegment(info.getWdiIpSegment());
			}else {
				vo.setIpStatus("N");
			}
			
			if(!StringUtils.isEmpty(info.getWdiWebShield())) {
				vo.setWebStatus("Y");
			}else {
				vo.setWebStatus("N");
			}
			return vo;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
	/**
	 * 更新域名防护规则
	 * @return
	 */
    @RequestMapping("/up")
    @ResponseBody
	public String updateDomainConfig(DomainConfigVO vo,String type){
    	boolean flag = false;
    	try {
    		WafDomainInfo info = new WafDomainInfo();
    		info.setWdiDname(vo.getDomainName());
			info.setWdiDniId(vo.getDomainId());
			info.setWdiCusId(getNowCompany().getCusId());
    		if(vo.getWebStatus().equals("Y")) {
    			info.setWdiWebShield("Y");
    		}else {
    			info.setWdiWebShield("N");
    		}
    		if(vo.getIpStatus().equals("Y")) {
				info.setWdiIpSegment(vo.getIpSegment());
			}
    		if(vo.getCcStatus().equals("Y")) {
    			info.setWdiCcIds(vo.getCcRuleIds());
    		}
    		if(vo.getExactStatus().equals("Y")) {
    			info.setWdiExactIds(vo.getExactRuleIds());
    		}
    		if(type.equals("add")) {
    			flag = baseService.save(info);
    		}else {
    			flag = baseService.update(info);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag?"OK":"ERROR";
    }
    
    
    /**
     * 删除域名
     * @param domainId
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
	public String deleteDomain(Integer domainId){
		boolean flag =false;
    	try{
			BaseEntity entity = baseService.findInfo(WafDomainInfo.class, domainId);
			flag = baseService.delete(entity);
			if(flag) {
				getNowDomainMap();
    		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag?"OK":"ERROR";
    }
    
    /**
     * 获取已选与未选的左右框
     */
    @RequestMapping("/ruleList")
    @ResponseBody
    public List<RulesVO> findRule(Integer domainId,String type){
    	List<RulesVO> ruleList = new ArrayList<>();
    	try{
    		Integer custId =getNowCompany().getCusId();
    		Map<Integer,String>  map = new HashMap<>();
    		WafDomainInfo info = baseService.findInfo(WafDomainInfo.class, domainId);
    		if(type.equals("cc")) {
    			map = baseService.findComboxMap(WafCcInfo.class, "wciId", "wciRuleName","wciCusId =?",new Object[] {custId});
    			if(info !=null) {
    				if(!StringUtils.isEmpty(info.getWdiCcIds())) {
        				for(String id: info.getWdiCcIds().split(",")) {
        					ruleList.add(new RulesVO(Integer.valueOf(id),map.get(Integer.valueOf(id)),true));
        					map.remove(Integer.valueOf(id));
        				}
        			}
    			}
    		}else {
    			map = baseService.findComboxMap(WafExactInfo.class, "weiId", "weiRuleName","weiCusId=?",new Object[] {custId});
    			if(info !=null) {
    				if(!StringUtils.isEmpty(info.getWdiExactIds())) {
        				for(String id: info.getWdiExactIds().split(",")) {
        					ruleList.add(new RulesVO(Integer.valueOf(id),map.get(Integer.valueOf(id)),true));
        					map.remove(Integer.valueOf(id));
        				}
        			}
    			}
    		}
    		for(Entry<Integer,String> entity :map.entrySet()) {
    			ruleList.add(new RulesVO(entity.getKey(),entity.getValue(),false));
    		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ruleList;
    }

}
