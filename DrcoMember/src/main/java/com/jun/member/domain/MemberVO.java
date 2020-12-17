package com.jun.member.domain;

import java.io.Serializable;
import java.util.Date;

public class MemberVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String dc_id;
	private String dc_password;
	private String dc_name;
	private int dc_birth;
	private String dc_gender;
	private String dc_address;
	private String dc_email;
	private Date dc_regDate;
	private int dc_grade;
	private int dc_state;
	private int dc_boardCnt;
	private int dc_commCnt;
	private int dc_enterCnt;
	
//	회원 탐색
	private String searchGender;
	
	
	
	public String getSearchGender() {
		return searchGender;
	}
	public void setSearchGender(String searchGender) {
		this.searchGender = searchGender;
	}
	public String getDc_id() {
		return dc_id;
	}
	public void setDc_id(String dc_id) {
		this.dc_id = dc_id;
	}
	public String getDc_password() {
		return dc_password;
	}
	public void setDc_password(String dc_password) {
		this.dc_password = dc_password;
	}
	public String getDc_name() {
		return dc_name;
	}
	public void setDc_name(String dc_name) {
		this.dc_name = dc_name;
	}
	public int getDc_birth() {
		return dc_birth;
	}
	public void setDc_birth(int dc_birth) {
		this.dc_birth = dc_birth;
	}
	public String getDc_address() {
		return dc_address;
	}
	public void setDc_address(String dc_address) {
		this.dc_address = dc_address;
	}
	public String getDc_email() {
		return dc_email;
	}
	public void setDc_email(String dc_email) {
		this.dc_email = dc_email;
	}
	public Date getDc_regDate() {
		return dc_regDate;
	}
	public void setDc_regDate(Date dc_regDate) {
		this.dc_regDate = dc_regDate;
	}
	public int getDc_grade() {
		return dc_grade;
	}
	public void setDc_grade(int dc_grade) {
		this.dc_grade = dc_grade;
	}
	public int getDc_state() {
		return dc_state;
	}
	public void setDc_state(int dc_state) {
		this.dc_state = dc_state;
	}
	public int getDc_boardCnt() {
		return dc_boardCnt;
	}
	public void setDc_boardCnt(int dc_boardCnt) {
		this.dc_boardCnt = dc_boardCnt;
	}
	public int getDc_commCnt() {
		return dc_commCnt;
	}
	public void setDc_commCnt(int dc_commCnt) {
		this.dc_commCnt = dc_commCnt;
	}
	public int getDc_enterCnt() {
		return dc_enterCnt;
	}
	public void setDc_enterCnt(int dc_enterCnt) {
		this.dc_enterCnt = dc_enterCnt;
	}
	
	
	@Override
	public String toString() {
		return "MemberVO [dc_id=" + dc_id + ", dc_password=" + dc_password + ", dc_name=" + dc_name + ", dc_birth="
				+ dc_birth + ", dc_gender=" + dc_gender + ", dc_address=" + dc_address + ", dc_email=" + dc_email
				+ ", dc_regDate=" + dc_regDate + ", dc_grade=" + dc_grade + ", dc_state=" + dc_state + ", dc_boardCnt="
				+ dc_boardCnt + ", dc_commCnt=" + dc_commCnt + ", dc_enterCnt=" + dc_enterCnt + "]";
	}
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemberVO(String dc_id, String dc_password, String dc_name, int dc_birth, String dc_gender) {
		super();
		this.dc_id = dc_id;
		this.dc_password = dc_password;
		this.dc_name = dc_name;
		this.dc_birth = dc_birth;
		this.dc_gender = dc_gender;
	}
	
	
	public MemberVO(String dc_id, String dc_password, String dc_name, int dc_birth, String dc_gender, String dc_address,
			String dc_email) {
		super();
		this.dc_id = dc_id;
		this.dc_password = dc_password;
		this.dc_name = dc_name;
		this.dc_birth = dc_birth;
		this.dc_gender = dc_gender;
		this.dc_address = dc_address;
		this.dc_email = dc_email;
	}
	public String getDc_gender() {
		return dc_gender;
	}
	public void setDc_gender(String dc_gender) {
		this.dc_gender = dc_gender;
	}
	
	
	
	
	
	
}
