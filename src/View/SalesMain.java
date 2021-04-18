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

//   ֺκ  import-------------------------------------------------
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
//-------------------------------------------------        

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.ui.TextAnchor;

//       import-------------------adasd---------------------------------------------------
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
import java.awt.Rectangle;
//-------------------------------------------------         

public class SalesMain {

   private JFrame frame;
   CardLayout menuLayout; // ī 巹 ̾ƿ      
   //     ̹       澲---------------------------------------------
   private JLabel lbl_sell, lbl_mtr, lbl_rcp, lbl_ord, lbl_sls;
   ////////////////  ǸŹ ư///////////////////////////////////////
   //    ϴ   ̹   
   ImageIcon clicksell = new ImageIcon("btn/clicksell.png");
   Image clicksell1 = clicksell.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
   ImageIcon click_sell = new ImageIcon(clicksell1);
   //       ̹   
   ImageIcon sellbtn = new ImageIcon("btn/sellbtn.png");
   Image sellbtn1 = sellbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
   ImageIcon sell_btn = new ImageIcon(sellbtn1);

   ////////////////     ư///////////////////////////////////////
   //    ϴ   ̹   
   ImageIcon clickmtr = new ImageIcon("btn/clickmtr.png");
   Image clickmtr1 = clickmtr.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
   ImageIcon click_mtr = new ImageIcon(clickmtr1);
   //       ̹   
   ImageIcon mtrbtn = new ImageIcon("btn/mtrbtn.png");
   Image mtrbtn1 = mtrbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
   ImageIcon mtr_btn = new ImageIcon(mtrbtn1);

   ////////////////      ǹ ư///////////////////////////////////////
   //    ϴ   ̹   
   ImageIcon clickrcp = new ImageIcon("btn/clickrcp.png");
   Image clickrcp1 = clickrcp.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
   ImageIcon click_rcp = new ImageIcon(clickrcp1);
   //       ̹   
   ImageIcon rcpbtn = new ImageIcon("btn/rcpbtn.png");
   Image rcpbtn1 = rcpbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
   ImageIcon rcp_btn = new ImageIcon(rcpbtn1);

   ////////////////    ֹ ư///////////////////////////////////////
   //    ϴ   ̹   
   ImageIcon clickodr = new ImageIcon("btn/clickodr.png");
   Image clickodr1 = clickodr.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
   ImageIcon click_odr = new ImageIcon(clickodr1);
   //       ̹   
   ImageIcon odrbtn = new ImageIcon("btn/odrbtn.png");
   Image odrbtn1 = odrbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
   ImageIcon odr_btn = new ImageIcon(odrbtn1);

