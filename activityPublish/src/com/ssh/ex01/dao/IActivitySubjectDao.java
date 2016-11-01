package com.ssh.ex01.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ssh.ex01.beans.ActivitySubject;
import com.ssh.ex01.beans.ActivityUser;

/**
 * @author linzhenying
 * @date 2016年3月17日
 */
public interface IActivitySubjectDao
		extends PagingAndSortingRepository<ActivitySubject, String>, JpaSpecificationExecutor<ActivitySubject> {
	@Query("from ActivitySubject p where  p.title = ?1")
	public List<ActivitySubject> findActivityByTitle(String title);
}
