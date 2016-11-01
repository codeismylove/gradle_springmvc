package util;

import java.io.UnsupportedEncodingException;

public class CodeUtil {
	/** 
     * 获取newStr 
     * @param str 原字符串 
     * @param type 原字符串编码 
     * @param toType 转换字符串编码 
     * @return newStr 新字符串 
     * @exception UnsupportedEncodingException 异常：编码异常 
     */  
	public static String codeChange(String str,String type,String toType){
		try {
            byte[] temp=str.getBytes(type);//这里写原编码方式
            String newStr=new String(temp,toType);//这里写转换后的编码方式
            return newStr;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
	}
}
