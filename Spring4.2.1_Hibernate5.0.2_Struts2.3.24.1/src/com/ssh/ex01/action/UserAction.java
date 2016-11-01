package com.ssh.ex01.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.ex01.entity.User;
import com.ssh.ex01.service.IUserService;

@Controller//userAction
@Scope(value="prototype")
public class UserAction extends ActionSupport 
	implements ModelDriven<User>,ParameterAware
{
	public UserAction(){
		System.out.println("UserAction");
	}
	private User user  = new User();//Get/Set
	
	private List<User> userLists  = new ArrayList<User>();//Get，如果需要接收则添加Set
	
	private Map<String, String[]> parameters;//struts2.interceptor ,只可以重写Set，不可以Get，否则NullPointExcetion
	
	@Autowired
	private IUserService userService;

	//重写Struts接口的方法
	public User getModel() {
		return user;
	}
	
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}
	
	public String save()
	{
		userService.saveOrUpdate(user);
		return SUCCESS;
	}

	public String delete()
	{
		String[] id = parameters.get("id");//url只可以传String
		//System.out.println("id:"+Long.parseLong(id[0]));
		User userTemp = userService.findById(Long.parseLong(id[0]));
		if(userTemp!=null){
			userService.delete(userTemp);
		}
		return SUCCESS;
	}
	
	public String findById()
	{
		String[] id = parameters.get("id");
		user  = userService.findById(Long.parseLong(id[0]));
		return SUCCESS;
	}
	
	public String findAll()
	{
		userLists = userService.findAll();
		return SUCCESS;
	}

	//什么时候Get,什么时候Set? 需要接收前端数据的Set,返回数据到前端Get
	//为自定义字段根据需要提供 Get/Set
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserLists() {
		return userLists;
	}

//	public void setUserLists(List<User> userLists) {
//		this.userLists = userLists;
//	}
		
}
