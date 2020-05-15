/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */
package cloud.simple.service;

import cloud.simple.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//import cloud.simple.service.UserServiceProvider.FeignUserService;

@Service
public class UserService {
	 private static final Logger LOGGER = LogManager.getLogger(UserService.class);
	 final String SERVICE_NAME="CLOUD-SIMPLE-SERVICE";

	 @Autowired
	 RestTemplate restTemplate;


	 @HystrixCommand(fallbackMethod = "fallbackSearchAll")
	 public List<User> readUserInfo() {
	        return restTemplate.getForObject("http://"+SERVICE_NAME+"/getUserList", List.class);
		 //return feignUserService.readUserInfo();
	 }	 
	 private List<User> fallbackSearchAll() {
		 System.out.println("HystrixCommand fallbackMethod handle!");
		 List<User> ls = new ArrayList<User>();
		 User user = new User();
		 user.setUserName("TestHystrixCommand");
		 ls.add(user);
		 return ls;
	 }

	@HystrixCommand(fallbackMethod = "fallbackGetUser")
	 public User getUser(int id){
		 return restTemplate.getForObject("http://"+SERVICE_NAME+"/getUser/{id}", User.class, id);
	 }

	private User fallbackGetUser(int id) {
		LOGGER.error("get user fallbackGetUser..................");
		User user = new User();
		user.setUserName("TestHystrixCommand");
		return user;
	}
}
