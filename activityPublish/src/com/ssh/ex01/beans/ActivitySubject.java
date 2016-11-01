package com.ssh.ex01.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ssh.ex01.util.BaseEntity;

/**
 * 活动主题
 * 
 * @author linzhenying
 * @date 2016年3月10日
 */


@SuppressWarnings("rawtypes")
@Entity
@Table(name="activity_subject")
public class ActivitySubject extends BaseEntity{
	// 活动分类
	private String activityType;
	// 标题
	private String title;
	// 主题描述
	private String subject;
	// 举办方
	private String holderId;
	// 举办方类型
	private String holderType;
	// 举办地址
	private String holdAddr;
	// 参与人范围，ALL表示所有用户，PART表示在activityEnroll表中限定的用户
	private String enrollscope;
	// 开始日期
	private Date beginDate;
	// 结束日期
	private Date datetime;
	
	private Date endDate;

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getHolderId() {
		return holderId;
	}

	public void setHolderId(String holderId) {
		this.holderId = holderId;
	}

	public String getHolderType() {
		return holderType;
	}

	public void setHolderType(String holderType) {
		this.holderType = holderType;
	}

	public String getHoldAddr() {
		return holdAddr;
	}

	public void setHoldAddr(String holdAddr) {
		this.holdAddr = holdAddr;
	}

	public String getEnrollscope() {
		return enrollscope;
	}

	public void setEnrollscope(String enrollscope) {
		this.enrollscope = enrollscope;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
}
