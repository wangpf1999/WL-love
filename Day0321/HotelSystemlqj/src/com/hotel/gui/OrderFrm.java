package com.hotel.gui;
//初级选择界面

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import java.awt.Font;

public class OrderFrm extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFrm frame = new OrderFrm();
				
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	
	
	public OrderFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("点餐");
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("幼圆", Font.PLAIN, 40));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderbuyFrm frame = new OrderbuyFrm();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBounds(119, 146, 191, 151);
		contentPane.add(btnNewButton_1);
		
		
		
		
		JButton btnNewButton = new JButton("人工客服");
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 40));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				//打开了客服端
				serviceFrm frame1 = new serviceFrm();
				frame1.setVisible(true);
				
			}
		});
		//按键组件透明
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(115, 381, 211, 127);
		contentPane.add(btnNewButton);
		
		
		
		
		
		
		JButton btnNewButton_2 = new JButton("客户模拟");
		btnNewButton_2.setFont(new Font("楷体", Font.ITALIC, 20));
		btnNewButton_2.setBounds(94, 552, 272, 48);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				//打开了客户端
				clientFrm frame2 = new clientFrm();
				clientFrm frame1= new clientFrm();
				frame1.setVisible(true);
				frame2.setVisible(true);
			}
		});
		btnNewButton_2.setContentAreaFilled(false);
		contentPane.add(btnNewButton_2);
		this.setLocationRelativeTo(null);//窗体居中
		
		
		
		JTextPane txtpniuiuuiuur = new JTextPane();
		txtpniuiuuiuur.setForeground(Color.RED);
		txtpniuiuuiuur.setBackground(new Color(255, 200, 0));
		txtpniuiuuiuur.setFont(new Font("方正姚体", Font.ITALIC, 28));
		txtpniuiuuiuur.setText("本店致力于客户服务，餐饮广受好评，欢迎各位用户光临，品尝 ");
		txtpniuiuuiuur.setToolTipText("开心");
		//组件透明
		txtpniuiuuiuur.setOpaque(false);
		txtpniuiuuiuur.setBounds(466, 230, 328, 127);
		contentPane.add(txtpniuiuuiuur);
		
		
		
		
		
		
		
	}
}
