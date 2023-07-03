package com.adhi.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;
    private String name;
    private String course;
    private int sub1;
    private int sub2;
    private int sub3;
    private double average;
    private int total;
    private String grade;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Long iD, String name, String course, int sub1, int sub2, int sub3, double average, int total,
			String grade) {
		super();
		this.iD = iD;
		this.name = name;
		this.course = course;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.average = average;
		this.total = total;
		this.grade = grade;
	}
	public Long getiD() {
		return iD;
	}
	public void setiD(Long iD) {
		this.iD = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getSub1() {
		return sub1;
	}
	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}
	public int getSub2() {
		return sub2;
	}
	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}
	public int getSub3() {
		return sub3;
	}
	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Student [iD=" + iD + ", name=" + name + ", course=" + course + ", sub1=" + sub1 + ", sub2=" + sub2
				+ ", sub3=" + sub3 + ", average=" + average + ", total=" + total + ", grade=" + grade + "]";
	}
    
	
}

