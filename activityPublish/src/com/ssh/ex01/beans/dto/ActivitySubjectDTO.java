package com.ssh.ex01.beans.dto;

import java.sql.Date;

public class ActivitySubjectDTO {
	private String id;
	private String activityType;
	private String title;
	private String subject;
	private String holderId;
	private String holderType;
	private String holdAddr;
	private String enrollscope;
	private String beginDate;
	private String datetime;
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
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	
}
