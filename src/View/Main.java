package View;

import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.SwingConstants;

import DAO.MemberDAO;
import DAO.RecipeDAO;
import VO.MemberVO;
import VO.RecipeVO;
import View.Order_in;

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
import VO.BreadVO;
import VO.DeliveryVO;
import java.awt.event.ActionEvent;
import javax.swing.AbstractButton;
import javax.swing.table.DefaultTableModel;
//------------------------------------------------- 발주 끝

//레시피 import----------------------------------------------------
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
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

import org.omg.CORBA.INITIALIZE;

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

public class Main {

	private JFrame frame;
	CardLayout cardLayout ; //카드레이아웃 선언
	CardLayout menuLayout ; //카드레이아웃 선언

	//발주 참조 선언------------------------------------------------
	private JTable table;
	MemberDAO dao = new MemberDAO();
	DeliveryDAO daoo = new DeliveryDAO();
//	ArrayList<DeliveryVO> al = new ArrayList<DeliveryVO>();
	ArrayList<DeliveryVO> al = daoo.allSelect();
	String selected_dvr_num = "";
	//----------------------------------------------------발주 끝
	
	//레시피 참조 선언 -----------------------------------------------
	private JTextField brdName_Rcp;
	private JTextField brdCode_Rcp;
	private String brd_name;
	private JTable table1;
	private JTextField Inname_Rcp;
	private JTextField Brdname_Rcp;
	private JScrollPane scroll_RCP;
	private JScrollPane Scroll_DE;
	private JButton Button_DE_insert;
	RecipeDAO dao_brd = new RecipeDAO();
	ArrayList<BreadVO> al_brd = new ArrayList<BreadVO>();
	private JTable table_1;
	//----------------------------------------------------레시피 끝
	
	
	
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

	
	public Main() {
		initialize();
		frame.setVisible(true);
	}

	
	private void initialize() {
		frame = new JFrame();
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
		
		cardLayout = new CardLayout();
		frame.getContentPane().setLayout(cardLayout);
		menuLayout = new CardLayout();
		
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
		
		JLabel lblNewLabel = new JLabel("\uB808\uC2DC\uD53C"); //레시피 상단 글자
		lblNewLabel.setBounds(12, 10, 57, 15);
		panel_rcp.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel(); //버튼이 들어갈 패널
		panel_1.setBounds(0, 35, 738, 545);
		panel_rcp.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel registration_Rcp = new JLabel("\uC0C1\uD488\uB4F1\uB85D");
		registration_Rcp.setBounds(577, 346, 128, 30);
		registration_Rcp.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(registration_Rcp);
		
		
		brdCode_Rcp = new JTextField();//빵코드
		brdCode_Rcp.setBounds(38, 383, 100, 20);
		panel_1.add(brdCode_Rcp);
		brdCode_Rcp.setColumns(10);
		
		brdName_Rcp = new JTextField();//빵이름
		brdName_Rcp.setBounds(197, 383, 100, 20);
		panel_1.add(brdName_Rcp);
		brdName_Rcp.setColumns(10);
		
		JSpinner brdPrc_Rcp = new JSpinner();//빵가격
		brdPrc_Rcp.setBounds(337, 386, 100, 20);
		panel_1.add(brdPrc_Rcp);
		
		
		//=========================빵 등록====================================
		JButton btnInsertBrd_Rcp = new JButton("Insert");
		btnInsertBrd_Rcp.setBounds(567, 386, 159, 149);
		btnInsertBrd_Rcp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String brd_code = brdCode_Rcp.getText();
				String brd_name = brdName_Rcp.getText();
//				String in_name = inName.getText();
//				int brd_cnt = (int)brdCnt_Rcp.getValue();
				int brd_prc = (int)brdPrc_Rcp.getValue();
//				int in_cnt = inCnt.getComponentCount();
				
				
				if(brd_code!="" && brd_name!=""&&brd_prc>=0) {
					RecipeDAO dao = new RecipeDAO();
					BreadVO vo = new BreadVO(brd_code, brd_name, brd_prc);
					boolean result = dao.brdInsert(vo);
					
					if(result==true) {
						//null : 메시지창이 어떤 프레임에서 보여지기 될지 보통 null 사용
						JOptionPane.showMessageDialog(null, "레시피 등록 성공");
						new Main();//레시피 창 띄우기
//						frame.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "레시피 등록 실패","레시피 등록",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "모든 정보를 입력하시오","레시피 등록",JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
				
			}
		});
		btnInsertBrd_Rcp.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panel_1.add(btnInsertBrd_Rcp);
		
