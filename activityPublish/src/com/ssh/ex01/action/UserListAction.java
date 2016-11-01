package com.ssh.ex01.action;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ssh.ex01.beans.dto.ActivityUserDTO;
import com.ssh.ex01.service.IActivityUserService;


@Controller
@Scope(value = "prototype")
public class UserListAction extends JqGridBaseAction<ActivityUserDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3118289102602377833L;
	@Autowired
	private IActivityUserService activityUserService;

	@Override
	public String execute() {
		return this.refreshGridModel();
	}

	@Override
	public int getResultSize() {
		return this.activityUserService.queryResultsCount();
	}

	@Override
	public List<ActivityUserDTO> listResults(int from, int length) {
		List<ActivityUserDTO> results = Collections.emptyList();
		results = this.activityUserService.queryByAll(from, length);
		return results;
	}

	public void setContactService(IActivityUserService activityUserService) {
		this.activityUserService = activityUserService;
	}

}
