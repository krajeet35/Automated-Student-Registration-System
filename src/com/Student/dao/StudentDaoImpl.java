package com.Student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.Student.exceptions.CourseException;
import com.Student.exceptions.StudentException;
import com.Student.model.Course;
import com.Student.model.Student;
import com.Student.utility.DBUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String registerStudent(Student student) throws StudentException {
		String result="Not registered...";
		
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into student(sname, semail, spassword) values(?,?,?)");
			ps.setString(1, student.getSname());
			ps.setString(2, student.getSemail());
			ps.setString(3, student.getSpassword());
			
			int x= ps.executeUpdate();
			if(x>0) {
				result="Registration Successfull.....";
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public String updateDetails() throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> availableCourseAndSeat() throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student signInStudent(String user, String pass) throws StudentException {
		Student student= new Student();
		
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select * from student where semail=? and spassword=?");
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				student.setRoll(rs.getInt("roll"));
				student.setSname(rs.getString("sname"));
			}
			else {
				throw new StudentException("Invalid username or password");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}
		
		
		return student;
	}

	@Override
	public String enrollInCourse(int cid, int roll) throws CourseException {
		String result= "Not enrolled";
		
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("insert into student_course values(?,?)");
			ps.setInt(2, cid);
			ps.setInt(1, roll);
			int x=ps.executeUpdate();
			if(x>0) {
				result =roll+" is enrolled in Course Id "+cid+" Successfully";
			}
			else {
				throw new CourseException("Invalid cid or roll");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return result;
	}

}
