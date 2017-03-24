package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.service.StudentService;

@Controller
//@RequestMapping("/rules")
public class RuleMasterController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/allStudents")
	public String getAllStudents(Model model){
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
		//model.addAttribute("allStudents", studentService.getAllStudents());
		return "allStudentsView";
	}
	
}
