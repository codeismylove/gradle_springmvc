package com.ssh.ex01.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.ex01.entity.User;
import com.ssh.ex01.service.IUserService;
import com.ssh.ex01.service.UserService;

public class TsetUserService {
	public static void main(String[] args) 
	{
		ApplicationContext cotext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//IUserService userService = (IUserService) cotext.getBean("userService");
		UserService userService = (UserService) cotext.getBean("userService");//cglib.jar
		
		
//		User user = new User();
//		user.setUserName("123");
//		user.setPassword("333");
//		
//		userService.save(user);

	}
}
