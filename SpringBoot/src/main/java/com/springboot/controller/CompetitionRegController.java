package com.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.model.CompetitionMaster;
import com.springboot.service.CompetitionMasterService;

@Controller
@RequestMapping("/register")
public class CompetitionRegController {

	@Autowired
	private CompetitionMasterService competitionMasterService;


	@RequestMapping("/regCompetitionSummary")
	public String competitionSummaryPage(Model model) {
		return "regCompetitionSummary";
	}

}
