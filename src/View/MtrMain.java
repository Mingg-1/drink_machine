package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
import VO.wrhVO;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
//------------------------------------------------- 발주 끝
import javax.swing.table.TableColumnModel;

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

public class MtrMain {

	private JFrame frame;
	CardLayout menuLayout; // 카드레이아웃 선언

	// 재고---------------------------------------------------------
	private DefaultTableModel model;
	private JTable mtr_table;
	private int row; // 선택한 행의 위치
	mtrDAO mdao = new mtrDAO();
	ArrayList<mtrVO> ual = new ArrayList<mtrVO>();
	ArrayList<wrhVO> wal = new ArrayList<wrhVO>();
	// ------------------------------------------------------------

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
					MtrMain window = new MtrMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MtrMain() {
		ual = mdao.useIn();
		wal = mdao.wrhIn();
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame("FRANCE Jang 재고관리");
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

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		   // 이미지 불러오기
//        ImageIcon bg = new ImageIcon("images/BG.png");
//  	Image img4 = bg.getImage(); 
		// Image 새변수명 = ImageIcon변수명.getImage();
//        // 이미지 크기 조절
//  	img4  = img4.getScaledInstance(165, 220, Image.SCALE_SMOOTH);
//     
//        // 크기 조절한 이미지 불러오기
//        ImageIcon bgch = new ImageIcon(img4);
		// ImageIcon 새변수명 = new ImageIcon(Image변수);
//        // 패널을 생성하고 이미지 산입
//        home_page = new JPanel() { //JPanel 패널이름 = new JPanel()
//              protected void paintComponent(Graphics g) {
//                 g.drawImage(bgch.getImage(), 0, 0, null); //g.drawImage(ImageIcon변수.getImage(), 0, 0, null);
//                 setOpaque(false);
//                 super.paintComponent(g);
//          }
//        };
//        // 부모 패널에  현재 이미지를 넣은 패널을 추가
//        panel.add(home_page, "home_page"); //부모패널.add(현재패널이름, "이름"); 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////재료 재고관리 화면////////////////////////////////////////////////////////////////////////////////////////////		

// 테이블 출력
// JTable 데이터 초기화
// 컬럼명은 1차원 배열, 행 데이터는 2차원 배열로 구성

		String[] colNames = { "재료코드", "재료명", "매장수량", "창고수량" };
		String[][] rowDatas = new String[ual.size()][4];

		for (int i = 0; i < ual.size(); i++) {
			for (int j = 0; j < 5; j++) {// 컬럼 수 만큼 반복
// j값에 따라 vo값이 달라지게
// 하나의 행당 하나의 회원정보가 들어있게
				if (j == 0) {
					rowDatas[i][j] = ual.get(i).getIn_code();
				} else if (j == 1) {
					rowDatas[i][j] = ual.get(i).getIn_name();
				} else if (j == 2) {
					rowDatas[i][j] = ual.get(i).getUse_in_cnt() + "";
				} else if (j == 3) {
					rowDatas[i][j] = ual.get(i).getWrh_in_cnt() + "";
				}
			}
		}

		model = new DefaultTableModel(rowDatas, colNames);
		/*
		 * rentingReload();
		 * 
		 * //- 테이블 객체를 생성하면서 모델을 넣어줌 tb_renting = new JTable(renting);
		 * 
		 * //여기는 레이아웃 코드 쏼라쏼라
		 * 
		 * // renting 목록 갱신 public void rentingReload() { renting.setRowCount(0); rent =
		 * mdao.rentingbook(userID); String[][] rentStr = new String[rent.size()][5];
		 * rentinfoVO.clear(); if (rent.size() != 0) { for (int i = 0; i < rent.size();
		 * i++) { rentinfoVO.add(i, bdao.BookAllInfo(rent.get(i).getBookid())); } for
		 * (int i = 0; i < rentinfoVO.size(); i++) { rentStr[i][0] =
		 * rentinfoVO.get(i).getTitle(); rentStr[i][1] = rentinfoVO.get(i).getAuthor();
		 * rentStr[i][2] = rentinfoVO.get(i).getEnter(); rentStr[i][3] =
		 * rentinfoVO.get(i).getTYPE(); rentStr[i][4] = rent.get(i).getReturndate();
		 * renting.addRow(new Object[] { rentStr[i][0], rentStr[i][1], rentStr[i][2],
		 * rentStr[i][3], rentStr[i][4] }); } } }
		 * 
		 */
		// 이미지 불러오기
		ImageIcon mtbg = new ImageIcon("img/menubg.png");
		Image img3 = mtbg.getImage(); // Image 새변수명 = ImageIcon변수명.getImage();
		// 크기 조절한 이미지 불러오기
		ImageIcon mtbg1 = new ImageIcon(img3); // ImageIcon 새변수명 = new ImageIcon(Image변수);
		// 패널을 생성하고 이미지 산입
		JPanel panel_mtr = new JPanel() { // JPanel 패널이름 = new JPanel()
			protected void paintComponent(Graphics g) {
				g.drawImage(mtbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// 부모 패널에 현재 이미지를 넣은 패널을 추가
		menuView.add(panel_mtr, "mtr"); // 부모패널.add(현재패널이름, "이름");
		panel_mtr.setLayout(null);

		JPanel panel_mtr1 = new JPanel();
		panel_mtr1.setBounds(12, 56, 726, 237);
		panel_mtr.add(panel_mtr1);
		panel_mtr1.setLayout(null);

// 테이블 출력시 꼭 넣어줘야 함, 패널 아래에 넣어주기!
		JScrollPane scroll_mtr = new JScrollPane();
		scroll_mtr.setBounds(0, 0, 726, 238);
		panel_mtr1.add(scroll_mtr);

//// 테이블 생성, desing에서 jtable클릭해도 됨

		JTable mtr_table = new JTable(model);
		mtr_table.setFillsViewportHeight(true);// 전체를 테이블로 채울 때
		mtr_table.setRowHeight(25);// 행높이
//mtr_table.setShowVerticalLines(false);//세로 줄 안보이게
//mtr_table.setShowHorizontalLines(false);//가로 줄 안보이게
		// 테이블 내용 가운데 정렬하기
		  DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		  dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		  TableColumnModel tcm = mtr_table.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴

		  for(int i = 0 ; i < tcm.getColumnCount() ; i++){
		   tcm.getColumn(i).setCellRenderer(dtcr); // 컬럼모델에서 컬럼의 갯수만큼 컬럼을 가져와 for문을 이용하여
		             // 각각의 셀렌더러를 아까 생성한 dtcr에 set해줌
		scroll_mtr.setViewportView(mtr_table);
		  }

		String[] cols = { "재료명", "매장 수량 부족" };
		String[][] rows = new String[ual.size()][2];

		for (int i = 0; i < ual.size(); i++) {
			for (int j = 0; j < 2; j++) {// 컬럼 수 만큼 반복

				if (j == 0) {
						rows[i][j] = ual.get(i).getIn_name();
				} else if (j == 1) {
					if(ual.get(i).getUse_in_cnt()<5) {
						rows[i][j] = ual.get(i).getUse_in_cnt() + "";
					}else {
						rows[i][j] = "-";
					}
				}
			}
		}
		model = new DefaultTableModel(rows, cols);

		////////////// 매장 내 재고부족
		JPanel use_in = new JPanel();
		use_in.setBounds(22, 338, 333, 232);
		panel_mtr.add(use_in);
		use_in.setLayout(null);

		// 테이블 출력시 꼭 넣어줘야 함, 패널 아래에 넣어주기!
		JScrollPane scroll_mtr1 = new JScrollPane();
		scroll_mtr1.setBounds(0, 0, 333, 232);
		use_in.add(scroll_mtr1);

		//// 테이블 생성, desing에서 jtable클릭해도 됨

		JTable mtr_table1 = new JTable(model);
		mtr_table1.setFillsViewportHeight(true);// 전체를 테이블로 채울 때
		mtr_table1.setRowHeight(25);// 행높이
		// mtr_table.setShowVerticalLines(false);//세로 줄 안보이게
		// mtr_table.setShowHorizontalLines(false);//가로 줄 안보이게
		
		// 테이블 내용 가운데 정렬하기
		  dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		  dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		  tcm = mtr_table1.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴

		  for(int i = 0 ; i < tcm.getColumnCount() ; i++){
		   tcm.getColumn(i).setCellRenderer(dtcr); // 컬럼모델에서 컬럼의 갯수만큼 컬럼을 가져와 for문을 이용하여
		             // 각각의 셀렌더러를 아까 생성한 dtcr에 set해줌
		   scroll_mtr1.setViewportView(mtr_table1);
		  }
		

		String[] wcols = { "재료명", "창고 수량 부족" };
		String[][] wrows = new String[ual.size()][2];

		for (int i = 0; i < ual.size(); i++) {
			for (int j = 0; j < 2; j++) {// 컬럼 수 만큼 반복

				if (j == 0) {
						wrows[i][j] = ual.get(i).getIn_name();
				} else if (j == 1) {
					if(ual.get(i).getWrh_in_cnt()<5) {
						wrows[i][j] = ual.get(i).getWrh_in_cnt() + "";
						
					}else {
						wrows[i][j] = "-";
					}
				}
			}
		}
  
		model = new DefaultTableModel(wrows, wcols);

		/////////// 창고 재고 부족
		JPanel wrh_in = new JPanel();
		wrh_in.setBounds(390, 338, 333, 232);
		panel_mtr.add(wrh_in);
		wrh_in.setLayout(null);
		
		// 테이블 출력시 꼭 넣어줘야 함, 패널 아래에 넣어주기!
		JScrollPane scroll_mtrw = new JScrollPane();
		scroll_mtrw.setBounds(0, 0, 333, 232);
		wrh_in.add(scroll_mtrw);
		
		ImageIcon mtrlogo = new ImageIcon("img/mtrlogo.png");
		JLabel lblNewLabel = new JLabel(mtrlogo);
		lblNewLabel.setBounds(12, 10, 179, 43);
		panel_mtr.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB9E4\uC7A5 \uC7AC\uACE0 \uBD80\uC871 \uC54C\uB9BC");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("210 밤의해변 R", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(22, 303, 169, 25);
		panel_mtr.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uCC3D\uACE0 \uC7AC\uACE0 \uBD80\uC871 \uC54C\uB9BC");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("210 밤의해변 R", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(390, 303, 169, 25);
		panel_mtr.add(lblNewLabel_1_1);

		//// 테이블 생성, desing에서 jtable클릭해도 됨

		JTable mtr_tablew = new JTable(model);
		mtr_tablew.setFillsViewportHeight(true);// 전체를 테이블로 채울 때
		mtr_tablew.setRowHeight(25);// 행높이
		// mtr_table.setShowVerticalLines(false);//세로 줄 안보이게
		// mtr_table.setShowHorizontalLines(false);//가로 줄 안보이게
		
		// 테이블 내용 가운데 정렬하기
		  dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		  dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		  tcm = mtr_tablew.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴

		  for(int i = 0 ; i < tcm.getColumnCount() ; i++){
		   tcm.getColumn(i).setCellRenderer(dtcr); // 컬럼모델에서 컬럼의 갯수만큼 컬럼을 가져와 for문을 이용하여
		             // 각각의 셀렌더러를 아까 생성한 dtcr에 set해줌
		   scroll_mtrw.setViewportView(mtr_tablew);
		  }
		  

		/*
		 * TableCellRenderer renderer = new MyTableCellRenderer();
		 * table.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);
		 * 
		 * public class MyTableCellRenderer extends DefaultTableCellRenderer {
		 * 
		 * @Override public Component getTableCellRendererComponent(JTable table, Object
		 * value, boolean, isSelected, boolean hasFocus, int row, int column) {
		 * Component cell = super.getTableCellRendererComponent(table, value,
		 * isSelected, hasFocus, row, column); if (!isSelected) { if (row % 2 == 0) {
		 * cell.setBackground(Global.convert_Color(색깔코드)); } else {
		 * cell.setBackground(Global.convert_Color(색깔코드)); } } return cell; } }
		 */

////////////////////////끝/////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
				new Main();
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
				lbl_mtr.setIcon(click_mtr);
				menuLayout.show(menuView, "mtr");// 클릭 시 mtr패널 출력

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
