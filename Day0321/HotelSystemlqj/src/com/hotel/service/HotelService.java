package com.hotel.service;

import com.hotel.pojo.Admin;
import com.hotel.pojo.CustomerClean;
import com.hotel.pojo.Food;
import com.hotel.pojo.SmartHome;
import com.hotel.pojo.TextFeedback;
import com.hotel.pojo.User;



public interface HotelService {
	public Admin login(String uloginid,String upassword) ;
	
	public Object[][] listUsers();
	
	public int delectAdmin(String uname);
	
	public User get(String uname);
	
	public  int updateUser(User user);
	
	
	public int insert(CustomerClean customerClean);
	public int updateHome(SmartHome smartHome);
	public SmartHome searchRoomId(String roomId);
	public void sendEmail(String roomid,String msg);
	public int insertFeedback(TextFeedback textFeedback);
	
	
	public Object[][] list();
	public Object[][] searchByKeyWord(String keyword, String propColumn);
	
	
	public Object[][] listFoods();
	public Food getFood(String ufood);
	public int updateFood(Food food);
	public int insertFood(Food food);
}
