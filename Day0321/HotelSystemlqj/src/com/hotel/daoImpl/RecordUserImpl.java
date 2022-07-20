package com.hotel.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotel.dao.RecordUser;
import com.hotel.pojo.Menber;
import com.hotel.pojo.User;
import com.hotel.pojo.Userkf;

import DBUtil.JdbcUtil;

public class RecordUserImpl  implements RecordUser{
    User user=null;
    Menber mb=null;
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    int a;
	@Override
	public Userkf AddRecordUser(Userkf user) {
		 try {
	    	conn=JdbcUtil.getConnection();
	    	String sql="insert into HT_userinfor(uname,uphone,uidentity,unum,uindate) values(?,?,?,?,?)";
	    	ps=conn.prepareStatement(sql); 
			ps.setString(1,user.getRname());
			ps.setString(2,user.getRphonenumber());
			ps.setString(3, user.getIdentify());
			ps.setString(4, user.getRdept());
			ps.setDate(5, user.getRdate());	
			int count=ps.executeUpdate();
				System.out.println(count);		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs, ps, conn);	
		}			
			return user;
	}
	 public int pay(String name) {
	    	try {
	    		conn=JdbcUtil.getConnection();
	    		String sql="select money from t_menber where account  like  '%"+name+"%' ";
	        	ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()) {
					 a=rs.getInt("money");	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(rs, ps, conn);
			}
			return a;
	    }
		@Override
		public  void updata(String name,int a) {
			
			try {
	    		conn=JdbcUtil.getConnection();
	    		String sql="update t_menber set  money=?  where account like  '%"+name+"%' ";
	        	ps=conn.prepareStatement(sql);
	        	 ps.setLong(1,a);
	        	 int count=ps.executeUpdate();
					System.out.println(count);
	 		
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(rs, ps, conn);
			}

		}
}
