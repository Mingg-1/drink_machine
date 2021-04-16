package DAO;


import java.util.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import VO.DeliveryVO;
import VO.MemberVO;



public class DeliveryDAO {
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
	
	//발주 테이블
	public ArrayList<DeliveryVO> allSelect() {
		
		ArrayList<DeliveryVO> al = new ArrayList<DeliveryVO>();

		connect();
		String sql = "select * from Delivery order by dvr_num";

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
	
	
	public boolean InsertDelivery(DeliveryVO vo) {
		// TODO Auto-generated method stub
		
		boolean result = false;
		connect();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return result;
	}
	
	
	public boolean deletedelivery(String id, long minute) {
		// TODO Auto-generated method stub
		boolean result = false;
		connect();
		String sql = "delete from Delivery where dvr_num=?";
		
		if(minute < -10) {
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, id);

				int cnt = pst.executeUpdate();
				
				if(cnt>0 ) {
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
		}else {
			result = false;
		}
		
		return result;
	}
	
	
	
//	 public ArrayList<DeliveryVO> allMemberReload() {
//		
//		DeliveryDAO daoo = new DeliveryDAO();
//		ArrayList<DeliveryVO> al = daoo.allSelect();     
//        .setRowCount(0);
//        
//        String[][] allMemberInfo = new String[memberList.size()][4];
//        
//        for (int i = 0; i < memberList.size(); i++) {
//           allMemberInfo[i][0] = memberList.get(i).getId();
//           allMemberInfo[i][1] = memberList.get(i).getName();
//           allMemberInfo[i][2] = memberList.get(i).getAge();
//           allMemberInfo[i][3] = memberList.get(i).getState();
//           allMemberInfo[i][4] = memberList.get(i).getState();
//           
//           admin_memberModel.addRow(new Object[] {allMemberInfo[i][0], allMemberInfo[i][1], allMemberInfo[i][2], allMemberInfo[i][3]});
//           
//     }
//
//	
//
//	}
	 
}
	
	
