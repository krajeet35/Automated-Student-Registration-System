package com.Student.usecases;

import java.util.Scanner;

import com.Student.dao.AdminDao;
import com.Student.dao.AdminDaoImpl;
import com.Student.dao.StudentDao;
import com.Student.dao.StudentDaoImpl;
import com.Student.exceptions.AdminException;

public class SignInAdmin {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter your username/email: ");
		String user= sc.next();
		
		System.out.println("enter your password: ");
		String pass= sc.next();
		
		AdminDao ad= new AdminDaoImpl();
		
		try {
			String res=ad.signInAdmin(user, pass);
			System.out.println(res);
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
