package kr.co.daters.domain;

import java.io.Serializable;
import java.sql.Date;

public class UHistoryVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int uCode;
	private int boCode;
	private Date uToday;
	private long uUseTime;
	private long uUseTimePay;
	private long uUseOtherPay;
	private String uUseInfo;
	private long uNowseat;

	public UHistoryVO() {
		super();
	}

	public UHistoryVO(int uCode, int boCode, long uUseTime, long uUseTimePay, long uUseOtherPay, String uUseInfo, long uNowseat) { //시간결제 생성자
		super();
		this.uCode = uCode;
		this.boCode = boCode;
		this.uUseTime = uUseTime;
		this.uUseTimePay = uUseTimePay;
		this.uUseOtherPay = uUseOtherPay;
		this.uUseInfo = uUseInfo;
		this.uNowseat = uNowseat;
	}
	

	public int getuCode() {
		return uCode;
	}

	public void setuCode(int uCode) {
		this.uCode = uCode;
	}

	public int getBoCode() {
		return boCode;
	}

	public void setBoCode(int boCode) {
		this.boCode = boCode;
	}

	public Date getuToday() {
		return uToday;
	}

	public void setuToday(Date uToday) {
		this.uToday = uToday;
	}

	public long getuUseTime() {
		return uUseTime;
	}

	public void setuUseTime(long uUseTime) {
		this.uUseTime = uUseTime;
	}

	public long getuUseTimePay() {
		return uUseTimePay;
	}

	public void setuUseTimePay(long uUseTimePay) {
		this.uUseTimePay = uUseTimePay;
	}

	public long getuUseOtherPay() {
		return uUseOtherPay;
	}

	public void setuUseOtherPay(long uUseOtherPay) {
		this.uUseOtherPay = uUseOtherPay;
	}

	public String getuUseInfo() {
		return uUseInfo;
	}

	public void setuUseInfo(String uUseInfo) {
		this.uUseInfo = uUseInfo;
	}

	public long getuNowseat() {
		return uNowseat;
	}

	public void setuNowseat(long uNowseat) {
		this.uNowseat = uNowseat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UHistoryVO [uCode=" + uCode + ", boCode=" + boCode + ", uToday=" + uToday + ", uUseTime=" + uUseTime
				+ ", uUseTimePay=" + uUseTimePay + ", uUseOtherPay=" + uUseOtherPay + ", uUseInfo=" + uUseInfo
				+ ", uNowseat=" + uNowseat + "]";
	}
	
	

}
