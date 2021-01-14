package com.newcloud.waf.util;

import java.text.DecimalFormat;
/**
 * 
 * @author Fishwen
 *
 */
public class ShyyNumberUtil {

	public static double getFromate2Double(double data){
		if(Double.isInfinite(data)||Double.isNaN(data)){
		    data = 0D;
		}
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.parseDouble(df.format(data));
	}
	
	public static double getFromate3Double(double data){
		if(Double.isInfinite(data)||Double.isNaN(data)){
		    data = 0D;
		}
		DecimalFormat df = new DecimalFormat("0.000");
		return Double.parseDouble(df.format(data));
	}
	
	
	public static String getFromate2String(double data){
		if(Double.isInfinite(data)||Double.isNaN(data)){
		    data = 0D;
		}
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(data);
	}
	
	public static String getFromate3String(double data){
		if(Double.isInfinite(data)||Double.isNaN(data)){
		    data = 0D;
		}
		DecimalFormat df = new DecimalFormat("0.000");
		return df.format(data);
	}
	
	/**
	 * 数组排序
	 * 
	 * @param list
	 * @return
	 */
	public static void desc(Double[] array) {
		//选择排序
		for (int i = 0; i < array.length-1; i++) {
			Double d = array[i];
			int index = i;
			for (int j = 1+i; j < array.length; j++) {
				if (array[j]>d) {
					d = array[j];
					index = j;
				}
			}
			if (index != i) {
				Double temp = array[i];
				array[i] = array[index];
				array[index] = temp;
			}
		}
	}
	
	/**
	 * 数组排序
	 * 
	 * @param list
	 * @return
	 */
	public static void aesc(Double[] array) {
		//选择排序
		for (int i = 0; i < array.length-1; i++) {
			Double d = array[i];
			int index = i;
			for (int j = 1+i; j < array.length; j++) {
				if (array[j]<d) {
					d = array[j];
					index = j;
				}
			}
			if (index != i) {
				Double temp = array[i];
				array[i] = array[index];
				array[index] = temp;
			}
		}
	}
	
	/**
	 * 获取占比
	 * 
	 * @param value
	 * @param all
	 * @return
	 */
	public static double getRatio(Long value,Long all){
		if(value==0L || all==0L){
			return 0d;
		}else{
			return getFromate2Double(value.doubleValue()/all.doubleValue()*100d);
		}
	}
}
