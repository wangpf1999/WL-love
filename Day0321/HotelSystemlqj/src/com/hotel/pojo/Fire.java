package com.hotel.pojo;

import java.util.HashMap;
import java.util.Map;

public  class Fire {
	
	public static  String  id1;
	public static  String  foodName1;
	public static  String  foodid1;
	public static  String  price1;
	
	public static  Object[][]  menu;         
	public static  Map<String,Integer> nums1 = new HashMap<>();
	public static  Map<String,Integer> nums2 = new HashMap<>();
	public static  Map<String,Integer> nums3 = new HashMap<>();
	public static  Map<String,Integer> nums4 = new HashMap<>();
	
	
	public static Map food1() {
		nums1.put(id1, null);	
		return nums1;
	}

	public static Map food2() {
		nums2.put(foodName1, null);
		return nums2;
	}

	public static Map food3() {
		nums3.put(foodid1,null);
		return nums3;
	}

	public static Map food4() {
		nums4.put(price1, null);
		return nums4;
	}

	
}
