package com.hotel.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class CancelBookDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUserName;
	private com.hotel.service.RoomBookService roomBookService = new com.hotel.serviceImpl.RoomBookServiceImpl();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CancelBookDialog dialog = new CancelBookDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CancelBookDialog() {
		setResizable(false);
		setAlwaysOnTop(true);
		setModal(true);
		setTitle("\u53D6\u6D88/\u4FEE\u6539\u9884\u8BA2");
		setBounds(100, 100, 653, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
			lblNewLabel.setBounds(86, 44, 85, 18);
			contentPanel.add(lblNewLabel);
		}
		{
			txtUserName = new JTextField();
			txtUserName.setBounds(185, 41, 226, 24);
			contentPanel.add(txtUserName);
			txtUserName.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("tips\uFF1A\u8BF7\u8F93\u5165\u60A8\u7684\u7535\u8BDD\u53F7\u7801\u8FDB\u884C\u67E5\u627E\uFF0C\u9009\u4E2D\u540E\u518D\u8FDB\u884C\u76F8\u5173\u64CD\u4F5C");
			lblNewLabel_1.setBounds(14, 13, 619, 18);
			lblNewLabel_1.setForeground(Color.RED);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JButton btnSearch = new JButton("\u67E5\u627E");
			btnSearch.setBounds(464, 40, 72, 27);
			contentPanel.add(btnSearch);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(14, 75, 619, 269);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					roomBookService.listRoom(),
					new String[] {
						"房号", "楼层", "用户", "身份证", "电话", "房型号", "房型", "价格", "时间", "总价"
					}
				));
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CancelBookDialog.this.dispose();//关闭窗口;
					}
				});
				
				JButton btnNewButton = new JButton("\u4FEE\u6539\u9884\u8BA2");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//弹出对话框
						UpdateBookDialog dialog = new UpdateBookDialog();
						dialog.setVisible(true);
						dialog.setLocationRelativeTo(null);
					}
				});
				buttonPane.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("\u53D6\u6D88\u9884\u8BA2");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//删除
						
					}
				});
				buttonPane.add(btnNewButton_1);
				cancelButton.setActionCommand("Cancel\r\n");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
		}
	}
}
