package com.ssh.ex01.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.ex01.entity.User;
import com.ssh.ex01.repository.IUserDao;

@Service
@Transactional
public class UserService implements IUserService 
{

	@Resource
	private IUserDao userDao;

	public void saveOrUpdate(User user) {
		System.out.println("User Service save method!!");
		userDao.save(user);
	}

	public User findById(Long id) {
		System.out.println("User Service findById method!!");
		User user = null;
		user = userDao.findOne(id);
		return user;
	}
	
	public void delete(User user) {
		System.out.println("User Service delete method!!");
		userDao.delete(user);
	}

	public List<User> findAll(){
		List<User> userList = null;
		userList = (List<User>) userDao.findAll();
		return userList;
	}

}
