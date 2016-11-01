/**
 * 
 */
package com.ssh.ex01.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ssh.ex01.beans.ActivityComment;

/**
 * @author linzhenying
 * @date 2016年3月17日
 */
public interface IActivityCommentDao extends PagingAndSortingRepository<ActivityComment, String>, JpaSpecificationExecutor<ActivityComment> {

}
