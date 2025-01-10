package com.sn.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sn.student.dao.StudentServiceI;
import com.sn.student.vo.Student;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentServiceI studentService;
	
	// to retrieve data from database by primary key
	// http://localhost:8080/student/USBM004/details
	@GetMapping("/{sid}/details")
	public Student getStudent(@PathVariable String sid) {
		 return studentService.getStudentById(sid);
	}
	
	// to send data to database by primary key
	// http://localhost:8080/student/save
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudentDetails(student);
	}
	
	// to retrieve data from database by department
	// http://localhost:8080/student/MCA/data
	@GetMapping("/{dept}/data")
	public List<Student> studentByDept(@PathVariable String dept){
		return studentService.getStudentByDept(dept);
	}
	
	// to retrieve data from database by Date Of Birth and Address
	// http://localhost:8080/student/retrieve/dob/jajpur?dob=15/05/1998 
	// in Params key dob, value 15/05/1998
	@GetMapping("/retrieve/dob/{address}")
	public List<Student> studentByDobAndAddress(@RequestParam String dob, @PathVariable String address){
		return studentService.getStudentByDobAndAddress(dob, address);
	}
	
	// to change/update the address of a record by using primary key
	// http://localhost:8080/student/USBM006/address?address=Bhadrak
	@PutMapping("/{sid}/address")
	public Student updateById(@PathVariable String sid, @RequestParam String address) {
		return studentService.updateStudentById(sid, address);
	}
	
	// to delete a record in database by using primary key
	// http://localhost:8080/student/USBM008/delete
	@DeleteMapping("/{sid}/delete")
	public void deleteById(@PathVariable String sid) {
		studentService.deleteStudentById(sid);
	}

	// @PatchMapping
}
