/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */

package cloud.simple.web;

import cloud.simple.model.User;
import cloud.simple.service.FeignUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
		
	@Resource
	FeignUserService feignUserService;
	
	@RequestMapping(value="/userListFeign")
	public ResponseEntity<List<User>> readUserInfoList(){
		List<User> users = feignUserService.findByIdFeign();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
}
