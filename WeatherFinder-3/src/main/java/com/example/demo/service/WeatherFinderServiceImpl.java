package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CassandraWeatherFinderDao;
import com.example.demo.domain.User;

@Service
public class WeatherFinderServiceImpl implements WeatherFinderService {

	@Autowired
	CassandraWeatherFinderDao cassandraWeatherFinderDao;

	@Override
	public void insertUser(User user) {

		cassandraWeatherFinderDao.insertUser(user);

		System.out.println("data inserted successfulyy");

	}

	@Override
	public List<User> listAllUsers() {

		List<User> list = cassandraWeatherFinderDao.listAllUsers();

		return list;
	}

	
	
	
	@Override
	public User getDataByUserId(User user) {
		cassandraWeatherFinderDao.getDataByUserId(user);
		
		return new User();
	}
}
