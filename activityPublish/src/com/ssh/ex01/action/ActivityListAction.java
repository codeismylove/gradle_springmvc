package com.ssh.ex01.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ssh.ex01.beans.dto.ActivitySubjectDTO;
import com.ssh.ex01.beans.dto.ActivityUserDTO;
import com.ssh.ex01.service.IActivitySubjectService;
import com.ssh.ex01.service.IActivityUserService;

@Controller
@Scope(value = "prototype")
public class ActivityListAction  extends JqGridBaseAction<ActivitySubjectDTO>{

	private static final long serialVersionUID = -8952167387062877234L;

	@Autowired
	private IActivitySubjectService activitySubjectService;
	
	@Override
	public String execute() {
		return this.refreshGridModel();
	}
	
	@Override
	public int getResultSize() {
		return activitySubjectService.queryResultsCount();
	}

	@Override
	public List<ActivitySubjectDTO> listResults(int from, int length) {
		HttpServletRequest request = ServletActionContext.getRequest();
		ActivitySubjectDTO activitySubjectDTO=new ActivitySubjectDTO();
		String key1=request.getParameter("checkTitle");
		String key2=request.getParameter("checkHolderId");
		String key3=request.getParameter("checkType");
		List<ActivitySubjectDTO> results = Collections.emptyList();
		if(key1!=null||key2!=null||key3!=null)
			results = this.activitySubjectService.queryByKey(key1,key2,key3);
		else
			results = this.activitySubjectService.queryByAll(from, length);
		
		return results;
	}
	
	public void setContactService(IActivitySubjectService activitySubjectService) {
		this.activitySubjectService = activitySubjectService;
	}

}
