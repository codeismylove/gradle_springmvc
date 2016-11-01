package com.ssh.ex01.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Tool {
	public static String uuID() {
		UUID uuid = UUID.randomUUID(); 
		String uuID=uuid.toString();
		return uuID;
	}
	
	public static java.sql.Date dateChange(String time) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		java.util.Date utilDate=sdf.parse(time);
		java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
		java.sql.Time sTime=new java.sql.Time(utilDate.getTime());
		java.sql.Timestamp stp=new java.sql.Timestamp(utilDate.getTime());
		return sqlDate;
	}
}
