package com.springboot.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Student;

@Repository
@Qualifier("fakeData")
public class StudentDaoImpl implements StudentDao {

	private static Map<Integer, Student> students;
	
	static{
		students = new HashMap<Integer, Student>(){
			{
				put (1, new Student(1,"Sudeep","Computer Science"));
				put (2, new Student(2,"Sarah","Class-2"));
				put (3, new Student(3,"Roopa","BSc"));
			}
		};
	}
	
	/* (non-Javadoc)
	 * @see com.springboot.dao.StudentDao#getAllStudents()
	 */
	public Collection<Student> getAllStudents(){
		return this.students.values();
	}
	
	/* (non-Javadoc)
	 * @see com.springboot.dao.StudentDao#getStudentBuId(int)
	 */
	public Student getStudentBuId(int id) {
		return this.students.get(id);
	}
	
	/* (non-Javadoc)
	 * @see com.springboot.dao.StudentDao#updateStudent(com.springboot.entity.Student)
	 */
	public void updateStudent(Student student){
		Student studentObj = students.get(student.getId());
		studentObj.setCourse(student.getCourse());
		studentObj.setName(student.getName());
		
		this.students.put(student.getId(), studentObj);
	}

	/* (non-Javadoc)
	 * @see com.springboot.dao.StudentDao#removeStudentById(int)
	 */
	public void removeStudentById(int id){
		this.students.remove(id);
	}

	/* (non-Javadoc)
	 * @see com.springboot.dao.StudentDao#insertStudent(com.springboot.entity.Student)
	 */
	public void insertStudent(Student student) {
		this.students.put(student.getId(), student);
	}
}
