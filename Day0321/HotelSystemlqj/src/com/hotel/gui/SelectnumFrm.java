package com.hotel.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class SelectnumFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectnumFrm frame11 = new SelectnumFrm();
					frame11.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectnumFrm() {
		
		setBounds(100, 100, 456, 274);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("亲，输入你想要的份数哦！");
		label.setFont(new Font("楷体", Font.BOLD, 20));
		label.setBounds(14, 13, 317, 68);
		getContentPane().add(label);

	}

}
