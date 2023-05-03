package com.Student.dao;

import java.util.List;

import com.Student.exceptions.CourseException;
import com.Student.exceptions.StudentException;
import com.Student.model.Course;
import com.Student.model.Student;

public interface StudentDao {
	
	public String registerStudent(Student student) throws StudentException;
	
	public String updateDetails() throws StudentException;
	
	public List<Course> availableCourseAndSeat() throws CourseException;

}
