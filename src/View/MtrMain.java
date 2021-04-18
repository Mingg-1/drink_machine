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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
//------------------------------------------------- ���� ��
import javax.swing.table.TableColumnModel;

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

public class MtrMain {

	private JFrame frame;
	CardLayout menuLayout; // ī�巹�̾ƿ� ����

	// ���---------------------------------------------------------
	private DefaultTableModel model;
	private JTable mtr_table;
	private int row; // ������ ���� ��ġ
	mtrDAO mdao = new mtrDAO();
	ArrayList<mtrVO> ual = new ArrayList<mtrVO>();
	ArrayList<wrhVO> wal = new ArrayList<wrhVO>();
	// ------------------------------------------------------------

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
		frame = new JFrame("FRANCE Jang ������");
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

		model = new DefaultTableModel(rowDatas, colNames);
		/*
		 * rentingReload();
		 * 
		 * //- ���̺� ��ü�� �����ϸ鼭 ���� �־��� tb_renting = new JTable(renting);
		 * 
		 * //����� ���̾ƿ� �ڵ� �X��X��
		 * 
		 * // renting ��� ���� public void rentingReload() { renting.setRowCount(0); rent =
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
		panel_mtr1.setBounds(12, 56, 726, 237);
		panel_mtr.add(panel_mtr1);
		panel_mtr1.setLayout(null);

// ���̺� ��½� �� �־���� ��, �г� �Ʒ��� �־��ֱ�!
		JScrollPane scroll_mtr = new JScrollPane();
		scroll_mtr.setBounds(0, 0, 726, 238);
		panel_mtr1.add(scroll_mtr);

//// ���̺� ����, desing���� jtableŬ���ص� ��

		JTable mtr_table = new JTable(model);
		mtr_table.setFillsViewportHeight(true);// ��ü�� ���̺�� ä�� ��
		mtr_table.setRowHeight(25);// �����
//mtr_table.setShowVerticalLines(false);//���� �� �Ⱥ��̰�
//mtr_table.setShowHorizontalLines(false);//���� �� �Ⱥ��̰�
		// ���̺� ���� ��� �����ϱ�
		  DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // ����Ʈ���̺��������� ����
		  dtcr.setHorizontalAlignment(SwingConstants.CENTER); // �������� ���������� CENTER��
		  TableColumnModel tcm = mtr_table.getColumnModel() ; // ������ ���̺��� �÷����� ������

		  for(int i = 0 ; i < tcm.getColumnCount() ; i++){
		   tcm.getColumn(i).setCellRenderer(dtcr); // �÷��𵨿��� �÷��� ������ŭ �÷��� ������ for���� �̿��Ͽ�
		             // ������ ���������� �Ʊ� ������ dtcr�� set����
		scroll_mtr.setViewportView(mtr_table);
		  }

		String[] cols = { "����", "���� ���� ����" };
		String[][] rows = new String[ual.size()][2];

		for (int i = 0; i < ual.size(); i++) {
			for (int j = 0; j < 2; j++) {// �÷� �� ��ŭ �ݺ�

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

		////////////// ���� �� ������
		JPanel use_in = new JPanel();
		use_in.setBounds(22, 338, 333, 232);
		panel_mtr.add(use_in);
		use_in.setLayout(null);

		// ���̺� ��½� �� �־���� ��, �г� �Ʒ��� �־��ֱ�!
		JScrollPane scroll_mtr1 = new JScrollPane();
		scroll_mtr1.setBounds(0, 0, 333, 232);
		use_in.add(scroll_mtr1);

		//// ���̺� ����, desing���� jtableŬ���ص� ��

		JTable mtr_table1 = new JTable(model);
		mtr_table1.setFillsViewportHeight(true);// ��ü�� ���̺�� ä�� ��
		mtr_table1.setRowHeight(25);// �����
		// mtr_table.setShowVerticalLines(false);//���� �� �Ⱥ��̰�
		// mtr_table.setShowHorizontalLines(false);//���� �� �Ⱥ��̰�
		
		// ���̺� ���� ��� �����ϱ�
		  dtcr = new DefaultTableCellRenderer(); // ����Ʈ���̺��������� ����
		  dtcr.setHorizontalAlignment(SwingConstants.CENTER); // �������� ���������� CENTER��
		  tcm = mtr_table1.getColumnModel() ; // ������ ���̺��� �÷����� ������

		  for(int i = 0 ; i < tcm.getColumnCount() ; i++){
		   tcm.getColumn(i).setCellRenderer(dtcr); // �÷��𵨿��� �÷��� ������ŭ �÷��� ������ for���� �̿��Ͽ�
		             // ������ ���������� �Ʊ� ������ dtcr�� set����
		   scroll_mtr1.setViewportView(mtr_table1);
		  }
		

		String[] wcols = { "����", "â�� ���� ����" };
		String[][] wrows = new String[ual.size()][2];

		for (int i = 0; i < ual.size(); i++) {
			for (int j = 0; j < 2; j++) {// �÷� �� ��ŭ �ݺ�

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

		/////////// â�� ��� ����
		JPanel wrh_in = new JPanel();
		wrh_in.setBounds(390, 338, 333, 232);
		panel_mtr.add(wrh_in);
		wrh_in.setLayout(null);
		
		// ���̺� ��½� �� �־���� ��, �г� �Ʒ��� �־��ֱ�!
		JScrollPane scroll_mtrw = new JScrollPane();
		scroll_mtrw.setBounds(0, 0, 333, 232);
		wrh_in.add(scroll_mtrw);
		
		ImageIcon mtrlogo = new ImageIcon("img/mtrlogo.png");
		JLabel lblNewLabel = new JLabel(mtrlogo);
		lblNewLabel.setBounds(12, 10, 179, 43);
		panel_mtr.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB9E4\uC7A5 \uC7AC\uACE0 \uBD80\uC871 \uC54C\uB9BC");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("210 �����غ� R", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(22, 303, 169, 25);
		panel_mtr.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uCC3D\uACE0 \uC7AC\uACE0 \uBD80\uC871 \uC54C\uB9BC");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("210 �����غ� R", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(390, 303, 169, 25);
		panel_mtr.add(lblNewLabel_1_1);

		//// ���̺� ����, desing���� jtableŬ���ص� ��

		JTable mtr_tablew = new JTable(model);
		mtr_tablew.setFillsViewportHeight(true);// ��ü�� ���̺�� ä�� ��
		mtr_tablew.setRowHeight(25);// �����
		// mtr_table.setShowVerticalLines(false);//���� �� �Ⱥ��̰�
		// mtr_table.setShowHorizontalLines(false);//���� �� �Ⱥ��̰�
		
		// ���̺� ���� ��� �����ϱ�
		  dtcr = new DefaultTableCellRenderer(); // ����Ʈ���̺��������� ����
		  dtcr.setHorizontalAlignment(SwingConstants.CENTER); // �������� ���������� CENTER��
		  tcm = mtr_tablew.getColumnModel() ; // ������ ���̺��� �÷����� ������

		  for(int i = 0 ; i < tcm.getColumnCount() ; i++){
		   tcm.getColumn(i).setCellRenderer(dtcr); // �÷��𵨿��� �÷��� ������ŭ �÷��� ������ for���� �̿��Ͽ�
		             // ������ ���������� �Ʊ� ������ dtcr�� set����
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
		 * cell.setBackground(Global.convert_Color(�����ڵ�)); } else {
		 * cell.setBackground(Global.convert_Color(�����ڵ�)); } } return cell; } }
		 */

////////////////////////��/////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
				new Main();
				frame.dispose(); // ���� Windowâ ����
			}

			// ���콺�� �÷��� ��
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_sell.setIcon(click_sell);

				// �ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				// lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// ���콺 ������ ��
				lbl_sell.setIcon(click_sell);

				// �ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				// lbl_sell.setIcon(sell_btn);
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
				lbl_mtr.setIcon(click_mtr);
				menuLayout.show(menuView, "mtr");// Ŭ�� �� mtr�г� ���

			}

			// ���콺�� �÷��� ��
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_mtr.setIcon(click_mtr);
				// �ٸ���ư ���󺹱�
				// lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// ���콺 ������ ��
				lbl_mtr.setIcon(click_mtr);
				// �ٸ���ư ���󺹱�
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

