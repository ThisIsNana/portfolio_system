package com.example.portfolio_system.service.ifs;

import com.example.portfolio_system.entity.User;
import com.example.portfolio_system.vo.UserResponse;

public interface UserService {

//	使用者追加
	public UserResponse addUser(User user);

//	使用者登入
	public UserResponse userLogin(String account, String password);

}
