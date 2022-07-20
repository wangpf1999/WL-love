package com.hotel.serviceImpl;

import java.util.Map;

import com.hotel.service.MajorService;



public class MajorServiceImpl implements MajorService {
	private com.hotel.dao.MajorDao majorDao =new com.hotel.daoImpl.MajorDaoImpl();
	@Override
	public Map<String, String> listMajors(String x) {
 
		return majorDao.list(x);
	}

}
