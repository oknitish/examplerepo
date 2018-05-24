package com.example.demo.dao;

import java.util.List;

import com.example.demo.domain.User;

public interface CassandraWeatherFinderDao {

	
	public void insertUser(User user);
	public List<User> listAllUsers();
	public User getDataByUserId(User UserId); 
	
}
