package com.hotel.dao;


import com.hotel.pojo.Admin;
import com.hotel.pojo.CustomerClean;
import com.hotel.pojo.Food;
import com.hotel.pojo.SmartHome;
import com.hotel.pojo.TextFeedback;
import com.hotel.pojo.User;



public interface HotelDao {
	//管理员登录
	Admin Loginche(String loginid);
	
	//获取客房信息
	public Object[][] UserList();
	
	//退房
	public int delect(String uname);
	
	//换房
	public User getUserByuname(String uname);
	public int update(User user);
	
	
	public int insert(CustomerClean customerClean); 
	public int updateHome(SmartHome smartHome);
	public SmartHome SearchByRoomId(String roomId);
	public void SendEmail(String roomid,String msg);
	public int insertFeedback(TextFeedback textFeedback);
	
	
	
	public Object[][] list();
	public Object[][] search(String keyword,String propColumn);
	

	
	public Object[][] listFood();
	public int insert(Food food);
	public Object[][] search(String key);
	public int update(Food updateUser); 
}
