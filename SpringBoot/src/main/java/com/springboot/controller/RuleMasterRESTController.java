package com.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.RuleMaster;
import com.springboot.service.RuleMasterService;

@RestController
@RequestMapping("/rules")
public class RuleMasterRESTController {

	@Autowired
	private RuleMasterService ruleMasterService;

	@RequestMapping("/allRuleDetails")
	public List<String> getAllRuleDetails(HttpServletRequest request) {
		System.out.println("RuleMasterController.getAllRuleNames()");
		String colName = request.getParameter("colName");
		List<String> ruleData = this.ruleMasterService.getColSpecificData(colName);
		ruleData.add("Other");
		return ruleData;
	}

	@RequestMapping("/allRules")
	public List<RuleMaster> getAllRules(){
		System.out.println("All Rules");
		List<RuleMaster> listObj = this.ruleMasterService.list();
		return listObj;
	}

}
