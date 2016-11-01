package com.ssh.ex01.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ssh.ex01.util.BaseEntity;

/**
 * 活动评论
 * 
 * @author linzhenying
 * @date 2016年3月10日
 */

@SuppressWarnings("rawtypes")
@Entity
@Table(name = "activity_comment")
public class ActivityComment extends BaseEntity {

	// 所在主题,引用ActivitySubject
	private String subject_id;

	// 参加人,引用ActivityCheckin
	private String checkin_id;

	// 评论
	private String comment;

	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	public String getCheckin_id() {
		return checkin_id;
	}

	public void setCheckin_id(String checkin_id) {
		this.checkin_id = checkin_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
