package com.Student.model;

public class Student_Batch {
	private int roll;
	private int batchId;
	
	public Student_Batch() {
		// TODO Auto-generated constructor stub
	}

	public Student_Batch(int roll, int batchId) {
		super();
		this.roll = roll;
		this.batchId = batchId;
	}

	@Override
	public String toString() {
		return "Student_Batch [roll=" + roll + ", batchId=" + batchId + "]";
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	

}
