package com.example.portfolio_system.vo;

import com.example.portfolio_system.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddUserRequest {

	@JsonProperty("new_user")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
