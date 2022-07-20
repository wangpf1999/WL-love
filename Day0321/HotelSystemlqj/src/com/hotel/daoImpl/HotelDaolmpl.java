package com.hotel.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.hotel.dao.HotelDao;
import com.hotel.pojo.Admin;
import com.hotel.pojo.CustomerClean;
import com.hotel.pojo.Food;
import com.hotel.pojo.SmartHome;
import com.hotel.pojo.TextFeedback;
import com.hotel.pojo.User;

import DBUtil.JdbcUtil;







public class HotelDaolmpl implements HotelDao {

	@Override
	public Admin Loginche(String loginid) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Admin admin=null;
		try {
			//�õ����Ӷ���
			conn=JdbcUtil.getConnection();
			//����PreparedStatement����
			String sql="select * from ht_admin where aloginid=?";
			ps=conn.prepareStatement(sql);
			//ִ�в���
			ps.setString(1, loginid);
			rs=ps.executeQuery();
			//��ȡ����
			if(rs.next()) {
				String apassword=rs.getString("apassword");
				String aloginid=rs.getString("aloginid");
				String aname=rs.getString("aname");
				//OMRapping������ת���ɹ�ϵ���߽���ϵת���ɶ���
				admin =new Admin(apassword,aloginid,aname);
			}
			
		} catch (SQLException e) {}
		finally {//�رն���
			JdbcUtil.close(rs, ps, conn);}
		
