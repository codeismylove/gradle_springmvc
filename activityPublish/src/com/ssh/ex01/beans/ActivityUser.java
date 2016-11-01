package com.ssh.ex01.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ssh.ex01.util.BaseEntity;

/**
 * 用户实体
 * 
 * @author linzhenying
 * @date 2016年3月17日
 */
@SuppressWarnings("rawtypes")
@Entity
@Table(name = "activity_user")
public class ActivityUser extends BaseEntity {

	// 用户名
	private String userName;
	// 密码
	private String password;
	// 用户类型
	private String type;
	// 所属单位
	private String unit;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
