package com.hotel.gui;


//客户端
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class clientFrm extends JFrame implements ActionListener, Runnable{
	private JTextField msgTest;
	JTextArea showArea;
	JTextField msgText;
	JFrame mainJframe2;
	JButton sentBtn;
	JScrollPane JSPane;
	JPanel pane;
	Container con;
	Thread thread = null;
	Socket connectToServer;
	DataInputStream inFromServer;
	DataOutputStream outToServer;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientFrm frame2 = new clientFrm();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public clientFrm() {
		setTitle("客户端");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 580);
		getContentPane().setLayout(null);
		
		JScrollPane Jspane = new JScrollPane((Component) null);
		Jspane.setBounds(0, 0, 482, 424);
		getContentPane().add(Jspane);
		
		JTextArea showArea = new JTextArea();
		showArea.setLineWrap(true);
		showArea.setEditable(false);
		Jspane.setViewportView(showArea);
		
		msgTest = new JTextField();
		msgTest.setColumns(30);
		msgTest.setBounds(14, 473, 246, 24);
		getContentPane().add(msgTest);
		
		JButton sentBtn = new JButton("发送");
		sentBtn.setBounds(315, 472, 108, 27);
		getContentPane().add(sentBtn);
		
		
		
	}


	@Override
	public void run() {
		try {
			while (true) {
				showArea.append("服务端说：" + inFromServer.readUTF() + "\n");
				Thread.sleep(1000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String s = msgText.getText();
		if (s.length() > 0) {
			try {
				outToServer.writeUTF(s);
				outToServer.flush();
				showArea.append("我（客户端）说： " + msgText.getText() + "\n");
			} catch (IOException e1) {
				showArea.append("你的消息：“" + msgText.getText() + "”未能发送出去！\n");
			}
		}
		
	}
}
