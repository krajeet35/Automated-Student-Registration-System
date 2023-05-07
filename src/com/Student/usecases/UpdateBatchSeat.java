package com.Student.usecases;

import java.util.Scanner;

import com.Student.dao.AdminDao;
import com.Student.dao.AdminDaoImpl;
import com.Student.exceptions.BatchException;

public class UpdateBatchSeat {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter new size: ");
		int size=sc.nextInt();
		
		System.out.println("enter batch id: ");
		int bid= sc.nextInt();
		
		AdminDao ad = new AdminDaoImpl();
		
		try {
			String res= ad.updateBatchSeat(size, bid);
			System.out.println(res);
		} catch (BatchException e) {
			System.out.println(e.getMessage());
		}

	}

}
