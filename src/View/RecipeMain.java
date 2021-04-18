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

//import org.omg.CORBA.INITIALIZE;

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
import java.awt.Image;

//-------------------------------------------------������ ��

public class RecipeMain {

   private JFrame frame;
   CardLayout menuLayout; // ī�巹�̾ƿ� ����

   // ----------------------------------------------------���� ��

   // ������ ���� ���� -----------------------------------------------
   private JTextField brdName_Rcp;
   private JTextField brdCode_Rcp;
   private String brd_name;
   private JTextField Inname_Rcp;
   private JTextField Brdname_Rcp;
//private JButton Button_DE_insert;
   RecipeDAO dao_brd = new RecipeDAO();
   ArrayList<BreadVO> al_brd = new ArrayList<BreadVO>();
   ArrayList<RecipeVO> al_rcp = new ArrayList<RecipeVO>();
//   private JTable table_1;
   String selected_brd_name = "";
//   private JTextField textRcpSearch;
//   private JTable table_2;
   private JTable tableRcpInlist;
   private JTextField RcpListBrdName;
   // ----------------------------------------------------������ ��
   //���������������̸�����
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
               RecipeMain window = new RecipeMain();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public RecipeMain() {
      al_brd = dao_brd.allSelect();
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

//////////////      // �޴� ȭ��////////////////////////////////////////////////////////////////////////

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
//         // �̹��� �ҷ�����
//        ImageIcon bg = new ImageIcon("images/BG.png");
//     Image img4 = bg.getImage(); 
      // Image �������� = ImageIcon������.getImage();
//        // �̹��� ũ�� ����
//     img4  = img4.getScaledInstance(165, 220, Image.SCALE_SMOOTH);
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

      // =========================�� ���====================================
            JButton btnInsertBrd_Rcp = new JButton("\uBE75\uCD94\uAC00");
            btnInsertBrd_Rcp.setBounds(567, 432, 159, 103);
            btnInsertBrd_Rcp.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  String brd_code = brdCode_Rcp.getText();
                  String brd_name = brdName_Rcp.getText();
//                  String in_name = inName.getText();
                  int brd_cnt = 0;
                  int brd_prc = (int) brdPrc_Rcp.getValue();
//                  int in_cnt = inCnt.getComponentCount();

                  if (brd_code != "" && brd_name != "" && brd_prc >= 0) {
                     RecipeDAO dao = new RecipeDAO();
                     BreadVO vo = new BreadVO(brd_code, brd_name, brd_cnt, brd_prc);
                     boolean result = dao.brdInsert(vo);

                     if (result == true) {
                        // null : �޽���â�� � �����ӿ��� �������� ���� ���� null ���
                        JOptionPane.showMessageDialog(null, "������ ��� ����");
                        new RecipeMain();// ������ â ����
//                        frame.dispose();
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

            // ======================�����ǻ���=========================

            JButton btnDeleteBrd_Rcp = new JButton("\uC0AD\uC81C\uD558\uAE30");
            btnDeleteBrd_Rcp.setBounds(409, 469, 100, 44);
            btnDeleteBrd_Rcp.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  if (brd_name != "") {
                     RecipeDAO dao = new RecipeDAO();
//                     RcpVO vo = new RcpVO(brd_name);
                     String brd_name = brdName_Rcp.getText();
                     boolean result = dao.delete(brd_name);

                     if (result == true) {
                        JOptionPane.showMessageDialog(null, "�����ǻ��� ����");
                        new RecipeMain();

                     } else {
                        JOptionPane.showMessageDialog(null, "�����ǻ��� ����", "�����ǻ���", JOptionPane.ERROR_MESSAGE);
                     }
                  }

               }
            });
            panel_1.add(btnDeleteBrd_Rcp);

            // =====================������ ����Ʈ===================

            //
//                  ��ó: https://blaseed.tistory.com/16 [���ڽɸ��� ������]
//                  int row = 0;
//                  int col = 0;

