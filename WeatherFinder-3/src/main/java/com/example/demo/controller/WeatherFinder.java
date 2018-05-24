package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.User;
import com.example.demo.service.WeatherFinderService;

@Controller

public class WeatherFinder {

	@Autowired
	WeatherFinderService weatherFinderService;

	@RequestMapping("/path")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/getallusers", method = RequestMethod.GET)

	public List<User> listAllUsers() {

		List<User> users = weatherFinderService.listAllUsers();

		System.out.println(users.size());
		for (User user : users) {

			System.out.println(user.getUserid());
			System.out.println(user.getUsername());
			System.out.println(user.getOrderNouuid());
			System.out.println(user.getPassword() + "\n");

		}

		System.out.println("received all data !!!! thanks!!!!!");
		return users;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insertUser(@RequestParam("userid") String userid, @RequestParam("username") String username,
			@RequestParam("password") String password) {

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setOrderNouuid(user.getOrderNouuid());
		java.util.Date d = user.getInsertionDate();

		user.setInsertionDate(d);

		user.setUserid(Integer.parseInt(userid));

		System.out.println(userid);

		System.out.println(username);
		System.out.println(password);

		weatherFinderService.insertUser(user);

		System.out.println("done");

	}

	

	@RequestMapping(value = "/getDataByUserId", method = RequestMethod.GET)
	public void getDataByUserId(@RequestParam("userid") String userid) {

		User user = new User();

		user.setUserid(Integer.parseInt(userid));

		System.out.println(userid);


		weatherFinderService.getDataByUserId(user);

		System.out.println("done");

	}
	
	
	
	
	
	
	
	
	
	
	
}