   ////////////////      ư///////////////////////////////////////
   //    ϴ   ̹   
   ImageIcon clicksls = new ImageIcon("btn/clicksls.png");
   Image clicksls1 = clicksls.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
   ImageIcon click_sls = new ImageIcon(clicksls1);
   //       ̹   
   ImageIcon slsbtn = new ImageIcon("btn/slsbtn.png");
   Image slsbtn1 = slsbtn.getImage().getScaledInstance(264, 51, Image.SCALE_SMOOTH);
   ImageIcon sls_btn = new ImageIcon(slsbtn1);
   private JPanel panel_1;
   private JPanel panel_2;
   private JPanel panel;
   // ------------------------------------------------------     

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
                  PolylineBarChart demo = new PolylineBarChart();
                   JFreeChart chart = demo.getChart();
                   ChartFrame frame1=new ChartFrame("Bar Chart",chart);
                   frame1.setBounds(new Rectangle(722, 556, 0, 0));
                   frame1.setSize(742,290); 
                   frame1.setVisible(true);   
//               SalesMain window = new SalesMain();
//               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public SalesMain() {
      initialize();
      frame.setVisible(true);
   }

   private void initialize() {
      frame = new JFrame();
      //       â ũ  
      int use_width = 1029;
      int use_heigt = 631;
      // â                (  ġ   ) >   Ȯ    ߾ӿ      
      int get_width = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
      int get_heigt = Toolkit.getDefaultToolkit().getScreenSize().height / 2;
      //  ߾ӿ   ߰    ġ    
      int width = get_width - use_width / 2;
      int heigt = get_heigt - use_heigt / 2;
      // â   ġ     
      frame.setBounds(width, heigt, use_width, use_heigt);
      frame.setBackground(new Color(230, 230, 230));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      menuLayout = new CardLayout();

//////////////      //  ޴  ȭ  ////////////////////////////////////////////////////////////////////////

      //  ̹     ҷ     
      ImageIcon mnbg = new ImageIcon("img/bg.png");
      Image img1 = mnbg.getImage();
      // ũ           ̹     ҷ     
      ImageIcon mnbg1 = new ImageIcon(img1);
      //  г         ϰ   ̹        
      JPanel menu = new JPanel() {
         protected void paintComponent(Graphics g) {
            g.drawImage(mnbg1.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      //  θ   гο        ̹            г     ߰ 
      menu.setBounds(0, 0, 1015, 594);
      frame.getContentPane().add(menu);
      menu.setLayout(null);

      //  ̹     ҷ     
      ImageIcon mvbg = new ImageIcon("img/menubg.png");
      Image img2 = mvbg.getImage();
      // ũ           ̹     ҷ     
      ImageIcon mvbg1 = new ImageIcon(img2);
      //  г         ϰ   ̹        
      JPanel menuView = new JPanel() {
         protected void paintComponent(Graphics g) {
            g.drawImage(mvbg1.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      //  θ   гο        ̹            г     ߰ 
      menuView.setBounds(263, 0, 750, 592);
      menu.add(menuView);
      menuView.setLayout(menuLayout);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////      //     ȭ  ////////////////////////////////////////////////////////////////////////////////////////

      //  ̹     ҷ     
      ImageIcon slsbg = new ImageIcon("img/menubg.png");
      Image img8 = slsbg.getImage(); // Image          = ImageIcon      .getImage();
      // ũ           ̹     ҷ     
      ImageIcon slsbg1 = new ImageIcon(img8); // ImageIcon          = new ImageIcon(Image    );
      //  г         ϰ   ̹        
      JPanel panel_sls = new JPanel() { // JPanel  г  ̸  = new JPanel()
         protected void paintComponent(Graphics g) {
            g.drawImage(slsbg1.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      //  θ   гο        ̹            г     ߰ 
      menuView.add(panel_sls, "sls"); //  θ  г .add(     г  ̸ , " ̸ ");
      panel_sls.setLayout(null);
      
      panel_1 = new JPanel();
      panel_1.setBounds(12, 10, 351, 303);
      panel_sls.add(panel_1);
      
      panel_2 = new JPanel();
      panel_2.setBounds(387, 10, 351, 303);
      panel_sls.add(panel_2);
      
      panel = new JPanel();
      panel.setBounds(12, 337, 726, 245);
      panel_sls.add(panel);
      
      
      
      
      
      

//////////////////////      //  ޴      ȭ  /////////////////////////////////////////////////////////////////////////////////////////

      //  ̹     ҷ     
      ImageIcon mlbg = new ImageIcon("img/menulist.png");
      Image img10 = mlbg.getImage(); // Image          = ImageIcon      .getImage();
      // ũ           ̹     ҷ     
      ImageIcon mlbg1 = new ImageIcon(img10); // ImageIcon          = new ImageIcon(Image    );
      //  г         ϰ   ̹        
      JPanel menuList = new JPanel() { // JPanel  г  ̸  = new JPanel()
         protected void paintComponent(Graphics g) {
            g.drawImage(mlbg1.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      //  θ   гο        ̹            г     ߰ 
      menuList.setBounds(0, 0, 264, 592);
      menu.add(menuList); //  θ  г .add(     г  ̸ , " ̸ ");
      menuList.setLayout(null);

/////////////// Ǹ    ư///////////////////////////
      lbl_sell = new JLabel("");
      lbl_sell.setForeground(Color.WHITE);
      lbl_sell.setFont(new Font("210      غ  R", Font.BOLD, 24));
      lbl_sell.setHorizontalAlignment(SwingConstants.CENTER);

      lbl_sell.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            new Main();
            frame.dispose(); //      Windowâ     
         }

         //    콺    ÷      
         @Override
         public void mouseEntered(MouseEvent e) {
            lbl_sell.setIcon(click_sell);
            
            // ٸ   ư    󺹱 
            lbl_mtr.setIcon(mtr_btn);
            lbl_ord.setIcon(odr_btn);
            lbl_rcp.setIcon(rcp_btn);
            lbl_sls.setIcon(sls_btn);
            //lbl_sell.setIcon(sell_btn);
         }

         @Override
         public void mousePressed(MouseEvent e) {//    콺          
            lbl_sell.setIcon(click_sell);
            
            // ٸ   ư    󺹱 
            lbl_mtr.setIcon(mtr_btn);
            lbl_ord.setIcon(odr_btn);
            lbl_rcp.setIcon(rcp_btn);
            lbl_sls.setIcon(sls_btn);
            //lbl_sell.setIcon(sell_btn);
         }
      });

      menuList.add(lbl_sell);
      //  ⺻  ̹   
      lbl_sell.setIcon(sell_btn);
      lbl_sell.setBounds(0, 206, 264, 51);

///////////////////////    ư////////////////////////////////////////////////////////////      
      lbl_mtr = new JLabel("");
      lbl_mtr.setForeground(Color.WHITE);
      lbl_mtr.setFont(new Font("210      غ  R", Font.BOLD, 24));
      lbl_mtr.setHorizontalAlignment(SwingConstants.CENTER);

      lbl_mtr.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            new MtrMain();
            frame.dispose(); //      Windowâ     
         }

         //    콺    ÷      
         @Override
         public void mouseEntered(MouseEvent e) {
            lbl_mtr.setIcon(click_mtr);
            // ٸ   ư    󺹱 
            //lbl_mtr.setIcon(mtr_btn);
            lbl_ord.setIcon(odr_btn);
            lbl_rcp.setIcon(rcp_btn);
            lbl_sls.setIcon(sls_btn);
            lbl_sell.setIcon(sell_btn);
         }

         @Override
         public void mousePressed(MouseEvent e) {//    콺          
            lbl_mtr.setIcon(click_mtr);
            // ٸ   ư    󺹱 
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

////////////////         ư////////////////////////////////////////////////////////////////      
      lbl_rcp = new JLabel("");
      lbl_rcp.setForeground(Color.WHITE);
      lbl_rcp.setFont(new Font("210      غ  R", Font.BOLD, 24));
      lbl_rcp.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_rcp.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            new RecipeMain();
            frame.dispose(); //      Windowâ     
         }

         //    콺    ÷      
         @Override
         public void mouseEntered(MouseEvent e) {
            lbl_rcp.setIcon(click_rcp);
            // ٸ   ư    󺹱 
            lbl_mtr.setIcon(mtr_btn);
            lbl_ord.setIcon(odr_btn);
            //lbl_rcp.setIcon(rcp_btn);
            lbl_sls.setIcon(sls_btn);
            lbl_sell.setIcon(sell_btn);
         }

         @Override
         public void mousePressed(MouseEvent e) {//    콺          
            lbl_rcp.setIcon(click_rcp);
            // ٸ   ư    󺹱 
            lbl_mtr.setIcon(mtr_btn);
            lbl_ord.setIcon(odr_btn);
            //lbl_rcp.setIcon(rcp_btn);
            lbl_sls.setIcon(sls_btn);
            lbl_sell.setIcon(sell_btn);
         }
      });
      lbl_rcp.setBounds(0, 326, 264, 51);
      menuList.add(lbl_rcp);

/////////////////////   ֹ ư///////////////////////////////////////////////////////////////////      
      lbl_ord = new JLabel("");
      lbl_ord.setForeground(Color.WHITE);
      lbl_ord.setFont(new Font("210      غ  R", Font.BOLD, 24));
      lbl_ord.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_ord.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            new DeliveryMain();
            frame.dispose(); //      Windowâ     
         }

         //    콺    ÷      
         @Override
         public void mouseEntered(MouseEvent e) {
            lbl_ord.setIcon(click_odr);
            // ٸ   ư    󺹱 
            lbl_mtr.setIcon(mtr_btn);
            //lbl_ord.setIcon(odr_btn);
            lbl_rcp.setIcon(rcp_btn);
            lbl_sls.setIcon(sls_btn);
            lbl_sell.setIcon(sell_btn);
         }

         @Override
         public void mousePressed(MouseEvent e) {//    콺          
            lbl_ord.setIcon(click_odr);
            // ٸ   ư    󺹱 
            lbl_mtr.setIcon(mtr_btn);
            //lbl_ord.setIcon(odr_btn);
            lbl_rcp.setIcon(rcp_btn);
            lbl_sls.setIcon(sls_btn);
            lbl_sell.setIcon(sell_btn);
         }
      });
      lbl_ord.setBounds(0, 387, 264, 51);
      menuList.add(lbl_ord);

///////////////////////////////     ư////////////////////////////////////////////////      
      lbl_sls = new JLabel("");
      lbl_sls.setForeground(Color.WHITE);
      lbl_sls.setFont(new Font("210      غ  R", Font.BOLD, 24));
      lbl_sls.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_sls.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            lbl_sls.setIcon(click_sls);
            menuLayout.show(menuView, "sls");// Ŭ      sls г     
         }

         //    콺    ÷      
         @Override
         public void mouseEntered(MouseEvent e) {
            lbl_sls.setIcon(click_sls);
            // ٸ   ư    󺹱 
            lbl_mtr.setIcon(mtr_btn);
            lbl_ord.setIcon(odr_btn);
            lbl_rcp.setIcon(rcp_btn);
            //lbl_sls.setIcon(sls_btn);
            lbl_sell.setIcon(sell_btn);
         }

         @Override
         public void mousePressed(MouseEvent e) {//    콺          
            lbl_sls.setIcon(click_sls);
            // ٸ   ư    󺹱 
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
   
   
    public JFreeChart getChart() {

        // 데이터 생성

        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();                // bar chart 1
        DefaultCategoryDataset dataset12 = new DefaultCategoryDataset();         // bar chart 2
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();                // line chart 1

        // 데이터 입력 ( 값, 범례, 카테고리 )

        // 그래프 1       

        dataset1.addValue(1050.0, "S1", "1월");
        dataset1.addValue(1500.0, "S1", "2월");
        dataset1.addValue(1200.0, "S1", "3월");
        dataset1.addValue(900.0, "S1", "4월");
        dataset1.addValue(0.0, "S1", "5월");
        dataset1.addValue(0.0, "S1", "6월");
        dataset1.addValue(0.0, "S1", "7월");
        dataset1.addValue(0.0, "S1", "8월");
        dataset1.addValue(0, "S1", "9월");
        dataset1.addValue(0, "S1", "10월");
        dataset1.addValue(0, "S1", "11월");
        dataset1.addValue(0, "S1", "12월");
 

        // 렌더링 생성 및 세팅
        // 렌더링 생성
        final BarRenderer renderer = new BarRenderer();
        final BarRenderer renderer12 = new BarRenderer();
        final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();

       // 공통 옵션 정의

        final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
        final ItemLabelPosition p_center = new ItemLabelPosition(
               ItemLabelAnchor.CENTER, TextAnchor.CENTER
            );

        final ItemLabelPosition p_below = new ItemLabelPosition(
                     ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT
                     );

        Font f = new Font("Gulim", Font.BOLD, 14);
        Font axisF = new Font("Gulim", Font.PLAIN, 14); 

        // 렌더링 세팅
        // 그래프 1

        renderer.setBaseItemLabelGenerator(generator);

        renderer.setBaseItemLabelsVisible(true);

        renderer.setBasePositiveItemLabelPosition(p_center);

        renderer.setBaseItemLabelFont(f);

//        renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(

//                GradientPaintTransformType.VERTICAL));

//        renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f, 0.0f, Color.blue));

        renderer.setSeriesPaint(0, new Color(0,162,255));


        // plot 생성

        final CategoryPlot plot = new CategoryPlot();

        // plot 에 데이터 적재

        plot.setDataset(dataset1);
        plot.setRenderer(renderer);
        plot.setDataset(1,dataset12);
        plot.setRenderer(1,renderer12);
        plot.setDataset(2, dataset2);
        plot.setRenderer(2, renderer2);

        // plot 기본 설정

        plot.setOrientation(PlotOrientation.VERTICAL);             // 그래프 표시 방향
        plot.setRangeGridlinesVisible(true);                       // X축 가이드 라인 표시여부
        plot.setDomainGridlinesVisible(true);                      // Y축 가이드 라인 표시여부

 
        // 렌더링 순서 정의 : dataset 등록 순서대로 렌더링 ( 즉, 먼저 등록한게 아래로 깔림 )

        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);    

        // X축 세팅

        plot.setDomainAxis(new CategoryAxis());              // X축 종류 설정
        plot.getDomainAxis().setTickLabelFont(axisF); // X축 눈금라벨 폰트 조정
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);       // 카테고리 라벨 위치 조정

        // Y축 세팅

        plot.setRangeAxis(new NumberAxis());                 // Y축 종류 설정
        plot.getRangeAxis().setTickLabelFont(axisF);  // Y축 눈금라벨 폰트 조정
       
        // 세팅된 plot을 바탕으로 chart 생성

        final JFreeChart chart = new JFreeChart(plot);

//        chart.setTitle("Overlaid Bar Chart"); // 차트 타이틀

//        TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));

//        copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);

//        chart.addSubtitle(copyright);  // 차트 서브 타이틀

        return chart;

    }
   
   
}