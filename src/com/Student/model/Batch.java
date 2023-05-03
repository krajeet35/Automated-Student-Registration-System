package com.Student.model;

public class Batch {
	private int batchId;
	private int cid;
	private int batchSeat;
	
	public Batch() {
		// TODO Auto-generated constructor stub
	}

	public Batch(int batchId, int cid, int batchSeat) {
		super();
		this.batchId = batchId;
		this.cid = cid;
		this.batchSeat = batchSeat;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", cid=" + cid + ", batchSeat=" + batchSeat + "]";
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getBatchSeat() {
		return batchSeat;
	}

	public void setBatchSeat(int batchSeat) {
		this.batchSeat = batchSeat;
	}
	
	

}
