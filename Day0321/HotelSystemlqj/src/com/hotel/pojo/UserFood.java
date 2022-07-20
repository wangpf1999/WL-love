package com.hotel.pojo;

public class UserFood {
	private String id1;
	private String foodName1;
	private String foodid1;
	private String 	price1;
	public String getId1() {
		return id1;
	}
	public void setId1(String id1) {
		this.id1 = id1;
	}
	public String getFoodName1() {
		return foodName1;
	}
	public void setFoodName1(String foodName1) {
		this.foodName1 = foodName1;
	}
	public String getFoodid1() {
		return foodid1;
	}
	public void setFoodid1(String foodid1) {
		foodid1 = foodid1;
	}
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price1) {
		this.price1 = price1;
	}
	
	public UserFood() {
		
	}
	
	
	public UserFood(String id1, String foodName1, String foodid1, String price1) {
		super();
		
		this.id1 = id1;
		this.foodName1 = foodName1;
		this.foodid1 = foodid1;
		this.price1 = price1;
	}
	@Override
	public String toString() {
		return "User [id1=" + id1 + ", foodName1=" + foodName1 + ", Foodid1=" + foodid1 + ", price1=" + price1 + "]";
	}
	
	
	
}
