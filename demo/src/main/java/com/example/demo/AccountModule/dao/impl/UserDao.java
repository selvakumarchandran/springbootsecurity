package com.example.demo.AccountModule.dao.impl;


import com.example.demo.AccountModule.Entity.UserEntity;

import java.util.List;

public interface UserDao {
	
	List<UserEntity> getUserDetails();
	UserEntity findUserById(String userId);

}
