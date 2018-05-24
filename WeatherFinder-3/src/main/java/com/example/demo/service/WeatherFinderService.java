package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.User;

public interface WeatherFinderService {

	public void insertUser(User user);
	public List<User> listAllUsers();
	public User getDataByUserId(User user); 
}
