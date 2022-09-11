package com.erpaudit.service.entitiy;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "USER_ACTIONS" database table.
 * 
 */
@Entity
@Table(name="\"USER_ACTIONS\"")
@NamedQuery(name="UserAction.findAll", query="SELECT u FROM UserAction u")
public class UserAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"ID\"")
	private String id;

	@Column(name="\"ACTION_OBEJCT\"")
	private String actionObejct;

	@Column(name="\"ACTION_TYPE\"")
	private String actionType;

	@Column(name="\"AFTER_VALUES\"")
	private Object afterValues;

	@Column(name="\"BEFORE_VALUES\"")
	private Object beforeValues;

	@Column(name="\"USER_ID\"")
	private String userId;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumns({
		})
	private User user;

	public UserAction() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActionObejct() {
		return this.actionObejct;
	}

	public void setActionObejct(String actionObejct) {
		this.actionObejct = actionObejct;
	}

	public String getActionType() {
		return this.actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public Object getAfterValues() {
		return this.afterValues;
	}

	public void setAfterValues(Object afterValues) {
		this.afterValues = afterValues;
	}

	public Object getBeforeValues() {
		return this.beforeValues;
	}

	public void setBeforeValues(Object beforeValues) {
		this.beforeValues = beforeValues;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}