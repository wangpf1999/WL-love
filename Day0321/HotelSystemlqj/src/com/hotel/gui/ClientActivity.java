package com.hotel.gui;

import javax.swing.JFrame;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import com.google.gson.Gson;
import javax.swing.JTextArea;

public class ClientActivity extends JFrame{
  private String name;
  private JTextField textField;
  private DatagramSocket socket;
  private InetAddress ip;
  private  JTextArea textArea;
  private JButton playBtn;
  private JButton soundRecordBtn;
  private AudioFormat format;
  public  TargetDataLine targetDataLine;
  private boolean isStartAduio=true;
  
  public ClientActivity(String name) {
	  super("����ͻ���:"+name);
	  setResizable(false);
	  this.name=name;
	  setSize(500,500);
	  getContentPane().setLayout(null);
	  initLayout();
	  initUdp();
	  show();  
  }

  public void  initLayout() {
	  JButton  sendBtn = new JButton("����");
	  sendBtn.addActionListener(new ActionListener() {
	  	public void actionPerformed(ActionEvent arg0) {
	  		//������͵�ʱ���õ��ı����е�����
	  		String msg=textField.getText();
	  		sendMessage(msg, 0);
	  		textField.setText(null);
	  	}
	  });
	  sendBtn.setBounds(332, 391, 113, 27);
	  getContentPane().add( sendBtn);
	  
	  textField = new JTextField();
	  textField.setBounds(14, 392, 304, 24);
	  getContentPane().add(textField);
	  textField.setColumns(10);
	  
	  soundRecordBtn = new JButton("���¼��");
	  soundRecordBtn.addActionListener(new ActionListener() {
	  	public void actionPerformed(ActionEvent e) {
	  		if(isStartAduio) {
	  			captureAudio();
	  			soundRecordBtn.setText("�������");
	  		}else {
	  			targetDataLine.stop();
	  			targetDataLine.close();
	  			soundRecordBtn.setText("���¼��");
	  			sendMessage("������������������������", 1);
	  			playBtn.setVisible(true);
	  		}
	  		isStartAduio=!isStartAduio;
	  	}
	  });
	  soundRecordBtn.setBounds(24, 352, 113, 27);
	  getContentPane().add(soundRecordBtn);
	  
	  playBtn = new JButton("�������");
	  playBtn.addActionListener(new ActionListener() {
	  	public void actionPerformed(ActionEvent e) {
	  		 playAduio();
	  		 playBtn.setText("���ڲ���....");
	  	}
	  });
	  playBtn.setBounds(216, 352, 113, 27);
	  getContentPane().add(playBtn);
	  
	  textArea = new JTextArea();
	  textArea.setBounds(14, 13, 454, 329);
	  getContentPane().add(textArea);
  }
  
  public void  initUdp() {
	  MyService.loginGroups(this);
	  try {
		socket=new DatagramSocket();
		try {
			ip=InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	} catch (SocketException e) {
		e.printStackTrace();
	}
  }
 public void pushMessage(MessageBean bean) {
	 //������׷�ӵ��ı�����
	 textArea.append(bean.getName()+":"+bean.getContent()+"\n");
	 //�ж���Ϣ����
	 if(bean.getType()==0) {
		 playBtn.setVisible(false);
	 }else {
		 playBtn.setVisible(true);
	 }
 }
 //���͹���
 private void sendMessage(String msg,int type) {
	 MessageBean bean=new MessageBean();
	 bean.setName(name);
	 bean.setContent(msg);
	 bean.setType(type);
	 //gson����Ϊ�˰� Message bean��ΪString���͵�
	 Gson gson=new Gson();
	 String json=gson.toJson(bean);
	 byte[] bytes=json.getBytes();
	 DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length,ip,MyService.PORT);
	 try {
		socket.send(datagramPacket);	
	} catch (IOException e) {
		e.printStackTrace();
	} 
 }
	private void captureAudio() {
		format=getAudioFormat();
        DataLine.Info  dataLineInfo=new DataLine.Info(TargetDataLine.class,format);
        try {
			targetDataLine=(TargetDataLine)AudioSystem.getLine(dataLineInfo);
			new CaptureThread ().start();
			
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
        
	}
	//�����������˼�Ƕ����ļ�����
	private AudioFormat getAudioFormat() {
		float sampleRate=11025.0f;
		int sampleSizeInBits=16;//ÿ�������е�λ��
		int channles=1;//ͨ����=1��ʱ���ǵ�ͨ��
		boolean signed=true;
		boolean bigEndian=false;
		return new AudioFormat(sampleRate, sampleSizeInBits,channles, signed, bigEndian);
	}
	class CaptureThread extends Thread {
		@Override
		public void run() {
			//��Ƶ���淽ʽ
			AudioFileFormat.Type  fileType=AudioFileFormat.Type.WAVE;
			File audioFile=new File("chat.wav");
			try {
				targetDataLine.open(format);
				targetDataLine.start();
				AudioSystem.write(new AudioInputStream(targetDataLine), fileType,audioFile);
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void playAduio() {
		AudioInputStream  as;
		try {
			as=AudioSystem.getAudioInputStream(new File("chat.wav"));
			AudioFormat format=as.getFormat();
			SourceDataLine sdl=null;
			DataLine.Info  info=new DataLine.Info(SourceDataLine.class, format);
			try {
				sdl=(SourceDataLine) AudioSystem.getLine(info);
				sdl.open(format);
				sdl.start();
				int nBytesRead=0;
				byte[] abData=new byte[512];
				while(nBytesRead!=-1) {
					nBytesRead=as.read(abData,0,abData.length);
					if(nBytesRead>=0) {
						sdl.write(abData, 0, nBytesRead);		
					}
				}
				sdl.drain();
				sdl.close();
				playBtn.setVisible(false);
				playBtn.setText("�������");
				
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}	
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
