package com.Student.usecases;

import java.util.ArrayList;
import java.util.List;

import com.Student.dao.AdminDao;
import com.Student.dao.AdminDaoImpl;
import com.Student.exceptions.BatchException;
import com.Student.model.Student;

public class AllStudentOfAllBatch {

	public static void main(String[] args) {
		
		AdminDao ad= new AdminDaoImpl();
		List<Student> ls= new ArrayList<>();
		
		try {
			ls= ad.allStudentOfAllBatch();
			ls.forEach(s -> System.out.println(s));
		} catch (BatchException e) {
		System.out.println(e.getMessage());
		}

	}

}
