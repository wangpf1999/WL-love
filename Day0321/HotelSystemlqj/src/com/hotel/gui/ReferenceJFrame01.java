package com.hotel.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
public class ReferenceJFrame01 extends JFrame {
	private JPanel contentPane;
	private OrderJFrame ojf;
	private JTextField roommunber;
	private JLabel lblNewLabel_3;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReferenceJFrame01 frame = new ReferenceJFrame01();
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
	public ReferenceJFrame01() {
		
		setTitle("\u5BA2\u623F\u63A8\u8350");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 674);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("\u8C6A\u534E\u53CC\u4EBA\u95F4");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setForeground(Color.RED);
		label.setBounds(28, 13, 135, 43);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("\u65E9\u9910\u914D\u9001  23m^2   \u5927\u5E8A  \u5165\u4F4F \u6709\u7A97~");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(28, 553, 388, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u767D\u94F6\u4F1A\u54589.8 \u6298      8\u6298\u7279\u4EF7\u65E5 ");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(38, 593, 317, 37);
		contentPane.add(lblNewLabel_2);
		
		//立即下单按钮
		JButton btnNewButton = new JButton("\u7ACB\u5373\u4E0B\u5355");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ojf=new OrderJFrame();
				ojf.setVisible(true);	
				String la=label.getText();
				String money=lblNewLabel_3.getText();
				ojf.setcomboBox_1(la);
				ojf.setlblNewLabel_3(money);
                System.out.println(la );
			}
		});
		btnNewButton.setBounds(855, 553, 98, 63);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u4E0B\u4E00\u95F4");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReferenceJFrame01.this.setVisible(false);
				ReferenceJFrame02  jf02=new ReferenceJFrame02();
				jf02.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(569, 19, 113, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u4E0A\u4E00\u95F4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame01.this.setVisible(false);
				ReferenceJFrame06 jf06=new ReferenceJFrame06();
				jf06.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(451, 19, 113, 37);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReferenceJFrame01.this.setVisible(false);
				CustMainFrm cfr=new CustMainFrm();
				cfr.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(798, 19, 113, 37);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\wwwww\\Desktop\\\u56FE\u7247\\p01.jpg"));
		lblNewLabel.setBounds(28, 69, 939, 485);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_3 = new JLabel("99");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 27));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(791, 551, 72, 57);
		contentPane.add(lblNewLabel_3);
		
		roommunber = new JTextField();
		roommunber.setText("501");
		roommunber.setBounds(154, 25, 86, 24);
		contentPane.add(roommunber);
		roommunber.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u8054\u7CFB\u5BA2\u670D");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ClientActivity("用户");
				new ClientActivity("客服");
				MyService myService=new MyService();
				myService.start();
			}
		});
		btnNewButton_1.setBounds(684, 18, 113, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel label_1 = new JLabel("\uFFE5");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("宋体", Font.PLAIN, 26));
		label_1.setBounds(769, 556, 72, 46);
		contentPane.add(label_1);
	}
}
