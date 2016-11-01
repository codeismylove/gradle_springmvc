/**
 * 
 */
package com.ssh.ex01.service;

import java.text.ParseException;
import java.util.List;

import com.ssh.ex01.beans.dto.ActivitySubjectDTO;
import com.ssh.ex01.beans.dto.ActivityUserDTO;

/**
 * @author linzhenying
 * @date 2016年3月18日
 */
public interface IActivitySubjectService {
	
	public void saveOrUpdate(ActivitySubjectDTO activitySubjectDTO,ActivityUserDTO activityUserDTO) throws ParseException;
	public void delete(String id);
	public List<ActivitySubjectDTO> queryByAll(int from, int length);
	public int queryResultsCount();
	public List<ActivitySubjectDTO> queryByKey(String key1,String key2,String key3);
}
