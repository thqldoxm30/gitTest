package com.jun.board.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int b_seq;
	private String dc_id;
	private String b_title;
	private String b_content;
	private Date b_writeDate;
	private int b_list;
	private int b_cnt;
	
	private String searchCondition;
	private String searchKeyWord;
	private MultipartFile b_uploadfile;
	private String b_fileLoad;
	
	private int b_rStart;
	private int b_rEnd;
	
	
	public int getB_seq() {
		return b_seq;
	}
	public void setB_seq(int b_seq) {
		this.b_seq = b_seq;
	}
	public String getDc_id() {
		return dc_id;
	}
	public void setDc_id(String dc_id) {
		this.dc_id = dc_id;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public Date getB_writeDate() {
		return b_writeDate;
	}
	public void setB_writeDate(Date b_writeDate) {
		this.b_writeDate = b_writeDate;
	}
	public int getB_list() {
		return b_list;
	}
	public void setB_list(int b_list) {
		this.b_list = b_list;
	}
	public int getB_cnt() {
		return b_cnt;
	}
	public void setB_cnt(int b_cnt) {
		this.b_cnt = b_cnt;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyWord() {
		return searchKeyWord;
	}
	public void setSearchKeyWord(String searchKeyWord) {
		this.searchKeyWord = searchKeyWord;
	}
	@Override
	public String toString() {
		return "BoardVO [b_seq=" + b_seq + ", dc_id=" + dc_id + ", b_title=" + b_title + ", b_content=" + b_content
				+ ", b_writeDate=" + b_writeDate + ", b_list=" + b_list + ", b_cnt=" + b_cnt + ", searchCondition="
				+ searchCondition + ", searchKeyWord=" + searchKeyWord + ", b_uploadfile=" + b_uploadfile
				+ ", b_fileLoad=" + b_fileLoad + ", b_rStart=" + b_rStart + ", b_rEnd=" + b_rEnd + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + b_cnt;
		result = prime * result + ((b_content == null) ? 0 : b_content.hashCode());
		result = prime * result + b_list;
		result = prime * result + b_seq;
		result = prime * result + ((b_title == null) ? 0 : b_title.hashCode());
		result = prime * result + ((b_writeDate == null) ? 0 : b_writeDate.hashCode());
		result = prime * result + ((dc_id == null) ? 0 : dc_id.hashCode());
		result = prime * result + ((searchCondition == null) ? 0 : searchCondition.hashCode());
		result = prime * result + ((searchKeyWord == null) ? 0 : searchKeyWord.hashCode());
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
		BoardVO other = (BoardVO) obj;
		if (b_cnt != other.b_cnt)
			return false;
		if (b_content == null) {
			if (other.b_content != null)
				return false;
		} else if (!b_content.equals(other.b_content))
			return false;
		if (b_list != other.b_list)
			return false;
		if (b_seq != other.b_seq)
			return false;
		if (b_title == null) {
			if (other.b_title != null)
				return false;
		} else if (!b_title.equals(other.b_title))
			return false;
		if (b_writeDate == null) {
			if (other.b_writeDate != null)
				return false;
		} else if (!b_writeDate.equals(other.b_writeDate))
			return false;
		if (dc_id == null) {
			if (other.dc_id != null)
				return false;
		} else if (!dc_id.equals(other.dc_id))
			return false;
		if (searchCondition == null) {
			if (other.searchCondition != null)
				return false;
		} else if (!searchCondition.equals(other.searchCondition))
			return false;
		if (searchKeyWord == null) {
			if (other.searchKeyWord != null)
				return false;
		} else if (!searchKeyWord.equals(other.searchKeyWord))
			return false;
		return true;
	}
	public int getB_rStart() {
		return b_rStart;
	}
	public void setB_rStart(int b_rStart) {
		this.b_rStart = b_rStart;
	}
	public int getB_rEnd() {
		return b_rEnd;
	}
	public void setB_rEnd(int b_rEnd) {
		this.b_rEnd = b_rEnd;
	}
	public MultipartFile getB_uploadfile() {
		return b_uploadfile;
	}
	public void setB_uploadfile(MultipartFile b_uploadfile) {
		this.b_uploadfile = b_uploadfile;
	}
	public String getB_fileLoad() {
		return b_fileLoad;
	}
	public void setB_fileLoad(String b_fileLoad) {
		this.b_fileLoad = b_fileLoad;
	}
	
}
