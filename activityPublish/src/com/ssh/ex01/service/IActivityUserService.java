/**
 * 
 */
package com.ssh.ex01.service;

import java.util.List;

import com.ssh.ex01.beans.ActivityUser;
import com.ssh.ex01.beans.dto.ActivityUserDTO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author linzhenying
 * @date 2016年4月4日
 */
public interface IActivityUserService {
	public void register(ActivityUserDTO activityUserDTO);
	public String login(ActivityUserDTO activityUserDTO);
	public String checkUserName(String userName);
	//public JSONObject findUserList();
	public int queryResultsCount();
	public JSONObject queryByPage(int from, int length);
	public List<ActivityUserDTO> queryByAll(int from, int length);
	public ActivityUser queryByUserName(String userName);
}
