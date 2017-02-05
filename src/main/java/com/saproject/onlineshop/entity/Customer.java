package com.saproject.onlineshop.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_accounts")
public class Customer {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;
	
	
	public Customer() {}
	
	public Customer(int userId, String userName, String password, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
