package com.hotel.pojo;

import java.sql.Date;

public class TextFeedback {
	private String roomId;
	private java.sql.Date time;
	private String note;
	public TextFeedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TextFeedback(String roomId, Date time, String note) {
		super();
		this.roomId = roomId;
		this.time = time;
		this.note = note;
	}
	/**
	 * @return the roomId
	 */
	public String getRoomId() {
		return roomId;
	}
	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	/**
	 * @return the time
	 */
	public java.sql.Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(java.sql.Date time) {
		this.time = time;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "TextFeedback [roomId=" + roomId + ", time=" + time + ", note=" + note + "]";
	}
	
}
