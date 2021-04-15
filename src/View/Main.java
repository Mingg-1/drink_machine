package View;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.MemberDAO;
import VO.MemberVO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

//발주부분 import-------------------------------------------------
//import java.awt.CardLayout;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import DAO.DeliveryDAO;
//import DAO.MemberDAO;
import VO.DeliveryVO;
//import VO.MemberVO;
//import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.text.SimpleDateFormat;
import javax.swing.AbstractButton;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
//------------------------------------------------- 발주 끝


public class Main {

	private JFrame frame;
	private JTextField tf_id;
	private JTextField tf_pw;
	CardLayout cardLayout ; //카드레이아웃 선언
	CardLayout loginLayout ; //카드레이아웃 선언
	CardLayout menuLayout ; //카드레이아웃 선언

	//발주 참조 선언------------------------------------------------
	private JTable table;
	MemberDAO dao = new MemberDAO();
	DeliveryDAO daoo = new DeliveryDAO();
//	ArrayList<DeliveryVO> al = new ArrayList<DeliveryVO>();
	ArrayList<DeliveryVO> al = daoo.allSelect();
	String selected_dvr_num = "";
	//----------------------------------------------------발주 끝
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1029, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cardLayout = new CardLayout();
		frame.getContentPane().setLayout(cardLayout);
		
		loginLayout = new CardLayout();
		menuLayout = new CardLayout();
		
		//로그인 화면
		JPanel login = new JPanel(loginLayout);
		frame.getContentPane().add(login, "login");
		login.setLayout(null);
		
		tf_id = new JTextField();
		tf_id.setBounds(751, 222, 116, 21);
		login.add(tf_id);
		tf_id.setColumns(10);
		
		tf_pw = new JTextField();
		tf_pw.setBounds(751, 278, 116, 21);
		login.add(tf_pw);
		tf_pw.setColumns(10);
		
		JLabel lbl_id = new JLabel("ID :");
		lbl_id.setBounds(653, 225, 57, 15);
		login.add(lbl_id);
		
		JLabel lbl_pw = new JLabel("PW :");
		lbl_pw.setBounds(653, 281, 57, 15);
		login.add(lbl_pw);
		
		JButton btn_login = new JButton("LOGIN");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//로그인 버튼 클릭 시
				String id = tf_id.getText();
				String pw = tf_pw.getText();

