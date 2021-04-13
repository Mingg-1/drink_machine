import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Main {

	private JFrame frame;

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
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel login = new JPanel();
		frame.getContentPane().add(login, "name_2738746196708600");
		
		JPanel menu = new JPanel();
		frame.getContentPane().add(menu, "name_2738769182170700");
		menu.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 264, 592);
		menu.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(99, 133, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(99, 180, 57, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(99, 226, 57, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(99, 280, 57, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(99, 341, 57, 15);
		panel.add(label_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(263, 0, 750, 592);
		menu.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "name_2739052760904100");
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "name_2739056525989000");
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, "name_2739058574073000");
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, "name_2739062590733300");
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, "name_2739070691161200");
	}
}
