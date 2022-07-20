package com.hotel.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LoginFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setTitle("\u9152\u5E97\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u9152\u5E97\u5165\u4F4F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustMainFrm custMainFrm=new CustMainFrm();
				custMainFrm.setVisible(true);
				LoginFrm.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(399, 62, 113, 54);
		contentPane.add(btnNewButton);
		
		JButton btnAdmin = new JButton("\u7BA1\u7406\u5458\u767B\u5F55");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//弹出添加对话框
				AdminLogin dialog = new AdminLogin();
				dialog.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnAdmin.setBounds(399, 208, 113, 54);
		contentPane.add(btnAdmin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\wwwww\\Desktop\\\u56FE\u7247\\logo.png"));
		lblNewLabel.setBounds(0, 0, 601, 409);
		contentPane.add(lblNewLabel);
	}
}
