package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import VO.RecipeVO;
import VO.BreadVO;
import VO.BreadVO; 






public class RecipeDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private String brd_code;
	private int brd_cnt;
	private int brd_prc;

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
	
	//빵 테이블
		public ArrayList<BreadVO> allSelect() {
			
			ArrayList<BreadVO> al_brd = new ArrayList<BreadVO>();

			connect();
			String sql = "select * from BREAD order by brd_code";

			try {
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				while (rs.next()) {
					
					
					String brd_code = rs.getString(1);
					String brd_name = rs.getString(2);
					
					int brd_prc = rs.getInt(3);
					
	
					BreadVO vo = new BreadVO(brd_code, brd_name, brd_prc);
					
					al_brd.add(vo);
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			}
			
			return al_brd;
		}
	
	
	
	
	//빵추가
		public boolean brdInsert(BreadVO vo) {
			// TODO Auto-generated method stub
			boolean result = false;
			connect();
			
			String sql = "insert into BREAD values (?,?,?)";
			
					try {
						pst = conn.prepareStatement(sql);
						pst.setString(1, vo.getBrd_code());
						pst.setString(2, vo.getBrd_name()); //String brd_code, brd_name brd_cnt,  brd_prc
						
						pst.setInt(3, vo.getBrd_prc());
//						pst.setString(4, vo.getIn_name());
//						pst.setInt(5, vo.getRcp_cnt());
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
				
			
			
	
	
	
	
	
	//레시피 삭제 중복이 없다는 가정하에
		public boolean delete(String brdName) {
			// TODO Auto-generated method stub
			boolean result = false;
			connect();
			String sql = "delete from BREAD where brd_name=?";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, brdName);

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
		//레시피추가
		
		public boolean rcpInsert(RecipeVO vo) {
			// TODO Auto-generated method stub
			boolean result = false;
			connect();
			String sql = "insert into RECIPE values (?,?,?) ";//in_name, brd_name, rcp_cnt
			try {
				pst = conn.prepareStatement(sql);
				
				pst.setString(1, vo.getIn_name()); //String in_name,String brd_name, int rcp_cnt
				pst.setString(2, vo.getBrd_name());
				pst.setInt(3, vo.getRcp_cnt());

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