		JLabel lblNewLabel_3_Rcp = new JLabel("\uBE75\uC774\uB984");
		lblNewLabel_3_Rcp.setBounds(197, 358, 57, 15);
		panel_1.add(lblNewLabel_3_Rcp);
		
		JLabel label_2_Rcp = new JLabel("\uBE75\uCF54\uB4DC");
		label_2_Rcp.setBounds(38, 358, 57, 15);
		panel_1.add(label_2_Rcp);
		
		JLabel label_3_Rcp = new JLabel("\uBE75\uAC00\uACA9");
		label_3_Rcp.setBounds(337, 361, 57, 15);
		panel_1.add(label_3_Rcp);
		
		
		//======================레시피삭제=========================
		
		JButton btnDeleteBrd_Rcp = new JButton("\uC0AD\uC81C\uD558\uAE30");
		btnDeleteBrd_Rcp.setBounds(409, 469, 100, 44);
		btnDeleteBrd_Rcp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(brd_name!="") {
					RecipeDAO dao = new RecipeDAO();
//					RcpVO vo = new RcpVO(brd_name);
				String brd_name = brdName_Rcp.getText();
				boolean result = dao.delete(brd_name);
				
				if(result==true) {
					JOptionPane.showMessageDialog(null, "레시피삭제 성공");
					new Main();
					
				}else{
					JOptionPane.showMessageDialog(null, "레시피삭제 실패","레시피삭제",JOptionPane.ERROR_MESSAGE);
				}
				}
				
				
			}
		});
		panel_1.add(btnDeleteBrd_Rcp);
		
		
		
		
		
		
		
		//=====================레시피 리스트===================
		

		
		String[] colname_Brd = { "빵코드", "빵이름", "빵가격"};

		String[][] data_Brd = new String[al_brd.size()][3];
