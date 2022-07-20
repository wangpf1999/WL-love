package com.hotel.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.eltima.components.ui.DatePicker;
import com.hotel.pojo.CustomerClean;
import com.hotel.serviceImpl.HotelServicelmpl;

public class cleanFrm extends JInternalFrame {
	com.hotel.service.HotelService hotelService = new com.hotel.serviceImpl.HotelServicelmpl();
	private JTextField txtNote;
	private DatePicker datePicker;
	private final JPanel contentPanel = new JPanel();
	private CustomerClean customerClean = new CustomerClean();
	private JTextField txtRoom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cleanFrm frame = new cleanFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void initDatePacker(java.util.Date defaultDate) {
		String format = "yyyy-MM-dd HH:mm:ss";
		Font font = new Font("楷体",Font.PLAIN,14);
		Dimension dimension = new Dimension(185, 24);
		//textCleanTime.setBounds(123, 78, 185, 24);
		datePicker = new DatePicker(defaultDate, format, font, dimension);
		datePicker.setBounds(123, 78, 185, 24);
		getContentPane().add(datePicker);
		
		JLabel lblNewLabel_2 = new JLabel("房间号");
		lblNewLabel_2.setBounds(59, 194, 72, 18);
		getContentPane().add(lblNewLabel_2);
		
		txtRoom = new JTextField();
		txtRoom.setBounds(123, 191, 185, 24);
		getContentPane().add(txtRoom);
		txtRoom.setColumns(10);
	}
	/**
	 * Create the frame.
	 */
	//textCleanTime.setBounds(123, 78, 185, 24);
	public cleanFrm() {
		setClosable(true);
		setFrameIcon(new ImageIcon("G:\\workspace\\HotelSystem\\打扫.png"));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setTitle("设定清洁时间");
		setBounds(100, 100, 414, 438);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("清洁时间");
		lblNewLabel.setBounds(59, 81, 72, 18);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("备注内容");
		lblNewLabel_1.setBounds(59, 149, 72, 18);
		getContentPane().add(lblNewLabel_1);
		
		txtNote = new JTextField();
		txtNote.setBounds(123, 146, 185, 24);
		getContentPane().add(txtNote);
		txtNote.setColumns(10);
		
		JButton btnSave = new JButton("确定");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确定
				String note = txtNote.getText();
				String dateString = datePicker.getText();
				String roomId = txtRoom.getText();
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date utilDate = null;
				try {
					utilDate = fmt.parse(dateString);
				}catch(ParseException e1) {e1.printStackTrace();}
				java.sql.Date cleanTime = new java.sql.Date(utilDate.getTime());
				customerClean.setNote(note);
				customerClean.setCleanTime(cleanTime);
				customerClean.setRoomId(roomId);
				hotelService.insert(customerClean);
				cleanFrm.this.dispose();
			}
		});
		btnSave.setBounds(242, 272, 66, 27);
		getContentPane().add(btnSave);
		
		JButton btnConcel = new JButton("取消");
		btnConcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanFrm.this.dispose();
			}
		});
		btnConcel.setBounds(144, 272, 66, 27);
		getContentPane().add(btnConcel);
		
		
		this.initDatePacker(new java.util.Date());
	}

}