package com.ssh.ex01.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ssh.ex01.util.BaseEntity;

/**
 * 活动报名表
 * 
 * @author linzhenying
 * @date 2016年3月10日
 */

@SuppressWarnings("rawtypes")
@Entity
@Table(name = "activity_enroll")
public class ActivityEnroll extends BaseEntity {
	// 所在主题,引用ActivitySubject
	private String subject_id;
	// 姓名
	private String enrollName;
	// 身份信息
	private String identifyInfo;
	// 电话号码
	private String mobileNum;
	// 邮箱
	private String email;
	// 参与目标或职责
	private String target;
	// 来源说明，0表示发起人限定，1表示互联网报名
	private String origin;

	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	public String getEnrollName() {
		return enrollName;
	}

	public void setEnrollName(String enrollName) {
		this.enrollName = enrollName;
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

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}
