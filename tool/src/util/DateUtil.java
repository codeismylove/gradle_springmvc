package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/** 
     * ��ȡSimpleDateFormat 
     * @param parttern ���ڸ�ʽ 
     * @return SimpleDateFormat���� 
     * @throws RuntimeException �쳣���Ƿ����ڸ�ʽ 
     */  
    @SuppressWarnings("unused")
	public static SimpleDateFormat getDateFormat(String parttern) throws RuntimeException {  
        return new SimpleDateFormat(parttern);  
    }
    
    /** 
     * ����������ĳ���͵�ĳ��ֵ������������ 
     * @param date ���� 
     * @param dateType ���� 
     * @param amount ��ֵ 
     * @return ��������� 
     */  
    @SuppressWarnings("unused")
	private static Date addInteger(Date date, int dateType, int amount) {  
        Date myDate = null;  
        if (date != null) {  
            Calendar calendar = Calendar.getInstance();  
            calendar.setTime(date);  
            calendar.add(dateType, amount);  
            myDate = calendar.getTime();  
        }  
        return myDate;  
    }  
    
    public static String timeStamp2Date(String dateType,String timeStamp) throws RuntimeException {  
    	SimpleDateFormat sdf = new SimpleDateFormat(dateType);
    	String date = sdf.format(new Date(Long.valueOf(timeStamp+"000")));
    	return date;
    }
    
    public static Long Date2timeStamp(String dateType,Date date) throws RuntimeException {  
    	SimpleDateFormat sdf = new SimpleDateFormat(dateType);    	
    	String dateString =sdf.format(date);
    	Long timeStamp=0L;
    	try {
			Date toDate=sdf.parse(dateString);
			timeStamp=toDate.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return timeStamp;
    }
}
