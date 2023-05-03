package com.Student.usecases;

import java.util.Scanner;

import com.Student.dao.StudentDao;
import com.Student.dao.StudentDaoImpl;
import com.Student.exceptions.StudentException;
import com.Student.model.Student;

public class RegisterStudent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter student name: ");
		String name= sc.nextLine();
		
		System.out.println("enter student email/username: ");
		String email=sc.next();
		
		System.out.println("enter password: ");
		String pass= sc.next();
		
		Student s= new Student();
		s.setSname(name);
		s.setSemail(email);
		s.setSpassword(pass);
		
		StudentDao sd= new StudentDaoImpl();
		try {
			String result= sd.registerStudent(s);
			System.out.println(result);
			
		}
		catch(StudentException e) {
			System.out.println(e.getMessage());
		}

	}

}
