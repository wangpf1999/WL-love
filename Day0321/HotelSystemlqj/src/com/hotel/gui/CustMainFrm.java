package com.hotel.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class CustMainFrm extends JFrame {

	private JPanel contentPane;

	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	static CustMainFrm frame = new CustMainFrm();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public CustMainFrm() {
		setTitle("xxx\u5927\u9152\u5E97\u6B22\u8FCE\u60A8");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setForeground(Color.BLACK);
		menuBar.setBounds(0, 0, 776, 26);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("\u5BA2\u623F\u5165\u4F4F ");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u5BA2\u623F\u63A8\u8350");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustMainFrm.this.setVisible(false);
				ReferenceJFrame01 rjf=new ReferenceJFrame01();
				rjf.setVisible(true);
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5BA2\u623F\u67E5\u8BE2");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//弹出查询子窗体
				//加载所有的子窗体
				JInternalFrame[] frames = desktopPane.getAllFrames();
				boolean isExist=false;
				for (JInternalFrame f : frames) {
					if (f.getTitle().equals("客房查询")) {
						isExist=true;
						try {
							f.setSelected(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
				
				if (isExist!=true) {
						RoomSearchFrm roomSearchFrm=new RoomSearchFrm();
					roomSearchFrm.setVisible(true);
					desktopPane.add(roomSearchFrm);
					}
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5BA2\u623F\u9884\u8BA2");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//加载客房预订子窗体;
				
				//desktopPane中所有子窗体得到;
				JInternalFrame[] frames = desktopPane.getAllFrames();
				//判断当前要打开的窗体在容器中是否存在，存在，激活，不存在，创建并添加到容器中;
				boolean isExist=false;
				for(JInternalFrame f : frames ) {
					if(f.getTitle().equals("客房预订")) {//存在;
						try {
							isExist=true;
							f.setSelected(true);
						} catch (PropertyVetoException e1) {e1.printStackTrace();}
					}
				}
				if(!isExist) {
					RoomBookFrm rBFrm = new RoomBookFrm();
					rBFrm.setVisible(true);
					desktopPane.add(rBFrm);
				}
//				CustMainFrm.this.setVisible(false);
			}
		});
		menu.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("\u9152  \u5E97  \u529F  \u80FD");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u70B9\u9910");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderFrm frame = new OrderFrm();
				frame.setVisible(true);
				CustMainFrm.this.setVisible(false);
			}
		});
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u6E05\u6D01");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//清洁
				JInternalFrame[] frames = desktopPane.getAllFrames();
				//2  判断当前要打开的窗体在容器中是否存，如果创建并添加到容器中;存在，激活，不存在，
				boolean isExist=false;
				for(JInternalFrame f : frames) {
					if(f.getTitle().equals("设定清洁时间")) { //存在;
						try {
							isExist=true;
							f.setSelected(true);
						} catch (PropertyVetoException e1) {e1.printStackTrace();}
					}
				}
				if(!isExist) {
					cleanFrm cleanfrm = new cleanFrm();
					cleanfrm.setVisible(true);
					desktopPane.add(cleanfrm);
				}
			}
		});
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u66F4\u6362\u623F\u95F4");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int confirm=JOptionPane.showConfirmDialog(null, "确认需要更换房间？");
				
				//获取主键（第一列
				if(confirm!=0) {
					
					JOptionPane.showMessageDialog(null, "退房取消");
					return;
				}else {
					int confirm1=JOptionPane.showConfirmDialog(null, "确认管理员在身旁？");
					if(confirm1==0) {
					AdminLogin adminLogin=new AdminLogin();
					adminLogin.setVisible(true);
					frame.setVisible(false);
					}
					
				}
				
				
//				AdminInfor adminInfor=new AdminInfor();
//				adminInfor.setVisible(true);
			}
		});
		menu_1.add(menuItem_5);
		
		JMenuItem menuItem_9 = new JMenuItem("\u667A\u80FD\u4E2D\u63A7");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//智能中控
				JInternalFrame[] frames = desktopPane.getAllFrames();
				//2  判断当前要打开的窗体在容器中是否存，如果创建并添加到容器中;存在，激活，不存在，
				boolean isExist=false;
				for(JInternalFrame f : frames) {
					if(f.getTitle().equals("智能家居控制")) { //存在;
						try {
							isExist=true;
							f.setSelected(true);
						} catch (PropertyVetoException e1) {e1.printStackTrace();}
					}
				}
				if(!isExist) {
					ControlFrm controlFrm = new ControlFrm();
					controlFrm.setVisible(true);
					desktopPane.add(controlFrm);
				}
			}
		});
		menu_1.add(menuItem_9);
		
		JMenu menu_2 = new JMenu("    \u5E2E  \u52A9");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_10 = new JMenuItem("\u7528\u6237\u53CD\u9988");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//用户反馈
				JInternalFrame[] frames = desktopPane.getAllFrames();
				//2  判断当前要打开的窗体在容器中是否存，如果创建并添加到容器中;存在，激活，不存在，
				boolean isExist=false;
				for(JInternalFrame f : frames) {
					if(f.getTitle().equals("用户反馈")) { //存在;
						try {
							isExist=true;
							f.setSelected(true);
						} catch (PropertyVetoException e1) {e1.printStackTrace();}
					}
				}
				if(!isExist) {
					UserFeedbackFrm userFeedbackFrm = new UserFeedbackFrm();
					userFeedbackFrm.setVisible(true);
					desktopPane.add(userFeedbackFrm);
				}
			}
		});
		menu_2.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("\u8FD4\u56DE\u4E3B\u754C\u9762");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrm loginFrm=new LoginFrm();
				loginFrm.setVisible(true);
				CustMainFrm.this.setVisible(false);
			}
		});
		menu_2.add(menuItem_11);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(651, 26, -653, 253);
		contentPane.add(scrollPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(0, 26, 776, 493);
		contentPane.add(desktopPane);
		

		
	}
}
