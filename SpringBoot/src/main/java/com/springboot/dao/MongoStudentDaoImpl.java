package com.springboot.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Student;

@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao {

	
	public Collection<Student> getAllStudents() {
		return new ArrayList<Student>();
	}

	public Student getStudentBuId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	public void removeStudentById(int id) {
		// TODO Auto-generated method stub
		
	}

	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

}
