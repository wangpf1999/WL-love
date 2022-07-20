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

public class ReferenceJFrame03 extends JFrame {

	private JPanel contentPane;
	private JTextField roomnumber;
	private OrderJFrame ojf;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReferenceJFrame03 frame = new ReferenceJFrame03();
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
	public ReferenceJFrame03() {
		setTitle("\u5BA2\u623F\u63A8\u8350");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\wwwww\\Desktop\\\u56FE\u7247\\p03.png"));
		lblNewLabel.setBounds(0, 55, 982, 510);
		contentPane.add(lblNewLabel);
		
		 lblNewLabel_1 = new JLabel("\u52A8\u7269\u4E3B\u9898\u95F4\uFF1A");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(0, 3, 177, 54);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u4E0A\u4E00\u95F4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame03.this.setVisible(false);
				ReferenceJFrame02 rjf=new ReferenceJFrame02();
				rjf.setVisible(true);
			}
		});
		btnNewButton.setBounds(492, 16, 113, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4E0B\u4E00\u95F4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame03.this.setVisible(false);
				ReferenceJFrame04 jf=new ReferenceJFrame04();
				jf.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(605, 16, 113, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame03.this.setVisible(false);
				CustMainFrm  jf=new CustMainFrm();
				jf.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(836, 13, 113, 42);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("\u6E05\u65B0   20m^2  \u513F\u7AE5\u623F   \u6709\u7A97   \u900F\u98CE~");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(10, 578, 411, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\u767D\u94F6\u4F1A\u54589.8  \u6298 ~   8\u6298\u7279\u4EF7\u65E5");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(20, 614, 369, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("88");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("宋体", Font.PLAIN, 27));
		label_1.setBounds(776, 578, 72, 65);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u7ACB\u5373\u4E0B\u5355");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ojf=new OrderJFrame();
				ojf.setVisible(true);	
				String la=lblNewLabel_1.getText();
				String money=label_1.getText();
				ojf.setcomboBox_1(la);
				ojf.setlblNewLabel_3(money);
                
			}
		});
		button.setBounds(862, 578, 100, 63);
		contentPane.add(button);
		
		roomnumber = new JTextField();
		roomnumber.setText("601");
		roomnumber.setColumns(10);
		roomnumber.setBounds(137, 22, 86, 24);
		contentPane.add(roomnumber);
		
		JButton button_1 = new JButton("\u8054\u7CFB\u5BA2\u670D");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClientActivity("用户端");
				new ClientActivity("客服端");
				MyService myService=new MyService();
				myService.start();
			}
		});
		button_1.setBounds(721, 16, 113, 38);
		contentPane.add(button_1);
		
		JLabel label_2 = new JLabel("\uFFE5");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("宋体", Font.PLAIN, 26));
		label_2.setBounds(741, 587, 72, 46);
		contentPane.add(label_2);
	}
}
