package com.ssh.ex01.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ssh.ex01.util.BaseEntity;

@Entity
@Table(name="t_user")//MySQL全小写   Oracle全大写
@NamedQueries({
	 @NamedQuery(name="User.findAll1",query="SELECT u FROM User u"),
	 @NamedQuery(name="User.findByName",query="SELECT u FROM User u WHERE u.userName = :name")
}) 
public class User extends BaseEntity<Long>
{
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