////////////////������ ��ư////////////////////////////////////////////////////////////////		
		lbl_rcp = new JLabel("");
		lbl_rcp.setForeground(Color.WHITE);
		lbl_rcp.setFont(new Font("210 �����غ� R", Font.BOLD, 24));
		lbl_rcp.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_rcp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RecipeMain();
				frame.dispose(); // ���� Windowâ ����
			}

			// ���콺�� �÷��� ��
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_rcp.setIcon(click_rcp);
				// �ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				// lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// ���콺 ������ ��
				lbl_rcp.setIcon(click_rcp);
				// �ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				// lbl_rcp.setIcon(rcp_btn);
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
				new DeliveryMain();
				frame.dispose(); // ���� Windowâ ����
			}

			// ���콺�� �÷��� ��
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_ord.setIcon(click_odr);
				// �ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				// lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// ���콺 ������ ��
				lbl_ord.setIcon(click_odr);
				// �ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				// lbl_ord.setIcon(odr_btn);
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
				new SalesMain();
				frame.dispose(); // ���� Windowâ ����
			}

			// ���콺�� �÷��� ��
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_sls.setIcon(click_sls);
				// �ٸ���ư ���󺹱�
				lbl_mtr.setIcon(mtr_btn);
				lbl_ord.setIcon(odr_btn);
				lbl_rcp.setIcon(rcp_btn);
				// lbl_sls.setIcon(sls_btn);
				lbl_sell.setIcon(sell_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {// ���콺 ������ ��
				lbl_sls.setIcon(click_sls);
				// �ٸ���ư ���󺹱�
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
