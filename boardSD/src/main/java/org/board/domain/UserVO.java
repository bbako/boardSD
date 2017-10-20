package org.board.domain;

public class UserVO {
	
	String member_id, member_name, member_pw;

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	@Override
	public String toString() {
		return "LoginVO [member_id=" + member_id + ", member_name=" + member_name + ", member_pw=" + member_pw + "]";
	}
	
}
