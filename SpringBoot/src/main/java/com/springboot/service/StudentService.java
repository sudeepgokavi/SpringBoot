package com.springboot.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.dao.StudentDao;
import com.springboot.entity.Student;

@Service
public class StudentService {

	@Autowired
	@Qualifier("fakeData")
	private StudentDao studentDao;
	
	public Collection<Student> getAllStudents(){
		return studentDao.getAllStudents();
	} 

	public Student getStudentBuId(int id){
		return this.studentDao.getStudentBuId(id);
	}
	
	public void updateStudent(Student student){
		this.studentDao.updateStudent(student);
	}

	public void removeStudentById(int id){
		this.studentDao.removeStudentById(id);
	}

	public void insertStudent(Student student) {
		this.studentDao.insertStudent(student);	
	}

}
