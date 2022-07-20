package com.hotel.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ReferenceJFrame05 extends JFrame {

	private JPanel contentPane;
	private JTextField roomnumber;
	private OrderJFrame ojf;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReferenceJFrame05 frame = new ReferenceJFrame05();
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
	public ReferenceJFrame05() {
		setResizable(false);
		setTitle("\u5BA2\u623F\u63A8\u8350");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\wwwww\\Desktop\\\u56FE\u7247\\p5.png"));
		lblNewLabel.setBounds(0, 65, 972, 505);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5962\u534E\u6C90\u6D74\u95F4\uFF1A");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		label.setBounds(14, 13, 206, 54);
		contentPane.add(label);
		
		JButton button = new JButton("\u4E0A\u4E00\u95F4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame05.this.setVisible(false);
				ReferenceJFrame04 jf=new ReferenceJFrame04();
				jf.setVisible(true);
				
			}
		});
		button.setBounds(506, 23, 113, 42);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u4E0B\u4E00\u95F4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame05.this.setVisible(false);
				ReferenceJFrame06 jf06=new ReferenceJFrame06();
				jf06.setVisible(true);				
			}
		});
		button_1.setBounds(621, 23, 113, 42);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame05.this.setVisible(false);
				CustMainFrm  cjf=new CustMainFrm();
				cjf.setVisible(true);
			}
		});
		button_2.setBounds(850, 23, 113, 42);
		contentPane.add(button_2);
		
		JLabel lblm = new JLabel("\u6E05\u65B0   24m^2  \u5962\u534E\u6C90\u6D74   \u4E13\u9A97\u4F60\u94B1~");
		lblm.setFont(new Font("宋体", Font.PLAIN, 22));
		lblm.setBounds(24, 585, 411, 42);
		contentPane.add(lblm);
		
		JLabel label_2 = new JLabel("\u767D\u94F6\u4F1A\u54589.8  \u6298 ~   8\u6298\u7279\u4EF7\u65E5");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(34, 633, 369, 29);
		contentPane.add(label_2);
		
		 label_1 = new JLabel("158");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("宋体", Font.PLAIN, 27));
		label_1.setBounds(777, 583, 72, 65);
		contentPane.add(label_1);
		
		JButton button_3 = new JButton("\u7ACB\u5373\u4E0B\u5355");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ojf=new OrderJFrame();
				ojf.setVisible(true);	
				String la=label.getText();
				String money=label_1.getText();
				ojf.setcomboBox_1(la);
				ojf.setlblNewLabel_3(money);
			}
		});
		button_3.setBounds(863, 575, 100, 63);
		contentPane.add(button_3);
		
		roomnumber = new JTextField();
		roomnumber.setText("801");
		roomnumber.setColumns(10);
		roomnumber.setBounds(158, 32, 86, 24);
		contentPane.add(roomnumber);
		
		JButton button_4 = new JButton("\u8054\u7CFB\u5BA2\u670D");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClientActivity("用户端");
				new ClientActivity("客服端");
				MyService myService=new MyService();
				myService.start();
			}
		});
		button_4.setBounds(736, 23, 113, 42);
		contentPane.add(button_4);
		
		JLabel label_3 = new JLabel("\uFFE5");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("宋体", Font.PLAIN, 26));
		label_3.setBounds(743, 592, 72, 46);
		contentPane.add(label_3);
	}

}
