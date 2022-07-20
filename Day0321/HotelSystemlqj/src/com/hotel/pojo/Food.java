package com.hotel.pojo;
//菜品种表

import java.io.Serializable;
import java.sql.Date;
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;
	//菜名
	private String foodName;
	//菜系
	private String Foodid;
	//价格
	private String price;
	//编号
	private String id;
    
	public Food() {
		
	}

	public Food(String id,String foodname, String foodid, String price) {
		super();
		this.id = id;
		this.foodName = foodname;
		this.Foodid = foodid;
		this.price = price;
		
	}

	public String getFoodname() {
		return foodName;
	}

	public void setFoodname(String foodname) {
		this.foodName = foodname;
	}

	public String getFoodid() {
		return Foodid;
	}

	public void setFoodid(String foodid) {
		this.Foodid = foodid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Food [foodname=" + foodName + ", foodid=" + Foodid + ", price=" + price + ", vipprice=" + id
				+ "]";
	}	
}
