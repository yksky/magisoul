package org.magisoul.system.model.query;

import org.magisoul.util.model.QueryPageVo;

public class QuerySysDeptInfoVo extends QueryPageVo{

	private static final long serialVersionUID = 1L;

	private Long parentId ;
	private String enableStatus ;
	private String isDeleted ;
	private Integer level ;
	private String deptName ;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

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
