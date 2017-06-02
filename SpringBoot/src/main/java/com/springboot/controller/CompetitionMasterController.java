package com.springboot.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.model.CompetitionMaster;
import com.springboot.model.RuleMaster;
import com.springboot.model.UserMaster;
import com.springboot.service.CompetitionMasterService;
import com.springboot.service.UserMasterService;

@Controller
@RequestMapping("/competition")
public class CompetitionMasterController {

	@Autowired
	private CompetitionMasterService competitionMasterService;

	@Autowired
	private UserMasterService userMasterService;

	@RequestMapping("/configureCompetition")
	public String configureCompetition(Model model, HttpServletRequest request) {
		return "configureCompetition";
	}

	@RequestMapping("/viewCompetition")
	public String viewCompetition(Model model, HttpServletRequest request) {
		return "viewCompetition";
	}

	@RequestMapping("/competitionSummary")
	public String competitionSummaryPage(Model model) {
		return "competitionSummary";
	}

	@RequestMapping(value = "/viewCompetitionDetails", method = RequestMethod.GET)
	public String viewCompetitionDetails(HttpServletRequest request, @RequestParam("competitionId") int competitionId) {
		request.getSession().setAttribute("competitionId", competitionId);

		return "configureCompetition";
	}

	@RequestMapping("/add")
	public String addCompetition(HttpServletRequest request) throws ParseException {
		//Getting User
		UserMaster userMasterObj = this.userMasterService.getUserDetails(1);

		// System.out.println("CompetitionMasterController.addCompetition()");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");

		CompetitionMaster competitionMasterObj = new CompetitionMaster();
		competitionMasterObj.setCompetitionDetails(request.getParameter("competitionDetails"));

		String endDate = request.getParameter("competitionEndDate");
		java.util.Date date1 = sdf1.parse(endDate);
		java.sql.Date sqlEndDate = new Date(date1.getTime());

		competitionMasterObj.setCompetitionEndDate(sqlEndDate);
		competitionMasterObj.setCompetitionName(request.getParameter("competitionName"));
		competitionMasterObj.setCompetitionOwner(request.getParameter("competitionOwner"));
		competitionMasterObj.setCompetitionPoints(Integer.parseInt(request.getParameter("competitionPoints")));
		competitionMasterObj.setCompetitionPrize(request.getParameter("competitionPrize"));
		competitionMasterObj.setCompetitionRules(request.getParameter("competitionRules"));

		String startDate = request.getParameter("competitionStartDate");
		java.util.Date date = sdf1.parse(startDate);
		java.sql.Date sqlStartDate = new Date(date.getTime());
		competitionMasterObj.setCompetitionStartDate(sqlStartDate);
		competitionMasterObj.setCompetitionStatus(request.getParameter("competitionStatus"));

		competitionMasterObj.setCompContactPhone(request.getParameter("compContactPhone"));
		competitionMasterObj.setCompContactEmail(request.getParameter("compContactEmail"));
		competitionMasterObj.setUserId(userMasterObj);
		
		this.competitionMasterService.save(competitionMasterObj);

		return "competitionSummary";
	}

	@RequestMapping("/update")
	// @RequestMapping(method = RequestMethod.PUT, value="/update")
	public String updateCompetition(HttpServletRequest request) throws ParseException {

		//Getting User
		UserMaster userMasterObj = this.userMasterService.getUserDetails(1);

		
		String competitionId = request.getParameter("competitionMasterId");
		//System.out.println(" -------- > " + competitionId);
		CompetitionMaster competitionMasterObj = null;
		if (competitionId != "" || competitionId != null || competitionId != "null") {
			competitionMasterObj = this.competitionMasterService
					.getCompititionMasterDetails(Integer.parseInt(competitionId));
		}

		// System.out.println("CompetitionMasterController.SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS()");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");

		// CompetitionMaster competitionMasterObj = new CompetitionMaster();
		competitionMasterObj.setCompetitionDetails(request.getParameter("competitionDetails"));

		String endDate = request.getParameter("competitionEndDate");
		java.util.Date date1 = sdf1.parse(endDate);
		java.sql.Date sqlEndDate = new Date(date1.getTime());

		competitionMasterObj.setCompetitionEndDate(sqlEndDate);
		competitionMasterObj.setCompetitionName(request.getParameter("competitionName"));
		competitionMasterObj.setCompetitionOwner(request.getParameter("competitionOwner"));
		competitionMasterObj.setCompetitionPoints(Integer.parseInt(request.getParameter("competitionPoints")));
		competitionMasterObj.setCompetitionPrize(request.getParameter("competitionPrize"));
		competitionMasterObj.setCompetitionRules(request.getParameter("competitionRules"));

		String startDate = request.getParameter("competitionStartDate");
		java.util.Date date = sdf1.parse(startDate);
		java.sql.Date sqlStartDate = new Date(date.getTime());
		competitionMasterObj.setCompetitionStartDate(sqlStartDate);
		competitionMasterObj.setCompetitionStatus(request.getParameter("competitionStatus"));

		competitionMasterObj.setCompContactPhone(request.getParameter("compContactPhone"));
		competitionMasterObj.setCompContactEmail(request.getParameter("compContactEmail"));
		competitionMasterObj.setUserId(userMasterObj);

		this.competitionMasterService.update(competitionMasterObj);
		request.getSession().removeAttribute("competitionId");
		return "competitionSummary";
	}

	@RequestMapping("/all")
	public @ResponseBody List<CompetitionMaster> getAllCompetitions() {
		List<CompetitionMaster> listObj = this.competitionMasterService.list();
		return listObj;
	}

	@RequestMapping(value = "/details/{competitionId}", method = RequestMethod.GET)
	public @ResponseBody CompetitionMaster getCompetitionDetails(@PathVariable("competitionId") int competitionId) {
		//System.out.println(" ------------------------ ? " + competitionId);
		CompetitionMaster competitionMasterObj = this.competitionMasterService
				.getCompititionMasterDetails(competitionId);
		return competitionMasterObj;
	}

	@RequestMapping(value = "/delete/{competitionId}", method = RequestMethod.GET)
	public String deleteCompetition(@PathVariable("competitionId") int competitionId) {
		CompetitionMaster competitionMasterObj = this.competitionMasterService
				.getCompititionMasterDetails(competitionId);
		if (competitionMasterObj != null)
			this.competitionMasterService.delete(competitionMasterObj);
		return "competitionSummary";
	}

}
