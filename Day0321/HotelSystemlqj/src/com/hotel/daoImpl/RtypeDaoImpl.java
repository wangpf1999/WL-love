package com.hotel.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.hotel.dao.RtypeDao;

import DBUtil.JdbcUtil;

public class RtypeDaoImpl implements RtypeDao {

	@Override
	public Map<String, String> list() {
		Map<String,String> map = new HashMap<String,String>();
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select*from tb_rtype";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) { 
				map.put(String.valueOf(rs.getInt("tid")),rs.getString("rtype"));
			}
		} 
		catch (Exception e) {}
		finally {
			JdbcUtil.close(rs, ps, conn);
		}
		return map;
	}

}
