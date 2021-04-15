package VO;

public class BreadVO {
	
	private String brd_code;
	private String brd_name;
	private int brd_cnt;
	private int brd_prc;
	
	public BreadVO(String brd_code, String brd_name, int brd_cnt, int brd_prc) {
		super();
		this.brd_code = brd_code;
		this.brd_name = brd_name;
		this.brd_cnt = brd_cnt;
		this.brd_prc = brd_prc;
	}

	public String getBrd_code() {
		return brd_code;
	}

	public void setBrd_code(String brd_code) {
		this.brd_code = brd_code;
	}

	public String getBrd_name() {
		return brd_name;
	}

	public void setBrd_name(String brd_name) {
		this.brd_name = brd_name;
	}

	public int getBrd_cnt() {
		return brd_cnt;
	}

	public void setBrd_cnt(int brd_cnt) {
		this.brd_cnt = brd_cnt;
	}

	public int getBrd_prc() {
		return brd_prc;
	}

	public void setBrd_prc(int brd_prc) {
		this.brd_prc = brd_prc;
	}
	
	
	
	
}
