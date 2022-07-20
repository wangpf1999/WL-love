package com.hotel.gui;

//�ͷ���
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
		setTitle("�ͷ���");
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
		
		JButton sentBtn = new JButton("����");
		sentBtn.setBounds(337, 361, 106, 34);
		contentPane.add(sentBtn);
		
		try {
            //���������׽���
            serverSocket = new ServerSocket(5500);
            showArea.append("���ڵȴ��Ի�����...\n");//�����ͻ��˵�����
            connectToClient = serverSocket.accept();
            inFromClient = new DataInputStream(connectToClient.getInputStream());
            outToClient = new DataOutputStream(connectToClient.getOutputStream());
            //�����߳��ں�̨�����նԷ�����Ϣ
            thread = new Thread(this);
            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
        } catch (IOException e) {
            showArea.append("�Բ��𣬲��ܴ���������\n");
            msgText.setEditable(false);
            sentBtn.setEnabled(false);
        }
	}

	@Override
	// ���̸߳��𽫿ͻ�����������Ϣ��ʾ�ڶԻ�����
	public void run() {
		try {
			while (true) {
				showArea.append("�ͻ���˵��" + inFromClient.readUTF() + "\n");
				Thread.sleep(1000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	// ��Ӧ��ť�¼���������Ϣ���Է�
	public void actionPerformed(ActionEvent e) {
		String s = msgText.getText();
		if (s.length() > 0) {
			try {
				outToClient.writeUTF(s);
				outToClient.flush();
				showArea.append("�ң�����ˣ�˵��" + msgText.getText() + "\n");
				msgText.setText(null);
			} catch (IOException el) {
				showArea.append("�����Ϣ����" + msgText.getText() + "��δ�ܷ���ȥ!\n");
			}
		}
	
	}

}
