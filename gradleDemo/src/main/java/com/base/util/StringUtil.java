package com.base.util;

public class StringUtil {
	//引用静态区的的字符串字面量
	private String s="Hello";
	//引用堆上的字符串对象
	private String p=new String("Hello");
	
	
	/*
	 *字符串常用的一些方法api 
	 */
	public void  stringMethod(){
		//字符串长度
		int length=s.length();
		//取单个字符
		char s1=s.charAt(2);
		//变大写
		String a1=s.toUpperCase();
		//变小写
		String a2=s.toLowerCase();
		//连接字符串
		String a3=a1.concat(a2);
		//字符串比较（两者的区别...）
		boolean b1=a1.equals(a2);
		int b2=a1.compareTo(a2);
		//判断开头结尾
		boolean b3=a1.startsWith("a");
		boolean b4=a1.endsWith("c");
		//返回 String 对象内第一次出现子字符串的字符位置
		int i=a1.indexOf("ab");
		//截取字符串
		String aa2=a2.substring(2, 3);
	}
}
