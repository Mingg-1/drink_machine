package View;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
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
import javax.swing.ImageIcon;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Insets;
import javax.swing.Icon;

public class Order_in {

	private JFrame frame;
	private JComboBox<String> inname;
	private JTextField dvrcnt;
	public static DefaultTableModel model=null;
	
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
		frame = new JFrame("FRANCE Jang 발주신청");
		// 사용할 창 크기
		int use_width = 291;
		int use_heigt = 439;
		// 창 보기 좋게 띄우기 (위치계산) > 정확히 중앙에 띄우기
		int get_width = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
		int get_heigt = Toolkit.getDefaultToolkit().getScreenSize().height / 2;
		// 중앙에 뜨게 위치 계산
		int width = get_width - use_width / 2;
		int heigt = get_heigt - use_heigt / 2;
		// 창 위치 설정
		frame.setBounds(width, heigt, use_width, use_heigt);
		frame.setBackground(new Color(230, 230, 230));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//프레임참 배경이미지 적용
		ImageIcon bg = new ImageIcon("img/debg.png");
		
		JPanel background =  new JPanel() {
			@Override
			
			protected void paintComponent (Graphics g) {
				g.drawImage(bg.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		frame.setContentPane(background);
		SpringLayout sl_background = new SpringLayout();
		background.setLayout(sl_background);
	
		
		JLabel lblNewLabel = new JLabel("\uC7AC\uB8CC \uBC1C\uC8FC");
		sl_background.putConstraint(SpringLayout.WEST, lblNewLabel, 97, SpringLayout.WEST, background);
		sl_background.putConstraint(SpringLayout.SOUTH, lblNewLabel, -301, SpringLayout.SOUTH, background);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("210 밤의해변 R", Font.BOLD, 20));
		lblNewLabel.setBounds(67, 28, 142, 33);
		frame.getContentPane().add(lblNewLabel);
				
		
		ButtonGroup gender = new ButtonGroup();
		
		ImageIcon clo = new ImageIcon("img/clodl.png");
		JButton btn_reset = new JButton(clo);
		btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sl_background.putConstraint(SpringLayout.SOUTH, btn_reset, -46, SpringLayout.SOUTH, background);
		sl_background.putConstraint(SpringLayout.EAST, btn_reset, -46, SpringLayout.EAST, background);
		btn_reset.setFont(new Font("210 밤의해변 R", Font.PLAIN, 12));
		
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
		lblNewLabel_1.setFont(new Font("210 밤의해변 R", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(27, 155, 74, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC8FC\uBB38 \uC218\uB7C9");
		sl_background.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("210 밤의해변 R", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(27, 230, 74, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		//수량 입력
		dvrcnt = new JTextField();
		sl_background.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.NORTH, dvrcnt);
		sl_background.putConstraint(SpringLayout.WEST, dvrcnt, 132, SpringLayout.WEST, background);
		sl_background.putConstraint(SpringLayout.SOUTH, dvrcnt, -148, SpringLayout.SOUTH, background);
		sl_background.putConstraint(SpringLayout.EAST, dvrcnt, -46, SpringLayout.EAST, background);
		sl_background.putConstraint(SpringLayout.NORTH, btn_reset, 72, SpringLayout.SOUTH, dvrcnt);
		dvrcnt.setBounds(128, 230, 117, 25);
		frame.getContentPane().add(dvrcnt);
		dvrcnt.setColumns(10);
		 
		 JComboBox<String> inname= new JComboBox<String>();
		 inname.setFont(new Font("210 밤의해변 R", Font.PLAIN, 12));
		 sl_background.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 7, SpringLayout.NORTH, inname);
		 sl_background.putConstraint(SpringLayout.EAST, lblNewLabel_1, -19, SpringLayout.WEST, inname);
		 sl_background.putConstraint(SpringLayout.NORTH, dvrcnt, 29, SpringLayout.SOUTH, inname);
		 sl_background.putConstraint(SpringLayout.SOUTH, inname, 94, SpringLayout.SOUTH, lblNewLabel);
		 sl_background.putConstraint(SpringLayout.NORTH, inname, 64, SpringLayout.SOUTH, lblNewLabel);
		 sl_background.putConstraint(SpringLayout.WEST, inname, 133, SpringLayout.WEST, background);
		 sl_background.putConstraint(SpringLayout.EAST, inname, -46, SpringLayout.EAST, background);
		
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
		 ImageIcon btn_icon = new ImageIcon("img/adddl.png");
		 JButton btn_join = new JButton(btn_icon);
		 btn_join.setMargin(new Insets(0, 0, 0, 0));
		 sl_background.putConstraint(SpringLayout.WEST, btn_join, 51, SpringLayout.WEST, background);
		 sl_background.putConstraint(SpringLayout.EAST, btn_join, -154, SpringLayout.EAST, background);
		 sl_background.putConstraint(SpringLayout.WEST, btn_reset, 27, SpringLayout.EAST, btn_join);
		 sl_background.putConstraint(SpringLayout.SOUTH, btn_join, 0, SpringLayout.SOUTH, btn_reset);
		 sl_background.putConstraint(SpringLayout.NORTH, btn_join, 0, SpringLayout.NORTH, btn_reset);
		 btn_join.setFont(new Font("210 밤의해변 R", Font.PLAIN, 12));
			
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
							new DeliveryMain();
							new Order_in();
							frame.dispose();					
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
