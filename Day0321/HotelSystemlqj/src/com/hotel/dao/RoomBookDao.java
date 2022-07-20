package com.hotel.dao;

import com.hotel.pojo.RoomBook;

public interface RoomBookDao {
	public int insert(RoomBook roomBook);
	public Object[][] list();
	public int delete(String userid);
}
