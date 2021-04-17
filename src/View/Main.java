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

//���ֺκ� import-------------------------------------------------
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
//------------------------------------------------- ���� ��

//������ import----------------------------------------------------
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
//-------------------------------------------------������ ��

public class Main {

	private JFrame frame;
	CardLayout menuLayout; // ī�巹�̾ƿ� ����

	// ���---------------------------------------------------------
	private JTable mtr_table;
	private int row; // ������ ���� ��ġ
	mtrDAO mdao = new mtrDAO();
	ArrayList<mtrVO> ual = new ArrayList<mtrVO>();
	// ------------------------------------------------------------

	// ���� ���� ����------------------------------------------------
	private JTable table;
	MemberDAO dao = new MemberDAO();
	DeliveryDAO daoo = new DeliveryDAO();
//	ArrayList<DeliveryVO> al = new ArrayList<DeliveryVO>();
	ArrayList<DeliveryVO> al = daoo.allSelect();
	String selected_dvr_num = "";
	String selected_rcvdate = "";
	// ----------------------------------------------------���� ��

	// ������ ���� ���� -----------------------------------------------
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
	private JScrollPane scrollPane_DE;
	// ----------------------------------------------------������ ��

	// �� �̹��� ���澲---------------------------------------------
	private JLabel lbl_sell, lbl_mtr, lbl_rcp, lbl_ord, lbl_sls;
	//////////////// �ǸŹ�ư///////////////////////////////////////
	// ���ϴ� �̹���
	ImageIcon clicksell = new ImageIcon("btn/clicksell.png");
	Image clicksell1 = clicksell.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon click_sell = new ImageIcon(clicksell1);
	// ���� �̹���
	ImageIcon sellbtn = new ImageIcon("btn/sellbtn.png");
	Image sellbtn1 = sellbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon sell_btn = new ImageIcon(sellbtn1);

	//////////////// ����ư///////////////////////////////////////
	// ���ϴ� �̹���
	ImageIcon clickmtr = new ImageIcon("btn/clickmtr.png");
	Image clickmtr1 = clickmtr.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon click_mtr = new ImageIcon(clickmtr1);
	// ���� �̹���
	ImageIcon mtrbtn = new ImageIcon("btn/mtrbtn.png");
	Image mtrbtn1 = mtrbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon mtr_btn = new ImageIcon(mtrbtn1);

	//////////////// �����ǹ�ư///////////////////////////////////////
	// ���ϴ� �̹���
	ImageIcon clickrcp = new ImageIcon("btn/clickrcp.png");
	Image clickrcp1 = clickrcp.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon click_rcp = new ImageIcon(clickrcp1);
	// ���� �̹���
	ImageIcon rcpbtn = new ImageIcon("btn/rcpbtn.png");
	Image rcpbtn1 = rcpbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon rcp_btn = new ImageIcon(rcpbtn1);

	//////////////// ���ֹ�ư///////////////////////////////////////
	// ���ϴ� �̹���
	ImageIcon clickodr = new ImageIcon("btn/clickodr.png");
	Image clickodr1 = clickodr.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon click_odr = new ImageIcon(clickodr1);
	// ���� �̹���
	ImageIcon odrbtn = new ImageIcon("btn/odrbtn.png");
	Image odrbtn1 = odrbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon odr_btn = new ImageIcon(odrbtn1);

	//////////////// �����ư///////////////////////////////////////
	// ���ϴ� �̹���
	ImageIcon clicksls = new ImageIcon("btn/clicksls.png");
	Image clicksls1 = clicksls.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon click_sls = new ImageIcon(clicksls1);
	// ���� �̹���
	ImageIcon slsbtn = new ImageIcon("btn/slsbtn.png");
	Image slsbtn1 = slsbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
	ImageIcon sls_btn = new ImageIcon(slsbtn1);
	// ------------------------------------------------------�� ��

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
		ual = mdao.useIn();
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
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
		frame.getContentPane().setLayout(null);
		menuLayout = new CardLayout();

//////////////		// �޴� ȭ��////////////////////////////////////////////////////////////////////////

