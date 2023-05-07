package com.Student.usecases;

import java.util.Scanner;

import com.Student.dao.AdminDao;
import com.Student.dao.AdminDaoImpl;
import com.Student.exceptions.CourseException;

public class UpdateFeeOfCourse {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter the course id: ");
		int cid= sc.nextInt();
		
		System.out.println("enter the newFees: ");
		int fee= sc.nextInt();
		
		AdminDao ad = new AdminDaoImpl();
		try {
			String res=ad.updateFeeOfCourse(fee, cid);
			System.out.println(res);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
