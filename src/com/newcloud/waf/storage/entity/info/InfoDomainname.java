package com.newcloud.waf.storage.entity.info;

import com.newcloud.waf.storage.entity.BaseEntity;

public class InfoDomainname extends BaseEntity{
	private static final long serialVersionUID = 5877948535279005015L;
	
	private Integer dniId;
	private String dniDname;
	private Integer dniCusid;
	private Long dniBwratio;
	

	public InfoDomainname() {
	}

	public InfoDomainname(Integer dniId) {
		super();
		this.dniId = dniId;
	}

	public Integer getDniId() {
		return dniId;
	}

	public void setDniId(Integer dniId) {
		this.dniId = dniId;
	}

	public String getDniDname() {
		return dniDname;
	}

	public void setDniDname(String dniDname) {
		this.dniDname = dniDname;
	}

	public Integer getDniCusid() {
		return dniCusid;
	}

	public void setDniCusid(Integer dniCusid) {
		this.dniCusid = dniCusid;
	}

	public Long getDniBwratio() {
		return dniBwratio;
	}

	public void setDniBwratio(Long dniBwratio) {
		this.dniBwratio = dniBwratio;
	}

	
	
}