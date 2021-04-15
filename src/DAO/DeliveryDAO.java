package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
      String sql = "select * from Delivery";

      try {
         pst = conn.prepareStatement(sql);
         rs = pst.executeQuery();
         while (rs.next()) {
            String dvr_num = rs.getString(1);
            String in_code = rs.getString(2);
            String dvr_date = rs.getString(3);
            String dvr_cnt = rs.getString(4);
            String rcv_date = rs.getString(5);
            DeliveryVO vo = new DeliveryVO(dvr_num, in_code, dvr_date, dvr_cnt, rcv_date);
            al.add(vo);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
    	  close();
      }
      return al;
   }
   
   
   public boolean InsertDelivery(DeliveryVO vo) {
      // TODO Auto-generated method stub
      
      boolean result = false;
      connect();
      String sql = "insert into Delivery values(?,?,?,?,?)";
      
      try {
         pst = conn.prepareStatement(sql);
         pst.setString(1, vo.getDvr_num());
         pst.setString(2, vo.getIn_name());
         pst.setString(3, vo.getDvr_date());
         pst.setString(4, vo.getDvr_cnt());
         pst.setString(5, vo.getRcv_date());
         
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
   
   
   public boolean deletedelivery(String id) {
      // TODO Auto-generated method stub
      boolean result = false;
      connect();
      String sql = "delete from Delivery where dvr_num=?";
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

   public Vector getMemberList() {
      // TODO Auto-generated method stub
      return null;
   }
   

   }
   
   