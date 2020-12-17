package kr.co.daters.domain;

import java.io.Serializable;
import java.sql.Date;

public class BoInfoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int boCode;
	private String boOrderName;
	private String boOrderGender;
	private Date boOpendate;
	private	String boIntro;
	private	long boTotalseat;
	private	String boAddress;
	private String boTell;
	private int boPrinter;
	
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boAddress == null) ? 0 : boAddress.hashCode());
		result = prime * result + boCode;
		result = prime * result + ((boIntro == null) ? 0 : boIntro.hashCode());
		result = prime * result + ((boOpendate == null) ? 0 : boOpendate.hashCode());
		result = prime * result + ((boOrderGender == null) ? 0 : boOrderGender.hashCode());
		result = prime * result + ((boOrderName == null) ? 0 : boOrderName.hashCode());
		result = prime * result + boPrinter;
		result = prime * result + ((boTell == null) ? 0 : boTell.hashCode());
		result = prime * result + (int) (boTotalseat ^ (boTotalseat >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoInfoVO other = (BoInfoVO) obj;
		if (boAddress == null) {
			if (other.boAddress != null)
				return false;
		} else if (!boAddress.equals(other.boAddress))
			return false;
		if (boCode != other.boCode)
			return false;
		if (boIntro == null) {
			if (other.boIntro != null)
				return false;
		} else if (!boIntro.equals(other.boIntro))
			return false;
		if (boOpendate == null) {
			if (other.boOpendate != null)
				return false;
		} else if (!boOpendate.equals(other.boOpendate))
			return false;
		if (boOrderGender == null) {
			if (other.boOrderGender != null)
				return false;
		} else if (!boOrderGender.equals(other.boOrderGender))
			return false;
		if (boOrderName == null) {
			if (other.boOrderName != null)
				return false;
		} else if (!boOrderName.equals(other.boOrderName))
			return false;
		if (boPrinter != other.boPrinter)
			return false;
		if (boTell == null) {
			if (other.boTell != null)
				return false;
		} else if (!boTell.equals(other.boTell))
			return false;
		if (boTotalseat != other.boTotalseat)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "BoInfoVO [boCode=" + boCode + ", boOrderName=" + boOrderName + ", boOrderGender=" + boOrderGender
				+ ", boOpendate=" + boOpendate + ", boIntro=" + boIntro + ", boTotalseat=" + boTotalseat
				+ ", boAddress=" + boAddress + ", boTell=" + boTell + ", boPrinter=" + boPrinter + "]";
	}
	
	
}
