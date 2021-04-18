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
import VO.DeliveryVO;
import java.awt.event.ActionEvent;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
//------------------------------------------------- 발주 끝
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.JProgressBar;

public class SellMain {

	private JFrame frame;
	CardLayout cardLayout; // 카드레이아웃 선언
	CardLayout menuLayout; // 카드레이아웃 선언

	// 발주 참조 선언------------------------------------------------
	private JTable table;
	MemberDAO dao = new MemberDAO();
	DeliveryDAO daoo = new DeliveryDAO();
//   ArrayList<DeliveryVO> al = new ArrayList<DeliveryVO>();
	ArrayList<DeliveryVO> al = daoo.allSelect();
	String selected_dvr_num = "";
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

	ImageIcon img1 = new ImageIcon("img/1.jpg");
	Image changed_img1 = img1.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img1 = new ImageIcon(changed_img1);

	ImageIcon img2 = new ImageIcon("img/2.jpg");
	Image changed_img2 = img2.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img2 = new ImageIcon(changed_img2);

	ImageIcon img3 = new ImageIcon("img/3.jpg");
	Image changed_img3 = img1.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img3 = new ImageIcon(changed_img3);

	ImageIcon img4 = new ImageIcon("img/4.jpg");
	Image changed_img4 = img4.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img4 = new ImageIcon(changed_img4);

	ImageIcon img5 = new ImageIcon("img/5.jpg");
	Image changed_img5 = img5.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img5 = new ImageIcon(changed_img5);

	ImageIcon img6 = new ImageIcon("img/6.jpg");
	Image changed_img6 = img6.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img6 = new ImageIcon(changed_img6);

	ImageIcon img7 = new ImageIcon("img/7.jpg");
	Image changed_img7 = img7.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img7 = new ImageIcon(changed_img7);

	ImageIcon img8 = new ImageIcon("img/8.jpg");
	Image changed_img8 = img8.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img8 = new ImageIcon(changed_img8);

	ImageIcon img9 = new ImageIcon("img/9.jpg");
	Image changed_img9 = img9.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img9 = new ImageIcon(changed_img9);

	ImageIcon img10 = new ImageIcon("img/10.jpg");
	Image changed_img10 = img10.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img10 = new ImageIcon(changed_img10);

	ImageIcon img11 = new ImageIcon("img/11.jpg");
	Image changed_img11 = img1.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img11 = new ImageIcon(changed_img11);

	ImageIcon img12 = new ImageIcon("img/12.jpg");
	Image changed_img12 = img12.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img12 = new ImageIcon(changed_img12);

	ImageIcon img13 = new ImageIcon("img/13.jpg");
	Image changed_img13 = img13.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img13 = new ImageIcon(changed_img13);

	ImageIcon img14 = new ImageIcon("img/14.jpg");
	Image changed_img14 = img14.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img14 = new ImageIcon(changed_img14);

	ImageIcon img15 = new ImageIcon("img/15.jpg");
	Image changed_img15 = img15.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img15 = new ImageIcon(changed_img15);

	ImageIcon img16 = new ImageIcon("img/16.jpg");
	Image changed_img16 = img16.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img16 = new ImageIcon(changed_img16);

	ImageIcon img17 = new ImageIcon("img/1.jpg");
	Image changed_img17 = img17.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img17 = new ImageIcon(changed_img17);

	ImageIcon img18 = new ImageIcon("img/18.jpg");
	Image changed_img18 = img18.getImage().getScaledInstance(281, 184, Image.SCALE_SMOOTH);
	ImageIcon changed_icon_img18 = new ImageIcon(changed_img18);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellMain window = new SellMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SellMain() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame("FRANCE Jang 판매");
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

//////////////	      // 메뉴 화면////////////////////////////////////////////////////////////////////////

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
		

		// 판매 화면
	
