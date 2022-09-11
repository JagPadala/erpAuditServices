package com.erpaudit.service.entitiy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

 
/**
 * The persistent class for the "PRIVILIEGES" database table.
 * 
 */
@Entity
@Table(name="\"PRIVILIEGES\"")
@NamedQuery(name="Priviliege.findAll", query="SELECT p FROM Priviliege p")
public class Priviliege implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"ID\"")
	private String id;

	@Column(name="\"DESCRIPTION\"")
	private String description;

	@Column(name="\"NAME\"")
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name="\"ROLE_ASSIGN_DATE\"")
	private Date roleAssignDate;

	@Column(name="\"ROLE_ID\"")
	private String roleId;

	@Column(name="\"SENSITIVE_FLAG\"")
	private Boolean sensitiveFlag;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumns({
		})
	private Role role;

	public Priviliege() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRoleAssignDate() {
		return this.roleAssignDate;
	}

	public void setRoleAssignDate(Date roleAssignDate) {
		this.roleAssignDate = roleAssignDate;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Boolean getSensitiveFlag() {
		return this.sensitiveFlag;
	}

	public void setSensitiveFlag(Boolean sensitiveFlag) {
		this.sensitiveFlag = sensitiveFlag;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}