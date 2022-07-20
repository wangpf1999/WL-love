package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//������
public class JdbcUtil {
	private static final String  URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "scott";
	private static final String PASSWORD = "123456";
	private static final String className = "oracle.jdbc.driver.OracleDriver";
	//���췽��˽�л�,����Ͳ��ܴ�������
	private JdbcUtil() {
		
	//�õ�����
	}
	public static Connection getConnection() {
		Connection conn = null;		
			try {
				//��������
				Class.forName(className);
				//ͨ��������ȡ����
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {e.printStackTrace();}
		      catch(SQLException e) {e.printStackTrace();}
		return conn;
	}
	//�رն���
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}