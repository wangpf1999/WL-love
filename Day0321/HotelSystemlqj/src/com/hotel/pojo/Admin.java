package com.hotel.pojo;

import java.io.Serializable;

public class Admin implements Serializable{

private static final long serialVersionUID = 1L;
private String Apassword;
private String Aloginid;
private String Aname;
public String getApassword() {
	return Apassword;
}
public void setApassword(String apassword) {
	Apassword = apassword;
}
public String getAloginid() {
	return Aloginid;
}
public void setAloginid(String aloginid) {
	Aloginid = aloginid;
}
public String getAname() {
	return Aname;
}
public void setAname(String aname) {
	Aname = aname;
}
@Override
public String toString() {
	return "Admin [Apassword=" + Apassword + ", Aloginid=" + Aloginid + ", Aname=" + Aname + "]";
}
public Admin(String apassword, String aloginid, String aname) {
	super();
	Apassword = apassword;
	Aloginid = aloginid;
	Aname = aname;
}
public Admin() {
	super();
}


}
	


