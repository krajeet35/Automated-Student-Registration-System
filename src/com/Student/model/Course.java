package com.Student.model;

public class Course {
	private int cid;
	private String cname;
	private int fee;
	private String duration;
	private int totalseat;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int cid, String cname, int fee, String duration, int totalseat) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.fee = fee;
		this.duration = duration;
		this.totalseat = totalseat;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", fee=" + fee + ", duration=" + duration + ", totalseat="
				+ totalseat + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getTotalseat() {
		return totalseat;
	}

	public void setTotalseat(int totalseat) {
		this.totalseat = totalseat;
	}
	

}
