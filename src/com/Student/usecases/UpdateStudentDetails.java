package com.Student.usecases;

import java.util.Scanner;

import com.Student.dao.StudentDao;
import com.Student.dao.StudentDaoImpl;
import com.Student.exceptions.StudentException;

public class UpdateStudentDetails {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("1: Enter to change your name");
		System.out.println("2: Enter to change your email");
		System.out.println("3: Enter to change your password");
		int n= sc.nextInt();
		System.out.println("enter your roll: ");
		int roll= sc.nextInt();
		StudentDao sd= new StudentDaoImpl();
		try {
			String res=sd.updateDetails(n, roll);
			System.out.println(res);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}

	}

}
