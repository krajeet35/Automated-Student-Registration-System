package com.Student.model;

public class Batch {
	private int batchId;
	private int cid;
	private int batchSeat;
	private int AvailableBatchSeat;
	
	public Batch() {
		// TODO Auto-generated constructor stub
	}

	public Batch(int batchId, int cid, int batchSeat, int AvailableBatchSeat) {
		super();
		this.batchId = batchId;
		this.cid = cid;
		this.batchSeat = batchSeat;
		this.AvailableBatchSeat=AvailableBatchSeat;
	}

	

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", cid=" + cid + ", batchSeat=" + batchSeat + ", AvailableBatchSeat="
				+ AvailableBatchSeat + "]";
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
	
	public int getAvailableBatchSeat() {
		return AvailableBatchSeat;
	}

	public void setAvailableBatchSeat(int AvailableBatchSeat) {
		this.AvailableBatchSeat = AvailableBatchSeat;
	}
	

}
