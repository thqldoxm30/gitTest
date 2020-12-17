package kr.co.daters.domain;

import java.io.Serializable;

public class BranchOfficeVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int boAdminChk;
	private int boCode;
	private String boId;
	private String boPwd;
	private String boName;
	private long boUsers;
	private long boTotalRevenue;
	private long boNetProfit;
	private long boCost;
	
	public int getBoAdminChk() {
		return boAdminChk;
	}
	public void setBoAdminChk(int boAdminChk) {
		this.boAdminChk = boAdminChk;
	}
	public int getBoCode() {
		return boCode;
	}
	public void setBoCode(int boCode) {
		this.boCode = boCode;
	}
	public String getBoId() {
		return boId;
	}
	public void setBoId(String boId) {
		this.boId = boId;
	}
	public String getBoPwd() {
		return boPwd;
	}
	public void setBoPwd(String boPwd) {
		this.boPwd = boPwd;
	}
	public String getBoName() {
		return boName;
	}
	public void setBoName(String boName) {
		this.boName = boName;
	}
	public long getBoUsers() {
		return boUsers;
	}
	public void setBoUsers(long boUsers) {
		this.boUsers = boUsers;
	}
	public long getBoTotalRevenue() {
		return boTotalRevenue;
	}
	public void setBoTotalRevenue(long boTotalRevenue) {
		this.boTotalRevenue = boTotalRevenue;
	}
	public long getBoNetProfit() {
		return boNetProfit;
	}
	public void setBoNetProfit(long boNetProfit) {
		this.boNetProfit = boNetProfit;
	}
	public long getBoCost() {
		return boCost;
	}
	public void setBoCost(long boCost) {
		this.boCost = boCost;
	}
	
	@Override
	public String toString() {
		return "BranchOfficeVO [boAdminChk=" + boAdminChk + ", boCode=" + boCode + ", boId=" + boId + ", boPwd=" + boPwd
				+ ", boName=" + boName + ", boUsers=" + boUsers + ", boTotalRevenue=" + boTotalRevenue
				+ ", boNetProfit=" + boNetProfit + ", boCost=" + boCost + "]";
	}

}
