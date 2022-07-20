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
			//拿到连接对象
			conn=JdbcUtil.getConnection();
			//创建PreparedStatement对象
			String sql="select * from ht_admin where aloginid=?";
			ps=conn.prepareStatement(sql);
			//执行操作
			ps.setString(1, loginid);
			rs=ps.executeQuery();
			//获取数据
			if(rs.next()) {
				String apassword=rs.getString("apassword");
				String aloginid=rs.getString("aloginid");
				String aname=rs.getString("aname");
				//OMRapping将对象转换成关系或者将关系转换成对象
				admin =new Admin(apassword,aloginid,aname);
			}
			
		} catch (SQLException e) {}
		finally {//关闭对象
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
		//第一步获取连接
		try {
			conn=JdbcUtil.getConnection();
			//第二部，创建PreparedStatement对象
			String sql="delete from ht_userinfor where uname=?";
			ps=conn.prepareStatement(sql);
			//第三部执行操作
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
			//拿到连接对象
			conn=JdbcUtil.getConnection();
			//创建PreparedStatement对象
			String sql="select * from ht_userinfor where uname=?";
			ps=conn.prepareStatement(sql);
			//执行操作
			ps.setString(1, uname1);
			rs=ps.executeQuery();
			//获取数据
			if(rs.next()) {
				String uname=rs.getString("uname");
				String unum=rs.getString("unum");
				String uphone=rs.getString("uphone");
				String uidentity=rs.getString("uidentity");
				java.sql.Date uindate=rs.getDate("uindate");
				java.sql.Date uoutdate=rs.getDate("uoutdate");

				//OMRapping将对象转换成关系或者将关系转换成对象
				user=new User(uname, unum, uphone, uidentity, uindate, uoutdate);
			}
			
		} catch (SQLException e) {}
		finally {//关闭对象
			JdbcUtil.close(rs, ps, conn);}
		
		return user;
	}

	@Override
	public int update(User user) {
		Connection conn=null;
		PreparedStatement ps=null;
		//第一步获取连接
		try {
			conn=JdbcUtil.getConnection();
			//第二部，创建PreparedStatement对象
			String sql="update  ht_userinfor set unum=?,uidentity=?,uphone=?,uindate=?,uoutdate=? where uname=?";
			ps=conn.prepareStatement(sql);
			//第三部执行操作
			
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
			//第五步，关闭对象
			JdbcUtil.close(rs, ps, conn); 
		}
		return sh;
	}

	public void SendEmail(String roomid,String msg) {
		//协议SMTP
		 Properties pro = new  Properties();
		 //设置主机
		 pro.setProperty("mail.host", "smtp.qq.com");
		 //设置传输协议
		 pro.setProperty("mail.transport.protocol", "smtp");
		 //设置允许邮箱授权认证
		 pro.setProperty("mail.smtp.auth", "true");
		 //邮箱授权的认证(认证器)
		 Session session = Session.getDefaultInstance(pro, new Authenticator() {
			 @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("1264204322", "mnaqhdvscjidhfhd");
			}
		 });
		 //获取连接
		 Transport ts = null;
		 try {
			ts = session.getTransport();
			//连接服务器
			ts.connect("smtp.qq.com","1264204322@qq.com","mnaqhdvscjidhfhd");
			//创建邮件对象
			MimeMessage message = new MimeMessage(session);
			//发件人地址
			message.setFrom(new InternetAddress("1264204322@qq.com"));
			//收件人地址
			message.setRecipient(Message.RecipientType.TO, new InternetAddress("2762474105@qq.com"));
			//设置邮件标题
			roomid = roomid + "用户反馈";
			message.setSubject(roomid);
			//设置邮件内容
			message.setContent(msg,"text/html;charset=utf-8");
			//发邮件
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
			conn=DBUtil.JdbcUtil.getConnection();//第一步得到连接
			String sql="select * from ht_room order by rnum asc";
			ps=conn.prepareStatement(sql);//第二部创建连接对象
			rs=ps.executeQuery();//3.执行操作
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
			conn=DBUtil.JdbcUtil.getConnection();//第一步得到连接
		String sql="select * from HT_ROOM where rnum like '%"+keyword+"%'";
		if("房间号码".equals(propColumn)) {
			sql="select * from HT_ROOM where rnum like '%"+keyword+"%'";
		}else if("房间类型".equals(propColumn)){
			sql="select * from HT_ROOM where rtype like '%"+keyword+"%'";
		}else {
			sql="select * from HT_ROOM where ruser like '%"+keyword+"%'";
		}
		ps=conn.prepareStatement(sql);//第二部创建连接对象
		rs=ps.executeQuery();//3.执行操作 
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
			//第1步：获取连接
			conn = JdbcUtil.getConnection();
			//第2步：创建PreparedStatement对象；
			String sql="select * from Food where uname like '%"+ key +"%'";
			ps = conn.prepareStatement(sql);
			//第3步：执行操作；
			rs =ps.executeQuery();
			//得到记录数；
			int num = 0;
			while(rs.next()) {
				num++;
			}
			rs.close();
			foods = new Object[num][];
			
			rs = ps.executeQuery();
			int i =0;
			//第4步：获取数据 ；
			while(rs.next()) {
				foods[i] =new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
				i++;
			}
			//第5步：关闭对象；			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}		
		return foods;
	}


	//更新表格数据
	@Override
	public int update(Food updateFood) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			//第1步：获取连连接；
			conn =JdbcUtil.getConnection();
			//第2步：创建PreparedStatement对象;
			String sql="update food set id=?,foodName=?,Foodid=?,price=?";
			ps = conn.prepareStatement(sql);
			//第3步：执行操作；
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






	
	
	//添加数据
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
			//第1步：获取连接
			conn = JdbcUtil.getConnection();
			//第2步：创建PreparedStatement对象；
			String sql="select * from Food";
			ps = conn.prepareStatement(sql);
			//第3步：执行操作；
			rs =ps.executeQuery();
			//得到记录数；
			int num = 0;
			while(rs.next()) {
				num++;
			}
			rs.close();
			foods = new Object[num][];
			rs = ps.executeQuery();
			int i =0;
			//第4步：获取数据 ；
			while(rs.next()) {
				foods[i] =new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
				i++;
			}
			//第5步：关闭对象；	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
		return foods;
	}



}


