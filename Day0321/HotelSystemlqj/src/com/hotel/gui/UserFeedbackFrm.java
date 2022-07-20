package com.hotel.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.hotel.pojo.TextFeedback;
import com.hotel.serviceImpl.HotelServicelmpl;

public class UserFeedbackFrm extends JInternalFrame {
	com.hotel.service.HotelService hotelService = new com.hotel.serviceImpl.HotelServicelmpl();
	private JTextField textRoomId;
	private JTextField textNote;
	private TextFeedback textFeedback;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFeedbackFrm frame = new UserFeedbackFrm();
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
	public UserFeedbackFrm() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setClosable(true);
		setTitle("用户反馈");
		setBounds(100, 100, 361, 421);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("房间号");
		lblNewLabel.setBounds(74, 91, 72, 18);
		getContentPane().add(lblNewLabel);
		
		textRoomId = new JTextField();
		textRoomId.setBounds(160, 88, 86, 24);
		getContentPane().add(textRoomId);
		textRoomId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("反馈内容");
		lblNewLabel_1.setBounds(74, 136, 72, 18);
		getContentPane().add(lblNewLabel_1);
		
		textNote = new JTextField();
		textNote.setBounds(74, 175, 245, 24);
		getContentPane().add(textNote);
		textNote.setColumns(10);
		
		JButton btnSure = new JButton("确定");
		btnSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确定
				String roomId = textRoomId.getText();
				String note = textNote.getText();
				java.sql.Date feedbackTime = new java.sql.Date((new java.util.Date()).getTime());
				textFeedback = new TextFeedback(roomId, feedbackTime, note);
				hotelService.insertFeedback(textFeedback);
				hotelService.sendEmail(roomId, note);
				UserFeedbackFrm.this.dispose();//关闭窗口
			}
		});
		btnSure.setBounds(254, 265, 65, 27);
		getContentPane().add(btnSure);
		
		JButton btnConcel = new JButton("取消");
		btnConcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//取消
				UserFeedbackFrm.this.dispose();//关闭窗口
			}
		});
		btnConcel.setBounds(173, 265, 65, 27);
		getContentPane().add(btnConcel);

	}
}
