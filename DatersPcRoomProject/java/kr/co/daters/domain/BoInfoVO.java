package kr.co.daters.domain;

import java.io.Serializable;
import java.sql.Date;

public class BoInfoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int boCode;
	private String boName;
	private String boOrderName;
	private String boOrderGender;
	private Date boOpendate;
	private	String boIntro;
	private	long boTotalseat;
	private	String boAddress;
	private String boTell;
	private int boPrinter;
	
	
	
	public String getBoName() {
		return boName;
	}
	public void setBoName(String boName) {
		this.boName = boName;
	}
	public int getBoCode() {
		return boCode;
	}
	public void setBoCode(int boCode) {
		this.boCode = boCode;
	}
	public String getBoOrderName() {
		return boOrderName;
	}
	public void setBoOrderName(String boOrderName) {
		this.boOrderName = boOrderName;
	}
	public String getBoOrderGender() {
		return boOrderGender;
	}
	public void setBoOrderGender(String boOrderGender) {
		this.boOrderGender = boOrderGender;
	}
	public Date getBoOpendate() {
		return boOpendate;
	}
	public void setBoOpendate(Date boOpendate) {
		this.boOpendate = boOpendate;
	}
	public String getBoIntro() {
		return boIntro;
	}
	public void setBoIntro(String boIntro) {
		this.boIntro = boIntro;
	}
	public long getBoTotalseat() {
		return boTotalseat;
	}
	public void setBoTotalseat(long boTotalseat) {
		this.boTotalseat = boTotalseat;
	}
	public String getBoAddress() {
		return boAddress;
	}
	public void setBoAddress(String boAddress) {
		this.boAddress = boAddress;
	}
	public String getBoTell() {
		return boTell;
	}
	public void setBoTell(String boTell) {
		this.boTell = boTell;
	}
	public int getBoPrinter() {
		return boPrinter;
	}
	public void setBoPrinter(int boPrinter) {
		this.boPrinter = boPrinter;
	}
	@Override
	public String toString() {
		return "BoInfoVO [boCode=" + boCode + ", boName=" + boName + ", boOrderName=" + boOrderName + ", boOrderGender="
				+ boOrderGender + ", boOpendate=" + boOpendate + ", boIntro=" + boIntro + ", boTotalseat=" + boTotalseat
				+ ", boAddress=" + boAddress + ", boTell=" + boTell + ", boPrinter=" + boPrinter + "]";
	}
	
	
	
	
	
}
