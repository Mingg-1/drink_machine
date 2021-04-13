package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import VO.MemberVO;



public class MemberDAO {
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
	
	//�α���
	public MemberVO loginSelect(String id, String pw) {
		MemberVO vo = null;

		connect();
		String sql = "select * from memberinfo where id=? and pw=?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery();
			while (rs.next()) {
				String selId = rs.getString(1);
				String selPw = rs.getString(2);
				String selName = rs.getString(3);
				String selGender = rs.getString(4);
				String selHobby = rs.getString(5);
				//�α��� �� ����� ����
				vo = new MemberVO(selId, selPw, selName, selGender, selHobby);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
	

	
	//����
	public boolean joinInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		boolean result = false;
		connect();
		String sql = "insert into memberinfo values(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPw());
			pst.setString(3, vo.getName());
			pst.setString(4, vo.getGender());
			pst.setString(5, vo.getHobby());
			int cnt = pst.executeUpdate();
			
			if(cnt>0) {
				result = true;
			}else {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return result;
	}
	
	//ȸ������, �ߺ��� ���ٴ� �����Ͽ�
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		boolean result = false;
		connect();
		String sql = "delete from memberinfo where id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);

			int cnt = pst.executeUpdate();
			
			if(cnt>0) {
				result = true;
			}else {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return result;
	}
}
