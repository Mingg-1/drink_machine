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

	// 데이터 베이스와 연결
	public void conn() {
		// 1. 드라이버 동적로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 실행 되면 이 경로로 가서 오라클드라이버를 찾아서 실행

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// Data Source Explorer - New Oracle우클릭 - Properties - Driver Properties-
			// Connection URL 복사
			String user = "hr";
			String password = "hr";

			// 2. 데이터 베이스 연결객체(Connection) 생성
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try { // 실행 된 것만 닫기
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
	// 현재 쓰고 있는 재고
	public ArrayList<mtrVO> useIn() {

		ArrayList<mtrVO> al = new ArrayList<mtrVO>();

		try {
			conn();
			// 3. SQL구문 준비 객체(preparedStatement) 생성
			String sql = "select * from INGREDIENT";
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();
			// executeQuery
			// ->resultset 반환
			// select처럼 테이블에 변화가 없을 경우 사용

			// 5.ResultSet 객체에 저장된 DB정보 가져오기
			while (rs.next()) {

				String in_code = rs.getString(1);
				String in_name = rs.getString(2);
				int use_in_cnt = rs.getInt(3);
				int in_prc = rs.getInt(4);
				int wrh_in_cnt = rs.getInt(5);

				mtrVO vo = new mtrVO(in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt);

				al.add(vo);
				// 학생 객체 생성 후 읽어오기;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 예외 상황이 일어나도, 안 일어나도 실행
			close();
		}
		return al;
	}

	// 빵을 만들어 추가했을 때 현재 재고에서 만든 수량만큼 재료 차감
	public boolean updateUseIn(String in_name, int use_in_cnt) {

		boolean result = false;
		try {
			conn();
			String sql = "update student set use_in_cnt = ? where in_name =?";
			// 3. SQL 구문 준비객체 생성
			pst = conn.prepareStatement(sql);

			pst.setInt(1, use_in_cnt);
			pst.setString(2, in_name);

			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (Exception e) { // 모든 예외상황 처리
			e.printStackTrace();
		} finally {// 예외 상황이 일어나도, 안 일어나도 실행
			close();
		}
		return result;
	}
	
	// 현재 창고에 재고 수량
	public ArrayList<mtrVO> wrhIn() {

		ArrayList<mtrVO> al = new ArrayList<mtrVO>();

		try {
			conn();
			// 3. SQL구문 준비 객체(preparedStatement) 생성
			String sql = "select * from INGREDIENT";
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();
			// executeQuery
			// ->resultset 반환
			// select처럼 테이블에 변화가 없을 경우 사용

			// 5.ResultSet 객체에 저장된 DB정보 가져오기
			while (rs.next()) {

				String in_code = rs.getString(1);
				String in_name = rs.getString(2);
				int use_in_cnt = rs.getInt(3);
				int in_prc = rs.getInt(4);
				int wrh_in_cnt = rs.getInt(5);

				mtrVO vo = new mtrVO(in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt);

				al.add(vo);
				// 학생 객체 생성 후 읽어오기;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 예외 상황이 일어나도, 안 일어나도 실행
			close();
		}
		return al;
	}
	
	// 현재 재고를 보충했을 때 창고재고 차감, 현재 재고 가득차기

	// 발주하여 재고가 추가되었을 때 창고 재고수량 주문 수 만큼 증가

}
