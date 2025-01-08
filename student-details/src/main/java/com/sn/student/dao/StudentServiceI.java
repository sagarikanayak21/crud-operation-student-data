package com.sn.student.dao;

import java.util.List;

import com.sn.student.vo.Student;

public interface StudentServiceI {
	
	// to retrieve data from database by primary key
	public Student getStudentById(String sid);
	
	// to send data to database by primary key
	public Student saveStudentDetails(Student student);
	 
	// to retrieve data from database by department
	public List<Student> getStudentByDept(String dept);
	
	// to retrieve data from database by Date Of Birth and Address
	public List<Student> getStudentByDobAndAddress(String dob, String address);
	
	// to change/update the address of a record by using primary key
	public Student updateStudentById(String sid, String newAddress);
	
	// to delete a record in database by using primary key
	public void deleteStudentById(String sid);
}
