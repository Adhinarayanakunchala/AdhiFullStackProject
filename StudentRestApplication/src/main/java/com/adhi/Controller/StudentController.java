package com.adhi.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adhi.Model.Student;
import com.adhi.Service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students;
    }

    @GetMapping("/{iD}")
    public Student getStudentById(@PathVariable("iD") Long iD) {
        Student student = studentService.getStudentById(iD);
        return student;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return createdStudent;
    }

    @PutMapping("/{iD}")
    public Student updateStudent(@PathVariable("iD") Long iD,@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(iD, student);
        return updatedStudent;
    }

    @DeleteMapping("/{iD}")
    public void deleteStudent(@PathVariable("iD") Long iD) {
    	
    	 studentService.deleteStudentById(iD);
        
    }
}
