package com.springboot.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Student;
import com.springboot.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Student> getAllStudents(){
		return studentService.getAllStudents();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") int id){
		return studentService.getStudentBuId(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteStudentById(@PathVariable("id") int id){
		studentService.removeStudentById(id);
		return "Student Deleted";
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateStudent(@RequestBody Student student){
		studentService.updateStudent(student);
		return "Student Updated";
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insertStudent(@RequestBody Student student){
		studentService.insertStudent(student);
		return "Student Inserted";
	}
}