		// �̹��� �ҷ�����
		ImageIcon mnbg = new ImageIcon("img/bg.png");
		Image img1 = mnbg.getImage();
		// ũ�� ������ �̹��� �ҷ�����
		ImageIcon mnbg1 = new ImageIcon(img1);
		// �г��� �����ϰ� �̹��� ����
		JPanel menu = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(mnbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// �θ� �гο� ���� �̹����� ���� �г��� �߰�
		menu.setBounds(0, 0, 1015, 594);
		frame.getContentPane().add(menu);
		menu.setLayout(null);

		// �̹��� �ҷ�����
		ImageIcon mvbg = new ImageIcon("img/menubg.png");
		Image img2 = mvbg.getImage();
		// ũ�� ������ �̹��� �ҷ�����
		ImageIcon mvbg1 = new ImageIcon(img2);
		// �г��� �����ϰ� �̹��� ����
		JPanel menuView = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(mvbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// �θ� �гο� ���� �̹����� ���� �г��� �߰�
		menuView.setBounds(263, 0, 750, 592);
		menu.add(menuView);
		menuView.setLayout(menuLayout);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////�Ǹ� ȭ��////////////////////////////////////////////////////////////////////////////////////////////	

		// �̹��� �ҷ�����
		ImageIcon slbg = new ImageIcon("img/menubg.png");
		Image img9 = slbg.getImage(); // Image �������� = ImageIcon������.getImage();
		// ũ�� ������ �̹��� �ҷ�����
		ImageIcon slbg1 = new ImageIcon(img9); // ImageIcon �������� = new ImageIcon(Image����);
		// �г��� �����ϰ� �̹��� ����
		JPanel panel_sell = new JPanel() { // JPanel �г��̸� = new JPanel()
			protected void paintComponent(Graphics g) {
				g.drawImage(slbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// �θ� �гο� ���� �̹����� ���� �г��� �߰�
		menuView.add(panel_sell, "sell"); // �θ��г�.add(�����г��̸�, "�̸�");
		panel_sell.setLayout(null);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		   // �̹��� �ҷ�����
//        ImageIcon bg = new ImageIcon("images/BG.png");
//  	Image img4 = bg.getImage(); 
		// Image �������� = ImageIcon������.getImage();
//        // �̹��� ũ�� ����
//  	img4  = img4.getScaledInstance(165, 220, Image.SCALE_SMOOTH);
//     
//        // ũ�� ������ �̹��� �ҷ�����
//        ImageIcon bgch = new ImageIcon(img4);
		// ImageIcon �������� = new ImageIcon(Image����);
//        // �г��� �����ϰ� �̹��� ����
//        home_page = new JPanel() { //JPanel �г��̸� = new JPanel()
//              protected void paintComponent(Graphics g) {
//                 g.drawImage(bgch.getImage(), 0, 0, null); //g.drawImage(ImageIcon����.getImage(), 0, 0, null);
//                 setOpaque(false);
//                 super.paintComponent(g);
//          }
//        };
//        // �θ� �гο�  ���� �̹����� ���� �г��� �߰�
//        panel.add(home_page, "home_page"); //�θ��г�.add(�����г��̸�, "�̸�"); 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////��� ������ ȭ��////////////////////////////////////////////////////////////////////////////////////////////		

// ���̺� ���
// JTable ������ �ʱ�ȭ
// �÷����� 1���� �迭, �� �����ʹ� 2���� �迭�� ����
		String[] colNames = { "����ڵ�", "����", "�������", "â�����" };
		String[][] rowDatas = new String[ual.size()][4];

		for (int i = 0; i < ual.size(); i++) {
			for (int j = 0; j < 5; j++) {// �÷� �� ��ŭ �ݺ�
// j���� ���� vo���� �޶�����
// �ϳ��� ��� �ϳ��� ȸ�������� ����ְ�
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

		// �̹��� �ҷ�����
		ImageIcon mtbg = new ImageIcon("img/menubg.png");
		Image img3 = mtbg.getImage(); // Image �������� = ImageIcon������.getImage();
		// ũ�� ������ �̹��� �ҷ�����
		ImageIcon mtbg1 = new ImageIcon(img3); // ImageIcon �������� = new ImageIcon(Image����);
		// �г��� �����ϰ� �̹��� ����
		JPanel panel_mtr = new JPanel() { // JPanel �г��̸� = new JPanel()
			protected void paintComponent(Graphics g) {
				g.drawImage(mtbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// �θ� �гο� ���� �̹����� ���� �г��� �߰�
		menuView.add(panel_mtr, "mtr"); // �θ��г�.add(�����г��̸�, "�̸�");
		panel_mtr.setLayout(null);

		JPanel panel_mtr1 = new JPanel();
		panel_mtr1.setBounds(12, 84, 726, 498);
		panel_mtr.add(panel_mtr1);
		panel_mtr1.setLayout(null);

// ���̺� ��½� �� �־���� ��, �г� �Ʒ��� �־��ֱ�!
		JScrollPane scroll_mtr = new JScrollPane();
		scroll_mtr.setBounds(0, 0, 726, 498);
		panel_mtr1.add(scroll_mtr);

//// ���̺� ����, desing���� jtableŬ���ص� ��
		JTable mtr_table = new JTable(rowDatas, colNames);
		mtr_table.setFillsViewportHeight(true);// ��ü�� ���̺�� ä�� ��
		mtr_table.setRowHeight(25);// �����
//mtr_table.setShowVerticalLines(false);//���� �� �Ⱥ��̰�
//mtr_table.setShowHorizontalLines(false);//���� �� �Ⱥ��̰�
		scroll_mtr.setViewportView(mtr_table);

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
		 * cell.setBackground(Global.convert_Color(�����ڵ�)); } else {
		 * cell.setBackground(Global.convert_Color(�����ڵ�)); } } return cell; } }
		 */

////////////////////////��/////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// ������ ȭ��
/////////////////////////////////////////////////////////////////////////////////
///////////������////////////////////////////////////////////////////////////////

//������ ȭ��

		// �̹��� �ҷ�����
		ImageIcon rcbg = new ImageIcon("img/menubg.png");
		Image img4 = rcbg.getImage(); // Image �������� = ImageIcon������.getImage();
		// ũ�� ������ �̹��� �ҷ�����
		ImageIcon rcbg1 = new ImageIcon(img4); // ImageIcon �������� = new ImageIcon(Image����);
		// �г��� �����ϰ� �̹��� ����
		JPanel panel_rcp = new JPanel() { // JPanel �г��̸� = new JPanel()
			protected void paintComponent(Graphics g) {
				g.drawImage(rcbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// �θ� �гο� ���� �̹����� ���� �г��� �߰�
		menuView.add(panel_rcp, "rcp"); // �θ��г�.add(�����г��̸�, "�̸�");
		panel_rcp.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uB808\uC2DC\uD53C"); // ������ ��� ����
		lblNewLabel.setBounds(12, 10, 57, 15);
		panel_rcp.add(lblNewLabel);

		// �̹��� �ҷ�����
		ImageIcon rcpbg = new ImageIcon("img/menubg.png");
		Image img5 = rcpbg.getImage(); // Image �������� = ImageIcon������.getImage();
		// ũ�� ������ �̹��� �ҷ�����
		ImageIcon rcpbg1 = new ImageIcon(img5); // ImageIcon �������� = new ImageIcon(Image����);
		// �г��� �����ϰ� �̹��� ����
		JPanel panel_1 = new JPanel() { // JPanel �г��̸� = new JPanel()
			protected void paintComponent(Graphics g) {
				g.drawImage(rcpbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// �θ� �гο� ���� �̹����� ���� �г��� �߰�
		panel_1.setBounds(0, 35, 750, 557);
		panel_rcp.add(panel_1); // �θ��г�.add(�����г��̸�, "�̸�");
		panel_1.setLayout(null);

		JLabel registration_Rcp = new JLabel("\uC0C1\uD488\uB4F1\uB85D");
		registration_Rcp.setBounds(577, 346, 128, 30);
		registration_Rcp.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(registration_Rcp);

		brdCode_Rcp = new JTextField();// ���ڵ�
		brdCode_Rcp.setBounds(38, 383, 100, 20);
		panel_1.add(brdCode_Rcp);
		brdCode_Rcp.setColumns(10);

		brdName_Rcp = new JTextField();// ���̸�
		brdName_Rcp.setBounds(197, 383, 100, 20);
		panel_1.add(brdName_Rcp);
		brdName_Rcp.setColumns(10);

		JSpinner brdPrc_Rcp = new JSpinner();// ������
		brdPrc_Rcp.setBounds(337, 386, 100, 20);
		panel_1.add(brdPrc_Rcp);

//=========================�� ���====================================
		JButton btnInsertBrd_Rcp = new JButton("Insert");
		btnInsertBrd_Rcp.setBounds(567, 386, 159, 149);
		btnInsertBrd_Rcp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String brd_code = brdCode_Rcp.getText();
				String brd_name = brdName_Rcp.getText();
//String in_name = inName.getText();
				int brd_cnt = 0;
				int brd_prc = (int) brdPrc_Rcp.getValue();
//int in_cnt = inCnt.getComponentCount();

				if (brd_code != "" && brd_name != "" && brd_prc >= 0) {
					RecipeDAO dao = new RecipeDAO();
					BreadVO vo = new BreadVO(brd_code, brd_name, brd_cnt, brd_prc);
					boolean result = dao.brdInsert(vo);

					if (result == true) {
//null : �޽���â�� � �����ӿ��� �������� ���� ���� null ���
						JOptionPane.showMessageDialog(null, "������ ��� ����");
						new Main();// ������ â ����
//frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "������ ��� ����", "������ ���", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "��� ������ �Է��Ͻÿ�", "������ ���", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnInsertBrd_Rcp.setFont(new Font("HY�߰��", Font.PLAIN, 17));
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

//======================�����ǻ���=========================

		JButton btnDeleteBrd_Rcp = new JButton("\uC0AD\uC81C\uD558\uAE30");
		btnDeleteBrd_Rcp.setBounds(409, 469, 100, 44);
		btnDeleteBrd_Rcp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (brd_name != "") {
					RecipeDAO dao = new RecipeDAO();
//RcpVO vo = new RcpVO(brd_name);
					String brd_name = brdName_Rcp.getText();
					boolean result = dao.delete(brd_name);

					if (result == true) {
						JOptionPane.showMessageDialog(null, "�����ǻ��� ����");
						new Main();

					} else {
						JOptionPane.showMessageDialog(null, "�����ǻ��� ����", "�����ǻ���", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		panel_1.add(btnDeleteBrd_Rcp);

//=====================������ ����Ʈ===================

		String[] colname_Brd = { "���ڵ�", "���̸�", "������" };

		String[][] data_Brd = new String[al_brd.size()][3];
//SimpleDateFormat format_Brd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < al_brd.size(); i++) {

			for (int j = 0; j < 3; j++) {

				if (j == 0) {
					data_Brd[i][j] = al_brd.get(i).getBrd_code();
				} else if (j == 1) {
					data_Brd[i][j] = al_brd.get(i).getBrd_name();
				} else if (j == 2) {
					data_Brd[i][j] = al_brd.get(i).getBrd_prc() + "";
				}

			}
		}

//������ ���̺�

//���������̺� ��ũ��

//======================��� ����Ʈ======================

//================�����ǵ��=============

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
				int rcp_cnt = (int) Rcpcnt_Rcp.getValue();

				if (in_name != "" && brd_name != "" && rcp_cnt >= 0) {
					RecipeDAO dao = new RecipeDAO();
					RecipeVO vo = new RecipeVO(in_name, brd_name, rcp_cnt);
					boolean result = dao.rcpInsert(vo);

					if (result == true) {
//null : �޽���â�� � �����ӿ��� �������� ���� ���� null ���
						JOptionPane.showMessageDialog(null, "������ ��� ����");
						new Main();// ������ â ����
//frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "������ ��� ����", "������ ���", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "��� ������ �Է��Ͻÿ�", "������ ���", JOptionPane.ERROR_MESSAGE);
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
//table_1.addMouseListener(new MouseAdapter() {
//@Override
//public void mouseClicked(MouseEvent e) {
//int row = table.getSelectedRow();		
//
//selected_dvr_num = (String) table.getModel().getValueAt(row, 0);
////String selected_inname = (String) table.getModel().getValueAt(row, 1);
////String selected_dvrdate = (String) table.getModel().getValueAt(row, 2);
////String selected_dvrcnt = (String) table.getModel().getValueAt(row, 3);
////String selected_rcvdate = (String) table.getModel().getValueAt(row, 4);
//
//}
//});

		table_1.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(table_1);

// ���� ȭ��---------------------------------------------------------------------------

// ���̺�
		String[] colname = { "�ֹ���ȣ", "����̸�", "��������", "���ּ���", "��������" };

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

//���̺��г�

		// �̹��� �ҷ�����
		ImageIcon orbg = new ImageIcon("img/menubg.png");
		Image img6 = orbg.getImage(); // Image �������� = ImageIcon������.getImage();
		// ũ�� ������ �̹��� �ҷ�����
		ImageIcon orbg1 = new ImageIcon(img6); // ImageIcon �������� = new ImageIcon(Image����);
		// �г��� �����ϰ� �̹��� ����
		JPanel panel_ord = new JPanel() { // JPanel �г��̸� = new JPanel()
			protected void paintComponent(Graphics g) {
				g.drawImage(orbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// �θ� �гο� ���� �̹����� ���� �г��� �߰�
		menuView.add(panel_ord, "ord"); // �θ��г�.add(�����г��̸�, "�̸�");
		panel_ord.setLayout(null);

		// �̹��� �ҷ�����
		ImageIcon ordbg = new ImageIcon("img/menubg.png");
		Image img7 = ordbg.getImage(); // Image �������� = ImageIcon������.getImage();
		// ũ�� ������ �̹��� �ҷ�����
		ImageIcon ordbg1 = new ImageIcon(img7); // ImageIcon �������� = new ImageIcon(Image����);
		// �г��� �����ϰ� �̹��� ����
		JPanel panel = new JPanel() { // JPanel �г��̸� = new JPanel()
			protected void paintComponent(Graphics g) {
				g.drawImage(ordbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// �θ� �гο� ���� �̹����� ���� �г��� �߰�
		panel.setBounds(0, 0, 750, 460);
		panel_ord.add(panel); // �θ��г�.add(�����г��̸�, "�̸�");
		panel.setLayout(null);

//���̺��
		JLabel lblNewLabel_1 = new JLabel("\uBC1C\uC8FC \uAD00\uB9AC");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(268, 10, 179, 43);
		panel.add(lblNewLabel_1);

//���̺�ũ���г�
		JScrollPane scrollPane_DE;
		scrollPane_DE = new JScrollPane();
		scrollPane_DE.setBounds(45, 87, 674, 347);
		panel.add(scrollPane_DE);
		scrollPane_DE.setViewportView(table);

//���̺� Ŭ�� 
		DefaultTableModel Model = new DefaultTableModel(data, colname);
		JTable table = new JTable(Model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();

				selected_dvr_num = (String) table.getModel().getValueAt(row, 0);
//		String selected_inname = (String) table.getModel().getValueAt(row, 1);
//		String selected_dvrdate = (String) table.getModel().getValueAt(row, 2);
//		String selected_dvrcnt = (String) table.getModel().getValueAt(row, 3);
				selected_rcvdate = (String) table.getModel().getValueAt(row, 4);

			}
		});

		table.setFillsViewportHeight(true);
		scrollPane_DE.setViewportView(table);

//�ֹ������� �߰����� ��ư
		JButton btnNewButton = new JButton("\uC8FC\uBB38");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Order_in();
			}
		});

//�ֹ� ���� ��ư
		btnNewButton.setFont(new Font("����", Font.PLAIN, 16));
		btnNewButton.setBounds(185, 506, 122, 48);
		panel_ord.add(btnNewButton);
		JButton button = new JButton("\uC8FC\uBB38 \uC0AD\uC81C");
		button.addActionListener(new ActionListener() {

			// ������ ���� �ð��� ��������
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < al.size(); i++) {
					if (al.get(i).getRcv_date() != null) {
						data[i][4] = format.format(al.get(i).getRcv_date());
					}
				}

				// ����ð� - ������ ��
				long minute = 0;
				String reqDateStr = selected_rcvdate; // ********************************************************************��ǥ�ð�
														// �ֱ�
				// ����ð� Date
				Date curDate = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// ��û�ð��� Date�� parsing �� time��������

				Date reqDate;
				try {
					reqDate = dateFormat.parse(reqDateStr);
					long reqDateTime = reqDate.getTime();
					// ����ð��� ��û�ð��� ���·� format �� time ��������
					curDate = dateFormat.parse(dateFormat.format(curDate));
					long curDateTime = curDate.getTime();
					// ������ ǥ��
					minute = (curDateTime - reqDateTime) / 60000;
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				boolean result = daoo.deletedelivery(selected_dvr_num, minute);

				if (result == false) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ���� : �����߰ų� �������� 10�� ���ҽ��ϴ�.");
					new Main();
					frame.dispose();

				}

				else if (result == true) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����");
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

		button.setFont(new Font("����", Font.PLAIN, 16));
		button.setBounds(448, 506, 122, 48);
		panel_ord.add(button);

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		button.setFont(new Font("����", Font.PLAIN, 16));
		button.setBounds(448, 506, 122, 48);
		panel_ord.add(button);

////////////////////		// ����ȭ��////////////////////////////////////////////////////////////////////////////////////////

		// �̹��� �ҷ�����
		ImageIcon slsbg = new ImageIcon("img/menubg.png");
		Image img8 = slsbg.getImage(); // Image �������� = ImageIcon������.getImage();
		// ũ�� ������ �̹��� �ҷ�����
		ImageIcon slsbg1 = new ImageIcon(img8); // ImageIcon �������� = new ImageIcon(Image����);
		// �г��� �����ϰ� �̹��� ����
		JPanel panel_sls = new JPanel() { // JPanel �г��̸� = new JPanel()
			protected void paintComponent(Graphics g) {
				g.drawImage(slsbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// �θ� �гο� ���� �̹����� ���� �г��� �߰�
		menuView.add(panel_sls, "sls"); // �θ��г�.add(�����г��̸�, "�̸�");
		panel_sls.setLayout(null);

//////////////////////		// �޴� ��� ȭ��/////////////////////////////////////////////////////////////////////////////////////////

		// �̹��� �ҷ�����
		ImageIcon mlbg = new ImageIcon("img/menulist.png");
		Image img10 = mlbg.getImage(); // Image �������� = ImageIcon������.getImage();
		// ũ�� ������ �̹��� �ҷ�����
		ImageIcon mlbg1 = new ImageIcon(img10); // ImageIcon �������� = new ImageIcon(Image����);
		// �г��� �����ϰ� �̹��� ����
		JPanel menuList = new JPanel() { // JPanel �г��̸� = new JPanel()
			protected void paintComponent(Graphics g) {
				g.drawImage(mlbg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		// �θ� �гο� ���� �̹����� ���� �г��� �߰�
		menuList.setBounds(0, 0, 264, 592);
		menu.add(menuList); // �θ��г�.add(�����г��̸�, "�̸�");
		menuList.setLayout(null);

///////////////�Ǹ� ��ư///////////////////////////
		lbl_sell = new JLabel("");
		lbl_sell.setForeground(Color.WHITE);
		lbl_sell.setFont(new Font("210 �����غ� R", Font.BOLD, 24));
		lbl_sell.setHorizontalAlignment(SwingConstants.CENTER);

		lbl_sell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lbl_sell.setIcon(click_sell);
				menuLayout.show(menuView, "sell");// Ŭ�� �� sell�г� ���
			}

			// ���콺�� �÷��� ��
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_sell.setIcon(click_sell);
				
				//�ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				//lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// ���콺 ������ ��
				lbl_sell.setIcon(click_sell);
				
				//�ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				//lbl_sell.setIcon(sell_btn);
			}
		});

		menuList.add(lbl_sell);
		// �⺻ �̹���
		lbl_sell.setIcon(sell_btn);
		lbl_sell.setBounds(0, 206, 264, 51);

///////////////////////����ư////////////////////////////////////////////////////////////		
		lbl_mtr = new JLabel("");
		lbl_mtr.setForeground(Color.WHITE);
		lbl_mtr.setFont(new Font("210 �����غ� R", Font.BOLD, 24));
		lbl_mtr.setHorizontalAlignment(SwingConstants.CENTER);

		lbl_mtr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuLayout.show(menuView, "mtr");// Ŭ�� �� mtr�г� ���
			}

			// ���콺�� �÷��� ��
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_mtr.setIcon(click_mtr);
				//�ٸ���ư ���󺹱�
				//lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// ���콺 ������ ��
				lbl_mtr.setIcon(click_mtr);
				//�ٸ���ư ���󺹱�
				//lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}
		});
		lbl_mtr.setBounds(0, 265, 264, 51);
		menuList.add(lbl_mtr);
		lbl_mtr.setIcon(mtr_btn);

////////////////������ ��ư////////////////////////////////////////////////////////////////		
		lbl_rcp = new JLabel("");
		lbl_rcp.setForeground(Color.WHITE);
		lbl_rcp.setFont(new Font("210 �����غ� R", Font.BOLD, 24));
		lbl_rcp.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_rcp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuLayout.show(menuView, "rcp");// Ŭ�� �� rcp�г� ���
			}

			// ���콺�� �÷��� ��
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_rcp.setIcon(click_rcp);
				//�ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				//lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// ���콺 ������ ��
				lbl_rcp.setIcon(click_rcp);
				//�ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				//lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}
		});
		lbl_rcp.setBounds(0, 326, 264, 51);
		menuList.add(lbl_rcp);

/////////////////////���ֹ�ư///////////////////////////////////////////////////////////////////		
		lbl_ord = new JLabel("");
		lbl_ord.setForeground(Color.WHITE);
		lbl_ord.setFont(new Font("210 �����غ� R", Font.BOLD, 24));
		lbl_ord.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuLayout.show(menuView, "ord");// Ŭ�� �� ord�г� ���
			}

			// ���콺�� �÷��� ��
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_ord.setIcon(click_odr);
				//�ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				//lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// ���콺 ������ ��
				lbl_ord.setIcon(click_odr);
				//�ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				//lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}
		});
		lbl_ord.setBounds(0, 387, 264, 51);
		menuList.add(lbl_ord);

///////////////////////////////�����ư////////////////////////////////////////////////		
		lbl_sls = new JLabel("");
		lbl_sls.setForeground(Color.WHITE);
		lbl_sls.setFont(new Font("210 �����غ� R", Font.BOLD, 24));
		lbl_sls.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sls.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuLayout.show(menuView, "sls");// Ŭ�� �� sls�г� ���
			}

			// ���콺�� �÷��� ��
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_sls.setIcon(click_sls);
				//�ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				//lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// ���콺 ������ ��
				lbl_sls.setIcon(click_sls);
				//�ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				//lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}
		});
		lbl_sls.setBounds(0, 448, 264, 51);
		menuList.add(lbl_sls);

	}
}
