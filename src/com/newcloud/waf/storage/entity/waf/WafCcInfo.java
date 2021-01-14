package com.newcloud.waf.storage.entity.waf;

import com.newcloud.waf.storage.entity.BaseEntity;

/**
 * cc防护规则表
 * @author song
 *
 */
public class WafCcInfo extends BaseEntity{
	private static final long serialVersionUID = 2253130519348764636L;
	
	private Integer wciId;            //id
	 
	private Integer wciCusId;         //客户id
	
	private String  wciRuleName;      //规则名称
	 
	private String wciUrl;            //url
	
	private String wciRuleInfo;       //匹配规则  0完全匹配 1前缀匹配
	
	private Integer wciDuration;      //检测时长 秒
	
	private Integer wciIpCount;       //单一ip访问次数
	
	private String wciMovement;       //阻断动作 0封禁 1 人机识别
	
	private Integer wciTime;         //封禁多少分钟 

	
	public WafCcInfo() {
		super();
	}


	public Integer getWciId() {
		return wciId;
	}


	public void setWciId(Integer wciId) {
		this.wciId = wciId;
	}



	public String getWciUrl() {
		return wciUrl;
	}


	public void setWciUrl(String wciUrl) {
		this.wciUrl = wciUrl;
	}


	public Integer getWciDuration() {
		return wciDuration;
	}


	public void setWciDuration(Integer wciDuration) {
		this.wciDuration = wciDuration;
	}


	public String getWciMovement() {
		return wciMovement;
	}


	public void setWciMovement(String wciMovement) {
		this.wciMovement = wciMovement;
	}


	public Integer getWciTime() {
		return wciTime;
	}


	public void setWciTime(Integer wciTime) {
		this.wciTime = wciTime;
	}


	public Integer getWciCusId() {
		return wciCusId;
	}


	public void setWciCusId(Integer wciCusId) {
		this.wciCusId = wciCusId;
	}


	public String getWciRuleName() {
		return wciRuleName;
	}


	public void setWciRuleName(String wciRuleName) {
		this.wciRuleName = wciRuleName;
	}


	public String getWciRuleInfo() {
		return wciRuleInfo;
	}


	public void setWciRuleInfo(String wciRuleInfo) {
		this.wciRuleInfo = wciRuleInfo;
	}


	public Integer getWciIpCount() {
		return wciIpCount;
	}


	public void setWciIpCount(Integer wciIpCount) {
		this.wciIpCount = wciIpCount;
	}



	
}