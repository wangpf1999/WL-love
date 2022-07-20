package com.hotel.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hotel.pojo.User;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ReferenceJFrame02 extends JFrame {

	private JPanel contentPane;
	private JTextField roomnumber;
	private OrderJFrame ojf;
	private JLabel lblNewLabel_4 ;
	private JLabel lblNewLabel ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReferenceJFrame02 frame = new ReferenceJFrame02();
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
	public ReferenceJFrame02() {
		setResizable(false);
		setTitle("\u5BA2\u623F\u63A8\u8350");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 948, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("\u8D85\u5927\u60C5\u4FA3\u95F4");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(25, 13, 246, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\wwwww\\Desktop\\\u56FE\u7247\\p02.png"));
		lblNewLabel_1.setBounds(25, 59, 891, 479);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u4E0A\u4E00\u95F4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame02.this.setVisible(false);
				 ReferenceJFrame01 rjf=new  ReferenceJFrame01();
				 rjf.setVisible(true);
			}
		});
		btnNewButton.setBounds(447, 21, 113, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4E0B\u4E00\u95F4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame02.this.setVisible(false);
				ReferenceJFrame03 jf=new ReferenceJFrame03();
				jf.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(562, 21, 113, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame02.this.setVisible(false);
				CustMainFrm cfr=new CustMainFrm();
				cfr.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(794, 21, 113, 35);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("\u6E05\u65B0   22m^2 \u8D85\u5927\u5E8A  \u5408\u9002\u4E24\u4EBA\u5165\u4F4F \uFF01");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(25, 551, 396, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u767D\u94F6\u4F1A\u54589.8  \u6298 ~   8\u6298\u7279\u4EF7\u65E5");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(25, 603, 369, 29);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("108");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 27));
		lblNewLabel_4.setBounds(746, 567, 72, 65);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("\u7ACB\u5373\u4E0B\u5355");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ojf=new OrderJFrame();
				ojf.setVisible(true);	
				String la=lblNewLabel.getText();
				String money=lblNewLabel_3.getText();
				ojf.setcomboBox_1(la);
				ojf.setlblNewLabel_3(money);
                System.out.println(la );
			}
		});
		btnNewButton_3.setBounds(816, 564, 100, 63);
		contentPane.add(btnNewButton_3);
		
		roomnumber = new JTextField();
		roomnumber.setText("601");
		roomnumber.setColumns(10);
		roomnumber.setBounds(149, 26, 86, 24);
		contentPane.add(roomnumber);
		
		JButton button = new JButton("\u8054\u7CFB\u5BA2\u670D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ClientActivity("用户端");
				new ClientActivity("客服端");
				MyService myService=new MyService();
				myService.start();
			}
		});
		button.setBounds(677, 20, 113, 37);
		contentPane.add(button);
		
		JLabel lblNewLabel_5 = new JLabel("\uFFE5");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_5.setBounds(718, 576, 72, 46);
		contentPane.add(lblNewLabel_5);
	}
}
