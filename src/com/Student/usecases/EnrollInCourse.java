package com.Student.usecases;

import java.util.Scanner;

import com.Student.dao.StudentDao;
import com.Student.dao.StudentDaoImpl;
import com.Student.exceptions.CourseException;

public class EnrollInCourse {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter the course id: ");
		int cid= sc.nextInt();
		
		System.out.println("enter your roll No.: ");
		int roll= sc.nextInt();
		
		StudentDao sd= new StudentDaoImpl();
		
		try {
			String result=sd.enrollInCourse(cid, roll);
			System.out.println(result);
		}
		catch(CourseException e) {
			System.out.println(e.getMessage());
		}

	}

}
