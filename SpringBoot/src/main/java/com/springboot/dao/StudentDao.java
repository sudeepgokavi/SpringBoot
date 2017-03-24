package com.springboot.dao;

import java.util.Collection;

import com.springboot.entity.Student;

public interface StudentDao {

	Collection<Student> getAllStudents();

	Student getStudentBuId(int id);

	void updateStudent(Student student);

	void removeStudentById(int id);

	void insertStudent(Student student);

}