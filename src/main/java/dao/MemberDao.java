package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import dto.MemberDto;
import process.Jdbc;
public class MemberDao {
	private static MemberDao mDao;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private int result = 0;
	
	/* 싱글톤 패턴 */
	private MemberDao() {	}
	public static MemberDao getInstance() {
		if(mDao == null)
			mDao = new MemberDao();
		return mDao;
	}
	
	public int join (MemberDto mDto) {
		con = Jdbc.getConnection();

		StringBuffer sql = new StringBuffer();
		sql.append("Insert into member");
		sql.append("(id, pw, name, nickname, email, phone, zip, addr1, addr2) ");
		sql.append("values(?,?,?,?,?,?,?,?,?);");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mDto.getId());
			pstmt.setString(2, mDto.getPassword());
			pstmt.setString(3, mDto.getName());
			pstmt.setString(4, mDto.getNickname());
			pstmt.setString(5, mDto.getEmail());
			pstmt.setString(6, mDto.getPhone());
			pstmt.setString(7, mDto.getZip());
			pstmt.setString(8, mDto.getAddr1());
			pstmt.setString(9, mDto.getAddr2());
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Jdbc.close(con, pstmt);
		}
		return result;
	}
	
	public int login (String id, String password) {
		String sql = "Select pw, nickname from member where id = ?";
		MemberDto mDto = new MemberDto();
		
		try {
			con = Jdbc.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if(rs.getString("pw").equals(password)) {
					mDto.setNickname(rs.getString("nickname"));
					return 1;
				} else {
					return 0;
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(con, pstmt, rs);
		}
		return -1;
	}
}
