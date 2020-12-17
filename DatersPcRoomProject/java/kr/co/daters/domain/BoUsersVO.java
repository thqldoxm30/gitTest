package kr.co.daters.domain;

import java.io.Serializable;
import java.sql.Date;

public class BoUsersVO implements Serializable {
	private static final long serialVersionUID = 1L;
		private int boCode;
		private int uCode;
		private String uId;
		private String uPwd;
		private String uName;
		private Date uBirth;
		private String uGender;
		private String uEmail;
		private int uEmailChk;
		private String uPhone;
		private String uAddress;
		private long uAllTime;
		private long uSavetime;
		private int uPoint;
		private int uState;
		private Date uRegdate;
		private int uUseBoCode;
		private int uUseSeat;
		
		
		public int getBoCode() {
			return boCode;
		}
		public void setBoCode(int boCode) {
			this.boCode = boCode;
		}
		public int getuCode() {
			return uCode;
		}
		public void setuCode(int uCode) {
			this.uCode = uCode;
		}
		public String getuId() {
			return uId;
		}
		public void setuId(String uId) {
			this.uId = uId;
		}
		public String getuPwd() {
			return uPwd;
		}
		public void setuPwd(String uPwd) {
			this.uPwd = uPwd;
		}
		public String getuName() {
			return uName;
		}
		public void setuName(String uName) {
			this.uName = uName;
		}
		public Date getuBirth() {
			return uBirth;
		}
		public void setuBirth(Date uBirth) {
			this.uBirth = uBirth;
		}
		public String getuGender() {
			return uGender;
		}
		public void setuGender(String uGender) {
			this.uGender = uGender;
		}
		public String getuEmail() {
			return uEmail;
		}
		public void setuEmail(String uEmail) {
			this.uEmail = uEmail;
		}
		public int getuEmailChk() {
			return uEmailChk;
		}
		public void setuEmailChk(int uEmailChk) {
			this.uEmailChk = uEmailChk;
		}
		public String getuPhone() {
			return uPhone;
		}
		public void setuPhone(String uPhone) {
			this.uPhone = uPhone;
		}
		public String getuAddress() {
			return uAddress;
		}
		public void setuAddress(String uAddress) {
			this.uAddress = uAddress;
		}
		public long getuAllTime() {
			return uAllTime;
		}
		public void setuAllTime(long uAllTime) {
			this.uAllTime = uAllTime;
		}
		public long getuSavetime() {
			return uSavetime;
		}
		public void setuSavetime(long uSavetime) {
			this.uSavetime = uSavetime;
		}
		public int getuPoint() {
			return uPoint;
		}
		public void setuPoint(int uPoint) {
			this.uPoint = uPoint;
		}
		public int getuState() {
			return uState;
		}
		public void setuState(int uState) {
			this.uState = uState;
		}
		public Date getuRegdate() {
			return uRegdate;
		}
		public void setuRegdate(Date uRegdate) {
			this.uRegdate = uRegdate;
		}
		public int getuUseBoCode() {
			return uUseBoCode;
		}
		public void setuUseBoCode(int uUseBoCode) {
			this.uUseBoCode = uUseBoCode;
		}
		public int getuUseSeat() {
			return uUseSeat;
		}
		public void setuUseSeat(int uUseSeat) {
			this.uUseSeat = uUseSeat;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		@Override
		public String toString() {
			return "BoUsersVO [boCode=" + boCode + ", uCode=" + uCode + ", uId=" + uId + ", uPwd=" + uPwd + ", uName="
					+ uName + ", uBirth=" + uBirth + ", uGender=" + uGender + ", uEmail=" + uEmail + ", uEmailChk="
					+ uEmailChk + ", uPhone=" + uPhone + ", uAddress=" + uAddress + ", uAllTime=" + uAllTime
					+ ", uSavetime=" + uSavetime + ", uPoint=" + uPoint + ", uState=" + uState + ", uRegdate="
					+ uRegdate + ", uUseBoCode=" + uUseBoCode + ", uUseSeat=" + uUseSeat + "]";
		}
		
		
		
		
		
}