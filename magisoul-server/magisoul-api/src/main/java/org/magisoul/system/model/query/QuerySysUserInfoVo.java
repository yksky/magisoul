package org.magisoul.system.model.query;

import org.magisoul.util.model.QueryPageVo;

import java.util.List;

public class QuerySysUserInfoVo extends QueryPageVo{

	private static final long serialVersionUID = 1L;

	private String userType ;
	private String enableStatus ;
	private String isDeleted ;
	private String username ;
	private List<Long> idsList ;

	public List<Long> getIdsList() {
		return idsList;
	}

	public void setIdsList(List<Long> idsList) {
		this.idsList = idsList;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
