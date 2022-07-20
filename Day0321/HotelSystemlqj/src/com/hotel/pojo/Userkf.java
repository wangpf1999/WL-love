package com.hotel.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Userkf implements Serializable {

	private static final long serialVersionUID = 1L;
	private  String  rname;
     private String rphonenumber;
     private String identify;
     private String rdept;
     private Date rdate;
     private int money;
   
     
  

	public Userkf() {
    	 
     }
	   public int getMoney() {
			return money;
		}

		public void setMoney(int money) {
			this.money = money;
		}
	public Userkf(String rname, String rphonenumber, String identify, String rdept, Date rdate) {
		super();
		this.rname = rname;
		this.rphonenumber = rphonenumber;
		this.identify = identify;
		this.rdept = rdept;
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "User [rname=" + rname + ", rphonenumber=" + rphonenumber + ", identify=" + identify + ", rdept="
				+ rdept + ", rdate=" + rdate + "]";
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRphonenumber() {
		return rphonenumber;
	}

	public void setRphonenumber(String rphonenumber) {
		this.rphonenumber = rphonenumber;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getRdept() {
		return rdept;
	}

	public void setRdept(String rdept) {
		this.rdept = rdept;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
  
}
