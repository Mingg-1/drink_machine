package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frame;
	private JTextField tf_id;
	private JTextField tf_pw;

	
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
		frame = new JFrame();
		frame.setBounds(100, 100, 1029, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1015, 594);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_id = new JLabel("ID : ");
		lbl_id.setBounds(683, 236, 52, 15);
		panel.add(lbl_id);
		
		JLabel lbl_pw = new JLabel("PW : ");
		lbl_pw.setBounds(683, 304, 52, 15);
		panel.add(lbl_pw);
		
		tf_id = new JTextField();
		tf_id.setBounds(759, 233, 106, 21);
		panel.add(tf_id);
		tf_id.setColumns(10);
		
		tf_pw = new JTextField();
		tf_pw.setBounds(759, 301, 106, 21);
		panel.add(tf_pw);
		tf_pw.setColumns(10);
		
		JButton btn_login = new JButton("LOGIN");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//로그인 버튼 클릭 시
				String id = tf_id.getText();
				String pw = tf_pw.getText();

				if (id.equals("admin") && pw.equals("1234")) {//일치 시 로그인
					JOptionPane.showMessageDialog(null, "로그인 성공!");
					new Main(); //성공시 메뉴 화면 출력
					frame.dispose(); //현재 Window창 종료
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패", 
							"로그인", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btn_login.setBounds(722, 362, 95, 23);
		panel.add(btn_login);
	}
}
