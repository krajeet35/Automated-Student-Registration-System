package com.Student.usecases;

import java.util.ArrayList;
import java.util.List;

import com.Student.dao.StudentDao;
import com.Student.dao.StudentDaoImpl;
import com.Student.exceptions.CourseException;
import com.Student.model.Course;

public class AvailableCourseAndSeat {

	public static void main(String[] args) {
		
		List<Course> ls= new ArrayList<>();
		StudentDao sd= new StudentDaoImpl();
		
		try {
			ls=sd.availableCourseAndSeat();
			ls.forEach(c -> System.out.println(c));
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

	}

}
