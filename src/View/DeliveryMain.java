package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import DAO.MemberDAO;
import DAO.RecipeDAO;
import DAO.mtrDAO;
import VO.MemberVO;
import VO.RecipeVO;
import VO.mtrVO;
import View.Order_in;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//발주부분 import-------------------------------------------------
//import java.awt.CardLayout;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import DAO.DeliveryDAO;
import VO.BreadVO;
import VO.DeliveryVO;
import java.awt.event.ActionEvent;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

//------------------------------------------------- 발주 끝

//레시피 import----------------------------------------------------
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.RecipeDAO;
import VO.RecipeVO;
import VO.BreadVO;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
//-------------------------------------------------레시피 끝

public class DeliveryMain {

	private JFrame frame;
	CardLayout menuLayout; // 카드레이아웃 선언

	// 발주 참조 선언------------------------------------------------
	private JTable table;
	MemberDAO dao = new MemberDAO();
	DeliveryDAO daoo = new DeliveryDAO();
//	ArrayList<DeliveryVO> al = new ArrayList<DeliveryVO>();
	ArrayList<DeliveryVO> al = daoo.allSelect();
	String selected_dvr_num = "";
	String selected_rcvdate = "";
	// ----------------------------------------------------발주 끝

	// 라벨 이미지 변경쓰---------------------------------------------
	private JLabel lbl_sell, lbl_mtr, lbl_rcp, lbl_ord, lbl_sls;
	//////////////// 판매버튼///////////////////////////////////////
	// 변하는 이미지
	ImageIcon clicksell = new ImageIcon("btn/clicksell.png");
	Image clicksell1 = clicksell.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon click_sell = new ImageIcon(clicksell1);
	// 원본 이미지
	ImageIcon sellbtn = new ImageIcon("btn/sellbtn.png");
	Image sellbtn1 = sellbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon sell_btn = new ImageIcon(sellbtn1);

	//////////////// 재료버튼///////////////////////////////////////
	// 변하는 이미지
	ImageIcon clickmtr = new ImageIcon("btn/clickmtr.png");
	Image clickmtr1 = clickmtr.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon click_mtr = new ImageIcon(clickmtr1);
	// 원본 이미지
	ImageIcon mtrbtn = new ImageIcon("btn/mtrbtn.png");
	Image mtrbtn1 = mtrbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon mtr_btn = new ImageIcon(mtrbtn1);

	//////////////// 레시피버튼///////////////////////////////////////
	// 변하는 이미지
	ImageIcon clickrcp = new ImageIcon("btn/clickrcp.png");
	Image clickrcp1 = clickrcp.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon click_rcp = new ImageIcon(clickrcp1);
	// 원본 이미지
	ImageIcon rcpbtn = new ImageIcon("btn/rcpbtn.png");
	Image rcpbtn1 = rcpbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon rcp_btn = new ImageIcon(rcpbtn1);

	//////////////// 발주버튼///////////////////////////////////////
	// 변하는 이미지
	ImageIcon clickodr = new ImageIcon("btn/clickodr.png");
	Image clickodr1 = clickodr.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon click_odr = new ImageIcon(clickodr1);
	// 원본 이미지
	ImageIcon odrbtn = new ImageIcon("btn/odrbtn.png");
	Image odrbtn1 = odrbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon odr_btn = new ImageIcon(odrbtn1);

	//////////////// 매출버튼///////////////////////////////////////
	// 변하는 이미지
	ImageIcon clicksls = new ImageIcon("btn/clicksls.png");
	Image clicksls1 = clicksls.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon click_sls = new ImageIcon(clicksls1);
	// 원본 이미지
	ImageIcon slsbtn = new ImageIcon("btn/slsbtn.png");
	Image slsbtn1 = slsbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon sls_btn = new ImageIcon(slsbtn1);
	// ------------------------------------------------------라벨 끝

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryMain window = new DeliveryMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeliveryMain() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame("FRANCE Jang 발주");
		// 사용할 창 크기
		int use_width = 1029;
		int use_heigt = 631;
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
		menuLayout = new CardLayout();

//////////////		// 메뉴 화면////////////////////////////////////////////////////////////////////////

