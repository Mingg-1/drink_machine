package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import VO.MemberVO;
import VO.mtrVO;

public class mtrDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	// ������ ���̽��� ����
	public void conn() {
		// 1. ����̹� �����ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ���� �Ǹ� �� ��η� ���� ����Ŭ����̹��� ã�Ƽ� ����

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// Data Source Explorer - New Oracle��Ŭ�� - Properties - Driver Properties-
			// Connection URL ����
			String user = "hr";
			String password = "hr";

			// 2. ������ ���̽� ���ᰴü(Connection) ����
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try { // ���� �� �͸� �ݱ�
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ���� ���� �ִ� ���
	public ArrayList<mtrVO> useIn() {

		ArrayList<mtrVO> al = new ArrayList<mtrVO>();

		try {
			conn();
			// 3. SQL���� �غ� ��ü(preparedStatement) ����
			String sql = "select * from INGREDIENT";
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();
			// executeQuery
			// ->resultset ��ȯ
			// selectó�� ���̺� ��ȭ�� ���� ��� ���

			// 5.ResultSet ��ü�� ����� DB���� ��������
			while (rs.next()) {

				String in_code = rs.getString(1);
				String in_name = rs.getString(2);
				int use_in_cnt = rs.getInt(3);
				int in_prc = rs.getInt(4);
				int wrh_in_cnt = rs.getInt(5);

				mtrVO vo = new mtrVO(in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt);

				al.add(vo);
				// �л� ��ü ���� �� �о����;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ���� ��Ȳ�� �Ͼ��, �� �Ͼ�� ����
			close();
		}
		return al;
	}

	// ���� ����� �߰����� �� ���� ����� ���� ������ŭ ��� ����
	public boolean updateUseIn(String in_name, int use_in_cnt) {

		boolean result = false;
		try {
			conn();
			String sql = "update student set use_in_cnt = ? where in_name =?";
			// 3. SQL ���� �غ�ü ����
			pst = conn.prepareStatement(sql);

			pst.setInt(1, use_in_cnt);
			pst.setString(2, in_name);

			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (Exception e) { // ��� ���ܻ�Ȳ ó��
			e.printStackTrace();
		} finally {// ���� ��Ȳ�� �Ͼ��, �� �Ͼ�� ����
			close();
		}
		return result;
	}
	
	// ���� â�� ��� ����
	public ArrayList<mtrVO> wrhIn() {

		ArrayList<mtrVO> al = new ArrayList<mtrVO>();

		try {
			conn();
			// 3. SQL���� �غ� ��ü(preparedStatement) ����
			String sql = "select * from INGREDIENT";
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();
			// executeQuery
			// ->resultset ��ȯ
			// selectó�� ���̺� ��ȭ�� ���� ��� ���

			// 5.ResultSet ��ü�� ����� DB���� ��������
			while (rs.next()) {

				String in_code = rs.getString(1);
				String in_name = rs.getString(2);
				int use_in_cnt = rs.getInt(3);
				int in_prc = rs.getInt(4);
				int wrh_in_cnt = rs.getInt(5);

				mtrVO vo = new mtrVO(in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt);

				al.add(vo);
				// �л� ��ü ���� �� �о����;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ���� ��Ȳ�� �Ͼ��, �� �Ͼ�� ����
			close();
		}
		return al;
	}
	
	// ���� ��� �������� �� â����� ����, ���� ��� ��������

	// �����Ͽ� ��� �߰��Ǿ��� �� â�� ������ �ֹ� �� ��ŭ ����

}
