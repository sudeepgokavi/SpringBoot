package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.model.RuleMaster;
import com.springboot.service.RuleMasterService;

@Controller
@RequestMapping("/rules")
public class RuleMasterController {

	@Autowired
	private RuleMasterService ruleMasterService;

	@RequestMapping("/configureRule")
	public String configureRule(Model model, HttpServletRequest request) {
		return "configureRules";
	}

	@RequestMapping("/rulesSummary")
	public String rulesSummaryPage(Model model) {
		return "rulesSummary";
	}

	@RequestMapping(value = "/viewRuleDetails", method = RequestMethod.GET)
	public String viewRuleDetails(HttpServletRequest request, @RequestParam("ruleID") int ruleID, Model model) {
		request.getSession().setAttribute("ruleID", ruleID);

		return "configureRules";
	}

	@RequestMapping("/all")
	public @ResponseBody List<RuleMaster> getAllRules(Model model) {
		List<RuleMaster> listObj = this.ruleMasterService.list();
		model.addAttribute("listRulesObj", listObj);
		return listObj;
	}

	@RequestMapping("/addRule")
	public String addRule(Model model, HttpServletRequest request) {
		String ruleId = request.getParameter("ruleId");
		RuleMaster ruleMasterObj = new RuleMaster();

		ruleMasterObj.setRuleDesc(request.getParameter("ruleDesc"));
		ruleMasterObj.setRuleName(request.getParameter("ruleName"));
		ruleMasterObj.setRulePoints(Integer.parseInt(request.getParameter("rulePoints")));
		ruleMasterObj.setRulePriority(request.getParameter("rulePriority"));
		ruleMasterObj.setRuleStatus(request.getParameter("ruleStatus"));
		ruleMasterObj.setRuleType(request.getParameter("ruleType"));

		this.ruleMasterService.save(ruleMasterObj);
		return "rulesSummary";
	}

	@RequestMapping("/updateRule")
	public String updateRule(Model model, HttpServletRequest request) {
		String ruleId = request.getParameter("ruleId");
		//System.out.println(" -------- > " + ruleId);
		RuleMaster ruleMasterObj = null;
		if (ruleId != "" || ruleId != null || ruleId != "null") {
			ruleMasterObj = this.getRuleDetails(Integer.parseInt(ruleId));
		}
		ruleMasterObj.setRuleDesc(request.getParameter("ruleDesc"));
		ruleMasterObj.setRuleName(request.getParameter("ruleName"));
		ruleMasterObj.setRulePoints(Integer.parseInt(request.getParameter("rulePoints")));
		ruleMasterObj.setRulePriority(request.getParameter("rulePriority"));
		ruleMasterObj.setRuleStatus(request.getParameter("ruleStatus"));
		ruleMasterObj.setRuleType(request.getParameter("ruleType"));

		this.ruleMasterService.update(ruleMasterObj);
		request.getSession().removeAttribute("ruleID");
		return "rulesSummary";
	}

	@RequestMapping(value = "/ruleDetails/{ruleId}", method = RequestMethod.GET)
	public @ResponseBody RuleMaster getRuleDetails(@PathVariable("ruleId") int ruleMasterId) {
		//System.out.println(" ------------------------ ? " + ruleMasterId);
		RuleMaster ruleMasterObj = this.ruleMasterService.getRuleMasterObj(ruleMasterId);
		return ruleMasterObj;
	}

	@RequestMapping(value = "/deleteRule/{ruleId}", method = RequestMethod.GET)
	public String deleteRules(@PathVariable("ruleId") int ruleMasterId) {
		//System.out.println(" ------------------------ ? " + ruleMasterId);
		RuleMaster ruleMasterObj = this.ruleMasterService.getRuleMasterObj(ruleMasterId);
		if(ruleMasterObj != null)
			this.ruleMasterService.delete(ruleMasterObj);
		return "rulesSummary";
	}

}
