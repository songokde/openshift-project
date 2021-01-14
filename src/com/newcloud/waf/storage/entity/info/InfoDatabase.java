package com.newcloud.waf.storage.entity.info;

import com.newcloud.waf.storage.entity.BaseEntity;

public class InfoDatabase extends BaseEntity {
	private static final long serialVersionUID = -5007338765284660187L;

	private Short ddiId;
	private String ddiInip; // 带宽查询库
	private String ddiTelip; // 带宽主库
	private String ddiCncip; // 带宽备库
	private String ddiComip; // 状态码库
	private String ddiSourceIp; // 回源带宽
	private String ddiDbname;
	private String ddiDbuser;
	private String ddiDbpwd;
	private String ddiDbport;

	public InfoDatabase() {
		super();
	}

	public InfoDatabase(Short ddiId) {
		super();
		this.ddiId = ddiId;
	}

	public InfoDatabase(Short ddiId, String ddiInip, String ddiTelip,
			String ddiCncip, String ddiComip, String ddiSourceIp,
			String ddiDbname, String ddiDbuser, String ddiDbpwd,
			String ddiDbport) {
		super();
		this.ddiId = ddiId;
		this.ddiInip = ddiInip;
		this.ddiTelip = ddiTelip;
		this.ddiCncip = ddiCncip;
		this.ddiComip = ddiComip;
		this.ddiSourceIp = ddiSourceIp;
		this.ddiDbname = ddiDbname;
		this.ddiDbuser = ddiDbuser;
		this.ddiDbpwd = ddiDbpwd;
		this.ddiDbport = ddiDbport;
	}

	public Short getDdiId() {
		return ddiId;
	}

	public void setDdiId(Short ddiId) {
		this.ddiId = ddiId;
	}

	public String getDdiInip() {
		return ddiInip;
	}

	public void setDdiInip(String ddiInip) {
		this.ddiInip = ddiInip;
	}

	public String getDdiTelip() {
		return ddiTelip;
	}

	public void setDdiTelip(String ddiTelip) {
		this.ddiTelip = ddiTelip;
	}

	public String getDdiCncip() {
		return ddiCncip;
	}

	public void setDdiCncip(String ddiCncip) {
		this.ddiCncip = ddiCncip;
	}

	public String getDdiComip() {
		return ddiComip;
	}

	public void setDdiComip(String ddiComip) {
		this.ddiComip = ddiComip;
	}

	public String getDdiSourceIp() {
		return ddiSourceIp;
	}

	public void setDdiSourceIp(String ddiSourceIp) {
		this.ddiSourceIp = ddiSourceIp;
	}

	public String getDdiDbname() {
		return ddiDbname;
	}

	public void setDdiDbname(String ddiDbname) {
		this.ddiDbname = ddiDbname;
	}

	public String getDdiDbuser() {
		return ddiDbuser;
	}

	public void setDdiDbuser(String ddiDbuser) {
		this.ddiDbuser = ddiDbuser;
	}

	public String getDdiDbpwd() {
		return ddiDbpwd;
	}

	public void setDdiDbpwd(String ddiDbpwd) {
		this.ddiDbpwd = ddiDbpwd;
	}

	public String getDdiDbport() {
		return ddiDbport;
	}

	public void setDdiDbport(String ddiDbport) {
		this.ddiDbport = ddiDbport;
	}
}