package View;
import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.DeliveryDAO;
import DAO.MemberDAO;
import VO.DeliveryVO;
import VO.MemberVO;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.lang.reflect.Member;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import java.awt.Rectangle;

public class Order_in {

	private JFrame frame;
	private JComboBox<String> inname;
	private JTextField dvrcnt;
	
	DeliveryDAO daoo = new DeliveryDAO();
	ArrayList<DeliveryVO> al = daoo.allSelect();
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	/**
	 * Create the application.
	 */
	public Order_in() {
		daoo.allSelect();
		initialize();
		frame.setVisible(true);
	}
	
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

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(1500, 225, 291, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC7AC\uB8CC \uBC1C\uC8FC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(67, 28, 142, 33);
		frame.getContentPane().add(lblNewLabel);
		
		ButtonGroup gender = new ButtonGroup();
		
		JButton btn_reset = new JButton("\uB418\uB3CC\uC544\uAC00\uAE30");
		
		btn_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();			
			}
		});
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		String[] colname = {"주문번호", "재료이름", "발주일자", "발주수량", "도착일자"};
		String[][] data = new String[al.size()][5];
		Timestamp[][] time = new Timestamp[al.size()][5];
		
		String[][] data1 = new String[al.size()][5];
//		Date[][] date = new Date[al.size()][5];
		for (int i = 0; i < al.size(); i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 0) {
//					data1[i][j] = al.get(i).getDvr_num();
				} 
				else if (j == 1) {
					data1[i][j] = al.get(i).getIn_name();
				}
				else if (j == 2) {
//					data1[i][j] = format1.format(al.get(i).getDvr_date());
				}
				else if (j == 3) {
					data1[i][j] = al.get(i).getDvr_cnt();
				}
				else if (j == 4) {
//					data1[i][j] = format1.format(al.get(i).getRcv_date());
				}
			}
		}
		
		
		
		btn_reset.setBounds(27, 348, 109, 23);
		frame.getContentPane().add(btn_reset);
		
		ArrayList<MemberVO> a2 = new ArrayList<MemberVO>();
		
		//추가

		JLabel lblNewLabel_1 = new JLabel("\uC7AC\uB8CC \uBAA9\uB85D");
		lblNewLabel_1.setBounds(27, 155, 74, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC8FC\uBB38 \uC218\uB7C9");
		lblNewLabel_2.setBounds(27, 230, 74, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		//수량 입력
		dvrcnt = new JTextField();
		dvrcnt.setBounds(128, 230, 117, 25);
		frame.getContentPane().add(dvrcnt);
		dvrcnt.setColumns(10);
		 
		 JComboBox<String> inname= new JComboBox<String>();
		
		 inname.setBounds(128, 157, 116, 21);
		 frame.getContentPane().add(inname);
		
		
		 try {
			 	connect();
				String q = "select in_name from INGREDIENT";
				pst = conn.prepareStatement(q);
				rs = pst.executeQuery();
				
						
				while(rs.next()) {
					String in_name = rs.getString("in_name");
					inname.addItem(in_name);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close();
			}
		 JButton btn_join = new JButton("\uCD94\uAC00");
			
			btn_join.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					frame.dispose();
					
//					String num = dvrnum.getText();
					String name = inname.getSelectedItem().toString();
					String cnt = dvrcnt.getText();
					
					if(name != "" && cnt != "") {
						
						MemberDAO dao = new MemberDAO();
						DeliveryDAO daoo = new DeliveryDAO();
						DeliveryVO vo = new DeliveryVO(null, name, null, cnt, null);
						
						boolean result = daoo.InsertDelivery(vo);
						
						
						if(result == true) {
							JOptionPane.showMessageDialog(null, "주문 성공");
							
//				            //추가버튼 클릭시, JTable에 행 데이터 추가
//				            //->먼저 사용자가 입력한 4개의 정보를 가져오기
//				            String num = deliveryVO.getDvr_num();
//				            String name = txt_java.getText();
//				            String  = txt_iot.getText();
//				            String web = txt_web.getText();
//				            
//				            //4개의 정보를 콘솔창에 출력하시오
//				            System.out.println(name+"/"+ java+"/"+ iot+"/"+ web);
//				            String[] rowData = {name, java, iot, web};
//				            model.addRow(rowData);
							
							new DeliveryMain();
							new Order_in();
							frame.dispose();
							
							DefaultTableModel model = new DefaultTableModel(data1, colname);
							JTable table = new JTable(model);
							table.updateUI();
						
						}
						else {
							JOptionPane.showMessageDialog(null, "주문실패", "주문", JOptionPane.ERROR_MESSAGE);	
							frame.dispose();	
							new Order_in();	
						}		
					}	
				}
			});
			btn_join.setBounds(148, 348, 109, 23);
			frame.getContentPane().add(btn_join);
		
		
	}
	
	
	
}
