package VO;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String hobby;
	
	public MemberVO(String id, String pw, String name, String gender, String hobby) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.hobby = hobby;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getHobby() {
		return hobby;
	}
	
	
}
