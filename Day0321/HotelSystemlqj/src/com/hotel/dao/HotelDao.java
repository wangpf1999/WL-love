package com.hotel.dao;


import com.hotel.pojo.Admin;
import com.hotel.pojo.CustomerClean;
import com.hotel.pojo.Food;
import com.hotel.pojo.SmartHome;
import com.hotel.pojo.TextFeedback;
import com.hotel.pojo.User;



public interface HotelDao {
	//����Ա��¼
	Admin Loginche(String loginid);
	
	//��ȡ�ͷ���Ϣ
	public Object[][] UserList();
	
	//�˷�
	public int delect(String uname);
	
	//����
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
