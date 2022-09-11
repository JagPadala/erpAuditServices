package com.erpaudit.service.entitiy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the "USER" database table.
 * 
 */
@Entity
@Table(name = "\"USER\"")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"ID\"")
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name = "\"CREATION_DATE\"")
	private Date creationDate;

	@Column(name = "\"DEPARTMENT\"")
	private String department;

	@Column(name = "\"DESCRIPTION\"")
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "\"INACTIVE_DATE\"")
	private Date inactiveDate;

	@Column(name = "\"Name\"")
	private String name;

	@Column(name = "\"STATUS\"")
	private String status;

	// bi-directional many-to-one association to UserAction
	@OneToMany(mappedBy = "user")
	private List<UserAction> userActions;

	// bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy = "user")
	private List<UserRole> userRoles;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getInactiveDate() {
		return this.inactiveDate;
	}

	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<UserAction> getUserActions() {
		return this.userActions;
	}

	public void setUserActions(List<UserAction> userActions) {
		this.userActions = userActions;
	}

	public UserAction addUserAction(UserAction userAction) {
		getUserActions().add(userAction);
		userAction.setUser(this);

		return userAction;
	}

	public UserAction removeUserAction(UserAction userAction) {
		getUserActions().remove(userAction);
		userAction.setUser(null);

		return userAction;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.getId().setUserId(id);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.getId().setUserId(null);

		return userRole;
	}

}