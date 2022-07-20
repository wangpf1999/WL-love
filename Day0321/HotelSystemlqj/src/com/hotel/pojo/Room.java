package com.hotel.pojo;

import java.io.Serializable;


public class Room implements Serializable{
	private String roomnum;
	private String roomtype;
	private Integer roomprice;
	private String roomisempty;
	private String roomiscleaded;
	private String roomuser;
	private String roomusertel;
	private String time;
	public String getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public Integer getRoomprice() {
		return roomprice;
	}
	public void setRoomprice(Integer roomprice) {
		this.roomprice = roomprice;
	}
	public String getRoomisempty() {
		return roomisempty;
	}
	public void setRoomisempty(String roomisempty) {
		this.roomisempty = roomisempty;
	}
	public String getRoomiscleaded() {
		return roomiscleaded;
	}
	public void setRoomiscleaded(String roomiscleaded) {
		this.roomiscleaded = roomiscleaded;
	}
	public String getRoomuser() {
		return roomuser;
	}
	public void setRoomuser(String roomuser) {
		this.roomuser = roomuser;
	}
	public String getRoomusertel() {
		return roomusertel;
	}
	public void setRoomusertel(String roomusertel) {
		this.roomusertel = roomusertel;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Room() {
		super();
	}
	public Room(String roomnum, String roomtype, Integer roomprice, String roomisempty, String roomiscleaded,
			String roomuser, String roomusertel, String time) {
		super();
		this.roomnum = roomnum;
		this.roomtype = roomtype;
		this.roomprice = roomprice;
		this.roomisempty = roomisempty;
		this.roomiscleaded = roomiscleaded;
		this.roomuser = roomuser;
		this.roomusertel = roomusertel;
		this.time = time;
	}
	@Override
	public String toString() {
		return "Room [roomnum=" + roomnum + ", roomtype=" + roomtype + ", roomprice=" + roomprice + ", roomisempty="
				+ roomisempty + ", roomiscleaded=" + roomiscleaded + ", roomuser=" + roomuser + ", roomusertel="
				+ roomusertel + ", time=" + time + "]";
	}
	
	
	}


