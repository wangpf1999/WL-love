package com.hotel.serviceImpl;

import com.hotel.pojo.RoomBook;
import com.hotel.service.RoomBookService;

public class RoomBookServiceImpl implements RoomBookService {
	private com.hotel.dao.RoomBookDao roomBookDao = new com.hotel.daoImpl.RoomBookDaoImpl();

	@Override
	public int insert(RoomBook roomBook) {
		return roomBookDao.insert(roomBook);
	}

	@Override
	public Object[][] listRoom() {
		return roomBookDao.list();
	}

}
