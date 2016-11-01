/**
 * 
 */
package com.ssh.ex01.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.ex01.beans.ActivitySubject;
import com.ssh.ex01.beans.ActivityUser;
import com.ssh.ex01.beans.dto.ActivitySubjectDTO;
import com.ssh.ex01.beans.dto.ActivityUserDTO;
import com.ssh.ex01.dao.IActivitySubjectDao;
import com.ssh.ex01.dao.IActivityUserDao;
import com.ssh.ex01.util.BaseList;
import com.ssh.ex01.util.Tool;

/**
 * @author linzhenying
 * @date 2016年3月18日
 */
@Service
@Transactional
public class ActivitySubjectService implements IActivitySubjectService {

	@Resource
	private IActivitySubjectDao activitySubjectDao;

	@Resource
	private IActivityUserDao activityUserDao;

	@Override
	public void saveOrUpdate(ActivitySubjectDTO activitySubjectDTO, ActivityUserDTO activityUserDTO)
			throws ParseException {
		ActivitySubject activitySubject = new ActivitySubject();
		activitySubject.setActivityType(BaseList.subjectTypeString(activitySubjectDTO.getActivityType()));
		activitySubject.setTitle(activitySubjectDTO.getTitle());
		activitySubject.setSubject(activitySubjectDTO.getSubject());
		activitySubject.setHolderId(activitySubjectDTO.getHolderId());
		activitySubject.setHolderType(BaseList.typeString(activitySubjectDTO.getHolderType()));
		activitySubject.setHoldAddr(activitySubjectDTO.getHoldAddr());
		activitySubject.setBeginDate(Tool.dateChange(activitySubjectDTO.getBeginDate()));
		activitySubject.setEndDate(Tool.dateChange(activitySubjectDTO.getDatetime()));
		activitySubject.setCreate_by(activitySubjectDTO.getHolderId());
		activitySubject.setCreate_date(new Date());
		activitySubject.setUpdate_by(activitySubjectDTO.getHolderId());
		activitySubject.setUpdate_date(new Date());
		activitySubjectDao.save(activitySubject);
	}

	@Override
	public void delete(String id) {
		activitySubjectDao.delete(id);
	}

	@Override
	public List<ActivitySubjectDTO> queryByAll(int from, int length) {
		List<ActivitySubject> activityList = new ArrayList<>();
		List<ActivitySubjectDTO> activityListDTO = new ArrayList<>();
		activityList = (List<ActivitySubject>) activitySubjectDao.findAll();
		for (int i = 0; i < activityList.size(); i++) {
			ActivitySubjectDTO activitySubjectDTO = new ActivitySubjectDTO();
			activitySubjectDTO.setId(String.valueOf(i + 1));
			activitySubjectDTO.setTitle(activityList.get(i).getTitle());
			activitySubjectDTO.setActivityType(BaseList.subjectTypeNumber(activityList.get(i).getActivityType()));
			activitySubjectDTO.setHolderId(activityList.get(i).getHolderId());
			activityListDTO.add(activitySubjectDTO);
		}
		return activityListDTO;
	}

	@Override
	public int queryResultsCount() {
		ArrayList<ActivitySubject> activityList = new ArrayList<>();
		activityList = (ArrayList<ActivitySubject>) activitySubjectDao.findAll();
		return activityList.size();
	}

	@SuppressWarnings("unused")
	@Override
	public List<ActivitySubjectDTO> queryByKey(String key1, String key2, String key3) {

		List<ActivitySubject> activityList = new ArrayList<>();
		List<ActivitySubjectDTO> activityListDTO = new ArrayList<>();
		if (key1!=null&&key1!="")
			activityList = (List<ActivitySubject>) activitySubjectDao.findActivityByTitle(key1);
		else
			activityList = (List<ActivitySubject>) activitySubjectDao.findAll();
		for (int i = 0; i < activityList.size(); i++) {
			ActivitySubjectDTO activitySubjectDTO = new ActivitySubjectDTO();
			activitySubjectDTO.setId(String.valueOf(i + 1));
			activitySubjectDTO.setTitle(activityList.get(i).getTitle());
			activitySubjectDTO.setActivityType(BaseList.subjectTypeNumber(activityList.get(i).getActivityType()));
			activitySubjectDTO.setHolderId(activityList.get(i).getHolderId());
			activityListDTO.add(activitySubjectDTO);
		}
		return activityListDTO;

	}

}
