package com.newcloud.waf.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 聚合IP建议调用顺度
 * 
 * 1、getGroupMap
 * 2、getIpAddressMask
 * 
 * @author Fishwen
 *
 */
public class ShyyIpViewUtil {
	
	/**
	 * 合并IP段[将多小段IP合并成大段IP]
	 * 
	 * @param map
	 * 
	 * @return
	 */
	public static Map<Long,Long> getGroupMap(Map<Long,Long> map){
		Map<Long,Long> dataMap = new TreeMap<Long, Long>();
		long begin = 0;
		long end = 0;
		for(Map.Entry<Long,Long> entry:map.entrySet()){
			if(begin==0 && end==0){
				begin = entry.getKey();
				end = entry.getValue();
			}else{
				long bbegin = entry.getKey();
				if( (end+1L) == bbegin){
					end = entry.getValue();
				}else{
					dataMap.put(begin, end);
					begin = entry.getKey();
					end = entry.getValue();
				}
			}
		}
		dataMap.put(begin, end);
		return dataMap;
	}
	
	/**
	 * 递归方法[传入NULL,开始IP,结束IP]
	 * 
	 * @param masks			设置为NULL调用
	 * @param beginIp		开始IP整型
	 * @param endIp			结束IP整型
	 * 
	 * @return	List<String> String=IP/masks
	 */
	public static List<String> getIpAddressMask(Integer masks,long beginIp,long endIp){
		List<String> list = new ArrayList<String>();
		String ipMask = getIpMask(beginIp,endIp);
		int mask = Integer.parseInt(ipMask.split("/")[1]);
		if(masks!=null){
			ipMask = fromatToStrIp(beginIp)+"/"+masks;
			mask = masks.intValue();
		}
		if(mask==32){
			list.add(ipMask);
			if(beginIp<endIp){
				beginIp = beginIp+1L;
				list.addAll(getIpAddressMask(null,beginIp,endIp));
			}else{
				return list;
			}
		}else{
			long[] anaIpMask = getIPScope(ipMask);
			if(anaIpMask[0]==beginIp && anaIpMask[1]==endIp){
				list.add(ipMask);
				return list;
			}else{
				if(beginIp!=anaIpMask[0]){
					mask ++;
					list.addAll(getIpAddressMask(mask,beginIp,endIp));
				}else{
					if(anaIpMask[1]<endIp){
						list.add(ipMask);
						list.addAll(getIpAddressMask(null,anaIpMask[1]+1,endIp));
					}else{
						mask ++;
						list.addAll(getIpAddressMask(mask,beginIp,endIp));
					}
				}
			}
		}
		return list;
	}

	/**
	 * 根据开始和结束IP获取IP/掩码位[需要getIpAddressMask方法反馈的集合]
	 * 
	 * @param beginIp	开始IP
	 * @param endIp		结束IP
	 * 
	 * @return 如192.168.1.1/24
	 */
	private static String getIpMask(long beginIp,long endIp){
		String bStr = String.format("%32s",Long.toBinaryString(beginIp)).replace(" ", "0");
		String eStr = String.format("%32s",Long.toBinaryString(endIp)).replace(" ", "0");
		int mask = 0;
		for(int i=0;i<4;i++){
			mask = 32;
			String a = bStr.substring(i*8,(i+1)*8);
			String b = eStr.substring(i*8,(i+1)*8);
			if(a.equals(b)){
				continue;
			}else{
				for(int j=0;j<8;j++){
					String c = a.substring(j,j+1);
					String d = b.substring(j,j+1);
					if(!c.equals(d)){
						mask = (i*8) + j;
						return fromatToStrIp(beginIp)+"/"+mask;
					}
				}
			}
		}
		return fromatToStrIp(beginIp)+"/"+mask;
	}
	
	/**
	 * 根据IP和掩码位计算IP范围
	 * 
	 * @param ipAndMask  例如192.168.1.1/24
	 * 
	 * @return long[]{开始IP,结束IP}
	 */
	public static long[] getIPScope(String ipAndMask) {
        String[] ipArr = ipAndMask.split("/");
        if (ipArr.length != 2) {
        	return new long[]{fromToLongIp(ipArr[0]),fromToLongIp(ipArr[0])};
        }
        int netMask = Integer.valueOf(ipArr[1].trim());
        long ipInt = fromToLongIp(ipArr[0]);
        long netIP = ipInt & (0xFFFFFFFF << (32 - netMask));
        long hostScope = (0xFFFFFFFF >>> netMask);
        return new long[] {netIP,netIP+hostScope };
    }
	
	/**
	 * 根据IP和掩码位计算IP范围
	 * 
	 * @param ipAndMask  例如192.168.1.1/24
	 * 
	 * @return long[]{开始IP,结束IP}
	 */
	public static String[] getIPScopeStr(String ipAndMask) {
        String[] ipArr = ipAndMask.split("/");
        if (ipArr.length != 2) {
        	return new String[]{ipArr[0],ipArr[0]};
        }
        int netMask = Integer.valueOf(ipArr[1].trim());
        long ipInt = fromToLongIp(ipArr[0]);
        long netIP = ipInt & (0xFFFFFFFF << (32 - netMask));
        long hostScope = (0xFFFFFFFF >>> netMask);
        return new String[] {fromatToStrIp(netIP),fromatToStrIp(netIP+hostScope)};
    }
	
	/**
	 * 整数转化成IP地址
	 * 
	 * @param longIp 整型IP
	 * 
	 * @return
	 */
	public static String fromatToStrIp(long longIp){
		StringBuilder sb = new StringBuilder();   
		sb.append(String.valueOf((longIp >>> 24)));   
		sb.append(".");   
		sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));   
		sb.append(".");   
		sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));   
		sb.append(".");   
		sb.append(String.valueOf((longIp & 0x000000FF)));        
		return sb.toString();
	}

	/**
	 * IP地址转化成整数
	 * 
	 * @param strIp	IP地址
	 * 
	 * @return
	 */
	public static long fromToLongIp(String strIp){
		long[] ip = new long[4];   
		int position1 = strIp.indexOf(".");   
		int position2 = strIp.indexOf(".", position1 + 1);   
		int position3 = strIp.indexOf(".", position2 + 1);   
		ip[0] = Long.parseLong(strIp.substring(0, position1));   
		ip[1] = Long.parseLong(strIp.substring(position1+1, position2));   
		ip[2] = Long.parseLong(strIp.substring(position2+1, position3));   
		ip[3] = Long.parseLong(strIp.substring(position3+1));   
		long longIp =  (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3]; 
		return longIp;
	}

}
