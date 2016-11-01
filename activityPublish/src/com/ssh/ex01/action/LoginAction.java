package com.ssh.ex01.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.ex01.beans.ActivityUser;
import com.ssh.ex01.beans.dto.ActivityUserDTO;
import com.ssh.ex01.service.IActivityUserService;
import com.ssh.ex01.util.BaseList;

@Controller
@Scope(value = "prototype")
public class LoginAction extends ActionSupport
implements ModelDriven<ActivityUser>, ParameterAware, SessionAware{


	private static final long serialVersionUID = 3161890478826790822L;
	
	private ActivityUserDTO activityUserDTO = new ActivityUserDTO();
	
	@Autowired
	private IActivityUserService activityUserService;
	
	private Map<String, Object> session;
	
	public String saveOrUpdate() throws Exception {
		String status = activityUserService.login(activityUserDTO);
		ActivityUser activityUser=new ActivityUser();
		activityUser=activityUserService.queryByUserName(activityUserDTO.getUserName());
		this.session.put("user_name", activityUserDTO.getUserName());
		this.session.put("pass_word", activityUserDTO.getPassword());
		this.session.put("user_type", BaseList.typeNumber(activityUser.getType()));
		return status;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	@Override
	public void setParameters(Map<String, String[]> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActivityUser getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public ActivityUserDTO getActivityUserDTO() {
		return activityUserDTO;
	}

	public void setActivityUserDTO(ActivityUserDTO activityUserDTO) {
		this.activityUserDTO = activityUserDTO;
	}

	public IActivityUserService getActivityUserService() {
		return activityUserService;
	}

	public void setActivityUserService(IActivityUserService activityUserService) {
		this.activityUserService = activityUserService;
	}

}
