package com.tender.bean;

public class Current {

	private int tid;
	private String tName;
	private String vname;
	private String amount;
	
	public Current() {
		// TODO Auto-generated constructor stub
	}

	public Current(int tid, String tName, String vname, String amount) {
		super();
		this.tid = tid;
		this.tName = tName;
		this.vname = vname;
		this.amount = amount;
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

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Current [tid=" + tid + ", tName=" + tName + ", vname=" + vname + ", amount=" + amount + "]";
	}
	
	
	
}
