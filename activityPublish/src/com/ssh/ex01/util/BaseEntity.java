package com.ssh.ex01.util;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * 基础类实体/通用字段
 * 
 * @author linzhenying
 * @date 2016年3月10日
 * @param <PK>
 */

@MappedSuperclass
public class BaseEntity<PK extends java.io.Serializable> {

	// 编号
	@Id
	@GeneratedValue(generator="system_uuid")
    @GenericGenerator(name="system_uuid",strategy="uuid")
    @Column(name = "id", unique = true, nullable = false, length = 20)
	@Type(type = "string")
	protected PK id;

	// 创建者
	protected String create_by;
	protected Date create_date;

	// 更新者
	protected String update_by;
	protected Date update_date;

	// 备注信息
	protected String remake;

	// 删除标记
	protected char del_flag;

	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getRemake() {
		return remake;
	}

	public void setRemake(String remake) {
		this.remake = remake;
	}

	public char getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(char del_flag) {
		this.del_flag = del_flag;
	}

}
