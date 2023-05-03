package com.Student.model;

public class Student {
	private int roll;
	private String sname;
	private String semail;
	private String spassword;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int roll, String sname, String semail, String spassword) {
		super();
		this.roll = roll;
		this.sname = sname;
		this.semail = semail;
		this.spassword = spassword;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", sname=" + sname + ", semail=" + semail + ", spassword=" + spassword + "]";
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	
	

}
