package com.hotel.service;

import com.hotel.pojo.Userkf;

public interface ServiceRecordUser {
       
	  Userkf add(Userkf user);
	  
	  public int pay(String name);
	  
		 void updatamoney(String name,int a);
}
