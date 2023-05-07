package com.Student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	public String updateDetails(int n, int roll) throws StudentException {
		String result= "Not updated...";
		Scanner sc = new Scanner(System.in);
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps1= conn.prepareStatement("select * from student where roll=?");
			ps1.setInt(1, roll);
			ResultSet rs= ps1.executeQuery();
			if(rs.next()) {
				
			if(n==1) {
				String name1=rs.getString("sname");
				System.out.println("Your current name "+name1);
				System.out.println("enter new name: ");
				String name=sc.nextLine();
				PreparedStatement ps= conn.prepareStatement("update student set sname=? where roll=?");
				ps.setString(1, name);
				ps.setInt(2, roll);
				result ="name updated sucessfully...";
				
			}
			else if(n==2) {
				String email1=rs.getString("semail");
				System.out.println("Your current email "+email1);
				System.out.println("enter new email: ");
				String email=sc.nextLine();
				PreparedStatement ps= conn.prepareStatement("update student set semail=? where roll=?");
				ps.setString(1, email);
				ps.setInt(2, roll);
				result= "Roll updated Successfully...";
			}
			else if(n==3) {
				String pass1=rs.getString("spassword");
				System.out.println("Your current name "+pass1);
				System.out.println("enter new password: ");
				String pass=sc.nextLine();
				PreparedStatement ps= conn.prepareStatement("update student set spassword=? where roll=?");
				ps.setString(1, pass);
				ps.setInt(2, roll);
				result="Password updated successfully...";
			}
			else {
				throw new StudentException("Invalid input.....");
			}
		  }
			else {
				throw new StudentException("Student not found with roll "+roll);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}
		
		
		return result;
	}

	@Override
	public List<Course> availableCourseAndSeat() throws CourseException {
		List<Course> ls = new ArrayList<>();
		Course c= new Course();
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from course");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				c.setCid(rs.getInt("cid"));
				c.setCname(rs.getString("cname"));
				c.setFee(rs.getInt("fee"));
				c.setDuration(rs.getString("duration"));
				c.setTotalseat(rs.getInt("totalSeat"));
				c.setAvailableSeat(rs.getInt("availableseat"));
				ls.add(c);
			}
			if(ls==null || ls.size()==0 ) {
				throw new CourseException("Course is not available....");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return ls;
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
			PreparedStatement ps1= conn.prepareStatement("select * from course where cid=?");
			ps1.setInt(1, cid);
			ResultSet rs= ps1.executeQuery();
			if(rs.next()) {
				int seat= rs.getInt("availableSeat");
				if(seat>0) {
					PreparedStatement ps= conn.prepareStatement("insert into student_course values(?,?)");
					ps.setInt(2, cid);
					ps.setInt(1, roll);
					int x=ps.executeUpdate();
					if(x>0) {
						result =roll+" is enrolled in Course Id "+cid+" Successfully";
						PreparedStatement ps3= conn.prepareStatement("update course set availableSeat=availableSeat-1 where cid=?");
						ps3.setInt(1, cid);
					    ps3.executeUpdate();
					}
					else {
						throw new CourseException("Invalid roll");
					}
				}
				else {
					result="Seat is not available in this course with cid "+cid;
				}
			}
			else {
				throw new CourseException("No course found with cid "+cid);
			}
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return result;
	}

}
