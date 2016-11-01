package com.ssh.ex01.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.ssh.ex01.entity.User;
/*
 * 声明一个切面
 */
@Aspect
public class MyAspect {
	//一个切面可以有多个切入点:
	//切入点:执行 public 任意返回类型   任意方法名  任意参数列表的方法时切入
	@Pointcut("execution (public * *(..))")
	private void anyPublicMehtod(){
		
	}
	//切入点:切入com.springdemo.ex01.service包下面所有的类（..包含所有的子包）
	@Pointcut("within (com.ssh.ex01.service..*)")
	private void inService(){
		
	}
	//满足上述两个切点的条件时切入
	@Pointcut("anyPublicMehtod() &&  inService()")
	private void servicePublicMehtod(){
		
	}
	
	//一个切面可以有任意的通知：通知可以自定义切入表达式，也可以使用前面定义的切入点,一般需要切入的代码都编写在通知之中!
	//前置通知:
	@Before("servicePublicMehtod() && args(user)")//this  和  target
	private void beforeMehtod(User user){
		System.out.println("前置通知:方法执行之前执行！！适合拦截数据,校验,权限");
		System.out.println("UserName:"+user.getUserName());
	}
	//后置通知:
	@AfterReturning("servicePublicMehtod()")
	private void afterReturningMehtod(){
		System.out.println("后置通知:方法执行返回之后执行！！,如果方法发生异常则不执行!!!适合做操作日志");
	}
	//异常通知:
	@AfterThrowing("servicePublicMehtod()")
	private void afterThrowingMehtod(){
		System.out.println("异常通知:方法执行产生异常的时候执行！！适合做异常处理,错误日志等等");
	}
	//最终通知:
	@After("servicePublicMehtod()")
	private void afterMehtod(){
		System.out.println("最终通知:方法执行不管有没有异常都必须执行！！适合做资源回收等");
	}
	//环绕通知:
//	@Around("servicePublicMehtod()")
//	private void aroundMehtod(){
//		System.out.println("环绕通知:方法执行任何地方都有可能执行！！不可控");
//	}
	
}
