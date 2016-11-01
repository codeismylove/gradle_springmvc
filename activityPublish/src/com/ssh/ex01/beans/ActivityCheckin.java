package com.ssh.ex01.beans;

import javax.persistence.Table;
import javax.persistence.Entity;

import com.ssh.ex01.util.BaseEntity;

/**
 * 活动报到登记
 * @author linzhenying
 * @date 2016年3月10日
 */

@SuppressWarnings("rawtypes")
@Entity
@Table(name="activity_checkin")
public class ActivityCheckin extends BaseEntity {

	// 所在主题,引用ActivitySubject
	private String subject_id;
	// 姓名
	private String checkInName;
	// 身份信息
	private String identifyInfo;
	// 电话号码
	private String mobileNum;
	// 邮箱
	private String email;

	public String getCheckInName() {
		return checkInName;
	}

	public void setCheckInName(String checkInName) {
		this.checkInName = checkInName;
	}

	public String getIdentifyInfo() {
		return identifyInfo;
	}

	public void setIdentifyInfo(String identifyInfo) {
		this.identifyInfo = identifyInfo;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

}
