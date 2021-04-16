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

public class Login {

	private JFrame frame;
	private JTextField tf_id;
	private JTextField tf_pw;

	private ImageIcon icon;
	private JPasswordField passwordField;

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
		frame = new JFrame("br.Jang �α���");
		frame.getContentPane().setLayout(null);
		// ����� â ũ��
		int use_width = 1029;
		int use_heigt = 631;
		// â ���� ���� ���� (��ġ���) > ��Ȯ�� �߾ӿ� ����
		int get_width = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
		int get_heigt = Toolkit.getDefaultToolkit().getScreenSize().height / 2;
		// �߾ӿ� �߰� ��ġ ���
		int width = get_width - use_width / 2;
		int heigt = get_heigt - use_heigt / 2;
		// â ��ġ ����
		frame.setBounds(width, heigt, use_width, use_heigt);
		frame.setBackground(new Color(230, 230, 230));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �������� ����̹��� ����
		ImageIcon bg = new ImageIcon("img/log.png");

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
		sl_background.putConstraint(SpringLayout.WEST, lbl_id, 793, SpringLayout.WEST, panel);
		lbl_id.setForeground(Color.WHITE);
		lbl_id.setBounds(683, 236, 52, 15);
		panel.add(lbl_id);

		JLabel lbl_pw = new JLabel("PW");
		sl_background.putConstraint(SpringLayout.WEST, lbl_pw, 785, SpringLayout.WEST, panel);
		lbl_pw.setForeground(Color.WHITE);
		sl_background.putConstraint(SpringLayout.EAST, lbl_pw, 0, SpringLayout.EAST, lbl_id);
		lbl_pw.setBounds(683, 304, 52, 15);
		panel.add(lbl_pw);

		tf_id = new JTextField();
		sl_background.putConstraint(SpringLayout.NORTH, tf_id, 232, SpringLayout.NORTH, panel);
		sl_background.putConstraint(SpringLayout.WEST, tf_id, 814, SpringLayout.WEST, panel);
		sl_background.putConstraint(SpringLayout.EAST, tf_id, -70, SpringLayout.EAST, panel);
		sl_background.putConstraint(SpringLayout.NORTH, lbl_id, 3, SpringLayout.NORTH, tf_id);
		sl_background.putConstraint(SpringLayout.EAST, lbl_id, 0, SpringLayout.WEST, tf_id);
		tf_id.setBounds(759, 233, 106, 21);
		panel.add(tf_id);
		tf_id.setColumns(10);

		tf_pw = new JTextField();
		sl_background.putConstraint(SpringLayout.NORTH, tf_pw, 274, SpringLayout.NORTH, panel);
		sl_background.putConstraint(SpringLayout.WEST, tf_pw, 814, SpringLayout.WEST, panel);
		sl_background.putConstraint(SpringLayout.EAST, tf_pw, -70, SpringLayout.EAST, panel);
		sl_background.putConstraint(SpringLayout.NORTH, lbl_pw, 3, SpringLayout.NORTH, tf_pw);
		tf_pw.setBounds(759, 301, 106, 21);
		panel.add(tf_pw);
		tf_pw.setColumns(10);

		JButton btn_login = new JButton("LOGIN");
		sl_background.putConstraint(SpringLayout.NORTH, btn_login, 31, SpringLayout.SOUTH, tf_pw);
		sl_background.putConstraint(SpringLayout.WEST, btn_login, -156, SpringLayout.EAST, panel);
		sl_background.putConstraint(SpringLayout.SOUTH, btn_login, 64, SpringLayout.SOUTH, tf_pw);
		sl_background.putConstraint(SpringLayout.EAST, btn_login, 0, SpringLayout.EAST, tf_id);
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// �α��� ��ư Ŭ�� ��
				String id = tf_id.getText();
				String pw = tf_pw.getText();

				if (id.equals("admin") && pw.equals("1234")) {// ��ġ �� �α���
					JOptionPane.showMessageDialog(null, "�α��� ����!");
					new Main(); // ������ �޴� ȭ�� ���
					frame.dispose(); // ���� Windowâ ����
				} else {
					JOptionPane.showMessageDialog(null, "�α��� ����", "�α���", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btn_login.setBounds(722, 362, 95, 23);
		panel.add(btn_login);

	}
}
