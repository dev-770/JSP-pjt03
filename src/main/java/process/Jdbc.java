package process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Jdbc {
	private static Connection con = null;
	
	/* DBConnection ConnectionPool DB연결 */
	public static Connection getConnection() {
		try {
		Context context = new InitialContext(); //JNDI를 이용하기 위한 객체 생성
		DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
		con = source.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/* DB 닫기 */
	public static void close (Connection con, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close (Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
