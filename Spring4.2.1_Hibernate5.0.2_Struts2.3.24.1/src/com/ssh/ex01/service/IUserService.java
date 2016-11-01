package com.ssh.ex01.service;

import java.util.List;

import com.ssh.ex01.entity.User;

public interface IUserService 
{
	public void saveOrUpdate(User user);
//	public void update(User user);
	public void delete(User user);
	
	public User findById(Long id);
	public List<User> findAll();
	
}
