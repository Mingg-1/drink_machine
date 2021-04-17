package VO;

public class RecipeVO {
   private String in_name;
   private String brd_name;
   private int rcp_cnt;
   
   public RecipeVO(String in_name,String brd_name, int rcp_cnt) {
      super();
      this.in_name = in_name;
      this.brd_name = brd_name;
      this.rcp_cnt = rcp_cnt;
   }
   
   public RecipeVO(String in_name, int rcp_cnt) {
      super();
      this.in_name = in_name;
//      this.brd_name = brd_name;
      this.rcp_cnt = rcp_cnt;
   }
   
   public String getIn_name() {
      return in_name;
   }
   public String getBrd_name() {
      return brd_name;
   }
   public int getRcp_cnt() {
      return rcp_cnt;
   }
   
   

}