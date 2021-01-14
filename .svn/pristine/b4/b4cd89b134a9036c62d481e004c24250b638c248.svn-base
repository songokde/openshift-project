package com.newcloud.waf.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class OtherDatabaseConfig{
    private volatile static OtherDatabaseConfig instance = null;
    public Map<String,DatabaseInfo> otdbMap = new HashMap<String, DatabaseInfo>();
    private static long cacheTime;
    
    private OtherDatabaseConfig() {}

    public static OtherDatabaseConfig getInstance() {
        if (instance == null) {
            synchronized (OtherDatabaseConfig.class) {
                instance = new OtherDatabaseConfig();
                instance.init();
            }
        }else {
        	synchronized (OtherDatabaseConfig.class) {
        		if(System.currentTimeMillis()/1000l - cacheTime > 3600L){
        			instance.clear();
    				instance.init();
    			}
        	}
        }
        return instance;
    }
    
    private void clear(){
    	if(otdbMap!= null) {
			otdbMap.clear();
		}
	}

    private void init(){
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rSet = null;
		cacheTime = System.currentTimeMillis()/1000L;
		try{
			conn = ConnectionFactory.getFactory().getWebConnection();
			stmt = conn.createStatement();
			rSet = stmt.executeQuery("select DDI_TYPE,DDI_INIP,DDI_DBNAME,DDI_DBUSER,DDI_DBPWD,DDI_DBPORT,DDI_INIT,DDI_MAX from info_otherdb");
			while(rSet.next()){
				DatabaseInfo dbInfo = new DatabaseInfo(
						rSet.getString("DDI_INIP"),
						rSet.getString("DDI_DBNAME"),
						rSet.getString("DDI_DBUSER"),
						rSet.getString("DDI_DBPWD"),
						rSet.getString("DDI_DBPORT"),
						rSet.getInt("DDI_INIT"),
						rSet.getInt("DDI_MAX"));
				otdbMap.put(rSet.getString("DDI_TYPE"), dbInfo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, stmt, rSet);
		}
    }

    /**
     * 获取数据库配置
     */
	public DatabaseInfo getOtherDb(String type) {
		return otdbMap.get(type);
	}
}
