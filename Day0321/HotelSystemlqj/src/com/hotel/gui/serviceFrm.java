package com.hotel.gui;

//客服端
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

public class serviceFrm extends JFrame implements ActionListener, Runnable{

	private JPanel contentPane;
	private JTextField msgText;
	JTextArea showArea;
	JFrame mainJframe1;
	JButton sentBtn;
	JScrollPane JSPane;
	JPanel pane;
	Container con;
	Thread thread = null;
	ServerSocket serverSocket;
	Socket connectToClient;
	DataInputStream inFromClient;
	DataOutputStream outToClient;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					serviceFrm frame1 = new serviceFrm();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public serviceFrm() {
		setTitle("客服端");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane JSpane = new JScrollPane((Component) null);
		JSpane.setBounds(0, 0, 482, 316);
		contentPane.add(JSpane);
		
		JTextArea showArea = new JTextArea();
		showArea.setLineWrap(true);
		showArea.setEditable(false);
		JSpane.setViewportView(showArea);
		
		msgText = new JTextField();
		msgText.setColumns(30);
		msgText.setBounds(14, 361, 260, 41);
		contentPane.add(msgText);
		
		JButton sentBtn = new JButton("发送");
		sentBtn.setBounds(337, 361, 106, 34);
		contentPane.add(sentBtn);
		
		try {
            //创建服务套接字
            serverSocket = new ServerSocket(5500);
            showArea.append("正在等待对话请求...\n");//侦听客户端的连接
            connectToClient = serverSocket.accept();
            inFromClient = new DataInputStream(connectToClient.getInputStream());
            outToClient = new DataOutputStream(connectToClient.getOutputStream());
            //启动线程在后台来接收对方的消息
            thread = new Thread(this);
            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
        } catch (IOException e) {
            showArea.append("对不起，不能创建服务器\n");
            msgText.setEditable(false);
            sentBtn.setEnabled(false);
        }
	}

	@Override
	// 本线程负责将客户机传来的信息显示在对话区域
	public void run() {
		try {
			while (true) {
				showArea.append("客户端说：" + inFromClient.readUTF() + "\n");
				Thread.sleep(1000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	// 响应按钮事件，发送消息给对方
	public void actionPerformed(ActionEvent e) {
		String s = msgText.getText();
		if (s.length() > 0) {
			try {
				outToClient.writeUTF(s);
				outToClient.flush();
				showArea.append("我（服务端）说：" + msgText.getText() + "\n");
				msgText.setText(null);
			} catch (IOException el) {
				showArea.append("你的消息：“" + msgText.getText() + "”未能发出去!\n");
			}
		}
	
	}

}
