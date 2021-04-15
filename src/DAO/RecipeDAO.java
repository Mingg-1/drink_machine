package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import VO.MemberVO;
import VO.RecipeVO;

public class RecipeDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public void connect() {
		try {
			// 1. jdbc 드라이버 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			// 2. 데이터베이스 연결객체(Connection) 생성
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 레시피확인 (로그인)
	public RecipeVO recipeSelect(String brd_name) {
		RecipeVO vo = null;

		connect();
		String sql = "select * from RECIPE where brd_name=?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, brd_name);

			rs = pst.executeQuery();
			while (rs.next()) {
				String inName = rs.getString(1);
				String brdName = rs.getString(2);
				String rcpCnt = rs.getString(3);

				// 레시피정보
				vo = new RecipeVO(inName, brdName, rcpCnt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	// 레시피추가
	public boolean joinInsert(RecipeVO vo) {
		// TODO Auto-generated method stub
		boolean result = false;
		connect();
		String sql = "insert into RECIPE values(?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getInName());
			pst.setString(2, vo.getBrdName());
			pst.setString(3, vo.getRcpCnt());

			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	// 레시피 삭제, 중복이 없다는 가정하에
	public boolean delete(String brdName) {
		boolean result = false;
		connect();
		String sql = "delete from RECIPE where brd_name=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, brdName);

			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}