package com.Student.usecases;

import java.util.Scanner;

import com.Student.dao.AdminDao;
import com.Student.dao.AdminDaoImpl;
import com.Student.dao.StudentDao;
import com.Student.dao.StudentDaoImpl;
import com.Student.exceptions.AdminException;
import com.Student.exceptions.StudentException;
import com.Student.model.Student;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("1 Choose for Admin");
		System.out.println("2 Choose for Student");
		int n1=sc.nextInt();
		if(n1==1) {
			System.out.println("1 SignIn Admin");
			int n2=sc.nextInt();
			if(n2==1) {
				Scanner sc1= new Scanner(System.in);
				
				System.out.println("enter your username/email: ");
				String user= sc1.next();
				
				System.out.println("enter your password: ");
				String pass= sc1.next();
				
				AdminDao ad= new AdminDaoImpl();
				
				try {
					String res=ad.signInAdmin(user, pass);
					System.out.println(res);
					if(res=="SignIn Successfull...") {
						AdminFeatures.main(args);
					}
				} catch (AdminException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			else {
				System.out.println("Invalid input");
			}
		}
		else if(n1==2) {
			System.out.println("1 Choose for registration");
			System.out.println("2 Choose for SignIn");
			int n4=sc.nextInt();
			if(n4==1) {
				RegisterStudent.main(args);
			}
			else if(n4==2) {
				Scanner sc2= new Scanner(System.in);
				
				System.out.println("enter username/email: ");
				String email=sc2.next();
				
				System.out.println("enter password: ");
				String pass= sc2.next();
				
				StudentDao sd = new StudentDaoImpl();
				
				try {
					Student s= sd.signInStudent(email, pass);
					System.out.println(" SignIn Successfull ");
					System.out.println("Welcome "+s.getSname());
					System.out.println("Your roll is "+s.getRoll());
					if(s !=null) {
						StudentFeatures.main(args);
					}
				
				}
				catch(StudentException e) {
					System.out.println(e.getMessage());
				}
			}
			else {
				System.out.println("invalid input");
			}
		}
		else {
			System.out.println("Invalid input");
		}

	}

}
