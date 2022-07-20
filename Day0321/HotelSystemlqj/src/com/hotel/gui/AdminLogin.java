package com.hotel.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import com.hotel.pojo.Admin;



import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class AdminLogin extends JDialog {
	private JTextField textField;
	private JPasswordField passwordField;
	private JRadioButton remPassword;

	/**
	 * Launch the application.
	 */
	static LoginFrm frame = new LoginFrm();
	public static void main(String[] args) {
		try {
			frame.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminLogin() {
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setBounds(100, 100, 399, 341);
		getContentPane().setLayout(null);
		
		JLabel Alonginid = new JLabel("\u8D26\u53F7\uFF1A");
		Alonginid.setBounds(55, 49, 72, 18);
		getContentPane().add(Alonginid);
		
		JLabel Apassword = new JLabel("\u5BC6\u7801\uFF1A");
		Apassword.setBounds(55, 118, 72, 18);
		getContentPane().add(Apassword);
		
		textField = new JTextField();
		textField.setBounds(116, 46, 173, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 115, 173, 24);
		getContentPane().add(passwordField);
		
		JButton btnLog = new JButton("\u767B\u5F55");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text =textField.getText();
				String password=new String(passwordField.getPassword());
				com.hotel.service.HotelService hotelService=new com.hotel.serviceImpl.HotelServicelmpl();
				Admin currentUser =hotelService.login(text, password);
				if(currentUser!=null) {
					if(remPassword.isSelected()) {
						try{	
							ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("password.data"));
							out.writeObject(currentUser);
							out.close();
						} catch (Exception e1) {e1.printStackTrace();}
					}else {
						File file=new File("password.data");
						if(file.exists()) {
							file.delete();
							}
						}
					
					}
					com.hotel.gui.AdminMainFrm mainFrm=new com.hotel.gui.AdminMainFrm(currentUser);
					mainFrm.setVisible(true);
					AdminLogin.this.dispose();
			}
		});
		btnLog.setBounds(240, 184, 92, 40);
		getContentPane().add(btnLog);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setBounds(123, 184, 92, 40);
		getContentPane().add(btnCancel);
		
		remPassword = new JRadioButton("\u8BB0\u4F4F\u5BC6\u7801");
		remPassword.setBounds(10, 191, 104, 27);
		getContentPane().add(remPassword);
		File file=new File("password.data");
		if(file.exists()) {
			//´æÔÚ
			try{
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
				Admin admin=(Admin) ois.readObject();
				textField.setText(admin.getAloginid());
				passwordField.setText(admin.getApassword());
				remPassword.setSelected(true);
				ois.close();
			} catch (Exception e1) {e1.printStackTrace();} 
		}
	}

	
		
	//public AdminLogin() {
}
