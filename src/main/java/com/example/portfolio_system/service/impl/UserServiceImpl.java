package com.example.portfolio_system.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.portfolio_system.constant.RtnCode;
import com.example.portfolio_system.entity.User;
import com.example.portfolio_system.repository.UserDao;
import com.example.portfolio_system.service.ifs.UserService;
import com.example.portfolio_system.vo.UserResponse;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	
	
//	使用者追加
	@Override
	public UserResponse addUser(User user) {
		
		if(user == null || !StringUtils.hasText(user.getUserAccount())
				|| !StringUtils.hasText(user.getUserPassword()) 
				|| !StringUtils.hasText(user.getUserName())) {
			
			return new UserResponse(RtnCode.ADD_USER_SUCCESS.getMessage());
		}
		
		//檢查帳號重複
		if(userDao.findByUserAccount(user.getUserAccount()) != null) {
			return new UserResponse(RtnCode.USER_ALREADY_EXIST.getMessage());
		}
		
		
		// 格式設定 
		// 帳號8-20碼，要有英文及數字
		String accountPattern = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,20}$";
		String userAccount = user.getUserAccount();

		Pattern accPattern = Pattern.compile(accountPattern);
		Matcher accMatcher = accPattern.matcher(userAccount);

		if (!accMatcher.matches()) {
		    return new UserResponse(RtnCode.USER_ACCOUNT_ERROR.getMessage());
		}
		
		
		// 密碼8-20碼，要有英文及數字，可加特殊符號
		String passwordPattern = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9!@#$%^&*~]{8,20}$";
		String userPassword = user.getUserPassword();

		Pattern pwdPattern = Pattern.compile(passwordPattern);
		Matcher pwdMatcher = pwdPattern.matcher(userPassword);

		if (!pwdMatcher.matches()) {
		    return new UserResponse(RtnCode.USER_PASSWORD_ERROR.getMessage());
		}
		
		
		userDao.save(user);
		return new UserResponse(RtnCode.ADD_USER_SUCCESS.getMessage());
	}
	
	

//	使用者登入
	@Override
	public UserResponse userLogin(String account, String password) {
		
		if(!StringUtils.hasText(account) || !StringUtils.hasText(password)) {
			return new UserResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		
		User result = userDao.findByUserAccount(account);
		if(result == null || result.getUserPassword() != password) {
			return new UserResponse(RtnCode.LOGIN_FAILED.getMessage());
		}
		
		
		return new UserResponse(result, RtnCode.LOGIN_SUCCESS.getMessage());

	}

}
