package com.hotel.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hotel.pojo.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminInfor extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private com.hotel.service.HotelService hotelService=new com.hotel.serviceImpl.HotelServicelmpl();
	private JButton button;
	/**
	 * Launch the application.
	 */
	static AdminInfor frame = new AdminInfor();
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
	public AdminInfor() {
		setBounds(100, 100, 774, 514);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 13, 751, 360);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] header =new String[] {"����", "�����", "�ֻ���", "���֤", "��סʱ��", "��סʱ��"};
		table.setModel(new DefaultTableModel(hotelService.listUsers(),header));
		scrollPane.setViewportView(table);
		
		button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMainFrm mainFrm=new AdminMainFrm();
				mainFrm.setVisible(true);
				AdminInfor.this.setVisible(false);;
			}
		});
		button.setBounds(10, 386, 113, 39);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u9000\u623F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount()==0) {//�˷�
					//����Ϣ�ĶԻ���
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�˷��Ķ���");
					return;
				}
				//ȷ��ɾ����
				int confirm=JOptionPane.showConfirmDialog(null, "ȷ���˷���");
				
				//��ȡ��������һ��
				if(confirm!=0) {
					JOptionPane.showMessageDialog(null, "�˷�ȡ��");
					return;
				}
				int rowindex=table.getSelectedRow();
				String uname=table.getValueAt(rowindex, 0).toString();//ȡĳһ����Ԫ���ֵ
				int affter=hotelService.delectAdmin(uname);
				
				//ˢ�±������
				if(affter>0) {
					table.setModel(new DefaultTableModel(hotelService.listUsers(),header));
				}
			}
		});
		button_1.setBounds(629, 386, 113, 39);
		contentPane.add(button_1);
		
		JButton btnNewButton = new JButton("\u6362\u623F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//����
				if(table.getSelectedRowCount()==0) {
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
					return;
				}
				//�ҵ�Ҫ�޸ĵ����ݣ�������;
				String uname = table.getValueAt(table.getSelectedRow(), 0).toString();
				System.out.println(uname);
				User upateUser = hotelService.get(uname);
				User uuu=new User();
				//�ڶ������� �����õ�Ҫ�޸ĵ�����
				//�������������ݴ����޸ĵĶԻ�����
				AdminUserUpdate users=new AdminUserUpdate(upateUser);
				users.setVisible(true);
				//ˢ�´���
				table.setModel(new DefaultTableModel(hotelService.listUsers(),header));
			}
		});
		btnNewButton.setBounds(332, 386, 113, 39);
		contentPane.add(btnNewButton);

	}
}
