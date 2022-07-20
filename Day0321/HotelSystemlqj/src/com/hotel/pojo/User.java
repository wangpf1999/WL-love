package com.hotel.pojo;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
	private String uname;
	private String unum;
	private String uphone;
	private String uidentity;
	private Date uindate;
	private Date uoutdate;
	public User() {
		super();
	}
	public User(String uname, String unum, Date uindate, Date uoutdate) {
		super();
		this.uname = uname;
		this.unum = unum;
		this.uindate = uindate;
		this.uoutdate = uoutdate;
	}
	public User(String uname, String unum, String uphone, String uidentity, Date uindate, Date uoutdate) {
		super();
		this.uname = uname;
		this.unum = unum;
		this.uphone = uphone;
		this.uidentity = uidentity;
		this.uindate = uindate;
		this.uoutdate = uoutdate;
	}
	
	public User(String uname, String unum, String uphone, String uidentity, Date uindate) {
		super();
		this.uname = uname;
		this.unum = unum;
		this.uphone = uphone;
		this.uidentity = uidentity;
		this.uindate = uindate;
	}
	@Override
	public String toString() {
		return "User [uname=" + uname + ", unum=" + unum + ", uphone=" + uphone + ", uidentity=" + uidentity
				+ ", uindate=" + uindate + ", uoutdate=" + uoutdate + "]";
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUnum() {
		return unum;
	}
	public void setUnum(String unum) {
		this.unum = unum;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUidentity() {
		return uidentity;
	}
	public void setUidentity(String uidentity) {
		this.uidentity = uidentity;
	}
	public Date getUindate() {
		return uindate;
	}
	public void setUindate(Date uindate) {
		this.uindate = uindate;
	}
	public Date getUoutdate() {
		return uoutdate;
	}
	public void setUoutdate(Date uoutdate) {
		this.uoutdate = uoutdate;
	}
}
