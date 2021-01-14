package com.newcloud.waf.connection;

public class DatabaseInfo {
	private String dbIp;
	private String dbName;
	private String dbUser;
	private String dbPassword;
	private String dbPort;
	private Integer initPool;
	private Integer maxPool;

	public String getDbIp() {
		return dbIp;
	}
	public void setDbIp(String dbIp) {
		this.dbIp = dbIp;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	public String getDbPort() {
		return dbPort;
	}
	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}
	public Integer getInitPool() {
		return initPool;
	}
	public void setInitPool(Integer initPool) {
		this.initPool = initPool;
	}
	public Integer getMaxPool() {
		return maxPool;
	}
	public void setMaxPool(Integer maxPool) {
		this.maxPool = maxPool;
	}
	public DatabaseInfo(String dbIp, String dbName, String dbUser, String dbPassword, String dbPort,
			Integer initPool, Integer maxPool) {
		super();
		this.dbIp = dbIp;
		this.dbName = dbName;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
		this.dbPort = dbPort;
		this.initPool = initPool;
		this.maxPool = maxPool;
	}
	public DatabaseInfo() {
		super();
	}
}
