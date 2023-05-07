package com.Student.usecases;

import java.util.Scanner;

import com.Student.dao.AdminDao;
import com.Student.dao.AdminDaoImpl;
import com.Student.exceptions.CourseException;
import com.Student.model.Course;

public class CourseAddByAdmin {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Scanner sc1= new Scanner(System.in);
		System.out.println("enter course name: ");
		String name=sc.nextLine();
		
		System.out.println("enter course fee: ");
		int fee= sc1.nextInt();
		
		System.out.println("enter course duration: ");
		String dur= sc.nextLine();
		
		System.out.println("enter total course seat: ");
		int seat= sc1.nextInt();
		
		Course c= new Course();
		c.setCname(name);
		c.setFee(fee);
		c.setDuration(dur);
		c.setTotalseat(seat);
		
		AdminDao ad = new AdminDaoImpl();
		
		try {
			String res=ad.addCourse(c);
			System.out.println(res);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		sc.close();
		sc1.close();

	}

}
