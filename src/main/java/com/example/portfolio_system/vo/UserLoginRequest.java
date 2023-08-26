package com.example.portfolio_system.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginRequest {

	@JsonProperty("login_account")
	private String loginAccount;

	@JsonProperty("login_password")
	private String loginPassword;

//	===============================================

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

}
