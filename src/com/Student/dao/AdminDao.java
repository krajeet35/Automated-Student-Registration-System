package com.Student.dao;

import java.util.List;

import com.Student.exceptions.AdminException;
import com.Student.exceptions.BatchException;
import com.Student.exceptions.CourseException;
import com.Student.model.Batch;
import com.Student.model.Course;
import com.Student.model.Student;
import com.Student.model.Student_Batch;

public interface AdminDao {
	
	public String signInAdmin(String user, String pass) throws AdminException;
	
	public String addCourse(Course course) throws CourseException;
	
	public String updateFeeOfCourse(int newFee, int cid) throws CourseException;
	
	public String deleteCourse(String cname) throws CourseException;
	
//	public List<Course> courseInfo(String cname) throws CourseException;
	
	public String addBatch(Batch batch) throws BatchException;
	
	public String studentEnrollInBatch(Student_Batch studentBatch) throws BatchException;
	
	public String updateBatchSeat(int newSeat, int bid) throws BatchException;
	
	public List<Student> allStudentOfAllBatch() throws BatchException;

}
