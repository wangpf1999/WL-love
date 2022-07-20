package com.hotel.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hotel.pojo.Admin;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMainFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static AdminMainFrm frame = new AdminMainFrm();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminMainFrm() {
		setTitle("\u7BA1\u7406\u5458\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u5BA2\u623F\u5165\u4F4F\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminInfor infor=new AdminInfor();
				infor.setVisible(true);
				AdminMainFrm.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(342, 38, 123, 38);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrm loginFrm=new LoginFrm();
				loginFrm.setVisible(true);
				AdminMainFrm.this.setVisible(false);
			}
		});
		button.setBounds(243, 377, 113, 38);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\wwwww\\Desktop\\\u56FE\u7247\\tup1.jpg"));
		lblNewLabel.setBounds(0, 0, 629, 450);
		contentPane.add(lblNewLabel);
	}
	public AdminMainFrm(Admin admin) {
		this();
		this.setTitle("欢迎"+admin.getAname()+",进入内部系统");
	}
}
