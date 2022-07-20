package com.hotel.pojo;

import java.sql.Date;

public class CustomerClean {
private Date CleanTime;
private String Note;
private String RoomId;
public Date getCleanTime() {
	return CleanTime;
}
public void setCleanTime(Date cleanTime) {
	CleanTime = cleanTime;
}
public String getNote() {
	return Note;
}
public void setNote(String note) {
	Note = note;
}
public String getRoomId() {
	return RoomId;
}
public void setRoomId(String roomId) {
	RoomId = roomId;
}
public CustomerClean(Date cleanTime, String note, String roomId) {
	super();
	CleanTime = cleanTime;
	Note = note;
	RoomId = roomId;
}
public CustomerClean() {
	super();
}
@Override
public String toString() {
	return "CustomerClean [CleanTime=" + CleanTime + ", Note=" + Note + ", RoomId=" + RoomId + "]";
}


}
