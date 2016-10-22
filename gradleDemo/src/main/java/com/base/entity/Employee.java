/**
 * 
 */
package com.base.entity;

import java.util.Date;

import javax.persistence.*;

/**
 * @author linzhenying
 * @date 2016年10月23日
 */
@Table(name = "base_user")
@Entity
public class Employee {
	private Integer id;
    private String lastName;
    private String email;
    private Date birth;
    private Date crateTime;
 
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
 
    @Temporal(TemporalType.DATE)
    public Date getBirth() {
        return birth;
    }
 
    public void setBirth(Date birth) {
        this.birth = birth;
    }
 
 
    @Temporal(TemporalType.DATE)
    public Date getCrateTime() {
        return crateTime;
    }
 
    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }
 
}