		// 이미지 불러오기
		ImageIcon mnbg = new ImageIcon("img/bg.png");
		Image img1 = mnbg.getImage();
		// 크기 조절한 이미지 불러오기
		ImageIcon mnbg1 = new ImageIcon(img1);
		// 패널을 생성하고 이미지 삽입
		JPanel menu = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(mnbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// 부모 패널에 현재 이미지를 넣은 패널을 추가
		menu.setBounds(0, 0, 1015, 594);
		frame.getContentPane().add(menu);
		menu.setLayout(null);

		// 이미지 불러오기
		ImageIcon mvbg = new ImageIcon("img/menubg.png");
		Image img2 = mvbg.getImage();
		// 크기 조절한 이미지 불러오기
		ImageIcon mvbg1 = new ImageIcon(img2);
		// 패널을 생성하고 이미지 삽입
		JPanel menuView = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(mvbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// 부모 패널에 현재 이미지를 넣은 패널을 추가
		menuView.setBounds(263, 0, 750, 592);
		menu.add(menuView);
		menuView.setLayout(menuLayout);

// 발주 화면---------------------------------------------------------------------------
		// 테이블
		String[] colname = { "주문번호", "재료이름", "발주일자", "발주수량", "도착예정" };

		String[][] data = new String[al.size()][5];
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < al.size(); i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 0) {
					data[i][j] = al.get(i).getDvr_num();
				} else if (j == 1) {
					data[i][j] = al.get(i).getIn_name();
				} else if (j == 2) {
					if (al.get(i).getDvr_date() != null) {
						data[i][j] = format.format(al.get(i).getDvr_date());
					}
				} else if (j == 3) {
					data[i][j] = al.get(i).getDvr_cnt();
				} else if (j == 4) {
					if (al.get(i).getRcv_date() != null) {
						data[i][j] = format.format(al.get(i).getRcv_date());
					}
				}
			}
		}

