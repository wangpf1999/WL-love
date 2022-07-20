package com.hotel.pojo;

public class Menber {
   private String account;
   private String password;
   private int money;
   
   public Menber() {
	   
   }

public String getAccount() {
	return account;
}

public void setAccount(String account) {
	this.account = account;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getMoney() {
	return money;
}

public void setMoney(int money) {
	this.money = money;
}

@Override
public String toString() {
	return "Menber [account=" + account + ", password=" + password + ", money=" + money + "]";
}

public Menber(String account, String password, int money) {
	super();
	this.account = account;
	this.password = password;
	this.money = money;
}
   
}
