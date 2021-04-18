package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Vector;

import VO.DeliveryVO;
import VO.mtrVO;
import VO.wrhVO;

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

	/*
	 * 재료 테이블(코드,재료명,수량,단가,창고수량) CREATE TABLE INGREDIENT( in_code VARCHAR2(100) NOT
	 * NULL, in_name VARCHAR2(100), use_in_cnt NUMBER(10) NOT NULL, in_prc
	 * NUMBER(10), wrh_in_cnt NUMBER(10)
	 */
	

	// 현재 재고
	public ArrayList<mtrVO> useIn() {

		ArrayList<mtrVO> ual = new ArrayList<mtrVO>();

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

				ual.add(vo);
				// 학생 객체 생성 후 읽어오기;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 예외 상황이 일어나도, 안 일어나도 실행
			close();
		}
		return ual;
	}
	


	public ArrayList<DeliveryVO> allSelect() {
		
		ArrayList<DeliveryVO> al = new ArrayList<DeliveryVO>();

		conn();
		String sql = "select * from Delivery";

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String dvr_num = rs.getString(1);
				String in_name = rs.getString(2);
				Timestamp dvr_date = rs.getTimestamp(3);
				String dvr_cnt = rs.getString(4);
				Timestamp rcv_date = rs.getTimestamp(5);
				
				DeliveryVO vo = new DeliveryVO(dvr_num, in_name, dvr_date, dvr_cnt, rcv_date);
				al.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		return al;
	}
	
	// 현재 창고에 재고 수량
	public ArrayList<wrhVO> wrhIn() {

		ArrayList<wrhVO> wal = new ArrayList<wrhVO>();

		try {
			conn();
			// 3. SQL구문 준비 객체(preparedStatement) 생성
			String sql = "select i.in_code, i.in_name, i.use_in_cnt, i.wrh_in_cnt, d.dvr_cnt, d.in_name \r\n"
					+ "from INGREDIENT i, Delivery d \r\n"
					+ "where i.in_name=d.in_name \r\n"
			+ "order by i.in_code \r\n";
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
				int wrh_in_cnt = rs.getInt(4);
				int dvr_cnt = rs.getInt(5);
				String din_name = rs.getString(6);
				
				wrhVO wvo = new wrhVO(in_code, in_name, use_in_cnt, wrh_in_cnt, dvr_cnt, din_name);
				wal.add(wvo);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 예외 상황이 일어나도, 안 일어나도 실행
			close();
		}
		return wal;
	}
	
	
	//회원삭제, 중복이 없다는 가정하에
		public boolean delete(String in_name) {
			// TODO Auto-generated method stub
			boolean result = false;
			conn();
			String sql = "delete from INGREDIENT where in_name=? ";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, in_name);

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

	// 현재 재고 수량변경
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

	// 빵을 만들어 추가했을 때 현재 재고에서 만든 수량만큼 재료 차감
	public boolean updateUseIn(String in_name, int use_in_cnt) {

		boolean result = false;
		try {
			conn();
			String sql = "update INGREDIENT set use_in_cnt = ? where in_name =?";
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
	
	

	// 입고하면 입고요청 리스트에 있는 입고 확인 상태를 업데이트함
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



	// 재료 주문 : 재고현황 테이블 갱신
	private void orderMeasure() {
		try {
			ResultSet rs = pst.executeQuery("select * from stock;");

			// ice정보를 찾는 작업
			int currValue;
			while (rs.next()) {
				currValue = rs.getInt(3);

				// 우유면 500ml추가
				if (rs.getString(2).equals("우유")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='우유';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml 추가");
				}else if(rs.getString(2).equals("버터")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='버터';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml 추가");
				}else if(rs.getString(2).equals("밀가루")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='밀가루';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml 추가");
				}else if(rs.getString(2).equals("계란")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='계란';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml 추가");
				}else if(rs.getString(2).equals("팥앙금")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='팥앙금';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml 추가");
				}else if(rs.getString(2).equals("설탕")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='설탕';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml 추가");
				}else if(rs.getString(2).equals("생크림")) {
					pst = (PreparedStatement) conn.prepareStatement("update INGREDIENT set wrh_in_cnt = ? where item='생크림';");
					pst.setInt(1, currValue + 1);
					String currMeasure = rs.getString(2);
					System.out.println(currMeasure + " 500ml 추가");
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
				case "식빵":
				case "우유식빵":
				case "바게트빵":
				case "베이글":
				case "꽈배기도넛":
				case "모닝빵":
					useFlour();
					useButter();
					useSugar();
					useEgg();
					useMilk();
					break;
					
				case "단팥빵":
				case "단팥도넛":
					useFlour();
					useButter();
					useSugar();
					useEgg();
					useMilk();
					useBean();
					break;

				case "크림빵":
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

	// 밀가루
	private void useFlour() {
		consumnAmount("밀가루", 200);
		System.out.println("밀가루 200g 소비");
	}

	// 버터
	private void useButter() {
		consumnAmount("버터", 30);
		System.out.println("버터 30g 소비");
	}

	// 설탕 5그람 소비
	private void useSugar() {
		consumnAmount("설탕", 40);
		System.out.println("설탕 40g 소비");
	}
	
	// 계란 2개 소비
	private void useEgg() {
		consumnAmount("계란", 2);
		System.out.println("계란 2개 소비");
	}
	
	// 팥앙금
	private void useBean() {
		consumnAmount("팥앙금", 10);
		System.out.println("팥앙금 10g 소비");
	}

	// 생크림
	private void useCream() {
		consumnAmount("생크림", 50);
		System.out.println("생크림 50g 소비");
	}
	
	// 우유 120ml 소비
	private void useMilk() {
		consumnAmount("우유", 300);
		System.out.println("우유 300ml 소비");
	}


	// 재료를 소비하는 메소드 : 인수(재료, 소비량)
	private void consumnAmount(String mtr_name, int in_cnt) {
		try {
			conn();
			String sql = "select * from INGREDIENT";
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			// 재료에 해당하는 amount값 찾는 과정
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
	
	public boolean InsertDelivery1(DeliveryVO vo) {
		// TODO Auto-generated method stub
		
		boolean result = false;
		conn();
		String sql = "insert into Delivery values(Dvr_Num_seq.nextval,?,sysdate,?,sysdate+DBMS_RANDOM.VALUE(30,120)/(24*60))";
		
		try {
			pst = conn.prepareStatement(sql);
//			pst.setString(1, vo.getDvr_num());
			pst.setString(1, vo.getIn_name());
			pst.setString(2, vo.getDvr_cnt());
			
			int cnt = pst.executeUpdate();
			
			if(cnt>0) {
				result = true;
			}else {
				result = false;
			}
			
			if(result == true) {
				sql ="update INGREDIENT set use_in_cnt = ? where in_name= (select in_name from Delivery)";
				pst = conn.prepareStatement(sql);
				pst.executeUpdate();
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
