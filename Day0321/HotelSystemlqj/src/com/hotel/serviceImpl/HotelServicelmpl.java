package com.hotel.serviceImpl;


import com.hotel.pojo.Admin;
import com.hotel.pojo.CustomerClean;
import com.hotel.pojo.Food;
import com.hotel.pojo.SmartHome;
import com.hotel.pojo.TextFeedback;
import com.hotel.pojo.User;
import com.hotel.service.HotelService;



public class HotelServicelmpl implements HotelService{
	private com.hotel.dao.HotelDao hotelDao =new com.hotel.daoImpl.HotelDaolmpl();
	@Override
	public Admin login(String aloginid, String apassword) {
		Admin currentUser = hotelDao.Loginche(aloginid);
		if(currentUser!=null) {
			//验证密码；
			if(currentUser.getApassword().equals(apassword)) {
				return currentUser;
			}
		}
		return null;
	}
	public Object[][] listUsers() {

		return hotelDao.UserList();
	}
	@Override
	public int delectAdmin(String uname) {
		
		return hotelDao.delect(uname);
	}
	@Override
	public User get(String uname) {
		
		return hotelDao.getUserByuname(uname);
	}
	@Override
	public int updateUser(User user) {
		
		return hotelDao.update(user);
	}
	
	
	
	
	
	@Override
	public int insert(CustomerClean customerClean) {
		return hotelDao.insert(customerClean);
	}
	@Override
	public int updateHome(SmartHome smartHome) {
		return hotelDao.updateHome(smartHome);
	}
	@Override
	public SmartHome searchRoomId(String roomId) {
		return hotelDao.SearchByRoomId(roomId);
	}
	@Override
	public void sendEmail(String roomid, String msg) {
		hotelDao.SendEmail(roomid, msg);
	}
	@Override
	public int insertFeedback(TextFeedback textFeedback) {
		return hotelDao.insertFeedback(textFeedback);
	}

	@Override
	public Object[][] list() {

		return hotelDao.list();
	}
	@Override
	public Object[][] searchByKeyWord(String keyword, String propColumn) {
		return hotelDao.search(keyword, propColumn);
	}

	
	
	
	
	
	@Override
	public Object[][] listFoods() {
		return hotelDao.listFood();
	}

	//添加菜品
	@Override
	public int insertFood(Food food) {
		return hotelDao.insert(food);
	}

	//更新菜品数据
	@Override
	public int updateFood(Food food) {
		return hotelDao.update(food);
	}

	@Override
	public Food getFood(String ufood) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
