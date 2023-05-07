package com.Student.usecases;

import java.util.Scanner;

import com.Student.dao.AdminDao;
import com.Student.dao.AdminDaoImpl;
import com.Student.exceptions.BatchException;
import com.Student.model.Batch;

public class BatchAddByAdmin {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter course id: ");
		int cid= sc.nextInt();
		
		System.out.println("enter batch seat: ");
		int seat=sc.nextInt();
		
		Batch b= new Batch();
		b.setCid(cid);
		b.setBatchSeat(seat);
		
		AdminDao ad= new AdminDaoImpl();
		try {
			String res=ad.addBatch(b);
			System.out.println(res);
		} catch (BatchException e) {
			System.out.println(e.getMessage());
		}

	}

}
