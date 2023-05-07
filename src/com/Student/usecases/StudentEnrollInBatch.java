package com.Student.usecases;

import java.util.Scanner;

import com.Student.dao.AdminDao;
import com.Student.dao.AdminDaoImpl;
import com.Student.exceptions.BatchException;
import com.Student.model.Student_Batch;

public class StudentEnrollInBatch {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter your roll: ");
		int roll=sc.nextInt();
		
		System.out.println("enter batch Id: ");
		int bid=sc.nextInt();
		
		Student_Batch sb= new Student_Batch();
		sb.setRoll(roll);
		sb.setBatchId(bid);
		AdminDao ad= new AdminDaoImpl();
		try {
			String res= ad.studentEnrollInBatch(sb);
			System.out.println(res);
		} catch (BatchException e) {
			System.out.println(e.getMessage());
		}

	}

}