				if (id.equals("admin") && pw.equals("1234")) {//일치 시 로그인
					JOptionPane.showMessageDialog(null, "로그인 성공!");
					cardLayout.show(frame.getContentPane(), "menu_main"); //성공시 메뉴 화면 출력
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패", 
							"로그인", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btn_login.setBounds(714, 343, 97, 23);
		login.add(btn_login);
		
		//메뉴 화면
		JPanel menu = new JPanel();
		frame.getContentPane().add(menu, "menu_main");
		menu.setLayout(null);
		
		JPanel menuView = new JPanel();
		menuView.setBounds(263, 0, 750, 592);
		menu.add(menuView);
		menuView.setLayout(menuLayout);
		
		
		//판매 화면
		JPanel panel_sell = new JPanel();
		menuView.add(panel_sell, "sell");
		panel_sell.setLayout(null);
		
		JLabel label = new JLabel("\uD310\uB9E4");
		label.setBounds(363, 5, 24, 15);
		panel_sell.add(label);
		
		//재료관리 화면
		JPanel panel_mtr = new JPanel();
		menuView.add(panel_mtr, "mtr");
		panel_mtr.setLayout(null);
		
		JLabel label_1 = new JLabel("\uC7AC\uB8CC\uAD00\uB9AC");
		label_1.setBounds(333, 199, 57, 15);
		panel_mtr.add(label_1);
		
		//레시피 화면
		JPanel panel_rcp = new JPanel();
		menuView.add(panel_rcp, "rcp");
		panel_rcp.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB808\uC2DC\uD53C");
		lblNewLabel.setBounds(239, 252, 57, 15);
		panel_rcp.add(lblNewLabel);
		
		// 발주 화면---------------------------------------------------------------------------
		
		// 테이블
		String[] colname = { "주문번호", "재료이름", "발주일자", "발주수량", "도착일자" };

		String[][] data = new String[al.size()][5];
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < al.size(); i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 0) {
					data[i][j] = al.get(i).getDvr_num();
				} 
				else if (j == 1) {
					data[i][j] = al.get(i).getIn_name();
				}
				else if (j == 2) {
					if(al.get(i).getDvr_date()!=null) {
						data[i][j] = format.format(al.get(i).getDvr_date());		
					}
				}
				else if (j == 3) {
					data[i][j] = al.get(i).getDvr_cnt();
				}
				else if (j == 4) {
					if(al.get(i).getRcv_date()!=null) {
						data[i][j] = format.format(al.get(i).getRcv_date());
					}
				}
			}
		}
		
		//테이블패널
		JPanel panel_ord = new JPanel();
		menuView.add(panel_ord, "ord");
		panel_ord.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(23, 10, 715, 450);
		panel_ord.add(panel);
		panel.setLayout(null);
		
		//테이블라벨
		JLabel lblNewLabel_1 = new JLabel("\uBC1C\uC8FC \uAD00\uB9AC");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(268, 10, 179, 43);
		panel.add(lblNewLabel_1);
		
		//테이블스크롤패널
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 99, 674, 347);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		//테이블 클릭  ********************************************살짝 오류있음 빈칸 누를시 오류뜨는거 차후 수정
		JTable table = new JTable(data, colname);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();		
				selected_dvr_num = (String) table.getModel().getValueAt(row, 0);
				String selected_inname = (String) table.getModel().getValueAt(row, 1);
				String selected_dvrdate = (String) table.getModel().getValueAt(row, 2);
				String selected_dvrcnt = (String) table.getModel().getValueAt(row, 3);
				String selected_rcvdate = (String) table.getModel().getValueAt(row, 4);
			}
		});

		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		//아직 못만든 콤보박스
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(594, 68, 109, 21);
		panel.add(comboBox);
		
		//주문페이지 추가생성 버튼
		JButton btnNewButton = new JButton("\uC8FC\uBB38");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Order_in();
			}
		});

		//주문 삭제 버튼
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton.setBounds(185, 506, 122, 48);
		panel_ord.add(btnNewButton);
		JButton button = new JButton("\uC8FC\uBB38 \uC0AD\uC81C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = daoo.deletedelivery(selected_dvr_num);
				if (result == true) {
					JOptionPane.showMessageDialog(null, "주문삭제 성공");
					new Main();
				}
				else {
					JOptionPane.showMessageDialog(null, "주문삭제 실패");
				}
			}
		});
		
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		button.setFont(new Font("굴림", Font.PLAIN, 16));
		button.setBounds(448, 506, 122, 48);
		panel_ord.add(button);
		
		//매출화면
		JPanel panel_sls = new JPanel();
		menuView.add(panel_sls, "sls");
		panel_sls.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uB9E4\uCD9C");
		lblNewLabel_2.setBounds(304, 271, 57, 15);
		panel_sls.add(lblNewLabel_2);
		
		
		//메뉴 목록 화면
		JPanel menuList = new JPanel();
		menuList.setBounds(0, 0, 264, 592);
		menu.add(menuList);
		menuList.setLayout(null);
		
		JLabel lbl_sell = new JLabel("\uD310\uB9E4");
		lbl_sell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				menuLayout.show(menuView, "sell");//클릭 시 sell패널 출력
			}
		});
		lbl_sell.setBounds(99, 133, 57, 15);
		menuList.add(lbl_sell);
		
		JLabel lbl_mtr = new JLabel("\uC7AC\uB8CC\uAD00\uB9AC");
		lbl_mtr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuLayout.show(menuView, "mtr");//클릭 시 mtr패널 출력
			}
		});
		lbl_mtr.setBounds(99, 180, 57, 15);
		menuList.add(lbl_mtr);
		
		JLabel lbl_rcp = new JLabel("\uB808\uC2DC\uD53C");
		lbl_rcp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuLayout.show(menuView, "rcp");//클릭 시 rcp패널 출력				
			}
		});
		lbl_rcp.setBounds(99, 226, 57, 15);
		menuList.add(lbl_rcp);
		
		JLabel lbl_ord = new JLabel("\uBC1C\uC8FC");
		lbl_ord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuLayout.show(menuView, "ord");//클릭 시 ord패널 출력
			}
		});
		lbl_ord.setBounds(99, 280, 57, 15);
		menuList.add(lbl_ord);
		
		JLabel lbl_sls = new JLabel("\uB9E4\uCD9C");
		lbl_sls.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuLayout.show(menuView, "sls");//클릭 시 sls패널 출력
			}
		});
		lbl_sls.setBounds(99, 341, 57, 15);
		menuList.add(lbl_sls);
		
	}
}
