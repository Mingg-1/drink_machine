package View;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.MemberDAO;
import VO.MemberVO;

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
import VO.DeliveryVO;
import java.awt.event.ActionEvent;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
//------------------------------------------------- 발주 끝
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.JProgressBar;


public class Main {

   private JFrame frame;
   CardLayout cardLayout ; //카드레이아웃 선언
   CardLayout menuLayout ; //카드레이아웃 선언

   //발주 참조 선언------------------------------------------------
   private JTable table;
   MemberDAO dao = new MemberDAO();
   DeliveryDAO daoo = new DeliveryDAO();
//   ArrayList<DeliveryVO> al = new ArrayList<DeliveryVO>();
   ArrayList<DeliveryVO> al = daoo.allSelect();
   String selected_dvr_num = "";
   //----------------------------------------------------발주 끝
   
ImageIcon img1 = new ImageIcon("img/1.jpg");      
Image changed_img1 = img1.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img1 = new ImageIcon(changed_img1);

ImageIcon img2 = new ImageIcon("img/2.jpg");      
Image changed_img2 = img2.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img2 = new ImageIcon(changed_img2);

ImageIcon img3 = new ImageIcon("img/3.jpg");      
Image changed_img3 = img1.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img3 = new ImageIcon(changed_img3);

ImageIcon img4 = new ImageIcon("img/4.jpg");      
Image changed_img4 = img4.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img4 = new ImageIcon(changed_img4);

ImageIcon img5 = new ImageIcon("img/5.jpg");      
Image changed_img5 = img5.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img5 = new ImageIcon(changed_img5);

ImageIcon img6 = new ImageIcon("img/6.jpg");      
Image changed_img6 = img6.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img6 = new ImageIcon(changed_img6);

ImageIcon img7 = new ImageIcon("img/7.jpg");      
Image changed_img7 = img7.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img7 = new ImageIcon(changed_img7);

ImageIcon img8 = new ImageIcon("img/8.jpg");      
Image changed_img8 = img8.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img8 = new ImageIcon(changed_img8);

ImageIcon img9 = new ImageIcon("img/9.jpg");      
Image changed_img9 = img9.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img9 = new ImageIcon(changed_img9);

ImageIcon img10 = new ImageIcon("img/10.jpg");      
Image changed_img10 = img10.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img10 = new ImageIcon(changed_img10);

ImageIcon img11 = new ImageIcon("img/11.jpg");      
Image changed_img11 = img1.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img11 = new ImageIcon(changed_img11);

ImageIcon img12 = new ImageIcon("img/12.jpg");      
Image changed_img12 = img12.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img12 = new ImageIcon(changed_img12);

ImageIcon img13 = new ImageIcon("img/13.jpg");      
Image changed_img13 = img13.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img13 = new ImageIcon(changed_img13);

ImageIcon img14= new ImageIcon("img/14.jpg");      
Image changed_img14 = img14.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img14 = new ImageIcon(changed_img14);

ImageIcon img15= new ImageIcon("img/15.jpg");      
Image changed_img15 = img15.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img15 = new ImageIcon(changed_img15);

ImageIcon img16 = new ImageIcon("img/16.jpg");      
Image changed_img16 = img16.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img16 = new ImageIcon(changed_img16);

ImageIcon img17 = new ImageIcon("img/1.jpg");      
Image changed_img17 = img17.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img17 = new ImageIcon(changed_img17);

ImageIcon img18 = new ImageIcon("img/18.jpg");      
Image changed_img18 = img18.getImage().getScaledInstance(281, 184,Image.SCALE_SMOOTH);
ImageIcon changed_icon_img18 = new ImageIcon(changed_img18);
         

   
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
      frame.setBounds(width, heigt, 1030, 711);
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
      menuView.setBounds(263, 0, 750, 672);
      menu.add(menuView);
      menuView.setLayout(menuLayout);
      
      
      //판매 화면
      JPanel panel_sell = new JPanel();
      menuView.add(panel_sell, "sell");
      panel_sell.setLayout(null);
      
