package org.magisoul.util.model;

import java.io.Serializable;
import java.util.List;

public class Pagination<T> implements Serializable{

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
	 * 总记录数
	 */
	private Long totalNum ;
	/**
	 * 数据集合
	 */
	private List<T> list ;
	/**
	 * 总页数
	 */
	private Long pageCount ;
	/**
	 * 是否有上一页
	 */
	private Boolean hasPrevious = false ;
	/**
	 * 是否有下一页
	 */
	private Boolean hasNext = false ;
	
    public Pagination() {
		
	}

	public Pagination(Long pageNo,Long pageSize,Long totalNum,List<T> list) {
		this.pageNo = pageNo ;
		this.pageSize = pageSize ;
		this.totalNum = totalNum ;
		this.list = list ;
		this.pageCount = this.getTotalPageCount();
		refresh();
	}
	
	public Long getTotalPageCount() {
		if(this.getTotalNum()%this.pageSize==0) {
			return this.getTotalNum()/this.getPageSize();
		}else {
			return this.getTotalNum()/this.getPageSize()+1;
		}
	}
	
    /**
     * 刷新当前分页对象数据
     */
    private void refresh() {
        if (pageCount <= 1) {
            hasPrevious = false;
            hasNext = false;
        } else if (pageNo == 1) {
            hasPrevious = false;
            hasNext = true;
        } else if (pageNo == pageCount) {
            hasPrevious = true;
            hasNext = false;
        } else {
            hasPrevious = true;
            hasNext = true;
        }
    }
	
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
	public Long getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Boolean getHasPrevious() {
		return hasPrevious;
	}
	public void setHasPrevious(Boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	public Boolean getHasNext() {
		return hasNext;
	}
	public void setHasNext(Boolean hasNext) {
		this.hasNext = hasNext;
	}
	public Long getPageCount() {
		return pageCount;
	}
	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}
}
