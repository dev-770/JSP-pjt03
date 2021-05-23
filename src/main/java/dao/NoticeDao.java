package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import dto.NoticeDto;
import process.Jdbc;

public class NoticeDao {
	private static NoticeDao nDao;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int result = 0;
	
	/* 싱글톤 패턴 */
	private NoticeDao () {}
	public static NoticeDao getInstance() {
		 if(nDao == null)
			 nDao = new NoticeDao();
		return nDao;
	}
	
	/* max idx값 추출 */
	public int nextval() {
		String sql = "Select max(idx) from notice";
		try {
			con = Jdbc.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next())
				result = rs.getInt("max(idx)");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Jdbc.close(con, pstmt, rs);
		}
		return result;
	}
	
	/* DB insert */
	public int write (NoticeDto nDto) {
		StringBuffer sql  = new StringBuffer();
		sql.append("Insert into notice ");
		sql.append("(idx, subject, content, regdate, filename, hit, id, parent, sort, tab)");
		sql.append("values(?, ?, ?, sysdate(), ?, 0, ?, ?, 0, 0)");
		
		try {
			con = Jdbc.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, nDto.getIdx());
			pstmt.setString(2, nDto.getSubject());
			pstmt.setString(3, nDto.getContent());
			pstmt.setString(4, nDto.getFilename());
			pstmt.setString(5, nDto.getId());
			pstmt.setInt(6, nDto.getParent());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(con, pstmt);
		}
		return result;
	}
	
	/* 게시판 list 추출 */
	public List<NoticeDto> selectList(int start, int end, String text) {
		
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		
		if(text == null) { // 게시판 리스트 출력
		
		StringBuffer sql = new StringBuffer(); // ROWNUM 가상 필드
		sql.append("Select *from");
		sql.append("( select @ROWNUM:= @ROWNUM+1 AS rn, A.* from");
		sql.append("( select * from notice order by parent desc, sort desc )A)B");
		sql.append("inner join(select @rownum:=0)TEMP where rn between ? and ?");
		
		try {
			con = Jdbc.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				NoticeDto nDto = new NoticeDto(); // 호출할 때 마다 객체 생성
				
				nDto.setIdx(rs.getInt("idx"));
				nDto.setSubject(rs.getString("subject"));
				nDto.setContent(rs.getString("content"));
				nDto.setRegdate(rs.getDate("regdate"));
				nDto.setFilename(rs.getString("filename"));
				nDto.setHit(rs.getInt("hit"));
				nDto.setId(rs.getString("id"));
				nDto.setParent(rs.getInt("parent"));
				nDto.setSort(rs.getInt("sort"));
				nDto.setTab(rs.getInt("tab"));

				list.add(nDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(con, pstmt, rs);
		}
		} else if (text != null) { // 검색 텍스트가 있다면

			StringBuffer sql = new StringBuffer(); // ROWNUM 가상 필드
			sql.append("Select *from");
			sql.append("( select @ROWNUM:= @ROWNUM+1 AS rn, A.* from");
			sql.append("( select * from notice where subject like ? order by parent desc, sort desc )A)B");
			sql.append(" inner join(select @rownum:=0)TEMP where rn between ? and ?");
			
			try {
				con = Jdbc.getConnection();
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+text+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				
				rs = pstmt.executeQuery();

				while (rs.next()) {
					NoticeDto nDto = new NoticeDto(); // 호출할 때 마다 객체 생성
					
					nDto.setIdx(rs.getInt("idx"));
					nDto.setSubject(rs.getString("subject"));
					nDto.setContent(rs.getString("content"));
					nDto.setRegdate(rs.getDate("regdate"));
					nDto.setFilename(rs.getString("filename"));
					nDto.setHit(rs.getInt("hit"));
					nDto.setId(rs.getString("id"));
					nDto.setParent(rs.getInt("parent"));
					nDto.setSort(rs.getInt("sort"));
					nDto.setTab(rs.getInt("tab"));
					
					list.add(nDto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Jdbc.close(con, pstmt, rs);
			}
		}
		
		return list;
	}
	
	/* 조회수 함수 */
	public int hitUpdate(int idx) {
		String sql = "Update notice set hit = hit + 1 where idx = ?";
		
		try {
			con = Jdbc.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(con, pstmt);
		}
		return result;
	}
	
	/* DB idx 선택 */
	public NoticeDto selectById(int idx) {
		NoticeDto nDto  = new NoticeDto();
		
		String sql = "Select * from notice where idx = ?";
		
		try {
			con= Jdbc.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs  = pstmt.executeQuery();
			
			if (rs.next()) {
				
				nDto.setIdx(rs.getInt("idx"));
				nDto.setSubject(rs.getString("subject"));
				nDto.setContent(rs.getString("content"));
				nDto.setRegdate(rs.getDate("regdate"));
				nDto.setFilename(rs.getString("filename"));
				nDto.setHit(rs.getInt("hit"));
				nDto.setId(rs.getString("id"));
				nDto.setParent(rs.getInt("parent"));
				nDto.setSort(rs.getInt("sort"));
				nDto.setTab(rs.getInt("tab"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(con, pstmt, rs);
		}
		return nDto;
	}
	
	/* DB 개수  */
	public int getTotal() {
		
		String sql = "Select count(*) from notice";
		
		try {
			con = Jdbc.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(con, pstmt, rs);
		}
		return result;
	}
	
	/* 검색시 DB 계산 */
	public int getSearchCount(String text) {
		
		String sql = "select count(*) from notice where subject like ?";
		
		try {
			con = Jdbc.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+text+"%");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(con, pstmt, rs);
		}
		return result;
	}
	
	/* DB Update */
	public int update(NoticeDto nDto) {
		String sql ="update notice set subject = ?, content = ? where idx = ?";

		try {
			con = Jdbc.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nDto.getSubject());
			pstmt.setString(2, nDto.getContent());
			pstmt.setInt(3, nDto.getIdx());
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(con, pstmt);
		}
		return result;
	}
	
	/* DB Delete */
	public int delete (int idx) {
		String sql = "Delete from notice where idx = ?";
		try {
			con = Jdbc.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(con, pstmt);
		}
		return result;
	}
	
}
