package VO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DeliveryVO {
   private String dvr_num;
   private String in_name;
   private String dvr_date;
   private String dvr_cnt;
   private String rcv_date;
   
   public DeliveryVO(String dvr_num, String in_name, String dvr_date, String dvr_cnt, String rcv_date) {
      super();
      this.dvr_num = dvr_num;
      this.in_name = in_name;
      this.dvr_date = dvr_date;
      this.dvr_cnt = dvr_cnt;
      this.rcv_date = rcv_date;
   }


   public String getDvr_num() {
      return dvr_num;
   }

   public String getIn_name() {
      return in_name;
   }

   public String getDvr_date() {
      return dvr_date;
   }

   public String getDvr_cnt() {
      return dvr_cnt;
   }

   public String getRcv_date() {
      return rcv_date;
   }
   
   
   
}