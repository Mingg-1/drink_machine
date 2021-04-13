import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.MemberDAO;
import VO.MemberVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	private JFrame frame;
	private JTextField tf_id;
	private JTextField tf_pw;
	CardLayout cardLayout ; //카드레이아웃 선언
	CardLayout loginLayout ; //카드레이아웃 선언
	CardLayout menuLayout ; //카드레이아웃 선언

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
		
		//발주 화면
		JPanel panel_ord = new JPanel();
		menuView.add(panel_ord, "ord");
		panel_ord.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uBC1C\uC8FC");
		lblNewLabel_1.setBounds(249, 242, 57, 15);
		panel_ord.add(lblNewLabel_1);
		
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
