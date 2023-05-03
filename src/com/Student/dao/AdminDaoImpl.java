package com.Student.dao;

import java.util.List;

import com.Student.exceptions.BatchException;
import com.Student.exceptions.CourseException;
import com.Student.model.Batch;
import com.Student.model.Course;
import com.Student.model.Student;
import com.Student.model.Student_Batch;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String signInAdmin(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addCourse(Course course) throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateFeeOfCourse(int newFee) throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCourse(String cname) throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> courseInfo(String cname) throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addBatch(Batch batch) throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String studentEnrollInBatch(Student_Batch studentBatch) throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateBatchSeat(int newSeat) throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> allStudentOfAllBatch() throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

}