                  String[] colname_Brd = { "���ڵ�", "���̸�", "������" };
                  System.out.println(al_brd.size());
                  String[][] data_Brd = new String[al_brd.size()][3];
//                  SimpleDateFormat format_Brd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

                  // ======================��� ����Ʈ======================

                  String[] colname_rcp = { "����̸�", "��ᰳ��" };

                  String[][] data_rcp = new String[al_rcp.size()][2];
//                           SimpleDateFormat format_Brd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                  for (int i = 0; i < al_rcp.size(); i++) {

                     for (int j = 0; j < 2; j++) {

                        if (j == 0) {
                           data_rcp[i][j] = al_rcp.get(i).getIn_name();
                        } else if (j == 1) {
                           data_rcp[i][j] = al_rcp.get(i).getRcp_cnt() + "";

                        }
                     }
                  }
                  // ================�����ǵ��=============

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

                  JLabel label_6_Rcp = new JLabel("\uBE75\uC774\uB984");
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
                              // null : �޽���â�� � �����ӿ��� �������� ���� ���� null ���
                              JOptionPane.showMessageDialog(null, "������ ��� ����");
                              new RecipeMain();// ������ â ����
//                              frame.dispose();
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

                  JScrollPane scrollRcpInList = new JScrollPane();
                  scrollRcpInList.setBounds(516, 10, 210, 332);
                  panel_1.add(scrollRcpInList);

                  tableRcpInlist = new JTable();
                  tableRcpInlist.setFillsViewportHeight(true);
                  scrollRcpInList.setViewportView(tableRcpInlist);
                  DefaultTableModel Model_Rcp = new DefaultTableModel(data_rcp, colname_rcp);

                  JScrollPane scrollRcpList = new JScrollPane();
                  scrollRcpList.setBounds(12, 10, 491, 331);
                  panel_1.add(scrollRcpList);

                  new JTable();
                  DefaultTableModel Model_Brd = new DefaultTableModel(data_Brd, colname_Brd);
                  JTable tableRcplist = new JTable(Model_Brd);
//                  int row = table.getSelectedRow();
                  tableRcplist.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                        JTable t = (JTable) e.getComponent();
                        int row = t.getSelectedRow();
                        al_rcp = dao_brd.allSelect_rcp((String) t.getModel().getValueAt(row, 1));
                        
                        String[] colname_rcp = { "����̸�", "��ᰳ��" };

                        String[][] data_rcp = new String[al_rcp.size()][2];
//                                 SimpleDateFormat format_Brd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        for (int i = 0; i < al_rcp.size(); i++) {

                           for (int j = 0; j < 2; j++) {

                              if (j == 0) {
                                 data_rcp[i][j] = al_rcp.get(i).getIn_name();
                              } else if (j == 1) {
                                 data_rcp[i][j] = al_rcp.get(i).getRcp_cnt() + "";

                              }
                           }
                        }
                        DefaultTableModel model = new DefaultTableModel(data_rcp, colname_rcp);
                        tableRcpInlist = new JTable(model);
                        tableRcpInlist.setFillsViewportHeight(true);
                        scrollRcpInList.setViewportView(tableRcpInlist);

                     }
                  });

                  tableRcplist.setFillsViewportHeight(true);
                  scrollRcpList.setViewportView(tableRcplist);

      JPanel pan_brdImg = new JPanel();
      pan_brdImg.setBounds(516, 10, 210, 163);
      panel_1.add(pan_brdImg);

      

//////////////////////      // �޴� ��� ȭ��/////////////////////////////////////////////////////////////////////////////////////////

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
            new SellMain();
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
            new MtrMain();
            frame.dispose(); // ���� Windowâ ����
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
            lbl_rcp.setIcon(click_rcp);
            menuLayout.show(menuView, "rcp");// Ŭ�� �� rcp�г� ���
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