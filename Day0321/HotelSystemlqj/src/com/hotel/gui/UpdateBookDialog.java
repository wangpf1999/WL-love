package com.hotel.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class UpdateBookDialog extends JDialog {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DatePicker datePicker;
	private JTextField txtPrice;
	private JTextField txtLayer;
	private JTextField txtUserTel;
	private JTextField txtUserId;
	private JTextField txtUserName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UpdateBookDialog dialog = new UpdateBookDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initDatePacket(java.util.Date defaultDate) {//defaultDate: 传一个日期默认值;
		String format="yyyy-MM-dd";
		Font font = new Font("宋体", Font.PLAIN, 14);
		Dimension dimension = new Dimension(209,21);
		datePicker = new DatePicker(defaultDate, format, font, dimension);
		datePicker.setBounds(178, 298, 139, 24);
		getContentPane().add(datePicker);
	}
	

	/**
	 * Create the dialog.
	 */
	public UpdateBookDialog() {
		setAlwaysOnTop(true);
		setTitle("\u9884\u8BA2\u4FEE\u6539");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 394, 479);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 407, 388, 37);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			
			JButton button = new JButton("\u5BA2\u623F\u67E5\u8BE2");
			buttonPane.add(button);
			{
				JButton cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						UpdateBookDialog.this.dispose();//关闭 
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
			{
				JButton okButton = new JButton("\u786E\u8BA4");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
			}
		}
		
		txtPrice = new JTextField();
		txtPrice.setEnabled(false);
		txtPrice.setColumns(10);
		txtPrice.setBounds(178, 344, 139, 24);
		getContentPane().add(txtPrice);
		
		JLabel label = new JLabel("\u4EF7\u683C\uFF1A");
		label.setBounds(65, 347, 72, 18);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u65F6\u95F4\uFF1A");
		label_1.setBounds(65, 298, 72, 18);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u697C\u5C42\uFF1A");
		label_2.setBounds(65, 252, 72, 18);
		getContentPane().add(label_2);
		
		txtLayer = new JTextField();
		txtLayer.setColumns(10);
		txtLayer.setBounds(178, 249, 139, 24);
		getContentPane().add(txtLayer);
		
		JLabel label_3 = new JLabel("\u623F\u578B\uFF1A");
		label_3.setBounds(65, 204, 72, 18);
		getContentPane().add(label_3);
		
		JComboBox cmbType = new JComboBox();
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"\u8C6A\u534E\u53CC\u4EBA\u95F4", "\u8D85\u5927\u60C5\u4FA3\u95F4", "\u52A8\u7269\u4E3B\u9898\u95F4", "\u8C6A\u534E\u5355\u4EBA\u5927\u5E8A\u623F", "\u5962\u534E\u6C90\u6D74\u95F4", "\u6709\u70B9\u5E73\u51E1\u7684\u7535\u7ADE\u95F4"}));
		cmbType.setBounds(178, 201, 139, 24);
		getContentPane().add(cmbType);
		
		txtUserTel = new JTextField();
		txtUserTel.setColumns(10);
		txtUserTel.setBounds(178, 147, 139, 24);
		getContentPane().add(txtUserTel);
		
		JLabel label_4 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		label_4.setBounds(65, 150, 88, 18);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u8EAB\u4EFD\u8BC1\uFF1A");
		label_5.setBounds(65, 99, 72, 18);
		getContentPane().add(label_5);
		
		txtUserId = new JTextField();
		txtUserId.setColumns(10);
		txtUserId.setBounds(178, 96, 139, 24);
		getContentPane().add(txtUserId);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(178, 45, 139, 24);
		getContentPane().add(txtUserName);
		
		JLabel label_6 = new JLabel("\u59D3\u540D\uFF1A");
		label_6.setBounds(65, 48, 72, 18);
		getContentPane().add(label_6);
		
		this.initDatePacket(new java.util.Date());
	}
}
