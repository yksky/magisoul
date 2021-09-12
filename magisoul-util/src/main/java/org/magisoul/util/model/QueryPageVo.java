package org.magisoul.util.model;

import java.io.Serializable;

public class QueryPageVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 页码,默认值为1
	 */
	private Long pageNo ;
	/**
	 * 每页大小,默认值为10
	 */
	private Long pageSize ;
	/**
	 * 开始位置,为(pageNo-1)*pageSize
	 */
	private Long start ;
	/**
	 * 偏移量,与pageSize保持一致
	 */
	private Long offset ;
	
	public Long getPageNo() {
		if(pageNo==null) {
			pageNo = new Long(1);
		}
		return pageNo;
	}
	public void setPageNo(Long pageNo) {
		this.pageNo = pageNo;
	}
	public Long getPageSize() {
		if(pageSize==null) {
			pageSize = new Long(10);
		}
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	public Long getStart() {		
		return start ;
	}
	public void setStart(Long start) {
		this.start = (pageNo-1)*pageSize ;
	}
	public Long getOffset() {
		return offset;
	}
	public void setOffset(Long offset) {
		this.offset = pageSize;
	}

}
