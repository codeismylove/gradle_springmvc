package com.demo.algorithm.ex;

/**
 * @author linzhenying
 * @date 2016年10月26日
 */
public class demo01 {
	/*
	 * 编写一个程序，输入n,求n！（用递归的方式实现）。
	 */
	public static void questionOne(int n){
		long sum=0;
		if((n&1)!=0)
			sum=((n+1)+1)*(n+1)/2-(n+1);
		else
			sum=(n+1)*n/2;
		System.out.println(sum);
	}
	
	
	
	public static long fac(long n){
        if(n<=0) 
        	return 0;
        else if(n==1)    
        	return 1;
        else 
        	return n*fac(n-1);
    }
    public static void main(String [] args) {
        System.out.println(fac(49));
        questionOne(49);
    }
	
}
