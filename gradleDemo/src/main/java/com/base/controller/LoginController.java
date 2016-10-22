/**
 * 
 */
package com.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.entity.Employee;

/**
 * @author linzhenying
 * @date 2016年10月23日
 */
@Controller
@RequestMapping("/test")
public class LoginController {
	public int id;
	public String name="zs";
	public String password="123456";
	@RequestMapping(value = "/test")
	public String test(HttpServletRequest request) {
		Employee s = new Employee();
		
		System.out.println("name===" + name);
		System.out.println("password===" + password);
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		request.setAttribute("userName", userName);
		if (name.equals(userName) && password.equals(userPwd)) {
		   return "success";
		}
		   return "fail";
	}
}
