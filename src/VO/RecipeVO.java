package VO;

public class RecipeVO {
   private String inName;
   private String brdName;
   private String rcpCnt;
   public RecipeVO(String in_name, String brd_name, String rcpCnt) {
      super();
      this.inName = in_name;
      this.brdName = brd_name;
      this.rcpCnt = rcpCnt;
   }
   public String getInName() {
      return inName;
   }
   public String getBrdName() {
      return brdName;
   }
   public String getRcpCnt() {
      return rcpCnt;
   }
   
   
   
}