package com.hotel.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import com.hotel.service.HotelService;
import com.hotel.serviceImpl.HotelServicelmpl;

public class RoomSearchFrm extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSearchKey;
	private JComboBox cmbSearchType;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomSearchFrm frame = new RoomSearchFrm();
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
	public RoomSearchFrm() {
		setClosable(true);
		setTitle("客房查询");
		setFrameIcon(new ImageIcon(RoomSearchFrm.class.getResource("/com/hotel/gui/bgv.jpg")));
		setBounds(100, 100, 737, 460);
		com.hotel.service.HotelService hotelService=new com.hotel.serviceImpl.HotelServicelmpl();
		
		String[] header=new String[] {"房间号码", "房间类型", "价格", "是否入住", "清洁状态", "入住顾客", "顾客号码", "入住时间"};
		
		
		
		
		JButton btnSearch = new JButton("查询");
		btnSearch.setBounds(503, 15, 97, 36);
		btnSearch.setContentAreaFilled(false);//设置查询按钮透明
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// 查询
				String keyword=txtSearchKey.getText();
				String propColumn=cmbSearchType.getSelectedItem().toString();
			HotelService hotelService=new HotelServicelmpl();
			Object[][] datas=hotelService.searchByKeyWord(keyword, propColumn);
			table.setModel(new DefaultTableModel(datas, header));
			}
		});
		 getContentPane().setLayout(null);
		 cmbSearchType = new JComboBox();
		 cmbSearchType.setBounds(237, 15, 97, 36);
		cmbSearchType.setModel(new DefaultComboBoxModel(new String[] {"房间号码", "房间类型", "入住顾客"}));
		getContentPane().add(cmbSearchType);
		btnSearch.setIcon(new ImageIcon(RoomSearchFrm.class.getResource("/com/hotel/gui/7884c597fd56fc2494c0f3f70ccd54a3.jpg")));
		getContentPane().add(btnSearch);
		
		txtSearchKey = new JTextField();
		txtSearchKey.setBounds(335, 16, 169, 36);
		getContentPane().add(txtSearchKey);
		txtSearchKey.setColumns(10);
		
			JLabel time = new JLabel("");
			time.setBounds(0, 0, 207, 21);
			getContentPane().add(time);
			this.setTimer(time);//
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 64, 707, 166);
		getContentPane().add(scrollPane);
		

		
		table = new JTable();
		table.setModel(new DefaultTableModel(hotelService.list(),header));
		table.getTableHeader().setFont(new Font("楷体", Font.BOLD, 20));
		scrollPane.setViewportView(table);
		
		
		JLabel lbbgview = new JLabel("");
		lbbgview.setBounds(0, 0, 721, 424);
		lbbgview.setIcon(new ImageIcon(RoomSearchFrm.class.getResource("/com/hotel/gui/b08f1d0da5b8b9da083e2495ce3cb8d9.jpg")));
		getContentPane().add(lbbgview);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 64, 630, 166);
		getContentPane().add(scrollPane_1);

	}
	private void setTimer(JLabel time) {
		final JLabel varTime=time;
		Timer timeAction=new javax.swing.Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long timemillis=System.currentTimeMillis();
				//转换日期显示格式
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				varTime.setText(df.format(new Date(timemillis)));
				
			}
		});
		timeAction.start();
	}
}

