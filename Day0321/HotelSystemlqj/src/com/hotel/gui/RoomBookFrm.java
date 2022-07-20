package com.hotel.gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument.Content;

import com.eltima.components.ui.DatePicker;
import com.hotel.service.RtypeService;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;

public class RoomBookFrm extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtPrice;
	private JTextField txtUserName;
	private JTextField txtUserId;
	private JTextField txtUserTel;
	private JTextField txtLayer;
	private com.hotel.service.RtypeService rtypeService = new com.hotel.serviceImpl.RtypeServiceImpl();
	private com.hotel.service.RoomBookService roomBookService = new com.hotel.serviceImpl.RoomBookServiceImpl();
	private DatePicker datePicker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomBookFrm frame = new RoomBookFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void initDatePacket(java.util.Date defaultDate) {//defaultDate: 传一个日期默认值;
		String format="yyyy-MM-dd";
		Font font = new Font("宋体", Font.PLAIN, 14);
		Dimension dimension = new Dimension(209,21);
		datePicker = new DatePicker(defaultDate, format, font, dimension);
		datePicker.setBounds(278, 298, 139, 24);
		getContentPane().add(datePicker);
	}

	/**
	 * Create the frame.
	 */
	public RoomBookFrm() {
		setTitle("\u5BA2\u623F\u9884\u8BA2");
		setClosable(true);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 636, 473);
		getContentPane().setLayout(null);
		
		JComboBox cmbType = new JComboBox();
		Collection<String> rtype = rtypeService.listRtype().values();
		String[] rtypeArray = new String[rtype.size()];
		rtype.toArray(rtypeArray);//将集合转为数组;
		
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"\u8C6A\u534E\u53CC\u4EBA\u95F4", "\u8D85\u5927\u60C5\u4FA3\u95F4", "\u52A8\u7269\u4E3B\u9898\u95F4", "\u8C6A\u534E\u5355\u4EBA\u5927\u5E8A\u623F", "\u5962\u534E\u6C90\u6D74\u95F4", "\u6709\u70B9\u5E73\u51E1\u7684\u7535\u7ADE\u95F4"}));
		cmbType.setBounds(278, 204, 139, 24);
		getContentPane().add(cmbType);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel.setBounds(165, 51, 72, 18);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u623F\u578B\uFF1A");
		label.setBounds(165, 207, 72, 18);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u697C\u5C42\uFF1A");
		label_1.setBounds(165, 255, 72, 18);
		getContentPane().add(label_1);
		
		JButton btnOk = new JButton("\u786E\u8BA4");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBounds(483, 399, 113, 27);
		getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomBookFrm.this.dispose();//关闭窗口;
			}
		});
		btnCancel.setBounds(355, 399, 113, 27);
		getContentPane().add(btnCancel);
		
		JButton CancelBookBtn = new JButton("\u5BA2\u623F\u9000\u8BA2/\u4FEE\u6539");
		CancelBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//弹出对话框
				CancelBookDialog dialog = new CancelBookDialog();
				dialog.setVisible(true);
				dialog.setLocationRelativeTo(null);
			}
		});
		CancelBookBtn.setBounds(27, 399, 131, 27);
		getContentPane().add(CancelBookBtn);
		
		JLabel lblNewLabel_1 = new JLabel("\u4EF7\u683C\uFF1A");
		lblNewLabel_1.setBounds(165, 350, 72, 18);
		getContentPane().add(lblNewLabel_1);
		
		txtPrice = new JTextField();
		txtPrice.setEnabled(false);
		txtPrice.setBounds(278, 347, 139, 24);
		getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u65F6\u95F4\uFF1A");
		lblNewLabel_2.setBounds(165, 301, 72, 18);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("\u5BA2\u623F\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(483, 13, 113, 27);
		getContentPane().add(btnNewButton_1);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(278, 48, 139, 24);
		getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8EAB\u4EFD\u8BC1\uFF1A");
		lblNewLabel_3.setBounds(165, 102, 72, 18);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		lblNewLabel_4.setBounds(165, 153, 88, 18);
		getContentPane().add(lblNewLabel_4);
		
		txtUserId = new JTextField();
		txtUserId.setColumns(10);
		txtUserId.setBounds(278, 99, 139, 24);
		getContentPane().add(txtUserId);
		
		txtUserTel = new JTextField();
		txtUserTel.setColumns(10);
		txtUserTel.setBounds(278, 150, 139, 24);
		getContentPane().add(txtUserTel);
		
		txtLayer = new JTextField();
		txtLayer.setColumns(10);
		txtLayer.setBounds(278, 252, 139, 24);
		getContentPane().add(txtLayer);
		
		this.initDatePacket(new java.util.Date());

	}
}
