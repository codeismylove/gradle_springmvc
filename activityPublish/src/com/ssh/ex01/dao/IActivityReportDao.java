/**
 * 
 */
package com.ssh.ex01.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ssh.ex01.beans.ActivityReport;

/**
 * @author linzhenying
 * @date 2016年3月18日
 */
public interface IActivityReportDao
		extends JpaSpecificationExecutor<ActivityReport>, PagingAndSortingRepository<ActivityReport, String> {

}
