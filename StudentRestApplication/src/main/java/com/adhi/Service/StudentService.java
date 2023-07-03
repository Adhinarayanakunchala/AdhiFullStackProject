package com.adhi.Service;

import java.util.List;

import com.adhi.Model.Student;

public interface StudentService {

	 List<Student> getAllStudents();

	    Student getStudentById(Long iD);

	    Student createStudent(Student student);

	    Student updateStudent(Long iD, Student student);

	    void deleteStudentById(Long iD);
	
	
}
