package com.tender.bean;

import java.sql.Date;

public class Bid {
	
	private int bid;
	private int tid;
	private int amount;
	private int vid;
	private Date deadline;
	private int check;
	
	
	public Bid() {}
	
	
	public Bid(int bid, int tid, int amount, int vid, Date deadline, int check) {
		super();
		this.bid = bid;
		this.tid = tid;
		this.amount = amount;
		this.vid = vid;
		this.deadline = deadline;
		this.check = check;
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getVid() {
		return vid;
	}


	public void setVid(int vid) {
		this.vid = vid;
	}


	public Date getDeadline() {
		return deadline;
	}


	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}


	public int getCheck() {
		return check;
	}


	public void setCheck(int check) {
		this.check = check;
	}


	@Override
	public String toString() {
		return "Bid [bid=" + bid + ", tid=" + tid + ", amount=" + amount + ", vid=" + vid + ", deadline=" + deadline
				+ ", check=" + check + "]";
	}


	
	
}
