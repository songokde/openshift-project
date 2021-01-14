package com.newcloud.waf.connection;

import java.util.ArrayList;
import java.util.List;

public class ProxoolAliasCaChe {
	private volatile static ProxoolAliasCaChe instance = null;
	private List<String> list = new ArrayList<>(); 
	private static long cacheTime;

	private ProxoolAliasCaChe() {}

	public static ProxoolAliasCaChe getInstance() {
        if (instance == null) {
            synchronized (ProxoolAliasCaChe.class) {
            	instance = new ProxoolAliasCaChe();
            }
        }else {
        	synchronized (ProxoolAliasCaChe.class) {
        		if(System.currentTimeMillis()/1000l - cacheTime > 3600L){
        			instance.clear();
    			}
        	}
        }
        return instance;
    }
	
	private void clear(){
    	if(list!= null) {
    		list.clear();
		}
	}
	
	/**
	 * 存放信息到list
	 */
	public void setList(String alias){
		list.add(alias);
	}
	
	/**
	 * 获取信息，list是否存在信息
	 */
	public boolean hasAlias(String aliasString)
	{
		for(int i=0;i<list.size();i++)
		{
		    if(aliasString.equals(list.get(i)))
			{
				return true;
			}
		}
		return false;
	}
	

}