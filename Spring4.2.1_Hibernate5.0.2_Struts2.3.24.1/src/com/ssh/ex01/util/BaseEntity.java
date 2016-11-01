package com.ssh.ex01.util;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
/**
 * Domain Entity 的基础类
 * 用于系统集成 公共的/通用的　属性/字段
 * @author Sailer
 * @param <PK>
 */
@MappedSuperclass
public class BaseEntity <PK extends java.io.Serializable>
{
	protected PK id;

	protected Date lastUpdateTime;
	protected String lastUpdater;
	
	protected Date createrTime;
	protected String creater;
	
	protected String remake;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public PK getId() {
		return id;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public String getLastUpdater() {
		return lastUpdater;
	}

	public Date getCreaterTime() {
		return createrTime;
	}

	public String getCreater() {
		return creater;
	}

	public String getRemake() {
		return remake;
	}

	public void setId(PK id) {
		this.id = id;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public void setLastUpdater(String lastUpdater) {
		this.lastUpdater = lastUpdater;
	}

	public void setCreaterTime(Date createrTime) {
		this.createrTime = createrTime;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public void setRemake(String remake) {
		this.remake = remake;
	}	   
}
