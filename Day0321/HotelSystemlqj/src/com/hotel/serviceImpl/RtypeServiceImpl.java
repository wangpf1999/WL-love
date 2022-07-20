package com.hotel.serviceImpl;

import java.util.Map;

import com.hotel.service.RtypeService;

public class RtypeServiceImpl implements RtypeService {
	private com.hotel.dao.RtypeDao rtypeDao = new com.hotel.daoImpl.RtypeDaoImpl();
	@Override
	public Map<String, String> listRtype() {
		return rtypeDao.list();
	}

}
