package com.Student.usecases;

import java.util.Scanner;

public class AdminFeatures {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);


		
		System.out.println("1 Choose for course add");
		System.out.println("2 Choose for course fee update");
		System.out.println("3 choose for batch add");
		System.out.println("4 choose for student enrollment in a batch");
		System.out.println("5 choose for update batch seat");
		System.out.println("6 choose for see all student of all batch");
		System.out.println("7 choose for Logout");
		int n3=sc.nextInt();
		switch (n3) {
		case 1: {
			CourseAddByAdmin.main(args);
			AdminFeatures.main(args);
			break;
		}
		case 2:{
			UpdateFeeOfCourse.main(args);
			AdminFeatures.main(args);
			break;
		}
		case 3:{
			BatchAddByAdmin.main(args);
			AdminFeatures.main(args);
			break;
		}
		case 4:{
			StudentEnrollInBatch.main(args);
			AdminFeatures.main(args);
			break;
		}
		case 5:{
			UpdateBatchSeat.main(args);
			AdminFeatures.main(args);
			break;
		}
		case 6:{
			AllStudentOfAllBatch.main(args);
			AdminFeatures.main(args);
			break;
		}
		case 7:{
			System.out.println("LoggedOut Successfull...");
			return;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + n3);
		}


	}

}
