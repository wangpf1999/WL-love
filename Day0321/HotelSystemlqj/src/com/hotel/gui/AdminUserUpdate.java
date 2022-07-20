package com.hotel.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;
import com.hotel.pojo.User;



public class AdminUserUpdate extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtuname;
	private JTextField txtunum;
	private JTextField txtuindate;
	private JTextField txtuoutdate;
	private User user;
	private DatePicker datePicker;
	private com.hotel.service.HotelService hotelService=new com.hotel.serviceImpl.HotelServicelmpl();
	private JTextField txtphone;
	private JTextField txtidentity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdminUserUpdate dialog = new AdminUserUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initDatePicket(java.util.Date defaultDate) {//defaultDate传一个日期的默认值
		String format="yyyy-MM-dd-hh:mm:ss";
		Font font=new Font("宋体",Font.PLAIN,14);
		Dimension dimension =new Dimension(182,24);
		
		datePicker = new DatePicker(defaultDate,format,font,dimension);
		datePicker.setBounds(117, 115, 189, 24);
		contentPanel.add(datePicker);
		
	}
	private void initDatePicket1(java.util.Date defaultDate) {//defaultDate传一个日期的默认值
		String format="yyyy-MM-dd-hh:mm:ss";
		Font font=new Font("宋体",Font.PLAIN,14);
		Dimension dimension =new Dimension(182,24);
		
		datePicker = new DatePicker(defaultDate,format,font,dimension);
		datePicker.setBounds(117, 165, 189, 24);
		contentPanel.add(datePicker);
		
	}
	
	public AdminUserUpdate() {
		setModal(true);
		setBounds(100, 100, 450, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("    \u59D3\u540D\uFF1A");
		label.setBounds(32, 25, 94, 18);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("  \u623F\u95F4\u53F7\uFF1A");
		label_1.setBounds(32, 73, 94, 18);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\u5165\u4F4F\u65F6\u95F4\uFF1A");
		label_2.setBounds(32, 118, 94, 18);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("\u51FA\u4F4F\u65F6\u95F4\uFF1A");
		label_3.setBounds(32, 168, 94, 18);
		contentPanel.add(label_3);
		
		txtuname = new JTextField();
		txtuname.setEditable(false);
		txtuname.setColumns(10);
		txtuname.setBounds(117, 22, 189, 24);
		contentPanel.add(txtuname);
		
		txtunum = new JTextField();
		txtunum.setColumns(10);
		txtunum.setBounds(117, 70, 189, 24);
		contentPanel.add(txtunum);
		
		JLabel label_4 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		label_4.setBounds(32, 206, 94, 18);
		contentPanel.add(label_4);
		
		JLabel label_5 = new JLabel("  \u8EAB\u4EFD\u8BC1\uFF1A");
		label_5.setBounds(32, 258, 83, 18);
		contentPanel.add(label_5);
		
		txtphone = new JTextField();
		txtphone.setEditable(false);
		txtphone.setColumns(10);
		txtphone.setBounds(117, 203, 189, 24);
		contentPanel.add(txtphone);
		
		txtidentity = new JTextField();
		txtidentity.setEditable(false);
		txtidentity.setColumns(10);
		txtidentity.setBounds(117, 255, 189, 24);
		contentPanel.add(txtidentity);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u4FEE\u6539");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String uname=txtuname.getText();
						
						String unum=txtunum.getText();
						
						String uphone=txtphone.getText();
						
						String uidentity=txtidentity.getText();
						
						String dateString = datePicker.getText();
						SimpleDateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date utilDate =null;
						try{
								utilDate = fmt.parse(dateString);
						}catch(ParseException e1){
								e1.printStackTrace();
						}
						java.sql.Date uindate=new Date(utilDate.getTime());
						
						
						String dateString1 = datePicker.getText();
						SimpleDateFormat fmt1 =new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date utilDate1 =null;
						try{
								utilDate = fmt.parse(dateString);
						}catch(ParseException e1){
								e1.printStackTrace();
						}
						java.sql.Date uoutdate=new Date(utilDate.getTime());
						
						
						User user=new User(uname, unum,uphone,uidentity, uindate, uoutdate);
						
						hotelService.updateUser(user);
						//关闭当前窗体
						AdminUserUpdate.this.dispose();
					}
				});
				okButton.setActionCommand("修改");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public AdminUserUpdate(User user) {
		this();
		
		this.user=user;
		
		txtuname.setText(user.getUname());
		txtunum.setText(user.getUnum());
		txtphone.setText(user.getUphone());
		txtidentity.setText(user.getUidentity());
		this.initDatePicket(user.getUindate());
		this.initDatePicket1(user.getUoutdate());
	}
}
