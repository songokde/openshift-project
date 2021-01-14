package com.newcloud.waf.storage.dao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	private static SimpleDateFormat ymdhm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static SimpleDateFormat ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
     * 根据日期和日期差获取时间戳
     * @param date 字符日期
     * @param diffday 日期差
     * @return
     */
    public static Integer gettime(String date, Integer diffday) {
        Long l = 0L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            Date d = sdf.parse(date);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            c.add(Calendar.DATE, diffday);
            l = c.getTimeInMillis() / 1000L;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return l.intValue();
    }
    
    /**
	 * 获取取掉毫秒的时间戳
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getTimeStamp(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			long time = (sdf.parse(date).getTime() / 1000L);
			return (int) time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
    
    /**
     * 格式化long
     * @param time
     * @param fomrat
     * @return
     */
    public static String formatLongtime(Long time, String fomrat) {
        Date date = new Date(time * 1000);
        return new SimpleDateFormat(fomrat).format(date);
    }

    public static Integer getIntDate(Date date, Integer days) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DATE, days);
        Integer result = Integer.parseInt(formatDateToString(ca.getTime(), "yyyyMMdd"));
        return result;
    }

    public static String formatDateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 返回今天的日期，格式由传入的格式类型决定
     * @param format 日期格式，如yyyy-MM-dd
     * @return
     */
    public static String getToday(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * 返回unix时间戳
     * @return
     */
    public static int getUnixTimestamp() {
        return (int) (System.currentTimeMillis() / 1000l);
    }

    /**
     * 获取当前的时候戳
     * @param time
     * @return
     */
    public static long getUnixTime(long time) {
        time = time / 1000;
        return time;
    }

    /**
     * 将unix时间戳转换至指定格式的时间字符串
     * @param time 时间戳
     * @param format 日期格式，如yyyy-MM-dd HH:mm
     * @return
     */
    public static String fromUnixtime(long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date(time * 1000l);
        return sdf.format(date);
    }

    public static Date parseDate(String str, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(str);
    }

    /**
     * method getArithmeticDate 获取算术日期。获取当前日期加传入天数后的日期
     * @param amount 需要增加天数
     * @return
     */
    public static Date getArithmeticDate(int amount) {
        Calendar today = Calendar.getInstance();
        today.add(Calendar.DATE, amount);
        return today.getTime();
    }

    /**
     * 将当前日期转换为字符串
     * @param date java.util.Date
     * @param format 日期格式，如yyyy-MM-dd HH:mm
     * @return
     */
    public static String parseDateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /***************************************************************************
     * 格式化时长
     * @param second
     * @return
     */
    public static String formatLength(long second) {
        StringBuffer sb = new StringBuffer();
        if (second > 3600) {
            sb.append(second / 3600 + "小时");
        }
        second = second % 3600;
        sb.append(second / 60 + "分钟" + second % 60 + "秒");
        return sb.toString();
    }

    /**
     * 获取具体的小时
     * @param hour
     * @return
     */
    public static int getNowHour() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 根据时间戳，获取时间戳所属的小时
     * @param time
     * @return
     */
    public static String getTimeHour(long time) {
        Date d = new Date(time * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        return sdf.format(d);
    }

    /**
     * 获取数据库前24小时的时候戳
     * @param time
     * @return
     */
    public static long getTime(long time) {
        time = time / 1000 - (long) (24 * 60 * 60);
        // text t = new text();
        // t.time(System.currentTimeMillis());
        return time;
    }

    public static String getMon(long time) {
        Date d = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        return sdf.format(d);
    }

    /**
     * 把时间戳转换成时间
     * @param time
     * @return
     */
    public static String getDate(long time) {
        Date d = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(d);
    }

    public static String getDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    public static String getDate(String date) {
        return date.replaceAll("-", "");
    }

    /**
     * 根据时间戳返回日期
     * @param timestamp
     * @return
     */
    public static String getDateTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(timestamp);
        String day = sdf.format(date);
        return day;
    }

    /**
     * 计算两个日期(yyyyMMdd字符串型)间的天数(包含起始和结束日期)
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int getDateSpace(String beginDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date bDate = null;
        Date eDate = null;
        int day = 0;
        try {
            bDate = sdf.parse(beginDate);
            eDate = sdf.parse(endDate);
            long result = eDate.getTime() - bDate.getTime();
            day = (int) (result / 86400000L);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return day + 1;
    }

    public static String getDatesByRefDate(String datestr, int interval) {
        try {
            Date date = parseDate(datestr, "yyyyMMdd");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String str = null;
            long d1 = date.getTime();
            if (interval > 0) {
                str = sdf.format(d1 + Math.abs(interval) * 1000l * 60 * 60 * 24L);
            } else {
                str = sdf.format(d1 - Math.abs(interval) * 1000l * 60 * 60 * 24L);
            }

            return str;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static Date stringToDate(String date, String format) {
        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
        Date formatdate = null;
        try {
            formatdate = formate.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatdate;
    }
    
    /**
	 * 获取取掉毫秒的时间戳
	 * 
	 * @param date
	 * @return
	 */
	public static Long getLongTimeStamp(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			long time = (sdf.parse(date).getTime()/1000L);
			return time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0L;
	}
	
	/**
	 * 去除日期字符窜当中所有不规则的字符如（"-",":","/"）
	 * @param date
	 * @return
	 */
	public static String respleString(String date){
		if(date.indexOf("-")!=-1){
			date = date.replaceAll("-", "");
		}else if (date.indexOf("/")!=-1) {
			date = date.replaceAll("/", "");
		}else if (date.indexOf(":")!=-1) {
			date = date.replaceAll(":", "");
		}
		return date;
	}
	
	/**
	 * 返回当前日期的前后day天日期(当日参数为0) 返回yyyyMMdd字符串
	 */
	public static String getDataByIntYearW(int day) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		GregorianCalendar worldTour = new GregorianCalendar();
		worldTour.add(GregorianCalendar.DATE, day);
		Date d = worldTour.getTime();
		String s = sdf.format(d);
		return s;
	}

	/**
	 * 获取当前时间前5分钟左右整五分钟的时间戳
	 * 
	 * @return
	 */
	public static long getCurrent5Timestamp() {
		Long times = System.currentTimeMillis() / 1000L;
		times = times - times % 60L;
		times = times - (times % 300L) - 300L;
		return times;
	}
	
	/**
	 * 获取当前时间前5分钟左右整五分钟的时间戳
	 * 
	 * @return
	 */
	public static long getCurrent15Timestamp() {
		Long times = System.currentTimeMillis() / 1000L;
		times = times - times % 60L;
		times = times - (times % 300L) - 900L;
		return times;
	}
	
	public static Long getStrToLongDate(String date,String fromat){
        try {
        	SimpleDateFormat formate = new SimpleDateFormat(fromat);
            Date formatdate =  formate.parse(date);
            return formatdate.getTime()/1000L;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0l;
	}
	
	/**
	 * 获取第二天日期
	 * @param date 20121212
	 * @return
	 */
	public static String getTomorrow(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date today = null;
		Date tomorrow = null;
		long day = 0L;
		try {
			today = sdf.parse(date);
			day = today.getTime() + 86400000L;
			tomorrow = new Date(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sdf.format(tomorrow);
	}
	
	public static Date getCurrentDate(String date){
	    SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");  
	    Date d=null;
        try {   
            d = sf.parse(date);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return d;
	}
	
	public static Date getNextDate(String date){
		Calendar c = Calendar.getInstance();  
		c.setTime(getCurrentDate(date));  
		c.add(Calendar.DAY_OF_MONTH, 1); 
		return c.getTime();
	}
	
	public static String formatYmdhm(Long timestamp) {
		Date date = new Date(timestamp*1000L);
		return ymdhm.format(date);
	}
	
	public static String formatYmdhms(Long timestamp) {
		Date date = new Date(timestamp*1000L);
		return ymdhms.format(date);
	}
	
	/**
	 * 获取昨天0点的时间戳
	 * 
	 * @return
	 */
	public static long getYesterday0Timestamp() {
		Calendar calendar = Calendar.getInstance();
	    calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)-1,0,0,0);
	    long tt = calendar.getTime().getTime()/1000;
		return tt;
	}
}
