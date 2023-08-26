package com.example.portfolio_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portfolio_system.entity.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
	
	public User findByUserAccount(String userAccount);

}
