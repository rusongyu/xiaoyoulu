package com.ard.util;

public class PagerNum implements java.io.Serializable {

	/**
	 * @author Administrator
	 * 
	 */

	/**
     *
     */
	private static final long serialVersionUID = -1060125092198748183L;

	public String offset;

	public String pageSize;

	public String getOffset() {

		return offset;
	}

	public void setOffset(String offset) {

		this.offset = offset;
	}

	public String getPageSize() {

		return pageSize;
	}

	public void setPageSize(String pageSize) {

		this.pageSize = pageSize;
	}

	public Integer getFirstindex() {

		offset = offset == null ? "0" : offset;
		return Integer.parseInt(offset);
	}

	public Integer getMaxresult() {

		pageSize = pageSize == null ? "10" : pageSize;
		return Integer.parseInt(pageSize);
	}

}
