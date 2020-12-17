package kr.co.daters.domain;

import java.io.Serializable;

public class BoMenuVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int boCode;
	private int mNo;
	private String mName;
	private int mPrice;
	private int mQuantity;
	
	public int getBoCode() {
		return boCode;
	}
	public void setBoCode(int boCode) {
		this.boCode = boCode;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getmPrice() {
		return mPrice;
	}
	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}
	public int getmQuantity() {
		return mQuantity;
	}
	public void setmQuantity(int mQuantity) {
		this.mQuantity = mQuantity;
	}
	
	@Override
	public String toString() {
		return "BoMenuVO [boCode=" + boCode + ", mNo=" + mNo + ", mName=" + mName + ", mPrice=" + mPrice
				+ ", mQuantity=" + mQuantity + "]";
	}
	
}
