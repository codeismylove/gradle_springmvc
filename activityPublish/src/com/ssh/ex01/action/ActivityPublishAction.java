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
import com.ssh.ex01.beans.ActivitySubject;
import com.ssh.ex01.beans.dto.ActivitySubjectDTO;
import com.ssh.ex01.beans.dto.ActivityUserDTO;
import com.ssh.ex01.service.IActivitySubjectService;
import com.ssh.ex01.util.BaseList;

import net.sf.json.JSONObject;

@Controller
@Scope(value = "prototype")
public class ActivityPublishAction extends ActionSupport
implements ModelDriven<ActivitySubject>, ParameterAware, SessionAware{

	private static final long serialVersionUID = 5688910972779437895L;
	
	@Autowired
	private IActivitySubjectService activitySubjectService;
	
	private JSONObject list;

	public String saveOrUpdate() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		ActivitySubjectDTO activitySubjectDTO=new ActivitySubjectDTO();
		ActivityUserDTO activityUserDTO=new ActivityUserDTO();
		activitySubjectDTO.setActivityType(request.getParameter("activityType"));
		activitySubjectDTO.setTitle(request.getParameter("title"));
		activitySubjectDTO.setSubject(request.getParameter("subject"));	
		activitySubjectDTO.setHolderId(request.getParameter("holderId"));
		activitySubjectDTO.setHolderType(request.getParameter("holderType"));
		activitySubjectDTO.setHoldAddr(request.getParameter("holdAddr"));	
		activitySubjectDTO.setBeginDate(request.getParameter("beginDate"));
		activitySubjectDTO.setDatetime(request.getParameter("endDate"));
		activitySubjectService.saveOrUpdate(activitySubjectDTO, activityUserDTO);
		return SUCCESS;
	}
	
	public String publish() throws Exception {
		list = BaseList.subjectTypeList();
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParameters(Map<String, String[]> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActivitySubject getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public IActivitySubjectService getActivitySubjectService() {
		return activitySubjectService;
	}

	public void setActivitySubjectService(IActivitySubjectService activitySubjectService) {
		this.activitySubjectService = activitySubjectService;
	}

	public JSONObject getList() {
		return list;
	}

	public void setList(JSONObject list) {
		this.list = list;
	}

}
