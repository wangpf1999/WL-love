package com.hotel.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.hotel.pojo.Fire;

public class OrderbuyFrm extends JFrame {

	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table_1;	
	private String  id1;
	public String  foodName1;
	private String  Foodid1 ;
	private String price1;
	private static    int m=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderbuyFrm frame = new OrderbuyFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public OrderbuyFrm() {
		
		Fire.menu=new Object[50][];
		setResizable(false);
		setTitle("菜单");
		setBounds(0, 0, 884, 666);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 866, 408);
		getContentPane().add(scrollPane_1);
		com.hotel.service.HotelService foodService = new com.hotel.serviceImpl.HotelServicelmpl();
		
		table_1 = new JTable() {
			//表格不可被编辑
			public boolean isCellEditable(int row,int colunmn) {
				return false;
			}
		};
		//设置行高
		table_1.setRowHeight(30);		
		table_1.setFont(new Font("楷体", Font.BOLD, 20));
		table_1.setForeground(Color.BLACK);
		//只能选择一条数据
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setLocationRelativeTo(null);//窗体居中
		
		String[] header = new String[] { "编号","菜品", "菜系", "价格"};	
		table_1.setModel(new DefaultTableModel(foodService.listFoods(),header));
		scrollPane_1.setViewportView(table_1);
		table_1.getTableHeader().setFont(new Font("楷体", Font.BOLD, 20));
		
		
		// 客户点击表格监听器
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 客户选中了某一行
				int row = table_1.getSelectedRow();
				// 获取某一行中的第n列
				 id1= (String) table_1.getValueAt(row, 0);// 编号
				 foodName1 = (String) table_1.getValueAt(row, 1);// 菜名
				 Foodid1 = (String) table_1.getValueAt(row, 2);// 菜系
				 price1 = (String) table_1.getValueAt(row, 3);// 价格
				// 已经找到数据
				 Fire.id1=id1;
				 Fire.foodName1=foodName1;
				 Fire.foodid1=Foodid1;
				 Fire.price1= price1;				 
								
				 System.out.println(id1 + "--" + foodName1 + "--" + Foodid1 + "--" + price1);
								
				
			}
		});
		
		
				JButton btnAdd = new JButton("添加进购物车");
				btnAdd.setFont(new Font("楷体", Font.BOLD, 30));
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// 出现一个弹窗，让顾客选择菜品
						if (table_1.getSelectedRowCount() == 0) {
							JOptionPane.showMessageDialog(null, "请选择菜品");
							return;
						}
						
						//判断购物车界面是否打开
						
						// 打开购物车
						ShoppingCartFrm frame = new ShoppingCartFrm();
						frame.setVisible(true);
						
					}
					
				});
				btnAdd.setBounds(461, 503, 301, 62);
				getContentPane().add(btnAdd);

				JLabel lblNewLabel = new JLabel("请选择菜品：");
				lblNewLabel.setFont(new Font("楷体", Font.BOLD, 20));
				lblNewLabel.setBounds(40, 444, 225, 42);
				getContentPane().add(lblNewLabel);
				
				JButton btnNewButton = new JButton("确认");
				btnNewButton.setFont(new Font("楷体", Font.BOLD, 20));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Fire.menu[m]=new Object[] {Fire.id1,Fire.foodName1,Fire.foodid1,Fire.price1};
						m++;
						
					}
				});
				btnNewButton.setBounds(152, 522, 113, 36);
				getContentPane().add(btnNewButton);
				scrollPane_1.getViewport().setOpaque(false);	
				
	}
}
