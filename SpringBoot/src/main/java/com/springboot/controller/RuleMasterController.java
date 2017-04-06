package com.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.model.RuleMaster;
import com.springboot.service.RuleMasterService;

@Controller
@RequestMapping("/rules")
public class RuleMasterController {

	@Autowired
	private RuleMasterService ruleMasterService;

	@RequestMapping("/configureRule")
	public String configureRule(Model model){
		System.out.println("Configure Rule");
		//model.addAttribute("allStudents", studentService.getAllStudents());
		return "configureRules";
	}

	@RequestMapping("/rulesSummary")
	public String rulesSummaryPage(Model model){
		System.out.println("Configure Rule");
		//model.addAttribute("allStudents", studentService.getAllStudents());
		return "rulesSummary";
	}

	@RequestMapping("/all")
	public @ResponseBody List<RuleMaster> getAllRules(Model model){
		System.out.println("All Rules");
		List<RuleMaster> listObj = this.ruleMasterService.list();
		System.out.println(listObj.size());
		model.addAttribute("listRulesObj", listObj);
		return listObj;
	}

	@RequestMapping("/addRule")
	public String addRule(Model model, HttpServletRequest request){
		RuleMaster ruleMasterObj = new RuleMaster();
		ruleMasterObj.setRuleDesc(request.getParameter("ruleDesc"));
		ruleMasterObj.setRuleName(request.getParameter("ruleName"));
		ruleMasterObj.setRulePoints(Integer.parseInt(request.getParameter("rulePoints")));
		ruleMasterObj.setRulePriority(request.getParameter("rulePriority"));
		ruleMasterObj.setRuleStatus(request.getParameter("ruleStatus"));
		ruleMasterObj.setRuleType(request.getParameter("ruleType"));
		
		this.ruleMasterService.save(ruleMasterObj);
		
		List<RuleMaster> listObj = this.ruleMasterService.list();
		System.out.println(listObj.size());
		model.addAttribute("listRulesObj", listObj);
		return "rulesSummary";
	}
	
}