		// 이미지 불러오기
				ImageIcon mnbg3 = new ImageIcon("img/menubg.png");
				Image img4 = mnbg3.getImage();
				// 크기 조절한 이미지 불러오기
				ImageIcon mnbg5 = new ImageIcon(img4);
				// 패널을 생성하고 이미지 삽입
				JPanel panel_sell = new JPanel() {
					protected void paintComponent(Graphics g) {
						g.drawImage(mnbg5.getImage(), 0, 0, null);
						setOpaque(false);
						super.paintComponent(g);
					}
				};
				// 부모 패널에 현재 이미지를 넣은 패널을 추가
				panel_sell.setBounds(0, 0, 1015, 594);
				menuView.add(panel_sell, "sell");
				panel_sell.setLayout(null);

		
		ImageIcon mnbg9 = new ImageIcon("img/menubg.png");
		Image img9 = mnbg9.getImage();
		// 크기 조절한 이미지 불러오기
		ImageIcon mnbg8 = new ImageIcon(img9);
		// 패널을 생성하고 이미지 삽입
		JPanel sell_page = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(mnbg8.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// 부모 패널에 현재 이미지를 넣은 패널을 추가
		sell_page.setBounds(0, 0, 501, 674);
		panel_sell.add(sell_page);
		sell_page.setLayout(null);

		ImageIcon mnbg11 = new ImageIcon("img/menubg.png");
		Image img11 = mnbg11.getImage();
		// 크기 조절한 이미지 불러오기
		ImageIcon mnbg811 = new ImageIcon(img11);
		// 패널을 생성하고 이미지 삽입
		JPanel next_1 = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(mnbg811.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// 부모 패널에 현재 이미지를 넣은 패널을 추가
		next_1.setBounds(0, 36, 501, 638);
		sell_page.add(next_1);
		next_1.setLayout(null);
		
		ImageIcon b1 = new ImageIcon("img/b1.png");
		JLabel bread_1 = new JLabel(b1);
		
		next_1.add(bread_1);

		bread_1.setBounds(38, 80, 155, 129);
		next_1.add(bread_1);
		
		ImageIcon t1 = new ImageIcon("btn/t1.png");
		JButton name_1 = new JButton(t1);
		name_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		name_1.setFont(new Font("210 밤의해변 R", Font.PLAIN, 12));
		name_1.setBounds(12, 219, 220, 39);
		next_1.add(name_1);

		JLabel stock_1 = new JLabel("\uC794\uACE0 : 10");
		stock_1.setForeground(Color.WHITE);
		stock_1.setHorizontalAlignment(SwingConstants.CENTER);
		stock_1.setFont(new Font("210 밤의해변 R", Font.PLAIN, 12));
		stock_1.setBounds(12, 257, 220, 25);
		next_1.add(stock_1);

		ImageIcon b2 = new ImageIcon("img/b2.png");
		JLabel bread_2 = new JLabel(b2);
		
		next_1.add(bread_2);

		bread_2.setBounds(304, 80, 155, 129);
		next_1.add(bread_2);

		ImageIcon t2 = new ImageIcon("btn/t2.png");
		JButton name_2 = new JButton(t2);
		name_2.setFont(new Font("210 밤의해변 R", Font.PLAIN, 12));
		name_2.setBounds(269, 219, 220, 39);
		next_1.add(name_2);

		JLabel stock_2 = new JLabel("\uC794\uACE0 : 8");
		stock_2.setForeground(Color.WHITE);
		stock_2.setHorizontalAlignment(SwingConstants.CENTER);
		stock_2.setFont(new Font("210 밤의해변 R", Font.PLAIN, 12));
		stock_2.setBounds(269, 257, 220, 25);
		next_1.add(stock_2);

		ImageIcon b3 = new ImageIcon("img/6.jpg");
		JLabel bread_3 = new JLabel(b3);
		bread_3.setBounds(38, 330, 155, 129);
		
		next_1.add(bread_3);

		ImageIcon t3 = new ImageIcon("btn/t3.png");
		JButton name_3 = new JButton(
				t3);
		name_3.setFont(new Font("210 밤의해변 R", Font.PLAIN, 12));
		name_3.setBounds(12, 475, 220, 39);
		next_1.add(name_3);

		JLabel stock_3 = new JLabel("\uC794\uACE0 : 6");
		stock_3.setForeground(Color.WHITE);
		stock_3.setHorizontalAlignment(SwingConstants.CENTER);
		stock_3.setFont(new Font("210 밤의해변 R", Font.PLAIN, 12));
		stock_3.setBounds(12, 516, 220, 25);
		next_1.add(stock_3);

		ImageIcon b4 = new ImageIcon("img/8.jpg");
		JLabel bread_4 = new JLabel(b4);
		
		next_1.add(bread_4);

		bread_4.setBounds(304, 330, 155, 129);
		next_1.add(bread_4);

		ImageIcon t4 = new ImageIcon("btn/t4.png");
		JButton name_4 = new JButton(
				t4);
		name_4.setFont(new Font("210 밤의해변 R", Font.PLAIN, 12));
		name_4.setBounds(269, 475, 220, 39);
		next_1.add(name_4);

		JLabel stock_4 = new JLabel("\uC794\uACE0 : 7");
		stock_4.setForeground(Color.WHITE);
		stock_4.setHorizontalAlignment(SwingConstants.CENTER);
		stock_4.setFont(new Font("210 밤의해변 R", Font.PLAIN, 12));
		stock_4.setBounds(269, 516, 220, 25);
		next_1.add(stock_4);
		
		JLabel lblNewLabel = new JLabel("   \u25B6");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 33));
		lblNewLabel.setBounds(424, 10, 65, 39);
		next_1.add(lblNewLabel);

