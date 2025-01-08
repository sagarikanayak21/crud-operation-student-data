package com.sn.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sn.student.vo.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{
	public List<Student> findByDept(String dept);
	public List<Student> findByDobAndAddress(String dob, String address);
}
