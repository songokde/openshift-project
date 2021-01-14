package com.newcloud.waf.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.logicalcobwebs.proxool.util.ParameraterBuilder;

import com.newcloud.waf.storage.entity.info.InfoDatabase;


public class ConnectionFactory {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String proxoolDriver = "org.logicalcobwebs.proxool.ProxoolDriver";
	
	private static ConnectionFactory factory = new ConnectionFactory();
	
	private ConnectionFactory(){	}
	public static ConnectionFactory getFactory(){
		return factory;
	}
	
	public Connection getWebConnection() throws Exception{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection("proxool.control");
		return conn;
	}
	
	public Connection getWafConnection() throws Exception{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection("proxool.waf");
		return conn;
	}
	
	/**
	 * 获取当前带宽查询库
	 * 
	 * @param dbInfo
	 * @return
	 * @throws Exception
	 */
	public Connection getDynicBandwidthConnection(InfoDatabase dbInfo) throws Exception{
		if(dbInfo==null){
			return null;
		}
		Connection conn = null;
		String alias = dbInfo.getDdiInip();
		if(ProxoolAliasCaChe.getInstance().hasAlias(alias)){    	
			conn = DriverManager.getConnection("proxool." + alias);
		}else{
			Properties info=new Properties();
			info.setProperty("proxool.minimum-connection-count", "5");
			info.setProperty("proxool.maximum-connection-count", "10");
			info.setProperty("proxool.house-keeping-test-sql", "select CURRENT_DATE");
			info.setProperty("proxool.house-keeping-sleep-time","90000");
			info.setProperty("proxool.test-before-use", "true");
			info.setProperty("user", dbInfo.getDdiDbuser());
			info.setProperty("password",ParameraterBuilder.clear(dbInfo.getDdiDbpwd()));
			String driverClass = driver;
			String driverUrl = "jdbc:mysql://"+alias+":"+dbInfo.getDdiDbport()+"/"+dbInfo.getDdiDbname();
			if(alias.equals("218.91.230.18")) {
				driverUrl += "?useSSL=false";
			}
			String url = "proxool." + alias + ":" + driverClass + ":" + driverUrl;	
			Class.forName(proxoolDriver);
			conn = DriverManager.getConnection(url, info);
			if(conn!=null){
				ProxoolAliasCaChe.getInstance().setList(alias);
			}
		}
		return conn;
	}
	
    /**
     * 其他数据库
     * 
     * @param type
     * @return
     */
    public static Connection getOtherDatabaseConnection(String type){
		Connection conn = null;
		//DatabaseInfo database = OtherDatabaseConfig.getInstance().getOtherDb(type);
		//if(database!=null) {
			try {
				//String alias = type+"_"+database.getDbIp();
				String alias ="waf_127.0.0.1";
				if(ProxoolAliasCaChe.getInstance().hasAlias(alias)){    	
					conn = DriverManager.getConnection("proxool." + alias);
				}else{
					Properties info=new Properties();
//					info.setProperty("proxool.minimum-connection-count", database.getInitPool().toString());
//					info.setProperty("proxool.maximum-connection-count", database.getMaxPool().toString());
//					info.setProperty("proxool.house-keeping-test-sql", "select CURRENT_DATE");
//					info.setProperty("proxool.house-keeping-sleep-time","90000");
//					info.setProperty("proxool.test-before-use", "true");
//					info.setProperty("user", database.getDbUser());
//					info.setProperty("password",ParameraterBuilder.clear(database.getDbPassword()));
//					String driverClass = driver;
//					String driverUrl = "jdbc:mysql://"+database.getDbIp()+":"+database.getDbPort()+"/"+database.getDbName();
//					if(database.getDbIp().equals("218.91.230.18")) {
//						driverUrl += "?useSSL=false";
//					}
//					String url = "proxool." + alias + ":" + driverClass + ":" + driverUrl;	
					info.setProperty("proxool.minimum-connection-count", "20");
					info.setProperty("proxool.maximum-connection-count", "30");
					info.setProperty("proxool.house-keeping-test-sql", "select CURRENT_DATE");
					info.setProperty("proxool.house-keeping-sleep-time","90000");
					info.setProperty("proxool.test-before-use", "true");
					info.setProperty("user", "waf_suid");
					info.setProperty("password","Waf!%*S1uD");
					String driverClass = driver;
					String driverUrl = "jdbc:mysql://127.0.0.1:33606/";
					/*if(database.getDbIp().equals("218.91.230.18")) {
						driverUrl += "?useSSL=false";
					}*/
					String url = "proxool." + alias + ":" + driverClass + ":" + driverUrl;	
					Class.forName(proxoolDriver);
					conn = DriverManager.getConnection(url, info);
					if(conn!=null){
						ProxoolAliasCaChe.getInstance().setList(alias);
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		//}
		return conn;
	}
	
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		try{
			if(rs != null){
				rs.close();
			}
			
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