//테이블패널

		// 이미지 불러오기
		ImageIcon orbg = new ImageIcon("img/menubg.png");
		Image img6 = orbg.getImage(); // Image 새변수명 = ImageIcon변수명.getImage();
		// 크기 조절한 이미지 불러오기
		ImageIcon orbg1 = new ImageIcon(img6); // ImageIcon 새변수명 = new ImageIcon(Image변수);
		// 패널을 생성하고 이미지 산입
		JPanel panel_ord = new JPanel() { // JPanel 패널이름 = new JPanel()
			protected void paintComponent(Graphics g) {
				g.drawImage(orbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// 부모 패널에 현재 이미지를 넣은 패널을 추가
		menuView.add(panel_ord, "ord"); // 부모패널.add(현재패널이름, "이름");
		panel_ord.setLayout(null);

		// 이미지 불러오기
		ImageIcon ordbg = new ImageIcon("img/menubg.png");
		Image img7 = ordbg.getImage(); // Image 새변수명 = ImageIcon변수명.getImage();
		// 크기 조절한 이미지 불러오기
		ImageIcon ordbg1 = new ImageIcon(img7); // ImageIcon 새변수명 = new ImageIcon(Image변수);
		// 패널을 생성하고 이미지 산입
		JPanel panel = new JPanel() { // JPanel 패널이름 = new JPanel()
			protected void paintComponent(Graphics g) {
				g.drawImage(ordbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// 부모 패널에 현재 이미지를 넣은 패널을 추가
		panel.setBounds(0, 0, 750, 460);
		panel_ord.add(panel); // 부모패널.add(현재패널이름, "이름");
		panel.setLayout(null);

//테이블라벨
		//라벨에 이미지 추가
		ImageIcon lbl_icon = new ImageIcon("img/odrlogo.png");
		JLabel lblNewLabel_1 = new JLabel(lbl_icon); //이미지 추가 변수명 넣어주기
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(38, 29, 179, 43);
		panel.add(lblNewLabel_1);

//테이블스크롤패널
		JScrollPane scrollPane_DE;
		scrollPane_DE = new JScrollPane();
		scrollPane_DE.setBounds(38, 92, 674, 347);
		panel.add(scrollPane_DE);
		scrollPane_DE.setViewportView(table);

		// 테이블 클릭
		DefaultTableModel Model = new DefaultTableModel(data, colname);
		JTable table = new JTable(Model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();

				selected_dvr_num = (String) table.getModel().getValueAt(row, 0);
//				String selected_inname = (String) table.getModel().getValueAt(row, 1);
//				String selected_dvrdate = (String) table.getModel().getValueAt(row, 2);
//				String selected_dvrcnt = (String) table.getModel().getValueAt(row, 3);
				selected_rcvdate = (String) table.getModel().getValueAt(row, 4);

			}
		});

		table.setFillsViewportHeight(true);
		scrollPane_DE.setViewportView(table);

		// 주문페이지 추가생성 버튼
		ImageIcon btn_icon = new ImageIcon("btn/ordbtn.png");
		JButton btnNewButton = new JButton(btn_icon);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Order_in();
			}
		});

		// 주문 삭제 버튼
		ImageIcon btn_icon1 = new ImageIcon("btn/orddelbtn.png");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton.setBounds(185, 506, 122, 48);
		panel_ord.add(btnNewButton);
		JButton button = new JButton(btn_icon1);
		button.addActionListener(new ActionListener() {

			// 선택한 값의 시간을 가져오기
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < al.size(); i++) {
					if (al.get(i).getRcv_date() != null) {
						data[i][4] = format.format(al.get(i).getRcv_date());
					}
				}

				// 현재시간 - 선택한 값
				long minute = 0;
				String reqDateStr = selected_rcvdate; // ********************************************************************목표시간
														// 넣기
				// 현재시간 Date
				Date curDate = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// 요청시간을 Date로 parsing 후 time가져오기

				Date reqDate;
				try {
					reqDate = dateFormat.parse(reqDateStr);
					long reqDateTime = reqDate.getTime();
					// 현재시간을 요청시간의 형태로 format 후 time 가져오기
					curDate = dateFormat.parse(dateFormat.format(curDate));
					long curDateTime = curDate.getTime();
					// 분으로 표현
					minute = (curDateTime - reqDateTime) / 60000;
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				boolean result = daoo.deletedelivery(selected_dvr_num, minute);

				if (result == false) {
					JOptionPane.showMessageDialog(null, "주문삭제 실패 : 도착했거나 도착까지 10분 남았습니다.");
					new DeliveryMain();
					frame.dispose();

				}

				else if (result == true) {
					JOptionPane.showMessageDialog(null, "주문삭제 성공");
					new DeliveryMain();
					frame.dispose();
				}

			}
		});

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		button.setFont(new Font("굴림", Font.PLAIN, 16));
		button.setBounds(447, 491, 122, 48);
		panel_ord.add(button);

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		button.setFont(new Font("굴림", Font.PLAIN, 16));
		button.setBounds(448, 506, 122, 48);
		panel_ord.add(button);

//////////////////////		// 메뉴 목록 화면/////////////////////////////////////////////////////////////////////////////////////////

		// 이미지 불러오기
		ImageIcon mlbg = new ImageIcon("img/menulist.png");
		Image img10 = mlbg.getImage(); // Image 새변수명 = ImageIcon변수명.getImage();
		// 크기 조절한 이미지 불러오기
		ImageIcon mlbg1 = new ImageIcon(img10); // ImageIcon 새변수명 = new ImageIcon(Image변수);
		// 패널을 생성하고 이미지 산입
		JPanel menuList = new JPanel() { // JPanel 패널이름 = new JPanel()
			protected void paintComponent(Graphics g) {
				g.drawImage(mlbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// 부모 패널에 현재 이미지를 넣은 패널을 추가
		menuList.setBounds(0, 0, 264, 592);
		menu.add(menuList); // 부모패널.add(현재패널이름, "이름");
		menuList.setLayout(null);

///////////////판매 버튼///////////////////////////
		lbl_sell = new JLabel("");
		lbl_sell.setForeground(Color.WHITE);
		lbl_sell.setFont(new Font("210 밤의해변 R", Font.BOLD, 24));
		lbl_sell.setHorizontalAlignment(SwingConstants.CENTER);

		lbl_sell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new SellMain();
				frame.dispose(); // 현재 Window창 종료
			}

			// 마우스를 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_sell.setIcon(click_sell);

				// 다른버튼 원상복구
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				// lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// 마우스 눌렀을 때
				lbl_sell.setIcon(click_sell);

				// 다른버튼 원상복구
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				// lbl_sell.setIcon(sell_btn);
			}
		});

		menuList.add(lbl_sell);
		// 기본 이미지
		lbl_sell.setIcon(sell_btn);
		lbl_sell.setBounds(0, 206, 264, 51);

