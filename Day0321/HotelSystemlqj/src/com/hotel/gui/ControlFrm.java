package com.hotel.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.hotel.pojo.SmartHome;
import com.hotel.serviceImpl.HotelServicelmpl;

public class ControlFrm extends JInternalFrame {
	private com.hotel.service.HotelService service = new com.hotel.serviceImpl.HotelServicelmpl();
	private JTextField txtTem;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private JTextField txtRoom;
	private SmartHome sh ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlFrm frame = new ControlFrm();
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
	public ControlFrm() {
		setForeground(Color.WHITE);
		setFrameIcon(new ImageIcon("G:\\workspace\\HotelSystem\\中控.png"));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setClosable(true);
		setTitle("智能家居控制");
		setBounds(100, 100, 316, 384);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("扫地机");
		lblNewLabel_1.setBounds(36, 60, 72, 18);
		getContentPane().add(lblNewLabel_1);
		
		JRadioButton rbtnCleanO = new JRadioButton("开");
		buttonGroup.add(rbtnCleanO);
		rbtnCleanO.setBounds(118, 56, 50, 27);
		getContentPane().add(rbtnCleanO);
		
		JRadioButton rbtnCleanC = new JRadioButton("关");
		buttonGroup.add(rbtnCleanC);
		rbtnCleanC.setBounds(174, 56, 50, 27);
		getContentPane().add(rbtnCleanC);
		
		JLabel lblNewLabel_2 = new JLabel("洗衣机");
		lblNewLabel_2.setBounds(36, 91, 72, 18);
		getContentPane().add(lblNewLabel_2);
		
		JRadioButton rbtnWashO = new JRadioButton("开");
		buttonGroup_1.add(rbtnWashO);
		rbtnWashO.setBounds(118, 87, 50, 27);
		getContentPane().add(rbtnWashO);
		
		JRadioButton rbtnWashC = new JRadioButton("关");
		buttonGroup_1.add(rbtnWashC);
		rbtnWashC.setBounds(174, 88, 50, 27);
		getContentPane().add(rbtnWashC);
		
		JLabel label = new JLabel("电视机");
		label.setBounds(36, 129, 72, 18);
		getContentPane().add(label);
		
		JRadioButton rbtnTVO = new JRadioButton("开");
		buttonGroup_2.add(rbtnTVO);
		rbtnTVO.setBounds(118, 125, 50, 27);
		getContentPane().add(rbtnTVO);
		
		JRadioButton rbtnTVC = new JRadioButton("关");
		buttonGroup_2.add(rbtnTVC);
		rbtnTVC.setBounds(174, 125, 50, 27);
		getContentPane().add(rbtnTVC);
		
		JLabel lblNewLabel = new JLabel("窗帘");
		lblNewLabel.setBounds(36, 160, 72, 18);
		getContentPane().add(lblNewLabel);
		
		JRadioButton rbtnCurtainO = new JRadioButton("开");
		buttonGroup_3.add(rbtnCurtainO);
		rbtnCurtainO.setBounds(118, 156, 50, 27);
		getContentPane().add(rbtnCurtainO);
		
		JRadioButton rbtnCurtainHO = new JRadioButton("半开");
		buttonGroup_3.add(rbtnCurtainHO);
		rbtnCurtainHO.setBounds(230, 157, 59, 27);
		getContentPane().add(rbtnCurtainHO);
		
		JRadioButton rbtnCurtainC = new JRadioButton("关");
		buttonGroup_3.add(rbtnCurtainC);
		rbtnCurtainC.setBounds(174, 156, 50, 27);
		getContentPane().add(rbtnCurtainC);
		
		JLabel label_1 = new JLabel("房间灯");
		label_1.setBounds(36, 194, 72, 18);
		getContentPane().add(label_1);
		
		JRadioButton rbtnLightRoom = new JRadioButton("卧室");
		rbtnLightRoom.setBounds(118, 190, 59, 27);
		getContentPane().add(rbtnLightRoom);
		
		JRadioButton rbtnLightRoad = new JRadioButton("过道");
		rbtnLightRoad.setBounds(174, 190, 59, 27);
		getContentPane().add(rbtnLightRoad);
		
		JRadioButton rbtnLightWC = new JRadioButton("厕所");
		rbtnLightWC.setBounds(230, 189, 59, 27);
		getContentPane().add(rbtnLightWC);
		
		JLabel lblNewLabel_3 = new JLabel("空调");
		lblNewLabel_3.setBounds(36, 236, 72, 18);
		getContentPane().add(lblNewLabel_3);
		
		JRadioButton rbtnAirConditionerO = new JRadioButton("开");
		buttonGroup_4.add(rbtnAirConditionerO);
		rbtnAirConditionerO.setBounds(118, 232, 50, 27);
		getContentPane().add(rbtnAirConditionerO);
		
		JRadioButton rbtnAirConditionerC = new JRadioButton("关");
		buttonGroup_4.add(rbtnAirConditionerC);
		rbtnAirConditionerC.setBounds(174, 232, 50, 27);
		getContentPane().add(rbtnAirConditionerC);
		
		txtTem = new JTextField();
		txtTem.setBounds(230, 233, 59, 24);
		getContentPane().add(txtTem);
		txtTem.setColumns(10);
		
		JButton btnSure = new JButton("确定");
		btnSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确定
				String roomId = txtRoom.getText();
				String clean = rbtnCleanO.isSelected()?"开":"关";
				String wash = rbtnWashO.isSelected()?"开":"关";
				String tv = rbtnTVO.isSelected()?"开":"关";
				String curtain = rbtnCurtainO.isSelected()?"开":(rbtnCurtainC.isSelected()?"关":"半开");
				String light = "";
				if(rbtnLightRoad.isSelected()) {
					light = light + "过道";
				}
				if(light.length() != 0) {
					light = light + " ";
				}
				if(rbtnLightRoom.isSelected()) {
					light = light + "卧室";
				}
					light = light + " ";
				
				if(rbtnLightWC.isSelected()) {
					light = light + "厕所";
				}
				String airConditioner = rbtnAirConditionerO.isSelected()?"开":"关";
				String tem = txtTem.getText();
				if(airConditioner.equals("关")) {
					tem = "";
				}
				sh = new SmartHome(roomId, clean, wash, tv, curtain, light, airConditioner, tem);
				service.updateHome(sh);
				ControlFrm.this.dispose();// 关闭
				
			}
		});
		btnSure.setBounds(197, 299, 92, 27);
		getContentPane().add(btnSure);
		
		JButton btnConcel = new JButton("取消");
		btnConcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//取消
				ControlFrm.this.dispose();// 关闭
			}
		});
		btnConcel.setBounds(95, 299, 92, 27);
		getContentPane().add(btnConcel);
		
		JLabel label_2 = new JLabel("房间号");
		label_2.setBounds(36, 33, 72, 18);
		getContentPane().add(label_2);
		
		txtRoom = new JTextField();
		txtRoom.setBounds(118, 30, 50, 24);
		getContentPane().add(txtRoom);
		txtRoom.setColumns(10);
		
		JButton btnSearchRoomId = new JButton("搜索");
		btnSearchRoomId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//搜索roomid
				SmartHome sh1 = new SmartHome();
				String roomId = txtRoom.getText();
				sh1 = service.searchRoomId(roomId);
				if(sh1.getAirConditioner().equals("开")) {
					rbtnAirConditionerO.setSelected(true);
					txtTem.setText(sh1.getTem());
				}else {
					rbtnAirConditionerC.setSelected(true);
					txtTem.setText(" ");
				}
				if(sh1.getClean().equals("开")) {
					rbtnCleanO.setSelected(true);
				}else {
					rbtnCleanC.setSelected(true);
				}
				if(sh1.getCurtain().equals("开")) {
					rbtnCurtainO.setSelected(true);
				}else if(sh1.getCurtain().equals("关")) {
					rbtnCurtainC.setSelected(true);
				}else {
					rbtnCurtainHO.setSelected(true);
				}
				String[] lights = sh1.getLight().split(" ");
				for(String light : lights) {
					if(light.equals("过道")) {
						rbtnLightRoad.setSelected(true);
					}
					if(light.equals("卧室")) {
						rbtnLightRoom.setSelected(true);
						txtTem.setText(sh1.getTem());
					}
					if(light.equals("厕所")) {
						rbtnLightWC.setSelected(true);
					}
				}
				if(sh1.getTv().equals("开")) {
					rbtnTVO.setSelected(true);
				}else {
					rbtnTVC.setSelected(true);
				}
				if(sh1.getWash().equals("开")) {
					rbtnWashO.setSelected(true);
				}else {
					rbtnWashC.setSelected(true);
				}
				
			}
		});
		btnSearchRoomId.setBounds(174, 29, 72, 27);
		getContentPane().add(btnSearchRoomId);

	}
}
