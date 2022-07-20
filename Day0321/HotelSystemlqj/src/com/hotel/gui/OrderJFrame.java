package com.hotel.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;
import com.hotel.pojo.Userkf;
import com.hotel.service.ServiceRecordUser;
import com.hotel.serviceImpl.ServiceRecordUserImpl;

public class OrderJFrame extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JTextField textField_4;
	private ReferenceJFrame01 jf01;
	private DatePicker datePicker ;
	private JTextField textField_5;
	private Object lblNewLabel_3;
	private JComboBox comboBox_1;
	private com.hotel.service.MajorService majorService=new com.hotel.serviceImpl.MajorServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderJFrame frame = new OrderJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void initDatePicket(java.util.Date defaultDate) {//defaultDate传一个日期的默认值
		String format="yyyy-MM-dd";
		Font font=new Font("宋体",Font.PLAIN,14);
		Dimension dimension =new Dimension(182,24);
		
		datePicker = new DatePicker(defaultDate,format,font,dimension);
		datePicker.setBounds(126, 323, 164, 24);
		contentPane.add(datePicker);
		
		JLabel lblNewLabel = new JLabel("\u91D1\u989D");
		lblNewLabel.setBounds(44, 401, 72, 18);
		contentPane.add(lblNewLabel);
		
		textField_5 = new JTextField();
		textField_5.setBounds(126, 395, 86, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(126, 281, 164, 24);
		contentPane.add(comboBox_1);
		

	}

	/**
	 * Create the frame.
	 */
	public OrderJFrame() {
		setTitle("\u6B63\u5728\u4E0B\u5355....");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8FDB\u884C\u5B9E\u540D\u8BA4\u8BC1\uFF01");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(14, 35, 211, 38);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u59D3  \u540D\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(44, 86, 88, 32);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(126, 92, 164, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(33, 131, 98, 32);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 137, 164, 24);
		contentPane.add(textField_1);
		
		JLabel label_3 = new JLabel("\u8EAB\u4EFD\u8BC1\u7C7B\u578B\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(14, 176, 118, 38);
		contentPane.add(label_3);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5C45\u6C11\u8EAB\u4EFD\u8BC1  ", "\u4E34\u65F6\u8EAB\u4EFD\u8BC1", "\u6E2F\u6FB3\u5C45\u6C11\u8EAB\u4EFD\u8BC1", "\u58EB\u5175\u8BC1"}));
		comboBox.setBounds(126, 183, 164, 24);
		contentPane.add(comboBox);
		
		JLabel label_4 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\u7801\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		label_4.setBounds(14, 227, 108, 32);
		contentPane.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 227, 164, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_5 = new JLabel("\u4F4F\u623F\u7F16\u53F7\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 18));
		label_5.setBounds(33, 272, 99, 38);
		contentPane.add(label_5);
		
		JButton button = new JButton("\u7ACB\u5373\u4ED8\u6B3E");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				 
				String date= datePicker.getText();
				SimpleDateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date utilDate =null;
				try{
						utilDate = fmt.parse(date);
				}catch(Exception e1){
						e1.printStackTrace();
				}
				java.sql.Date ubirthday=new Date(utilDate.getTime());
				//点击立即付款的时候，连接数据库
				String rname=textField.getText();
				String  rphonenumber=textField_1.getText();
				String  ridentify=textField_2.getText();
			//	String  rdept=textField_3.getText();//那我要怎么获取这个呢？
				String  type=comboBox_1.getToolTipText();
			    String rdate=datePicker.getText();
			
			    
				//System.out.println(rdate);s
				 Userkf user=new Userkf();
				 user.setRname(rname);//姓名
				 user.setRphonenumber(rphonenumber);//电话号码
				 user.setIdentify(ridentify);//身份证
				 user.setRdept(type);//房间种类
				 user.setRdate(ubirthday);	 //入住日期
				 
				 ServiceRecordUser  ls=new ServiceRecordUserImpl();
				 
				 if((user.getRname().equals(null))||(user.getRphonenumber().equals(null))||(user.getIdentify().equals(null))) {
					 JOptionPane.showMessageDialog(null, "输入信息不能为空");
					OrderJFrame.this.setVisible(true);
                  }else { 
                	  //判断该用户余额够不够
     				  ls.pay(rname);
                	  String  name=textField.getText();
                	  //把账号传进去
                	 int b=ls.pay(name);//这个方法返回的是一个Menber account对象，里面只有金额
                	 int c= Integer.parseInt(textField_5.getText());
                	 int a=b-c;
                	 if(a>=0) {
                		 OrderJFrame.this.setVisible(false);
                		 //修改余额
                		 ls.updatamoney(name, a);
                		 //添加用户入住信息到表中
                		ls.add(user);
        				 JOptionPane.showMessageDialog(null, "支付成功");
                	 }else {
                		 JOptionPane.showMessageDialog(null, "余额不够"); 
                		 OrderJFrame.this.setVisible(true);
                	 }   		
                  }
			}
		});
		button.setBounds(192, 432, 113, 38);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88\u8BA2\u5355");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderJFrame.this.setVisible(false);
				ReferenceJFrame01 jf01=new ReferenceJFrame01();
				jf01.setVisible(true);
			}
		});
		button_1.setBounds(14, 432, 113, 38);
		contentPane.add(button_1);
		
		JLabel label_6 = new JLabel("\u5165\u4F4F\u65F6\u95F4\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 18));
		label_6.setBounds(14, 344, 118, 32);
		contentPane.add(label_6);
		this.initDatePicket(new java.util.Date());
	}


	public void setlblNewLabel_3(String money) {
		this.textField_5.setText(money);
	}
	public void setcomboBox_1(String type) {
//		Map<String,String> map=majorService.listMajors(type);
//		map.remove("是");
		System.out.print(majorService.listMajors(type).size());
		Collection<String> majors= majorService.listMajors(type).values();
		String[] majorArray=new String[majors.size()];
		majors.toArray(majorArray);//将集合转为数组
		this.comboBox_1.setModel(new DefaultComboBoxModel(majorArray));
	}
	
}
