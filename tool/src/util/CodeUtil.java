package util;

import java.io.UnsupportedEncodingException;

public class CodeUtil {
	/** 
     * ��ȡnewStr 
     * @param str ԭ�ַ��� 
     * @param type ԭ�ַ������� 
     * @param toType ת���ַ������� 
     * @return newStr ���ַ��� 
     * @exception UnsupportedEncodingException �쳣�������쳣 
     */  
	public static String codeChange(String str,String type,String toType){
		try {
            byte[] temp=str.getBytes(type);//����дԭ���뷽ʽ
            String newStr=new String(temp,toType);//����дת����ı��뷽ʽ
            return newStr;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
	}
}
