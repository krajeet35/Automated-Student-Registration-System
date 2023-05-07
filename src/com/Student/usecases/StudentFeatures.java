package com.Student.usecases;

import java.util.Scanner;

public class StudentFeatures {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("1 Choose for enroll in a course");
		System.out.println("2 Choose for update details");
		System.out.println("3 Choose to see available course and seat");
		int n5= sc.nextInt();
		switch (n5) {
		case 1: {
			EnrollInCourse.main(args);
			StudentFeatures.main(args);
			break;
		}
		case 2:{
			UpdateStudentDetails.main(args);
			StudentFeatures.main(args);
			break;
		}
		case 3:{
			AvailableCourseAndSeat.main(args);
			StudentFeatures.main(args);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + n5);
		}

	}

}
