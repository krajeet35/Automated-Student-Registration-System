package com.Student.usecases;

import java.util.Scanner;

import com.Student.dao.StudentDao;
import com.Student.dao.StudentDaoImpl;
import com.Student.exceptions.StudentException;
import com.Student.model.Student;

public class SignInStudent {
	
	 

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter username/email: ");
		String email=sc.next();
		
		System.out.println("enter password: ");
		String pass= sc.next();
		
		StudentDao sd = new StudentDaoImpl();
		
		try {
			Student s= sd.signInStudent(email, pass);
			System.out.println(" SignIn Successfull ");
			System.out.println("Welcome "+s.getSname());
			System.out.println("Your roll is "+s.getRoll());
		
		}
		catch(StudentException e) {
			System.out.println(e.getMessage());
		}

	}

}
