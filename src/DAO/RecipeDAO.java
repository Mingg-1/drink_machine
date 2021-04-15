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
			// 1. jdbc ����̹� �����ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			// 2. �����ͺ��̽� ���ᰴü(Connection) ����
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

	// ������Ȯ�� (�α���)
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

				// ����������
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

	// �������߰�
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

	// ������ ����, �ߺ��� ���ٴ� �����Ͽ�
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