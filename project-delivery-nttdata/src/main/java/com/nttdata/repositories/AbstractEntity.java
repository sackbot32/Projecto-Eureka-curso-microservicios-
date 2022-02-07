package com.nttdata.repositories;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Clase abstracta / super entidad
 * 
 * @author NTT DATA
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** Serial version */
	private static final long serialVersionUID = 1L;

	/** Usuario que actualiza BBDD */
	private String updateUser;

	/** Fecha en la que se actualiza BBDD */
	private Date updateDate;

	/**
	 * @return the updateUser
	 */
	@Column(name = "C_UPDATE_USER")
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser
	 *            the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * @return the updateDate
	 */
	@Column(name = "C_UPDATE_DATE")
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
