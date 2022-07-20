package com.hotel.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotel.dao.RoomBookDao;
import com.hotel.pojo.RoomBook;

import DBUtil.JdbcUtil;

public class RoomBookDaoImpl implements RoomBookDao {

	@Override
	public int insert(RoomBook roomBook) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.JdbcUtil.getConnection();
			String insertSql="insert into tb_room values(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(insertSql);
			ps.setInt(1, roomBook.getRnum());
			ps.setInt(2, roomBook.getRlayer());
			ps.setString(3, roomBook.getRuname());
			ps.setInt(4, roomBook.getRuid());
			ps.setInt(5, roomBook.getRutel());
			ps.setInt(6, roomBook.getTid());
			ps.setString(7, roomBook.getRtype());
			ps.setInt(8,roomBook.getRprice());
			ps.setDate(9, roomBook.getRtime());
			ps.setInt(10, roomBook.getRcost());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.JdbcUtil.close(null, ps, conn);
		}
		return 0;
	}

	@Override
	public Object[][] list() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Object[][] room =null;
		try {
			//��1������ȡ����
			conn = DBUtil.JdbcUtil.getConnection();
			//��2��������PreparedStatement����
			String sql="select * from tb_room";
			ps = conn.prepareStatement(sql);
			//��3����ִ�в�����
			rs =ps.executeQuery();
			//�õ���¼����
			int num = 0;
			while(rs.next()) {
				num++;
			}
			rs.close();
			room = new Object[num][];
			
			rs = ps.executeQuery();
			int i =0;
			//��4������ȡ���� ��
			while(rs.next()) {
				room[i] =new Object[] {rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getDate(9),rs.getInt(10)};
				i++;
			}
			//��5�����رն���
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
		
		return room;
	}

	@Override
	public int delete(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
