package com.ssh.ex01.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.ex01.beans.ActivityUser;
import com.ssh.ex01.beans.dto.ActivityUserDTO;
import com.ssh.ex01.service.IActivitySubjectService;
import com.ssh.ex01.service.IActivityUserService;
import com.ssh.ex01.util.BaseList;

import net.sf.json.JSONObject;

/**
 * @author linzhenying
 * @date 2016年3月18日
 */
@Controller
@Scope(value = "prototype")
public class ActivityUserAction extends ActionSupport
		implements ModelDriven<ActivityUser>, ParameterAware, SessionAware {

	private static final long serialVersionUID = -7127276885511575509L;

	@Autowired
	private IActivityUserService activityUserService;

	private ActivityUserDTO activityUserDTO = new ActivityUserDTO();

	private ActivityUser activityUser = new ActivityUser();

	private JSONObject list;

	private String checkResult;

	private String orgName;

/*	public String saveOrUpdate() throws Exception {
		String status = activityUserService.login(activityUserDTO);
		return status;
	}*/

	public String register() throws Exception {
		list = BaseList.typeList();
		return SUCCESS;
	}

	public String saveRegister() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		ActivityUserDTO activityUserDTO = new ActivityUserDTO();
		this.activityUserDTO = activityUserDTO;
		activityUserDTO.setUserName(request.getParameter("userName"));
		activityUserDTO.setPassword(request.getParameter("password"));
		activityUserDTO.setType(BaseList.typeString(request.getParameter("type")));
		activityUserDTO.setUnit(request.getParameter("unit"));
		activityUserService.register(activityUserDTO);
		return SUCCESS;
	}

	// public String findUserList(){
	// userListResult=activityUserService.findUserList();
	// return SUCCESS;
	// }

	public String checkUserName() {
		checkResult = activityUserService.checkUserName(orgName);
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {

	}


	@Override
	public void setParameters(Map<String, String[]> arg0) {
		// TODO Auto-generated method stub
	}

	public ActivityUserDTO getActivityUserDTO() {
		return activityUserDTO;
	}

	public void setActivityUserDTO(ActivityUserDTO activityUserDTO) {
		this.activityUserDTO = activityUserDTO;
	}

	@Override
	public ActivityUser getModel() {
		// TODO Auto-generated method stub
		return activityUser;
	}

	public ActivityUser getActivityUser() {
		return activityUser;
	}

	public void setActivityUser(ActivityUser activityUser) {
		this.activityUser = activityUser;
	}

	public JSONObject getList() {
		return list;
	}

	public void setList(JSONObject list) {
		this.list = list;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
