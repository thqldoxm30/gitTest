package kr.co.daters.domain;

import java.sql.Date;

public class BoHistoryVO {
	private int boCode;
	private	Date cToday;
	private long cTotalTime;
	private long cTotalOther;
	private long cNetProfit;
	private long cCost;
	private String cCostInfo;
	private long cInsen;

	public BoHistoryVO() {
		super();
	}
	
	

	public BoHistoryVO(int boCode, Date cToday, long cTotalTime, long cTotalOther, long cNetProfit, long cCost,
			String cCostInfo, long cInsen) {
		super();
		this.boCode = boCode;
		this.cToday = cToday;
		this.cTotalTime = cTotalTime;
		this.cTotalOther = cTotalOther;
		this.cNetProfit = cNetProfit;
		this.cCost = cCost;
		this.cCostInfo = cCostInfo;
		this.cInsen = cInsen;
	}



	public int getBoCode() {
		return boCode;
	}
	public void setBoCode(int boCode) {
		this.boCode = boCode;
	}
	public Date getcToday() {
		return cToday;
	}
	public void setcToday(Date cToday) {
		this.cToday = cToday;
	}
	public long getcTotalTime() {
		return cTotalTime;
	}
	public void setcTotalTime(long cTotalTime) {
		this.cTotalTime = cTotalTime;
	}
	public long getcTotalOther() {
		return cTotalOther;
	}
	public void setcTotalOther(long cTotalOther) {
		this.cTotalOther = cTotalOther;
	}
	public long getcNetProfit() {
		return cNetProfit;
	}
	public void setcNetProfit(long cNetProfit) {
		this.cNetProfit = cNetProfit;
	}
	public long getcCost() {
		return cCost;
	}
	public void setcCost(long cCost) {
		this.cCost = cCost;
	}
	public String getcCostInfo() {
		return cCostInfo;
	}
	public void setcCostInfo(String cCostInfo) {
		this.cCostInfo = cCostInfo;
	}
	public long getcInsen() {
		return cInsen;
	}
	public void setcInsen(long cInsen) {
		this.cInsen = cInsen;
	}
	
	@Override
	public String toString() {
		return "BoHistoryVO [boCode=" + boCode + ", cToday=" + cToday + ", cTotalTime=" + cTotalTime + ", cTotalOther="
				+ cTotalOther + ", cNetProfit=" + cNetProfit + ", cCost=" + cCost + ", cCostInfo=" + cCostInfo
				+ ", cInsen=" + cInsen + "]";
	}
	
	
}
