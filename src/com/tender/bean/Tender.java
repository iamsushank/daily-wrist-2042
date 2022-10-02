package com.tender.bean;

import java.sql.Date;

public class Tender {
	
	private int tid;
	private String tName;
	private String type;
	private int amount;
	private String location;
	private String deadline;
	
	public Tender() {}

	public Tender(int tid, String tName, String type, int amount, String location, String deadline) {
		super();
		this.tid = tid;
		this.tName = tName;
		this.type = type;
		this.amount = amount;
		this.location = location;
		this.deadline = deadline;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	@Override
	public String toString() {
		return "Tender [tid=" + tid + ", tName=" + tName + ", type=" + type + ", amount=" + amount + ", location="
				+ location + ", deadline=" + deadline + "]";
	}


	
	
}
