package com.hotel.serviceImpl;

import com.hotel.dao.RecordUser;
import com.hotel.daoImpl.RecordUserImpl;
import com.hotel.pojo.Userkf;
import com.hotel.service.ServiceRecordUser;

public class ServiceRecordUserImpl   implements ServiceRecordUser{
     RecordUser ru=new RecordUserImpl();
	@Override
	public Userkf add(Userkf user) {
		
		return ru.AddRecordUser(user);
	}
	@Override
	public int pay(String name) {
		return ru.pay(name);
	}

	@Override
	public void updatamoney(String name, int a) {
		
		ru.updata(name, a);
	}
}
