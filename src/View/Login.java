package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Login {

	private JFrame frame;
	private JTextField tf_id;
	private JTextField tf_pw;

	private ImageIcon icon;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("FRANCE Jang 로그인");
		frame.getContentPane().setLayout(null);
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

		// 프레임참 배경이미지 적용
		ImageIcon bg = new ImageIcon("img/logbg.png");

		JPanel panel = new JPanel() {
			@Override

			protected void paintComponent(Graphics g) {
				g.drawImage(bg.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		frame.setContentPane(panel);
		SpringLayout sl_background = new SpringLayout();
		panel.setLayout(sl_background);

		JLabel lbl_id = new JLabel("ID");
		lbl_id.setFont(new Font("210 밤의해변 R", Font.PLAIN, 17));
		lbl_id.setForeground(Color.WHITE);
		lbl_id.setBounds(683, 236, 52, 15);
		panel.add(lbl_id);

		JLabel lbl_pw = new JLabel("PW");
		sl_background.putConstraint(SpringLayout.WEST, lbl_pw, 715, SpringLayout.WEST, panel);
		sl_background.putConstraint(SpringLayout.WEST, lbl_id, 7, SpringLayout.WEST, lbl_pw);
		sl_background.putConstraint(SpringLayout.EAST, lbl_id, 0, SpringLayout.EAST, lbl_pw);
		lbl_pw.setFont(new Font("210 밤의해변 R", Font.PLAIN, 17));
		lbl_pw.setForeground(Color.WHITE);
		lbl_pw.setBounds(683, 304, 52, 15);
		panel.add(lbl_pw);

		tf_id = new JTextField();
		sl_background.putConstraint(SpringLayout.NORTH, tf_id, 240, SpringLayout.NORTH, panel);
		sl_background.putConstraint(SpringLayout.WEST, tf_id, 744, SpringLayout.WEST, panel);
		sl_background.putConstraint(SpringLayout.SOUTH, tf_id, 279, SpringLayout.NORTH, panel);
		sl_background.putConstraint(SpringLayout.EAST, tf_id, -22, SpringLayout.EAST, panel);
		sl_background.putConstraint(SpringLayout.NORTH, lbl_id, 12, SpringLayout.NORTH, tf_id);
		tf_id.setFont(new Font("210 밤의해변 R", Font.BOLD, 18));
		tf_id.setBounds(759, 233, 106, 21);
		panel.add(tf_id);
		tf_id.setColumns(10);

		tf_pw = new JPasswordField();
		sl_background.putConstraint(SpringLayout.NORTH, tf_pw, 296, SpringLayout.NORTH, panel);
		sl_background.putConstraint(SpringLayout.WEST, tf_pw, 744, SpringLayout.WEST, panel);
		sl_background.putConstraint(SpringLayout.SOUTH, tf_pw, 335, SpringLayout.NORTH, panel);
		sl_background.putConstraint(SpringLayout.EAST, tf_pw, -22, SpringLayout.EAST, panel);
		sl_background.putConstraint(SpringLayout.NORTH, lbl_pw, 12, SpringLayout.NORTH, tf_pw);
		sl_background.putConstraint(SpringLayout.EAST, lbl_pw, 0, SpringLayout.WEST, tf_pw);
		tf_pw.setFont(new Font("굴림", Font.PLAIN, 18));
		tf_pw.setBounds(759, 301, 106, 21);
		panel.add(tf_pw);
		tf_pw.setColumns(10);

		JButton btn_login = new JButton("LOGIN");
		sl_background.putConstraint(SpringLayout.NORTH, btn_login, 23, SpringLayout.SOUTH, tf_pw);
		sl_background.putConstraint(SpringLayout.WEST, btn_login, 1, SpringLayout.WEST, tf_id);
		sl_background.putConstraint(SpringLayout.SOUTH, btn_login, -203, SpringLayout.SOUTH, panel);
		sl_background.putConstraint(SpringLayout.EAST, btn_login, 0, SpringLayout.EAST, tf_id);
		btn_login.setFont(new Font("210 밤의해변 R", Font.PLAIN, 15));
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 로그인 버튼 클릭 시
				String id = tf_id.getText();
				String pw = tf_pw.getText();

				if (id.equals("admin") && pw.equals("1234")) {// 일치 시 로그인
					JOptionPane.showMessageDialog(null, "로그인 성공!");
					new SellMain(); // 성공시 메뉴 화면 출력
					frame.dispose(); // 현재 Window창 종료
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패", "로그인", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btn_login.setBounds(722, 362, 95, 23);
		panel.add(btn_login);
		
		JLabel lbl_adminlogin = new JLabel("Administrator Login");
		sl_background.putConstraint(SpringLayout.NORTH, lbl_adminlogin, -45, SpringLayout.NORTH, tf_id);
		sl_background.putConstraint(SpringLayout.SOUTH, lbl_adminlogin, -18, SpringLayout.NORTH, tf_id);
		sl_background.putConstraint(SpringLayout.EAST, lbl_adminlogin, -58, SpringLayout.EAST, panel);
		lbl_adminlogin.setForeground(Color.WHITE);
		lbl_adminlogin.setFont(new Font("210 밤의해변 R", Font.BOLD, 18));
		panel.add(lbl_adminlogin);
		

	}
}
