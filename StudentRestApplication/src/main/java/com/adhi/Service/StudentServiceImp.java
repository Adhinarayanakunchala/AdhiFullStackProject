package com.adhi.Service;


import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adhi.Model.Student;
import com.adhi.Repo.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
    	
    	List<Student> student=(List<Student>)studentRepository.findAll();
        return student;
    }

    @Override
    public Student getStudentById(Long iD) {
    	Student student=studentRepository.findById(iD).get();
    	return student;
    }

    @Override
    public Student createStudent(Student student) {
    	
    	 // Calculate average
        double average = (student.getSub1() + student.getSub2() + student.getSub3()) / 3.0;
        student.setAverage(average);

        // Calculate total
        int total = student.getSub1() + student.getSub2() + student.getSub3();
        student.setTotal(total);

        // Calculate grade
        String grade;
        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        student.setGrade(grade);
        
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long iD, Student students) {
    	 Student student = getStudentById(iD);

    	 student.setName(students.getName());
    	 student.setCourse(students.getCourse());
    	 student.setSub1(students.getSub1());
    	 student.setSub2(students.getSub2());
    	 student.setSub3(students.getSub3());
         
         //Calculate total ,average ,grade 
         
         int total=student.getSub1()+student.getSub2()+student.getSub3();
         student.setTotal(total);
         
         double average=total/3;
         student.setAverage(average);
         
         String grade;
         if (average >= 90) {
             grade = "A";
         } else if (average >= 80) {
             grade = "B";
         } else if (average >= 70) {
             grade = "C";
         } else if (average >= 60) {
             grade = "D";
         } else {
             grade = "F";
         }
         student.setGrade(grade);
         
         return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long iD) {
        studentRepository.deleteById(iD);
    }
}

