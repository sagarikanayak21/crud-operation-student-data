package com.sn.student.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sn.student.repository.StudentRepository;
import com.sn.student.vo.Student;

@Service
public class StudentService implements StudentServiceI {
	
	@Autowired
	StudentRepository studentRepository;
	
	// GET
	@Override
	public Student getStudentById(String sid) {
		Optional<Student> std = studentRepository.findById(sid);
		if(std.isPresent()) {
			return std.get();
		} else {
            throw new RuntimeException("Student not found with ID: " + sid);
        }
	}

	// POST
	@Override
	public Student saveStudentDetails(Student student) {
		return studentRepository.save(student);
	}
    
	// GET
	@Override
	public List<Student> getStudentByDept(String dept) {
		return  studentRepository.findByDept(dept);
	}

	// GET
	@Override
	public List<Student> getStudentByDobAndAddress(String dob, String address) {
		return studentRepository.findByDobAndAddress(dob, address);
	}

	// PUT
	@Override
	public Student updateStudentById(String sid, String newAddress) {
		Optional<Student> std = studentRepository.findById(sid);
		if(std.isPresent()) {
			Student student = std.get();
			student.setAddress(newAddress);
			return studentRepository.save(student);
		} else {
			throw new RuntimeException("Student ID is not present: " +sid);
		}
	}

	// DELETE
	@Override
	public void deleteStudentById(String sid) {
		Optional<Student> std = studentRepository.findById(sid);
		if(std.isPresent()) {
			Student student = std.get();
			studentRepository.delete(student);
		} else {
			throw new RuntimeException("Student ID not found: " +sid);
		}
	}
	
}
