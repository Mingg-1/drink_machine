package VO;

public class mtrVO {

	private String in_code;
	private String in_name;
	private int use_in_cnt;
	private int in_prc;
	private int wrh_in_cnt;
	
	//DB에서 가져온 재료정보를 초기화
	public mtrVO(String in_code, String in_name, int use_in_cnt, int in_prc, int wrh_in_cnt) {
		super();
		this.in_code = in_code;
		this.in_name = in_name;
		this.use_in_cnt = use_in_cnt;
		this.in_prc = in_prc;
		this.wrh_in_cnt = wrh_in_cnt;
	}

	public mtrVO(String in_name, int use_in_cnt) {
		this.in_name = in_name;
		this.use_in_cnt = use_in_cnt;
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

	public int getIn_prc() {
		return in_prc;
	}

	public void setIn_prc(int in_prc) {
		this.in_prc = in_prc;
	}

	public int getWrh_in_cnt() {
		return wrh_in_cnt;
	}

	public void setWrh_in_cnt(int wrh_in_cnt) {
		this.wrh_in_cnt = wrh_in_cnt;
	}
	
	

	
	
	
	
}
