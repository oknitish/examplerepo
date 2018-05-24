package com.example.demo.domain;

import java.util.Date;
import java.util.UUID;

public class User {

	private String username;
	private String password;
	private UUID orderNouuid;
	private Date insertionDate=new Date();

	private int userid;

	public UUID getOrderNouuid() {
		return orderNouuid;
	}

	public void setOrderNouuid(UUID orderNouuid) {
		this.orderNouuid = UUID.randomUUID();
	}

	public Date getInsertionDate() {
	Date 	date=new Date(insertionDate.getTime());
	
		return date;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate =new Date(insertionDate.getTime());
	}



	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
