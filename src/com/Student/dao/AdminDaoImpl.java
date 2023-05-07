package com.Student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			PreparedStatement ps = conn.prepareStatement("insert into course(cname,fee,duration,totalseat,availableSeat) values(?,?,?,?,?)");
			ps.setString(1, course.getCname());
			ps.setInt(2, course.getFee());
			ps.setString(3, course.getDuration());
			ps.setInt(4, course.getTotalseat());
			ps.setInt(5, course.getTotalseat());
			
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
				PreparedStatement ps2= conn.prepareStatement("select sum(batchseat) as total from batch where cid=?");
				ps2.setInt(1, batch.getCid());
				ResultSet rs1= ps2.executeQuery();
				int bSeat=rs1.getInt("total");
				int seat=rs.getInt("totalSeat");
				int fSeat=seat-bSeat;
				if(fSeat>=batch.getBatchSeat()) {
					PreparedStatement ps1= conn.prepareStatement("insert into batch(cid,batchseat,availablebatchseat) values(?,?,?)");
					ps1.setInt(1, batch.getCid());
					ps1.setInt(2, batch.getBatchSeat());
					ps1.setInt(3, batch.getBatchSeat());
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
        String result="Not updated";
        
        try(Connection conn=DBUtil.provideConnection()){
        	PreparedStatement ps = conn.prepareStatement("insert into student_batch values(?,?)");
        	ps.setInt(1, studentBatch.getRoll());
        	ps.setInt(2, studentBatch.getBatchId());
        	int x=ps.executeUpdate();
        	if(x>0) {
        		PreparedStatement ps1= conn.prepareStatement("update batch set availabeBatchSeat= availabeBatchSeat-1 where batchId=?");
        		ps1.setInt(1, studentBatch.getBatchId());
        		ps1.executeUpdate();
        		result=studentBatch.getRoll()+" enrolled successfully in batch "+studentBatch.getBatchId();
        	}
        	
        }
        catch(SQLException e) {
        	e.printStackTrace();
        	throw new BatchException(e.getMessage());
        	
        }
		
		return result;
	}

	@Override
	public String updateBatchSeat(int newSeat, int bid) throws BatchException {
		String result="Not updated";
		
		try(Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps3= conn.prepareStatement("select availabeBatchSeat from batch where batchid=?");
			ps3.setInt(1, bid);
			ResultSet rs3= ps3.executeQuery();
			if(rs3.next()) {
				int seatA=rs3.getInt("availabeBatchSeat");
				if(seatA<=newSeat) {
					PreparedStatement ps= conn.prepareStatement("select c.totalseat,b.cid from course as c inner join batch as b on c.cid=b.cid where b.batchId=?");
					ps.setInt(1, bid);
					ResultSet rs= ps.executeQuery();
					if(rs.next()) {
						int seat=rs.getInt("totalSeat");
						int cid= rs.getInt("cid");
						PreparedStatement ps2= conn.prepareStatement("select sum(batchseat) as total from batch where cid=?");
						ps2.setInt(1,cid);
						ResultSet rs1= ps2.executeQuery();
						if(rs1.next()) {
							int bSeat=rs1.getInt("total");
							int fSeat=seat-bSeat;
							if(fSeat>=newSeat) {
								PreparedStatement ps1= conn.prepareStatement("update batch set BatchSeat= ? where batchId=?");
								ps1.setInt(1, newSeat);
								ps1.setInt(2, bid);
								int z=ps1.executeUpdate();
								if(z>0) {
									result="Batch new size updated successfully..";
									int sizeU=newSeat-seatA;
									PreparedStatement ps4= conn.prepareStatement("update batch set availabeBatchSeat= availabeBatchSeat+? where batchId=?");
									ps4.setInt(1, sizeU);
									ps4.setInt(2, bid);
									ps4.executeUpdate();
					        		
								}
								
							}
							else {
								result="Batch seat should be less than course seat";
						}
						}
						else {
							result="Course not found with "+cid;
						}
					}
					else {
						result="Batch not found with "+bid;
					}
				}
				else {
					result="Batch size can not be decreased because students are already enrolled";
				}
			
			}
			else {
				result="Batch not found with "+bid;
			}
		}
        catch(SQLException e) {
        	e.printStackTrace();
        	throw new BatchException(e.getMessage());
        	
        }
		
		return result;
		
	}

	@Override
	public List<Student> allStudentOfAllBatch() throws BatchException {
		List<Student> ls= new ArrayList<>();
		
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from student as s inner join batch b inner join student_batch as sb on s.roll=sb.roll and b.batchid=sb.batchid");
			ResultSet rs= ps.executeQuery();
			Student s= new Student();
			while(rs.next()) {
				s.setRoll(rs.getInt("roll"));
				s.setSname(rs.getString("sname"));
				s.setSemail(rs.getString("semail"));
				ls.add(s);
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		return ls;
	}

}
