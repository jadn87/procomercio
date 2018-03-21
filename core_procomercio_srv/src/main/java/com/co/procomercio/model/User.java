package com.co.procomercio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable { 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private String id;
	@Column(name="password")
	private String password;
	@Column(name="subclass")
	private String subclass;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="updated")
	private Date updated;
	@Column(name="blocked")
	private boolean blocked;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSubclass() {
		return subclass;
	}
	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public Date getUpdated() {
		return updated;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}	
	
}