      JPanel sell_page = new JPanel();
      sell_page.setLayout(null);
      sell_page.setBounds(0, 0, 501, 674);
      panel_sell.add(sell_page);
      
      JPanel next_1 = new JPanel();
      next_1.setLayout(null);
      next_1.setBounds(0, 36, 501, 638);
      sell_page.add(next_1);
      
      JLabel bread_1 = new JLabel("");
      bread_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            bread_1.setIcon(changed_icon_img2);
         }
         
         @Override
         public void mouseExited(MouseEvent e) {
            bread_1.setIcon(changed_icon_img1);
         }
      });
      next_1.add(bread_1);
      bread_1.setIcon(changed_icon_img1);

      
      bread_1.setBounds(12, 66, 220, 181);
      next_1.add(bread_1);
      
      JButton name_1 = new JButton("<html>\r\n<p style=\"text-align:center\">\uC2DD\uBE75<br>2000\uC6D0</p></html>");
      name_1.setFont(new Font("휴먼옛체", Font.PLAIN, 17));
      name_1.setBounds(12, 257, 220, 39);
      next_1.add(name_1);
      
      JLabel stock_1 = new JLabel("\uC794\uACE0 : 2222");
      stock_1.setHorizontalAlignment(SwingConstants.CENTER);
      stock_1.setFont(new Font("함초롬바탕", Font.PLAIN, 17));
      stock_1.setBounds(12, 295, 220, 25);
      next_1.add(stock_1);
      
      JLabel bread_2 = new JLabel("");
      bread_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            bread_2.setIcon(changed_icon_img4);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            bread_2.setIcon(changed_icon_img3);
         }
      });
      next_1.add(bread_2);
      bread_2.setIcon(changed_icon_img3);
      
      bread_2.setBounds(269, 66, 220, 181);
      next_1.add(bread_2);
      
      JButton name_2 = new JButton("<html>\r\n<p style=\"text-align:center\">\uC6B0\uC720\uC2DD\uBE75<br>2000\uC6D0</p></html>");
      name_2.setFont(new Font("휴먼옛체", Font.PLAIN, 17));
      name_2.setBounds(269, 257, 220, 39);
      next_1.add(name_2);
      
      JLabel stock_2 = new JLabel("\uC794\uACE0 : 2222");
      stock_2.setHorizontalAlignment(SwingConstants.CENTER);
      stock_2.setFont(new Font("함초롬바탕", Font.PLAIN, 17));
      stock_2.setBounds(269, 295, 220, 25);
      next_1.add(stock_2);
      
      JLabel bread_3 = new JLabel("");
      bread_3.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            bread_3.setIcon(changed_icon_img6);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            bread_3.setIcon(changed_icon_img5);
         }
      });
      next_1.add(bread_3);
      bread_3.setIcon(changed_icon_img5);
      
      JButton name_3 = new JButton("<html>\r\n<p style=\"text-align:center\">\uB2E8\uD325\uBE75<br>2000\uC6D0</p></html>");
      name_3.setFont(new Font("휴먼옛체", Font.PLAIN, 17));
      name_3.setBounds(12, 550, 220, 39);
      next_1.add(name_3);
      
      JLabel stock_3 = new JLabel("\uC794\uACE0 : 2222");
      stock_3.setHorizontalAlignment(SwingConstants.CENTER);
      stock_3.setFont(new Font("함초롬바탕", Font.PLAIN, 17));
      stock_3.setBounds(12, 591, 220, 25);
      next_1.add(stock_3);
      
      JLabel bread_4 = new JLabel("");
      bread_4.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            bread_4.setIcon(changed_icon_img8);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            bread_4.setIcon(changed_icon_img7);
         }
      });
      next_1.add(bread_4);
      bread_4.setIcon(changed_icon_img7);
      
      
      bread_4.setBounds(269, 369, 220, 181);
      next_1.add(bread_4);
      
      JButton name_4 = new JButton("<html>\r\n<p style=\"text-align:center\">\uD06C\uB9BC\uBE75<br>2000\uC6D0</p></html>");
      name_4.setFont(new Font("휴먼옛체", Font.PLAIN, 17));
      name_4.setBounds(269, 550, 220, 39);
      next_1.add(name_4);
      
      JLabel stock_4 = new JLabel("\uC794\uACE0 : 2222");
      stock_4.setHorizontalAlignment(SwingConstants.CENTER);
      stock_4.setFont(new Font("함초롬바탕", Font.PLAIN, 17));
      stock_4.setBounds(269, 591, 220, 25);
      next_1.add(stock_4);
      
      JButton after_1 = new JButton("\u25B6");
      after_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            
            next_1.setVisible(false);         
         }
      });
      after_1.setBounds(437, 0, 64, 50);
      next_1.add(after_1);
   
      //=================================================================================================================================================================================
      JPanel next_2 = new JPanel();
      next_2.setLayout(null);
      next_2.setBounds(0, 36, 501, 638);
      sell_page.add(next_2);
      
      JLabel bread_5 = new JLabel("");
      bread_5.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            bread_5.setIcon(changed_icon_img10);
            
         }
         @Override
         public void mouseExited(MouseEvent e) {
            bread_5.setIcon(changed_icon_img9);
            
         }
      });
      next_2.add(bread_5);
      bread_5.setIcon(changed_icon_img9);
      
      bread_5.setBounds(12, 66, 220, 181);
      next_2.add(bread_5);
      
      JButton name_5 = new JButton("<html>\r\n<p style=\"text-align:center\">\uBC14\uAC8C\uD2B8\uBE75<br>2000\uC6D0</p></html>");
      name_5.setFont(new Font("휴먼옛체", Font.PLAIN, 17));
      name_5.setBounds(12, 257, 220, 39);
      next_2.add(name_5);
      
      JLabel stock_5 = new JLabel("\uC794\uACE0 : 2222");
      stock_5.setHorizontalAlignment(SwingConstants.CENTER);
      stock_5.setFont(new Font("함초롬바탕", Font.PLAIN, 17));
      stock_5.setBounds(12, 295, 220, 25);
      next_2.add(stock_5);
      
      JLabel bread_6 = new JLabel("");
      bread_6.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            bread_6.setIcon(changed_icon_img12);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            bread_6.setIcon(changed_icon_img11);
         }
      });
      next_2.add(bread_6);
      bread_6.setIcon(changed_icon_img11);
      
      bread_6.setBounds(269, 66, 220, 181);
      next_2.add(bread_6);
      
      JButton name_6 = new JButton("<html>\r\n<p style=\"text-align:center\">\uBCA0\uC774\uAE00<br>2000\uC6D0</p></html>");
      name_6.setFont(new Font("휴먼옛체", Font.PLAIN, 17));
      name_6.setBounds(269, 257, 220, 39);
      next_2.add(name_6);
      
      JLabel stock_6 = new JLabel("\uC794\uACE0 : 2222");
      stock_6.setHorizontalAlignment(SwingConstants.CENTER);
      stock_6.setFont(new Font("함초롬바탕", Font.PLAIN, 17));
      stock_6.setBounds(269, 295, 220, 25);
      next_2.add(stock_6);
      
      JLabel bread_7 = new JLabel("");
      bread_7.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            bread_7.setIcon(changed_icon_img14);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            bread_7.setIcon(changed_icon_img13);
         }
      });
      next_2.add(bread_7);
      bread_7.setIcon(changed_icon_img13);
      
      
      bread_7.setBounds(12, 369, 220, 181);
      next_2.add(bread_7);
      
      JButton name_7 = new JButton("<html>\r\n<p style=\"text-align:center\">\uB2E8\uD325\uB3C4\uB11B<br>2000\uC6D0</p></html>");
      name_7.setFont(new Font("휴먼옛체", Font.PLAIN, 17));
      name_7.setBounds(12, 550, 220, 39);
      next_2.add(name_7);
      
      JLabel stock_7 = new JLabel("\uC794\uACE0 : 2222");
      stock_7.setHorizontalAlignment(SwingConstants.CENTER);
      stock_7.setFont(new Font("함초롬바탕", Font.PLAIN, 17));
      stock_7.setBounds(12, 591, 220, 25);
      next_2.add(stock_7);
      
      JLabel bread_8 = new JLabel("");
      bread_8.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            bread_8.setIcon(changed_icon_img16);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            bread_8.setIcon(changed_icon_img15);
         }
         
      });
      
      next_2.add(bread_8);
      bread_8.setIcon(changed_icon_img15);
      
      bread_8.setBounds(269, 369, 220, 181);
      next_2.add(bread_8);
      
      JButton name_8 = new JButton("<html>\r\n<p style=\"text-align:center\">\uAF48\uBC30\uAE30\uB3C4\uB11B<br>2000\uC6D0</p></html>");
      name_8.setFont(new Font("휴먼옛체", Font.PLAIN, 17));
      name_8.setBounds(269, 550, 220, 39);
      next_2.add(name_8);
      
      JLabel stock_8 = new JLabel("\uC794\uACE0 : 2222");
      stock_8.setHorizontalAlignment(SwingConstants.CENTER);
      stock_8.setFont(new Font("함초롬바탕", Font.PLAIN, 17));
      stock_8.setBounds(269, 591, 220, 25);
      next_2.add(stock_8);
      
      JButton before_2 = new JButton("\u25C0");
      before_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            
            next_1.setVisible(true);   
         }
      });
      before_2.setBounds(0, 0, 64, 50);
      next_2.add(before_2);
      
      JButton after_2 = new JButton("\u25B6");
      after_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            next_2.setVisible(false);
         }
      });
      after_2.setBounds(437, 0, 64, 50);
      next_2.add(after_2);
      //==================================================================================================================================================================================
      
      JPanel next_3 = new JPanel();
      next_3.setLayout(null);
      next_3.setBounds(0, 36, 501, 638);
      sell_page.add(next_3);
      
      JLabel bread_9 = new JLabel("");
      bread_9.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            bread_9.setIcon(changed_icon_img18);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            bread_9.setIcon(changed_icon_img17);
         }
      });
      
      next_3.add(bread_9);
      bread_9.setIcon(changed_icon_img17);
      
      bread_9.setBounds(12, 66, 220, 181);
      next_3.add(bread_9);
      
      JButton name_9 = new JButton("<html>\r\n<p style=\"text-align:center\">\uBAA8\uB2DD\uBE75<br>2000\uC6D0</p></html>");
      name_9.setFont(new Font("휴먼옛체", Font.PLAIN, 17));
      name_9.setBounds(12, 257, 220, 39);
      next_3.add(name_9);
      
      JLabel stock_9 = new JLabel("\uC794\uACE0 : 2222");
      stock_9.setHorizontalAlignment(SwingConstants.CENTER);
      stock_9.setFont(new Font("함초롬바탕", Font.PLAIN, 17));
      stock_9.setBounds(12, 295, 220, 25);
      next_3.add(stock_9);
      
      JButton before3 = new JButton("\u25C0");
      before3.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            next_2.setVisible(true);
         }
      });
      before3.setBounds(0, 0, 64, 50);
      next_3.add(before3);
      
      //==================================================================================================================================================================================
      JLabel label = new JLabel("\uD310\uB9E4");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setBounds(0, 0, 501, 40);
      sell_page.add(label);
      label.setFont(new Font("HY목각파임B", Font.BOLD, 22));
      
      JPanel panel_10 = new JPanel();
      panel_10.setBounds(501, 0, 249, 672);
      panel_sell.add(panel_10);
      panel_10.setLayout(null);
      
      JScrollPane scrollPane_2 = new JScrollPane();
      scrollPane_2.setBounds(0, 38, 249, 498);
      panel_10.add(scrollPane_2);
      
      JLabel label_2 = new JLabel("\uBA54\uB274");
      label_2.setHorizontalAlignment(SwingConstants.LEFT);
      label_2.setFont(new Font("함초롬바탕", Font.BOLD, 20));
      label_2.setBounds(0, 0, 113, 40);
      panel_10.add(label_2);
      
      JLabel label_3 = new JLabel("\uC218\uB7C9");
      label_3.setHorizontalAlignment(SwingConstants.CENTER);
      label_3.setFont(new Font("함초롬바탕", Font.BOLD, 20));
      label_3.setBounds(114, 0, 46, 40);
      panel_10.add(label_3);
      
      JLabel label_4 = new JLabel("\uAC00\uACA9");
      label_4.setHorizontalAlignment(SwingConstants.CENTER);
      label_4.setFont(new Font("함초롬바탕", Font.BOLD, 20));
      label_4.setBounds(160, 0, 89, 40);
      panel_10.add(label_4);
      
      JButton btnPayment = new JButton("PAYMENT");
      btnPayment.setBounds(103, 616, 146, 56);
      panel_10.add(btnPayment);
      
      JButton btnNewButton_1 = new JButton("RESET");
      btnNewButton_1.setBounds(0, 616, 106, 56);
      panel_10.add(btnNewButton_1);
      
      JLabel label_6 = new JLabel("\uCD1D \uC218\uB7C9:");
      label_6.setBounds(0, 534, 249, 45);
      panel_10.add(label_6);
      label_6.setHorizontalAlignment(SwingConstants.LEFT);
      label_6.setFont(new Font("함초롬바탕", Font.BOLD, 24));
      
      JLabel label_7 = new JLabel("\uCD1D \uAC00\uACA9 :");
      label_7.setBounds(0, 574, 249, 45);
      panel_10.add(label_7);
      label_7.setHorizontalAlignment(SwingConstants.LEFT);
      label_7.setFont(new Font("함초롬바탕", Font.BOLD, 24));
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      
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
      
      // 발주 화면---------------------------------------------------------------------------
      
      // 테이블
      String[] colname = { "주문번호", "재료이름", "발주일자", "발주수량", "도착일자" };

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
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(29, 99, 674, 347);
      panel.add(scrollPane);
      scrollPane.setViewportView(table);
      
      //테이블 클릭  ********************************************살짝 오류있음 빈칸 누를시 오류뜨는거 차후 수정
      JTable table = new JTable(data, colname);
      table.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int row = table.getSelectedRow();      
            selected_dvr_num = (String) table.getModel().getValueAt(row, 0);
            String selected_inname = (String) table.getModel().getValueAt(row, 1);
            String selected_dvrdate = (String) table.getModel().getValueAt(row, 2);
            String selected_dvrcnt = (String) table.getModel().getValueAt(row, 3);
            String selected_rcvdate = (String) table.getModel().getValueAt(row, 4);
         }
      });

      table.setFillsViewportHeight(true);
      scrollPane.setViewportView(table);

      //아직 못만든 콤보박스
      JComboBox comboBox = new JComboBox();
      comboBox.setBounds(594, 68, 109, 21);
      panel.add(comboBox);
      
      //주문페이지 추가생성 버튼
      JButton btnNewButton = new JButton("\uC8FC\uBB38");
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            new Order_in();
         }
      });

      
      
      //매출화면
      JPanel panel_sls = new JPanel();
      menuView.add(panel_sls, "sls");
      panel_sls.setLayout(null);
      
      JLabel lblNewLabel_2 = new JLabel("\uB9E4\uCD9C");
      lblNewLabel_2.setBounds(304, 271, 57, 15);
      panel_sls.add(lblNewLabel_2);
      
      
      //메뉴 목록 화면
      JPanel menuList = new JPanel();
      menuList.setBounds(0, 0, 264, 672);
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
      lbl_rcp.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_rcp.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            menuLayout.show(menuView, "rcp");//클릭 시 rcp패널 출력            
         }
      });
      lbl_rcp.setBounds(0, 226, 264, 44);
      menuList.add(lbl_rcp);
      
      JLabel lbl_ord = new JLabel("\uBC1C\uC8FC");
      lbl_ord.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_ord.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            menuLayout.show(menuView, "ord");//클릭 시 ord패널 출력
         }
      });
      lbl_ord.setBounds(0, 280, 264, 51);
      menuList.add(lbl_ord);
      
      JLabel lbl_sls = new JLabel("\uB9E4\uCD9C");
      lbl_sls.setHorizontalAlignment(SwingConstants.CENTER);
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