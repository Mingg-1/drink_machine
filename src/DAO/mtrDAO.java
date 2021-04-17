package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

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

	/*
	 * ��� ���̺�(�ڵ�,����,����,�ܰ�,â�����) CREATE TABLE INGREDIENT( in_code VARCHAR2(100) NOT
	 * NULL, in_name VARCHAR2(100), use_in_cnt NUMBER(10) NOT NULL, in_prc
	 * NUMBER(10), wrh_in_cnt NUMBER(10)
	 */

	// ���� ���
	public ArrayList<mtrVO> useIn() {

		ArrayList<mtrVO> ual = new ArrayList<mtrVO>();

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

				ual.add(vo);
				// �л� ��ü ���� �� �о����;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ���� ��Ȳ�� �Ͼ��, �� �Ͼ�� ����
			close();
		}
		return ual;
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

	// ���� ��� ��������
	public void useInUpdate(mtrVO vo) {
		conn();
		try {
			String sql = "UPDATE INGREDIENT SET use_in_cnt = ? WHERE in_name = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, vo.getUse_in_cnt());
			pst.setString(2, vo.getIn_name());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close();
		}
	}

	// ���� ����� �߰����� �� ���� ����� ���� ������ŭ ��� ����
	public boolean updateUseIn(String in_name, int use_in_cnt) {

		boolean result = false;
		try {
			conn();
			String sql = "update INGREDIENT set use_in_cnt = ? where in_name =?";
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

	// �԰��ϸ� �԰��û ����Ʈ�� �ִ� �԰� Ȯ�� ���¸� ������Ʈ��
	public void reQuestlistStateUpdate(String vo) {
		conn();
		try {
			String sql = "UPDATE DELIVERY SET dvr_cnt = 'True' WHERE in_name = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo);
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close();
		}
	}

	// �����Ͽ� ��� �߰��Ǿ��� �� â�� ������ �ֹ� �� ��ŭ ����
	public void wrhUpdate(mtrVO vo) {
			conn();
			
			try {
				String sql = "select * from INGREDIENT";
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				
				int usecnt;
				
				while (rs.next()) {
					
					usecnt = rs.getInt(3);
					if(rs.getString(2).equals("����")) {
						sql = "UPDATE INGREDIENT SET wrh_in_cnt = ? WHERE in_name = '����'";
						pst = conn.prepareStatement(sql);
						
					}else if(rs.getString(2).equals("�а���")) {
						sql = "UPDATE INGREDIENT SET wrh_in_cnt = ? WHERE in_name = '�а���'";
						pst = conn.prepareStatement(sql);
						
					}else if(rs.getString(2).equals("��ũ��")) {
						sql = "UPDATE INGREDIENT SET wrh_in_cnt = ? WHERE in_name = '��ũ��'";
						pst = conn.prepareStatement(sql);
						
					}else if(rs.getString(2).equals("����")) {
						sql = "UPDATE INGREDIENT SET wrh_in_cnt = ? WHERE in_name = '����'";
						pst = conn.prepareStatement(sql);
						
					}else if(rs.getString(2).equals("����")) {
						sql = "UPDATE INGREDIENT SET wrh_in_cnt = ? WHERE in_name = '����'";
						pst = conn.prepareStatement(sql);
						
					}else if(rs.getString(2).equals("���")) {
						sql = "UPDATE INGREDIENT SET wrh_in_cnt = ? WHERE in_name = '���'";
						pst = conn.prepareStatement(sql);
						
					}else if(rs.getString(2).equals("�Ͼӱ�")) {
						sql = "UPDATE INGREDIENT SET wrh_in_cnt = ? WHERE in_name = '�Ͼӱ�'";
						pst = conn.prepareStatement(sql);
						
					}
					
				pst.setInt(1, vo.getWrh_in_cnt());
				pst.setString(2, vo.getIn_name());

				
				pst.executeUpdate();

				}} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				close();
			}
		
		}

	// ��� �ֹ� : �����Ȳ ���̺� ����
	private void orderMeasure() {
		try {
			ResultSet rs = pst.executeQuery("select * from stock;");

			// ice������ ã�� �۾�
			int currValue;
			while (rs.next()) {
				currValue = rs.getInt(3);

				// ������ 500ml�߰�
				if (rs.getString(2).equals("����")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='����';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml �߰�");
				}else if(rs.getString(2).equals("����")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='����';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml �߰�");
				}else if(rs.getString(2).equals("�а���")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='�а���';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml �߰�");
				}else if(rs.getString(2).equals("���")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='���';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml �߰�");
				}else if(rs.getString(2).equals("�Ͼӱ�")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='�Ͼӱ�';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml �߰�");
				}else if(rs.getString(2).equals("����")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='����';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml �߰�");
				}else if(rs.getString(2).equals("��ũ��")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='��ũ��';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml �߰�");
				}
				pst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	private void updateStockTable() {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from INGREDIENT;");

			while (rs.next()) {
				switch (rs.getString("item")) {
				case "�Ļ�":
				case "�����Ļ�":
				case "�ٰ�Ʈ��":
				case "���̱�":
				case "�ʹ�⵵��":
				case "��׻�":
					useFlour();
					useButter();
					useSugar();
					useEgg();
					useMilk();
					break;
					
				case "���ϻ�":
				case "���ϵ���":
					useFlour();
					useButter();
					useSugar();
					useEgg();
					useMilk();
					useBean();
					break;

				case "ũ����":
					useFlour();
					useButter();
					useSugar();
					useEgg();
					useMilk();
					useCream();
					break;
				
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// �а���
	private void useFlour() {
		consumnAmount("�а���", 200);
		System.out.println("�а��� 200g �Һ�");
	}

	// ����
	private void useButter() {
		consumnAmount("����", 30);
		System.out.println("���� 30g �Һ�");
	}

	// ���� 5�׶� �Һ�
	private void useSugar() {
		consumnAmount("����", 40);
		System.out.println("���� 40g �Һ�");
	}
	
	// ��� 2�� �Һ�
	private void useEgg() {
		consumnAmount("���", 2);
		System.out.println("��� 2�� �Һ�");
	}
	
	// �Ͼӱ�
	private void useBean() {
		consumnAmount("�Ͼӱ�", 10);
		System.out.println("�Ͼӱ� 10g �Һ�");
	}

	// ��ũ��
	private void useCream() {
		consumnAmount("��ũ��", 50);
		System.out.println("��ũ�� 50g �Һ�");
	}
	
	// ���� 120ml �Һ�
	private void useMilk() {
		consumnAmount("����", 300);
		System.out.println("���� 300ml �Һ�");
	}


	// ��Ḧ �Һ��ϴ� �޼ҵ� : �μ�(���, �Һ�)
	private void consumnAmount(String mtr_name, int in_cnt) {
		try {
			conn();
			String sql = "select * from INGREDIENT";
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			// ��ῡ �ش��ϴ� amount�� ã�� ����
			while (rs.next()) {
				if (rs.getString("in_name").equals(mtr_name))
					break;
			}
			int cnnn = rs.getInt("use_in_cnt");
			
			sql ="update INGREDIENT set use_in_cnt = ? where in_name='" + mtr_name + "'";
			pst = conn.prepareStatement(sql);
			pst.setInt(3, cnnn - in_cnt);
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
