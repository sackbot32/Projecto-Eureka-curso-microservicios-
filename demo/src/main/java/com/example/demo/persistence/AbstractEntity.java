package com.example.demo.persistence;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;

public class AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String updateUser;
	
	private Date updateDate;

	@Column(name="C_UPDATE_USER")
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	@Column(name="C_UPDATE_DATE")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	

}
