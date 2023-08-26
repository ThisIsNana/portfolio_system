package com.example.portfolio_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.portfolio_system.service.ifs.UserService;
import com.example.portfolio_system.vo.AddUserRequest;
import com.example.portfolio_system.vo.UserLoginRequest;
import com.example.portfolio_system.vo.UserResponse;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	
//	使用者追加
	@PostMapping(value = "add_user")
	public UserResponse addUser(@RequestBody AddUserRequest request) {
		return userService.addUser(request.getUser());
	}
	
	
//	使用者登入
	@PostMapping(value = "user_login")
	public UserResponse userLogin(@RequestBody UserLoginRequest request) {
		return userService.userLogin(request.getLoginAccount(), request.getLoginPassword());
		
	}

}
