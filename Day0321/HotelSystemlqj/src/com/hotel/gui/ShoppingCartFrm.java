package com.hotel.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.hotel.pojo.Fire;
import javax.swing.JTextField;
import javax.swing.JEditorPane;


public class ShoppingCartFrm extends JFrame {

	private JPanel contentPane;
	private static  JTable table11;
	private int a;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingCartFrm frame = new ShoppingCartFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ShoppingCartFrm() {
		setResizable(false);
		setTitle("购物车");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("菜品列表：");
		label.setFont(new Font("楷体", Font.BOLD, 25));
		label.setBounds(25, 50, 133, 30);
		contentPane.add(label);
			
			
		
//		scrollPane.setViewportView(getTable11());
//		getTable11().getTableHeader().setFont(new Font("楷体", Font.BOLD, 20));
		JButton button = new JButton("提交订单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table11.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "提交订单成功");
					return;
				}
							
			}
		});
		button.setFont(new Font("楷体", Font.BOLD, 20));
		button.setBounds(203, 526, 141, 52);
		contentPane.add(button);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 143, 563, 348);
		contentPane.add(scrollPane);
		
		table11 = new JTable();
		//设置行高
		getTable11().setRowHeight(30);	
		table11.setFont(new Font("楷体", Font.BOLD, 25));
		table11.setForeground(Color.BLACK);
		table11.setModel(new DefaultTableModel(
		Fire.menu,
			new String[] {
				"编号", "菜品", "菜系", "价格"
			}
		));
		scrollPane.setViewportView(table11);
		table11.getTableHeader().setFont(new Font("楷体", Font.BOLD, 20));
		
		
		
		
	}

	public static JTable getTable11() {
		return table11;
	}
	public int account() {
		
//		a= ()Fire.price1;
		return a;	
	}
	
}
