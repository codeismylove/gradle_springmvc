package com.ssh.ex01.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.ex01.beans.ActivityUser;
import com.ssh.ex01.beans.dto.ActivityUserDTO;
import com.ssh.ex01.dao.IActivityUserDao;
import com.ssh.ex01.util.BaseList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
@Transactional
public class ActivityUserService implements IActivityUserService {

	@Resource
	private IActivityUserDao activityUserDao;

	@Override
	public void register(ActivityUserDTO activityUserDTO) {
		ActivityUser activityUser = new ActivityUser();
		activityUser.setUserName(activityUserDTO.getUserName());
		activityUser.setPassword(activityUserDTO.getPassword());
		activityUser.setType(BaseList.typeString(activityUserDTO.getType()));
		activityUser.setUnit(activityUserDTO.getUnit());
		activityUserDao.save(activityUser);
	}

	@Override
	public String login(ActivityUserDTO activityUserDTO) {
		ActivityUser activityUser = new ActivityUser();
		activityUser = activityUserDao.findUserByUserName(activityUserDTO.getUserName());
		if (activityUser.getPassword().equals(activityUserDTO.getPassword()))
			return "success";
		else
			return "error";
	}
	
	@Override
	public String checkUserName(String userName){
		ActivityUser activityUser = new ActivityUser();
		activityUser = activityUserDao.findUserByUserName(userName);
		if (activityUser!=null)
			return "用户名已存在";
		else
			return "用户名可使用";
		
	}

	@Override
	public int queryResultsCount() {
		ArrayList<ActivityUser> userList=new ArrayList<>();
		userList=(ArrayList<ActivityUser>) activityUserDao.findAll();
		return userList.size();
	}

	@Override
	public JSONObject queryByPage(int from, int length) {
		ArrayList<ActivityUser> userList=new ArrayList<>();
		userList=(ArrayList<ActivityUser>) activityUserDao.findAll();
		JSONObject dataJson = new JSONObject();
		JSONArray attchArray=new JSONArray();
		for(int i=0;i<userList.size();i++){
			JSONObject attchJson = new JSONObject();
			attchJson.put("userName",userList.get(i).getUserName());
			attchJson.put("password",userList.get(i).getPassword());
			attchJson.put("type",userList.get(i).getType());
			attchArray.add(attchJson);
		}
		String result=attchArray.toString();
		dataJson.put("gridModel", result);
		return dataJson;
	}

	@Override
	public List<ActivityUserDTO> queryByAll(int from, int length) {
		List<ActivityUser> userList=new ArrayList<>();
		List<ActivityUserDTO> userListDTO=new ArrayList<>();
		userList=(List<ActivityUser>) activityUserDao.findAll();
		for(int i=0;i<userList.size();i++){
			ActivityUserDTO activityUserDTO=new ActivityUserDTO();
			activityUserDTO.setId(String.valueOf(i+1));
			activityUserDTO.setUserName(userList.get(i).getUserName());
			activityUserDTO.setPassword(userList.get(i).getPassword());
			activityUserDTO.setType(BaseList.typeNumber(userList.get(i).getType()));
			activityUserDTO.setUnit(userList.get(i).getUnit());
			userListDTO.add(activityUserDTO);
		}
		return userListDTO;
	}

	@Override
	public ActivityUser queryByUserName(String userName) {
		ActivityUser activityUser = new ActivityUser();
		activityUser = activityUserDao.findUserByUserName(userName);
		return activityUser;
	}

	
	//拼接json数据的例子
/*	@Override
	public JSONObject findUserList() {
		ArrayList<ActivityUser> userList=new ArrayList<>();
		userList=(ArrayList<ActivityUser>) activityUserDao.findAll();
		JSONObject attchJson = new JSONObject();
		attchJson.put("page","1");
		attchJson.put("total","2");
		attchJson.put("records", String.valueOf(userList.size()));
		JSONArray cellArray=new JSONArray();
		for(int i=0;i<userList.size();i++){
			JSONObject cellDataJson = new JSONObject();
			cellDataJson.put("id", String.valueOf(i));
			//JSONObject dataJson = new JSONObject();
			JSONArray dataArray = new JSONArray();
			dataArray.add(userList.get(i).getUserName());
			dataArray.add(userList.get(i).getPassword());
			dataArray.add(BaseList.typeNumber(userList.get(i).getType()));
			String dataResult=dataArray.toString();
			cellDataJson.put("cell", dataResult);
			cellArray.add(cellDataJson);
		}
		String cellResult=cellArray.toString();
		attchJson.put("rows",cellResult);
		JSONObject attchJson1 = new JSONObject();
		attchJson1.put("amount", 3220);
		attchJson1.put("tax", 342);
		attchJson1.put("total", 3564);
		attchJson1.put("name","Totals:");
		attchJson.put("userdata",attchJson1);
//		jsonArray.add(attchJson);
		//String jsonResult=attchJson.toString();
		return attchJson;
	}*/
	
	

}
