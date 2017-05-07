package com.springboot.controller;

import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.model.UserMaster;
import com.springboot.service.UserMasterService;

@Controller
@RequestMapping("/users")
public class UserMasterController {

	@Autowired
	private UserMasterService userMasterService;

	@RequestMapping("/configureUser")
	public String configureUser(Model model, HttpServletRequest request) {

		return "configureUser";
	}

	@RequestMapping("/userSummary")
	public String userSummaryPage(Model model) {
		return "userSummary";
	}

	@RequestMapping(value = "/viewUserDetails", method = RequestMethod.GET)
	public String viewUserDetails(HttpServletRequest request, @RequestParam("userId") int userId) {
		request.getSession().setAttribute("userId", userId);

		return "configureUser";
	}

	@RequestMapping("/all")
	public @ResponseBody List<UserMaster> getAllUsers() {
		List<UserMaster> listObj = this.userMasterService.list();
		return listObj;
	}

	@RequestMapping(value = "/details/{userId}", method = RequestMethod.GET)
	public @ResponseBody UserMaster getUserDetails(@PathVariable("userId") int userId) {
		UserMaster userMasterObj = this.userMasterService.getUserDetails(userId);
		return userMasterObj;
	}

	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("userId") int userId) {
		UserMaster userMasterObj = this.userMasterService.getUserDetails(userId);
		if (userMasterObj != null)
			this.userMasterService.delete(userMasterObj);
		return "userSummary";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) throws Exception {
		 System.out.println("CompetitionMasterController.addCompetition()" + request.getParameter("userCountry"));
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
		UserMaster userMasterObj = new UserMaster();
		userMasterObj.setUserCountry(request.getParameter("userCountry"));
		userMasterObj.setUserName(request.getParameter("userName"));
		userMasterObj.setUserNickName(request.getParameter("userNickName"));
		userMasterObj.setUserPassword(request.getParameter("userPassword"));
		userMasterObj.setUserRole(request.getParameter("userRole"));
		userMasterObj.setUserStatus(request.getParameter("userStatus"));
		userMasterObj.setUserEmail(request.getParameter("userEmail"));
		userMasterObj.setUserMobile(request.getParameter("userMobile"));
		
		String joiningDate = request.getParameter("userJoiningDate");
		String userDOB = request.getParameter("userDOB");
		
		java.util.Date date1 = sdf1.parse(joiningDate);
		java.sql.Date sqlJoiningDate = new Date(date1.getTime());
		
		java.util.Date dateDOB = sdf1.parse(userDOB);
		java.sql.Date sqlDOB = new Date(dateDOB.getTime());
		
		userMasterObj.setUserJoiningDate(sqlJoiningDate);
		userMasterObj.setUserDOB(sqlDOB);
		
		this.userMasterService.save(userMasterObj);
		
		return "userSummary";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateUser(HttpServletRequest request) throws Exception {
		// System.out.println("CompetitionMasterController.addCompetition()");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
		UserMaster userMasterObj = this.userMasterService.getUserDetails(Integer.parseInt(request.getParameter("userMasterId")));
		
		userMasterObj.setUserCountry(request.getParameter("userCountry"));
		userMasterObj.setUserName(request.getParameter("userName"));
		userMasterObj.setUserNickName(request.getParameter("userNickName"));
		userMasterObj.setUserPassword(request.getParameter("userPassword"));
		userMasterObj.setUserRole(request.getParameter("userRole"));
		userMasterObj.setUserStatus(request.getParameter("userStatus"));
		userMasterObj.setUserEmail(request.getParameter("userEmail"));
		userMasterObj.setUserMobile(request.getParameter("userMobile"));
		
		String joiningDate = request.getParameter("userJoiningDate");
		String userDOB = request.getParameter("userDOB");
		
		java.util.Date date1 = sdf1.parse(joiningDate);
		java.sql.Date sqlJoiningDate = new Date(date1.getTime());
		
		java.util.Date dateDOB = sdf1.parse(userDOB);
		java.sql.Date sqlDOB = new Date(dateDOB.getTime());
		
		userMasterObj.setUserJoiningDate(sqlJoiningDate);
		userMasterObj.setUserDOB(sqlDOB);
		
		this.userMasterService.update(userMasterObj);
		
		return "userSummary";
	}
	
}