		// ==================================================================================================================================================================================
		JLabel label = new JLabel("\uD310\uB9E4");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 183, 40);
		sell_page.add(label);
		label.setFont(new Font("210 밤의해변 R", Font.BOLD, 23));

		JPanel panel_10 = new JPanel();
		panel_10.setBounds(501, 38, 249, 420);
		panel_sell.add(panel_10);
		panel_10.setLayout(null);

		JButton btnPayment = new JButton("PAYMENT");
		btnPayment.setBounds(103, 616, 146, 56);
		panel_10.add(btnPayment);

		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setBounds(0, 616, 106, 56);
		panel_10.add(btnNewButton_1);
		
				JLabel label_2 = new JLabel("\uBA54\uB274");
				label_2.setForeground(Color.WHITE);
				label_2.setBounds(501, 0, 113, 40);
				panel_sell.add(label_2);
				label_2.setHorizontalAlignment(SwingConstants.LEFT);
				label_2.setFont(new Font("210 밤의해변 R", Font.BOLD, 22));
				
						JLabel label_3 = new JLabel("\uC218\uB7C9");
						label_3.setForeground(Color.WHITE);
						label_3.setBounds(609, 0, 46, 40);
						panel_sell.add(label_3);
						label_3.setHorizontalAlignment(SwingConstants.CENTER);
						label_3.setFont(new Font("210 밤의해변 R", Font.BOLD, 22));
						
								JLabel label_4 = new JLabel("\uAC00\uACA9");
								label_4.setForeground(Color.WHITE);
								label_4.setBounds(649, 0, 89, 40);
								panel_sell.add(label_4);
								label_4.setHorizontalAlignment(SwingConstants.CENTER);
								label_4.setFont(new Font("210 밤의해변 R", Font.BOLD, 22));
								
										JScrollPane scrollPane_2 = new JScrollPane();
										scrollPane_2.setBounds(501, 38, 249, 387);
										panel_sell.add(scrollPane_2);
										
												JLabel label_6 = new JLabel("\uCD1D \uC218\uB7C9:");
												label_6.setForeground(Color.WHITE);
												label_6.setBounds(501, 468, 249, 45);
												panel_sell.add(label_6);
												label_6.setHorizontalAlignment(SwingConstants.LEFT);
												label_6.setFont(new Font("210 밤의해변 R", Font.BOLD, 24));
												
														JLabel label_7 = new JLabel("\uCD1D \uAC00\uACA9 :");
														label_7.setForeground(Color.WHITE);
														label_7.setBounds(501, 525, 249, 45);
														panel_sell.add(label_7);
														label_7.setHorizontalAlignment(SwingConstants.LEFT);
														label_7.setFont(new Font("210 밤의해변 R", Font.BOLD, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

//////////////////////// 메뉴 목록 화면/////////////////////////////////////////////////////////////////////////////////////////

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
				new DeliveryMain();
				frame.dispose(); // 현재 Window창 종료
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