		return admin;
	}

	@Override
	public Object[][] UserList() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Object[][] users= null;
		try {
			conn = JdbcUtil.getConnection();
			String sql="select * from ht_userinfor";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int number = 0;
			while(rs.next()) {
				number++;
			}
			rs.close();
			users =new Object[number][];
			rs=ps.executeQuery();
			int i=0;
			while(rs.next()) {
				users[i]=new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6)
						};
				i++;
			}
		} catch (Exception e) {
		}finally {
			JdbcUtil.close(rs, ps, conn);
		}
		return users;
	}

	@Override
	public int delect(String uname) {
		Connection conn=null;
		PreparedStatement ps=null;
		//��һ����ȡ����
		try {
			conn=JdbcUtil.getConnection();
			//�ڶ���������PreparedStatement����
			String sql="delete from ht_userinfor where uname=?";
			ps=conn.prepareStatement(sql);
			//������ִ�в���
			ps.setString(1, uname);
			return ps.executeUpdate();
		} catch (Exception e) {}
		finally {
			JdbcUtil.close(null, ps, conn);
		}
		return 0;
	}

	@Override
	public User getUserByuname(String uname1) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		try {
			//�õ����Ӷ���
			conn=JdbcUtil.getConnection();
			//����PreparedStatement����
			String sql="select * from ht_userinfor where uname=?";
			ps=conn.prepareStatement(sql);
			//ִ�в���
			ps.setString(1, uname1);
			rs=ps.executeQuery();
			//��ȡ����
			if(rs.next()) {
				String uname=rs.getString("uname");
				String unum=rs.getString("unum");
				String uphone=rs.getString("uphone");
				String uidentity=rs.getString("uidentity");
				java.sql.Date uindate=rs.getDate("uindate");
				java.sql.Date uoutdate=rs.getDate("uoutdate");

				//OMRapping������ת���ɹ�ϵ���߽���ϵת���ɶ���
				user=new User(uname, unum, uphone, uidentity, uindate, uoutdate);
			}
			
		} catch (SQLException e) {}
		finally {//�رն���
			JdbcUtil.close(rs, ps, conn);}
		
		return user;
	}

	@Override
	public int update(User user) {
		Connection conn=null;
		PreparedStatement ps=null;
		//��һ����ȡ����
		try {
			conn=JdbcUtil.getConnection();
			//�ڶ���������PreparedStatement����
			String sql="update  ht_userinfor set unum=?,uidentity=?,uphone=?,uindate=?,uoutdate=? where uname=?";
			ps=conn.prepareStatement(sql);
			//������ִ�в���
			
			ps.setString(1, user.getUnum());
			ps.setString(2, user.getUidentity());
			ps.setString(3, user.getUphone());
			ps.setDate(4, user.getUindate());
			ps.setDate(5, user.getUoutdate());
			ps.setString(6, user.getUname());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(null, ps, conn);
		}
		return 0;
	}


	

	@Override
	public int insert(CustomerClean customerClean) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		 try {
			 conn = JdbcUtil.getConnection();
			 String insertSql = "insert into clean values(?,?,?)";
			ps = conn.prepareStatement(insertSql);
			ps.setDate(1, customerClean.getCleanTime());
			ps.setString(2, customerClean.getNote());
			ps.setString(3, customerClean.getRoomId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				JdbcUtil.close(null, ps, conn);
			}
		return 0;
	}
	@Override
	public int updateHome(SmartHome smartHome) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update tb_smarthome set CLEAN = ?,WASH = ?,TV = ?,CURTAIN = ?,LIGHT = ?,AIRCONDITIONER = ? ,TEM = ? where ROOMID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, smartHome.getClean());
			ps.setString(2, smartHome.getWash());
			ps.setString(3, smartHome.getTv());
			ps.setString(4, smartHome.getCurtain());
			ps.setString(5, smartHome.getLight());
			ps.setString(6, smartHome.getAirConditioner());
			ps.setString(7, smartHome.getTem());
			ps.setString(8, smartHome.getRoomId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(null, ps, conn);
		}
		return 0;
	}
	@Override
	public SmartHome SearchByRoomId(String roomId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		SmartHome sh = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from tb_smarthome where roomid =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, roomId);
			rs = ps.executeQuery();
			if(rs.next()) {
				String room = rs.getString(1);
				String clean = rs.getString(2);
				String wash = rs.getString(3);
				String tv = rs.getString(4);
				String curtain = rs.getString(5);
				String light = rs.getString(6);
				String airConditioner = rs.getString(7);
				String tem = rs.getString(8);
				sh = new SmartHome(room, clean, wash, tv, curtain, light, airConditioner, tem);
			}
		}catch(SQLException e) {}
		finally {
			//���岽���رն���
			JdbcUtil.close(rs, ps, conn); 
		}
		return sh;
	}

	public void SendEmail(String roomid,String msg) {
		//Э��SMTP
		 Properties pro = new  Properties();
		 //��������
		 pro.setProperty("mail.host", "smtp.qq.com");
		 //���ô���Э��
		 pro.setProperty("mail.transport.protocol", "smtp");
		 //��������������Ȩ��֤
		 pro.setProperty("mail.smtp.auth", "true");
		 //������Ȩ����֤(��֤��)
		 Session session = Session.getDefaultInstance(pro, new Authenticator() {
			 @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("1264204322", "mnaqhdvscjidhfhd");
			}
		 });
		 //��ȡ����
		 Transport ts = null;
		 try {
			ts = session.getTransport();
			//���ӷ�����
			ts.connect("smtp.qq.com","1264204322@qq.com","mnaqhdvscjidhfhd");
			//�����ʼ�����
			MimeMessage message = new MimeMessage(session);
			//�����˵�ַ
			message.setFrom(new InternetAddress("1264204322@qq.com"));
			//�ռ��˵�ַ
			message.setRecipient(Message.RecipientType.TO, new InternetAddress("2762474105@qq.com"));
			//�����ʼ�����
			roomid = roomid + "�û�����";
			message.setSubject(roomid);
			//�����ʼ�����
			message.setContent(msg,"text/html;charset=utf-8");
			//���ʼ�
			ts.sendMessage(message, message.getAllRecipients() );
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				ts.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public int insertFeedback(TextFeedback textFeedback) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into ufeedback values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, textFeedback.getRoomId());
			ps.setDate(2, textFeedback.getTime());
			ps.setString(3, textFeedback.getNote());
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	

	@Override
	public Object[][] list() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Object[][] rooms=null;
		try {
			conn=DBUtil.JdbcUtil.getConnection();//��һ���õ�����
			String sql="select * from ht_room order by rnum asc";
			ps=conn.prepareStatement(sql);//�ڶ����������Ӷ���
			rs=ps.executeQuery();//3.ִ�в���
			int num=0;
			while (rs.next()) {
				num++;
			}
			rs.close();
			rooms=new Object[num][];
			rs=ps.executeQuery();
			int i=0;
			while (rs.next()) {
				rooms[i]= new Object[] {rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8)};
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.JdbcUtil.close(rs, ps, conn);
		}
				return rooms ;
	}

	@Override
	public Object[][] search(String keyword, String propColumn) {
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Object[][] rooms=null;
		try {
			conn=DBUtil.JdbcUtil.getConnection();//��һ���õ�����
		String sql="select * from HT_ROOM where rnum like '%"+keyword+"%'";
		if("�������".equals(propColumn)) {
			sql="select * from HT_ROOM where rnum like '%"+keyword+"%'";
		}else if("��������".equals(propColumn)){
			sql="select * from HT_ROOM where rtype like '%"+keyword+"%'";
		}else {
			sql="select * from HT_ROOM where ruser like '%"+keyword+"%'";
		}
		ps=conn.prepareStatement(sql);//�ڶ����������Ӷ���
		rs=ps.executeQuery();//3.ִ�в��� 
		int num=0;
		while (rs.next()) {
			num++;
		}
		rs.close();
		rooms=new Object[num][];
		rs=ps.executeQuery();
		int i=0;
		while (rs.next()) {
			rooms[i]= new Object[] {rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8)};
			i++;
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}finally {
			DBUtil.JdbcUtil.close(rs, ps, conn);
		}
				return rooms ;
	}
	
	
	@Override
	public Object[][] search(String key) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Object[][] foods =null;
		try {
			//��1������ȡ����
			conn = JdbcUtil.getConnection();
			//��2��������PreparedStatement����
			String sql="select * from Food where uname like '%"+ key +"%'";
			ps = conn.prepareStatement(sql);
			//��3����ִ�в�����
			rs =ps.executeQuery();
			//�õ���¼����
			int num = 0;
			while(rs.next()) {
				num++;
			}
			rs.close();
			foods = new Object[num][];
			
			rs = ps.executeQuery();
			int i =0;
			//��4������ȡ���� ��
			while(rs.next()) {
				foods[i] =new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
				i++;
			}
			//��5�����رն���			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}		
		return foods;
	}


	//���±������
	@Override
	public int update(Food updateFood) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			//��1������ȡ�����ӣ�
			conn =JdbcUtil.getConnection();
			//��2��������PreparedStatement����;
			String sql="update food set id=?,foodName=?,Foodid=?,price=?";
			ps = conn.prepareStatement(sql);
			//��3����ִ�в�����
			ps.setString(1, updateFood.getId());
			ps.setString(2, updateFood.getFoodname());
			ps.setString(3,updateFood.getFoodid());
			ps.setString(4, updateFood.getPrice());
			
			return ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			JdbcUtil.close(null, ps, conn);
		}		
		return 0;
	}






	
	
	//�������
	@Override
	public int insert(Food food) {
			Connection conn = null;
			PreparedStatement ps =null;
			try {
				 conn = JdbcUtil.getConnection();
				 String insertSql="insert into food values(?,?,?,?)";
				 ps = conn.prepareStatement(insertSql);
				 ps.setString(1, food.getId());
				 ps.setString(2, food.getFoodname());
				 ps.setString(3, food.getFoodid());
				 ps.setString(4, food.getPrice());
				 return ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(null, ps, conn);
			}
			return 0;
	}
	
	@Override
	public Object[][] listFood() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Object[][] foods =null;
		try {
			//��1������ȡ����
			conn = JdbcUtil.getConnection();
			//��2��������PreparedStatement����
			String sql="select * from Food";
			ps = conn.prepareStatement(sql);
			//��3����ִ�в�����
			rs =ps.executeQuery();
			//�õ���¼����
			int num = 0;
			while(rs.next()) {
				num++;
			}
			rs.close();
			foods = new Object[num][];
			rs = ps.executeQuery();
			int i =0;
			//��4������ȡ���� ��
			while(rs.next()) {
				foods[i] =new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
				i++;
			}
			//��5�����رն���	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
		return foods;
	}



}


