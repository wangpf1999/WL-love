package Test;

public class Test {
	public static void main(String[] args) {
		com.hotel.service.HotelService hotelService=new com.hotel.serviceImpl.HotelServicelmpl();
		Object[][] food=hotelService.list();
		System.out.println(food[0][0]);
	}
}