///////////////////////재료버튼////////////////////////////////////////////////////////////		
		lbl_mtr = new JLabel("");
		lbl_mtr.setForeground(Color.WHITE);
		lbl_mtr.setFont(new Font("210 밤의해변 R", Font.BOLD, 24));
		lbl_mtr.setHorizontalAlignment(SwingConstants.CENTER);

		lbl_mtr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MtrMain();
				frame.dispose(); // 현재 Window창 종료
			}

			// 마우스를 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_mtr.setIcon(click_mtr);
				// 다른버튼 원상복구
				// lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// 마우스 눌렀을 때
				lbl_mtr.setIcon(click_mtr);
				// 다른버튼 원상복구
				// lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}
		});
		lbl_mtr.setBounds(0, 265, 264, 51);
		menuList.add(lbl_mtr);
		lbl_mtr.setIcon(mtr_btn);

////////////////레시피 버튼////////////////////////////////////////////////////////////////		
		lbl_rcp = new JLabel("");
		lbl_rcp.setForeground(Color.WHITE);
		lbl_rcp.setFont(new Font("210 밤의해변 R", Font.BOLD, 24));
		lbl_rcp.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_rcp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RecipeMain();
				frame.dispose(); // 현재 Window창 종료
			}

			// 마우스를 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_rcp.setIcon(click_rcp);
				// 다른버튼 원상복구
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				// lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// 마우스 눌렀을 때
				lbl_rcp.setIcon(click_rcp);
				// 다른버튼 원상복구
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				// lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}
		});
		lbl_rcp.setBounds(0, 326, 264, 51);
		menuList.add(lbl_rcp);

/////////////////////발주버튼///////////////////////////////////////////////////////////////////		
		lbl_ord = new JLabel("");
		lbl_ord.setForeground(Color.WHITE);
		lbl_ord.setFont(new Font("210 밤의해변 R", Font.BOLD, 24));
		lbl_ord.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_ord.setIcon(click_odr);
				menuLayout.show(menuView, "ord");// 클릭 시 ord패널 출력
			}

			// 마우스를 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_ord.setIcon(click_odr);
				// 다른버튼 원상복구
				lbl_mtr.setIcon(mtr_btn);
				// lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// 마우스 눌렀을 때
				lbl_ord.setIcon(click_odr);
				// 다른버튼 원상복구
				lbl_mtr.setIcon(mtr_btn);
				// lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}
		});
		lbl_ord.setBounds(0, 387, 264, 51);
		menuList.add(lbl_ord);

///////////////////////////////매출버튼////////////////////////////////////////////////		
		lbl_sls = new JLabel("");
		lbl_sls.setForeground(Color.WHITE);
		lbl_sls.setFont(new Font("210 밤의해변 R", Font.BOLD, 24));
		lbl_sls.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sls.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SalesMain();
				frame.dispose(); // 현재 Window창 종료
			}

			// 마우스를 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_sls.setIcon(click_sls);
				// 다른버튼 원상복구
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				// lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// 마우스 눌렀을 때
				lbl_sls.setIcon(click_sls);
				// 다른버튼 원상복구
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				// lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}
		});
		lbl_sls.setBounds(0, 448, 264, 51);
		menuList.add(lbl_sls);

	}
}
