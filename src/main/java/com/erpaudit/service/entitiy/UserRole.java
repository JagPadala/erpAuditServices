package com.erpaudit.service.entitiy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "USER_ROLES" database table.
 * 
 */
@Entity
@Table(name="\"USER_ROLES\"")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserRolePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="assign_date")
	private Date assignDate;

	public UserRole() {
	}

	public UserRolePK getId() {
		return this.id;
	}

	public void setId(UserRolePK id) {
		this.id = id;
	}

	public Date getAssignDate() {
		return this.assignDate;
	}

	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}

}