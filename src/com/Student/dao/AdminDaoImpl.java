package com.Student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.Student.exceptions.AdminException;
import com.Student.exceptions.BatchException;
import com.Student.exceptions.CourseException;
import com.Student.model.Batch;
import com.Student.model.Course;
import com.Student.model.Student;
import com.Student.model.Student_Batch;
import com.Student.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String signInAdmin(String user, String pass) throws AdminException{
		String result = "Not Signed In..";
		
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from admin where adminEmail=? and adminPassword=?");
			ps.setString(1, user);
			ps.setString(2, pass);
			
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				String name= rs.getString("adminName");
				result="SignIn Successfull...";
				System.out.println("Welcome "+name);
			}
			else {
				throw new AdminException("Invalid username or password");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public String addCourse(Course course) throws CourseException {
		String result= "Not added....";
		
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into course(cname,fee,duration,totalseat) values(?,?,?,?)");
			ps.setString(1, course.getCname());
			ps.setInt(2, course.getFee());
			ps.setString(3, course.getDuration());
			ps.setInt(4, course.getTotalseat());
			
			int x=ps.executeUpdate();
			if(x>0) {
				result="Course added successfully...";
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public String updateFeeOfCourse(int newFee, int cid) throws CourseException {
		String result ="Fee not updated";
		
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("update course set fee=? where cid=?");
			ps.setInt(1, newFee);
			ps.setInt(2, cid);
			int x=ps.executeUpdate();
			if(x>0) {
				result="Fee updated successfully..";
			}
			else {
				result="Course not found with cid "+cid;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		return result;
	}

	@Override
	public String deleteCourse(String cname) throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String addBatch(Batch batch) throws BatchException {
		String result="Batch not added..";
		
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select totalseat from course where cid=?");
			ps.setInt(1, batch.getCid());
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				int seat=rs.getInt("totalSeat");
				if(seat>=batch.getBatchSeat()) {
					PreparedStatement ps1= conn.prepareStatement("insert into batch(cid,batchseat) values(?,?)");
					ps1.setInt(1, batch.getCid());
					ps1.setInt(2, batch.getBatchSeat());
					int x= ps1.executeUpdate();
					if(x>0) {
						result="Batch added successfully...";
					}
				}
				else {
					result="Batch seat can not be greater than course seat";
				}
			}
			else {
				throw new BatchException("Course not found with cid "+batch.getCid());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public String studentEnrollInBatch(Student_Batch studentBatch) throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateBatchSeat(int newSeat, int cid) throws BatchException {
		
	}

	@Override
	public List<Student> allStudentOfAllBatch() throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

}
