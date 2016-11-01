package com.ssh.ex01.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ssh.ex01.beans.ActivityUser;

/**
 * @author linzhenying
 * @date 2016年3月17日
 */
public interface IActivityUserDao
		extends PagingAndSortingRepository<ActivityUser, String>, JpaSpecificationExecutor<ActivityUser> {
	@Query("from ActivityUser p where  p.userName = ?1")
	public ActivityUser findUserByUserName(String userName);
}
