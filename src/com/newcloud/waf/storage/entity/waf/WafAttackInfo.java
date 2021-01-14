package com.newcloud.waf.storage.entity.waf;

import com.newcloud.waf.storage.entity.BaseEntity;

/**
 * ip攻击表
 * @author song
 *
 */
public class WafAttackInfo extends BaseEntity{
	private static final long serialVersionUID = 2253130519348764636L;
	
	
	private Long waiTimeStamp;
	
	private Long  waiDate;  
	 
	private Integer waiDniId;
	
	private String waiNodeIp;
	
	private String waiAttackIp;
	
	private Integer waiType;
	
	private Integer waiMethod;
	
	private Long waiCount;
	
	private Integer waiArea;
	
	private Long waiBandwidth;
	
	private Integer waiIsp;
	
	private Integer waiCode;

	private String waiUrl;
	
	private String areaName;
	
	public WafAttackInfo() {
		super();
	}

	public Long getWaiTimeStamp() {
		return waiTimeStamp;
	}

	public void setWaiTimeStamp(Long waiTimeStamp) {
		this.waiTimeStamp = waiTimeStamp;
	}

	public Long getWaiDate() {
		return waiDate;
	}

	public void setWaiDate(Long waiDate) {
		this.waiDate = waiDate;
	}

	public Integer getWaiDniId() {
		return waiDniId;
	}

	public void setWaiDniId(Integer waiDniId) {
		this.waiDniId = waiDniId;
	}

	public String getWaiNodeIp() {
		return waiNodeIp;
	}

	public void setWaiNodeIp(String waiNodeIp) {
		this.waiNodeIp = waiNodeIp;
	}

	public String getWaiAttackIp() {
		return waiAttackIp;
	}

	public void setWaiAttackIp(String waiAttackIp) {
		this.waiAttackIp = waiAttackIp;
	}

	public Integer getWaiType() {
		return waiType;
	}

	public void setWaiType(Integer waiType) {
		this.waiType = waiType;
	}

	public Integer getWaiMethod() {
		return waiMethod;
	}

	public void setWaiMethod(Integer waiMethod) {
		this.waiMethod = waiMethod;
	}

	public Long getWaiCount() {
		return waiCount;
	}

	public void setWaiCount(Long waiCount) {
		this.waiCount = waiCount;
	}

	public Integer getWaiArea() {
		return waiArea;
	}

	public void setWaiArea(Integer waiArea) {
		this.waiArea = waiArea;
	}

	public Long getWaiBandwidth() {
		return waiBandwidth;
	}

	public void setWaiBandwidth(Long waiBandwidth) {
		this.waiBandwidth = waiBandwidth;
	}

	public Integer getWaiIsp() {
		return waiIsp;
	}

	public void setWaiIsp(Integer waiIsp) {
		this.waiIsp = waiIsp;
	}

	public Integer getWaiCode() {
		return waiCode;
	}

	public void setWaiCode(Integer waiCode) {
		this.waiCode = waiCode;
	}

	public String getWaiUrl() {
		return waiUrl;
	}

	public void setWaiUrl(String waiUrl) {
		this.waiUrl = waiUrl;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	
}