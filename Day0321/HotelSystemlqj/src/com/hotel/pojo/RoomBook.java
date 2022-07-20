package com.hotel.pojo;

import java.io.Serializable;
import java.sql.Date;

public class RoomBook implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer rnum;
	private Integer rlayer;
	private String runame;
	private Integer ruid;
	private Integer rutel;
	private Integer tid;
	private String rtype;
	private Integer rprice;
	private Date rtime;
	private Integer rcost;
	public Integer getRnum() {
		return rnum;
	}
	public void setRnum(Integer rnum) {
		this.rnum = rnum;
	}
	public Integer getRlayer() {
		return rlayer;
	}
	public void setRlayer(Integer rlayer) {
		this.rlayer = rlayer;
	}
	public String getRuname() {
		return runame;
	}
	public void setRuname(String runame) {
		this.runame = runame;
	}
	public Integer getRuid() {
		return ruid;
	}
	public void setRuid(Integer ruid) {
		this.ruid = ruid;
	}
	public Integer getRutel() {
		return rutel;
	}
	public void setRutel(Integer rutel) {
		this.rutel = rutel;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid= tid;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public Integer getRprice() {
		return rprice;
	}
	public void setRprice(Integer rprice) {
		this.rprice = rprice;
	}
	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}
	public Date getRtime() {
		return rtime;
	}
	public Integer getRcost() {
		return rcost;
	}
	public void setRcost(Integer rcost) {
		this.rcost = rcost;
	}
public RoomBook(Integer rnum, Integer rlayer, String runame, Integer ruid, Integer rutel, Integer tid, String rtype,
			Integer rprice, Date rtime, Integer rcost) {
		super();
		this.rnum = rnum;
		this.rlayer = rlayer;
		this.runame = runame;
		this.ruid = ruid;
		this.rutel = rutel;
		this.tid= tid;
		this.rtype = rtype;
		this.rprice = rprice;
		this.rtime = rtime;
		this.rcost = rcost;
	}
public RoomBook() {
}
}
