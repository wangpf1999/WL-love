package com.hotel.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.hotel.dao.MajorDao;

import DBUtil.JdbcUtil;



public class MajorDaoImpl implements MajorDao{

	@Override
	public Map<String, String> list(String x) {
		Map<String,String> map = new HashMap <String,String> ();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=JdbcUtil.getConnection();
			String sql="select * from HT_ROOM where rtype like '%"+x+"%'";
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				map.put(String.valueOf(rs.getString("risempty")), rs.getString("rnum"));
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JdbcUtil.close(rs, ps, conn);
		}
		
		return map;
	}

}
