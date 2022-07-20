package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//工具类
public class JdbcUtil {
	private static final String  URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "scott";
	private static final String PASSWORD = "123456";
	private static final String className = "oracle.jdbc.driver.OracleDriver";
	//构造方法私有化,此类就不能创建对象
	private JdbcUtil() {
		
	//得到连接
	}
	public static Connection getConnection() {
		Connection conn = null;		
			try {
				//加载驱动
				Class.forName(className);
				//通过驱动获取连接
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {e.printStackTrace();}
		      catch(SQLException e) {e.printStackTrace();}
		return conn;
	}
	//关闭对象
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