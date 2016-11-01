/**
 * 
 */
package com.base.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.base.entity.Employee;


/**
 * @author linzhenying
 * @date 2016年10月26日
 */
public interface IUerDao extends PagingAndSortingRepository<Employee, String>, JpaSpecificationExecutor<Employee>{
	
}
