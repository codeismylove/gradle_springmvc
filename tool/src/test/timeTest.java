package test;

import java.util.Date;

import util.DateStyle;
import util.DateUtil;

public class timeTest {
    public static String timeStamp(){  
        long time = System.currentTimeMillis();  
        String t = String.valueOf(time/1000);  
        return t;  
    }
	
	public static void main(String[] args){
		String timeStamp = timeStamp();
		System.out.println(DateUtil.timeStamp2Date(DateStyle.YYYY_MM_DD_HH_MM_SS_CN.getValue(), timeStamp));
		System.out.println(DateUtil.Date2timeStamp(DateStyle.YYYY_MM_DD_HH_MM_SS_CN.getValue(),new Date()));
	}
}
