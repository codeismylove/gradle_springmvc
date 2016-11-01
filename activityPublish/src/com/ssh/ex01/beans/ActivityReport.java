package com.ssh.ex01.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ssh.ex01.util.BaseEntity;

/**
 * 活动报道
 * @author linzhenying
 * @date 2016年3月10日
 */

@SuppressWarnings("rawtypes")
@Entity
@Table(name="activity_report")
public class ActivityReport extends BaseEntity{

	// 所在主题,引用ActivitySubject
	private String subject_id;
	// 报道标题
	private String title;
	// 报道内容
	private String reportContent;

	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

}
