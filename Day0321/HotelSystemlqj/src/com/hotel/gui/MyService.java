package com.hotel.gui;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import com.google.gson.Gson;

public class MyService extends Thread{

 private static DatagramSocket socket;
 private static ArrayList<ClientActivity> mList=new ArrayList<>();

 public static int PORT=10004;
 public MyService() {
	 try {
		socket=new DatagramSocket(PORT);
	} catch (SocketException e) {
		e.printStackTrace();
	}
 }
 public static void loginGroups(ClientActivity clientActivity) {
	 if(clientActivity==null) 
		 return;
		 mList.add(clientActivity);
 } 

 
 public void receiveMessage() {
	 byte[]  buf=new byte[1024];
	 DatagramPacket datagramPacket=new  DatagramPacket(buf,buf.length);
	 while(true) {
		 try { 
			socket.receive(datagramPacket);
			String msg=new String(datagramPacket.getData(),0,datagramPacket.getLength());
			//需要下载gsonjar包，解析成gson数据
			Gson gson=new Gson();
			MessageBean bean=gson.fromJson(msg, MessageBean.class);
			for(ClientActivity clientActivity:mList) {
				//发送数据给每一个客户端
				clientActivity.pushMessage(bean);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
 }
 @Override
	public void run() {
	 while(true) {
		 receiveMessage();
	 }
	}
}
