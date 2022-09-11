package com.erpaudit.service.entitiy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "ROLES" database table.
 * 
 */
@Entity
@Table(name="\"ROLES\"")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"ID\"")
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name="\"CREATION_DATE\"")
	private Date creationDate;

	@Column(name="\"DESCRIPTION\"")
	private String description;

	@Column(name="\"FROM_SYSTEM\"")
	private String fromSystem;

	@Column(name="\"NAME\"")
	private String name;

	@Column(name="\"SENSITIVE_FLAG\"")
	private Boolean sensitiveFlag;

	//bi-directional many-to-one association to Priviliege
	@OneToMany(mappedBy="role")
	private List<Priviliege> privilieges;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="role")
	private List<UserRole> userRoles;

	public Role() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFromSystem() {
		return this.fromSystem;
	}

	public void setFromSystem(String fromSystem) {
		this.fromSystem = fromSystem;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSensitiveFlag() {
		return this.sensitiveFlag;
	}

	public void setSensitiveFlag(Boolean sensitiveFlag) {
		this.sensitiveFlag = sensitiveFlag;
	}

	public List<Priviliege> getPrivilieges() {
		return this.privilieges;
	}

	public void setPrivilieges(List<Priviliege> privilieges) {
		this.privilieges = privilieges;
	}

	public Priviliege addPriviliege(Priviliege priviliege) {
		getPrivilieges().add(priviliege);
		priviliege.setRole(this);

		return priviliege;
	}

	public Priviliege removePriviliege(Priviliege priviliege) {
		getPrivilieges().remove(priviliege);
		priviliege.setRole(null);

		return priviliege;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.getId().setRoleId(id);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.getId().setRoleId(null);

		return userRole;
	}

}