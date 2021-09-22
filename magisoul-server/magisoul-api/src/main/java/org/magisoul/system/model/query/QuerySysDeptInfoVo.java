package org.magisoul.system.model.query;

import org.magisoul.util.model.QueryPageVo;

public class QuerySysDeptInfoVo extends QueryPageVo{

	private static final long serialVersionUID = 1L;

	private Long parentId ;
	private String enableStatus ;
	private String isDeleted ;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(String enableStatus) {
		this.enableStatus = enableStatus;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
}