//		SimpleDateFormat format_Brd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < al_brd.size(); i++) {
			
			for (int j = 0; j < 3; j++) {
			
				if (j == 0) {
					data_Brd[i][j] = al_brd.get(i).getBrd_code();
				} 
				else if (j == 1) {
					data_Brd[i][j] = al_brd.get(i).getBrd_name();
				}
				else if (j == 2) {
					data_Brd[i][j] = al_brd.get(i).getBrd_prc()+"";
				}
				
				
			}
		}
		
		
		//레시피 테이블
		
		
		//레시피테이블 스크롤
		
		//======================재료 리스트======================
		
		
		
		
		//================레시피등록=============
		
		
		
		
		Inname_Rcp = new JTextField();
		Inname_Rcp.setColumns(10);
		Inname_Rcp.setBounds(38, 430, 100, 20);
		panel_1.add(Inname_Rcp);
		
		Brdname_Rcp = new JTextField();
		Brdname_Rcp.setColumns(10);
		Brdname_Rcp.setBounds(197, 430, 100, 20);
		panel_1.add(Brdname_Rcp);
		
		JSpinner Rcpcnt_Rcp = new JSpinner();
		Rcpcnt_Rcp.setBounds(337, 430, 100, 20);
		panel_1.add(Rcpcnt_Rcp);
		
		JLabel label_5_Rcp = new JLabel("\uC7AC\uB8CC\uC774\uB984");
		label_5_Rcp.setBounds(38, 454, 57, 15);
		panel_1.add(label_5_Rcp);
		
		JLabel label_6_Rcp = new JLabel("\uC7AC\uB8CC\uC774\uB984");
		label_6_Rcp.setBounds(197, 454, 57, 15);
		panel_1.add(label_6_Rcp);
		
		JLabel label_7_Rcp = new JLabel("\uC7AC\uB8CC\uC774\uB984");
		label_7_Rcp.setBounds(337, 454, 57, 15);
		panel_1.add(label_7_Rcp);
		
		JButton btnInsertIn_Rcp = new JButton("\uC7AC\uB8CC\uC124\uC815");
		btnInsertIn_Rcp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String in_name = Inname_Rcp.getText();
				String brd_name = Brdname_Rcp.getText();
				int rcp_cnt = (int)Rcpcnt_Rcp.getValue();
				
				if(in_name!="" && brd_name!=""&&rcp_cnt>=0) {
					RecipeDAO dao = new RecipeDAO();
					RecipeVO vo = new RecipeVO(in_name, brd_name, rcp_cnt);
					boolean result = dao.rcpInsert(vo);
					
					if(result==true) {
						//null : 메시지창이 어떤 프레임에서 보여지기 될지 보통 null 사용
						JOptionPane.showMessageDialog(null, "레시피 등록 성공");
						new Main();//레시피 창 띄우기
//						frame.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "레시피 등록 실패","레시피 등록",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "모든 정보를 입력하시오","레시피 등록",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnInsertIn_Rcp.setBounds(38, 469, 97, 44);
		panel_1.add(btnInsertIn_Rcp);
		
		JPanel pan_brdImg = new JPanel();
		pan_brdImg.setBounds(516, 10, 210, 163);
		panel_1.add(pan_brdImg);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(516, 185, 210, 157);
		panel_1.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 10, 491, 331);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		DefaultTableModel Model_Brd = new DefaultTableModel(data_Brd, colname_Brd);
		JTable table_1 = new JTable(Model_Brd);

		table_1.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(table_1);
		
		
		
		
		
		// 발주 화면---------------------------------------------------------------------------
		

		
		
				// 테이블
				String[] colname = { "주문번호", "재료이름", "발주일자", "발주수량", "도착예정" };

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
				JScrollPane Scroll_DE;
				Scroll_DE = new JScrollPane();
				Scroll_DE.setBounds(29, 99, 674, 347);
				panel.add(Scroll_DE);
				Scroll_DE.setViewportView(table);
				
				//테이블 클릭 
				DefaultTableModel Model = new DefaultTableModel(data, colname);
				JTable table = new JTable(Model);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = table.getSelectedRow();		
						
						selected_dvr_num = (String) table.getModel().getValueAt(row, 0);
//						String selected_inname = (String) table.getModel().getValueAt(row, 1);
//						String selected_dvrdate = (String) table.getModel().getValueAt(row, 2);
//						String selected_dvrcnt = (String) table.getModel().getValueAt(row, 3);
//						String selected_rcvdate = (String) table.getModel().getValueAt(row, 4);
						
					}
				});
				
				table.setFillsViewportHeight(true);
				Scroll_DE.setViewportView(table);
				
				//주문페이지 추가생성 버튼
				JButton Button_DE_insert;
				Button_DE_insert = new JButton("\uC8FC\uBB38");
				Button_DE_insert.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						new Order_in();
					}
				});

				//주문 삭제 버튼
				Button_DE_insert.setFont(new Font("굴림", Font.PLAIN, 16));
				Button_DE_insert.setBounds(185, 506, 122, 48);
				panel_ord.add(Button_DE_insert);
				JButton button = new JButton("\uC8FC\uBB38 \uC0AD\uC81C");
				button.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						boolean result = daoo.deletedelivery(selected_dvr_num);
						if (result == true) {
							JOptionPane.showMessageDialog(null, "주문삭제 성공");
							new Main();
							frame.dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "주문삭제 실패");
							new Main();
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
				button.setBounds(448, 506, 122, 48);
				panel_ord.add(button);
		
		
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
		lbl_sell.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				menuLayout.show(menuView, "sell");//클릭 시 sell패널 출력
			}
		});
		lbl_sell.setBounds(0, 116, 264, 47);
		menuList.add(lbl_sell);
		
		JLabel lbl_mtr = new JLabel("\uC7AC\uB8CC\uAD00\uB9AC");
		lbl_mtr.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mtr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuLayout.show(menuView, "mtr");//클릭 시 mtr패널 출력
			}
		});
		lbl_mtr.setBounds(0, 173, 264, 47);
		menuList.add(lbl_mtr);
		
		JLabel lbl_rcp = new JLabel("\uB808\uC2DC\uD53C");
		lbl_rcp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuLayout.show(menuView, "rcp");//클릭 시 rcp패널 출력				
			}
		});
		lbl_rcp.setBounds(0, 226, 264, 44);
		menuList.add(lbl_rcp);
		
		JLabel lbl_ord = new JLabel("\uBC1C\uC8FC");
		lbl_ord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuLayout.show(menuView, "ord");//클릭 시 ord패널 출력
			}
		});
		lbl_ord.setBounds(0, 280, 264, 51);
		menuList.add(lbl_ord);
		
		JLabel lbl_sls = new JLabel("\uB9E4\uCD9C");
		lbl_sls.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuLayout.show(menuView, "sls");//클릭 시 sls패널 출력
			}
		});
		lbl_sls.setBounds(0, 341, 264, 47);
		menuList.add(lbl_sls);
		
	}
}
