package com.hotel.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ReferenceJFrame04 extends JFrame {

	private JPanel contentPane;
	private JTextField roomnumber;
	private OrderJFrame ojf;
	private JLabel label_3;
  private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReferenceJFrame04 frame = new ReferenceJFrame04();
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
	public ReferenceJFrame04() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\wwwww\\Desktop\\\u56FE\u7247\\p04.png"));
		lblNewLabel.setBounds(0, 63, 977, 519);
		contentPane.add(lblNewLabel);
		
		 label = new JLabel("\u8C6A\u534E\u5355\u4EBA\u5927\u5E8A\u95F4");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		label.setBounds(14, 13, 206, 54);
		contentPane.add(label);
		
		JButton button = new JButton("\u4E0A\u4E00\u95F4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame04.this.setVisible(false);
				ReferenceJFrame03 jf=new ReferenceJFrame03();
				jf.setVisible(true);
			}
		});
		button.setBounds(493, 23, 113, 42);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u4E0B\u4E00\u95F4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame04.this.setVisible(false);
				ReferenceJFrame05 jf05=new ReferenceJFrame05();
				jf05.setVisible(true);
			}
		});
		button_1.setBounds(617, 23, 113, 42);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame04.this.setVisible(false);
				CustMainFrm cjf=new CustMainFrm();
				cjf.setVisible(true);
			}
		});
		button_2.setBounds(849, 23, 113, 42);
		contentPane.add(button_2);
		
		JLabel label_1 = new JLabel("\u6E05\u65B0   20m^2  \u513F\u7AE5\u623F   \u6709\u7A97   \u900F\u98CE~");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(24, 595, 411, 42);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u767D\u94F6\u4F1A\u54589.8  \u6298 ~   8\u6298\u7279\u4EF7\u65E5");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(34, 638, 369, 29);
		contentPane.add(label_2);
		
	     label_3 = new JLabel("128");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("宋体", Font.PLAIN, 27));
		label_3.setBounds(743, 595, 72, 65);
		contentPane.add(label_3);
		
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
		button_3.setBounds(848, 595, 100, 63);
		contentPane.add(button_3);
		
		roomnumber = new JTextField();
		roomnumber.setText("701");
		roomnumber.setColumns(10);
		roomnumber.setBounds(198, 32, 86, 24);
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
		button_4.setBounds(734, 23, 113, 42);
		contentPane.add(button_4);
		
		JLabel label_4 = new JLabel("\uFFE5");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("宋体", Font.PLAIN, 26));
		label_4.setBounds(711, 604, 72, 46);
		contentPane.add(label_4);
	}

}
