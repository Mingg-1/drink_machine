package VO;

public class wrhVO{
	
	private String in_code ;
	private String in_name ;
	private int use_in_cnt ;
	private int wrh_in_cnt ;
	private int dvr_cnt ;
	private String din_name ;
	private int whr_cnt = wrh_in_cnt+dvr_cnt;

	public wrhVO(String in_code, String in_name, int use_in_cnt, int wrh_in_cnt, int dvr_cnt, String din_name) {
		super();
		this.in_code = in_code;
		this.in_name = in_name;
		this.use_in_cnt = use_in_cnt;
		this.wrh_in_cnt = wrh_in_cnt;
		this.dvr_cnt = dvr_cnt;
		this.din_name = din_name;
	}

	public wrhVO(String in_code, String in_name, int use_in_cnt, int whr_cnt) {
		super();
		this.in_code = in_code;
		this.in_name = in_name;
		this.use_in_cnt = use_in_cnt;
		this.whr_cnt = whr_cnt;
	}
	
	public int getWhr_cnt() {
		return whr_cnt;
	}
	
	public void setWhr_cnt(int whr_cnt) {
		this.whr_cnt = whr_cnt;
	}

	public String getDin_name() {
		return din_name;
	}

	public void setDin_name(String din_name) {
		this.din_name = din_name;
	}
	
	public String getIn_code() {
		return in_code;
	}

	public void setIn_code(String in_code) {
		this.in_code = in_code;
	}

	public String getIn_name() {
		return in_name;
	}

	public void setIn_name(String in_name) {
		this.in_name = in_name;
	}

	public int getUse_in_cnt() {
		return use_in_cnt;
	}

	public void setUse_in_cnt(int use_in_cnt) {
		this.use_in_cnt = use_in_cnt;
	}

	public int getWrh_in_cnt() {
		return wrh_in_cnt;
	}

	public void setWrh_in_cnt(int wrh_in_cnt) {
		this.wrh_in_cnt = wrh_in_cnt;
	}

	public int getDvr_cnt() {
		return dvr_cnt;
	}

	public void setDvr_cnt(int dvr_cnt) {
		this.dvr_cnt = dvr_cnt;
	}
	
	
}
