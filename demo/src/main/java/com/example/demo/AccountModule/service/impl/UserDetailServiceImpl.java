package com.example.demo.AccountModule.service.impl;

import com.example.demo.AccountModule.Entity.UserEntity;
import com.example.demo.AccountModule.dao.impl.UserDaoImpl;
import com.example.demo.AccountModule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component(value = "userDetailService")
public class UserDetailServiceImpl implements UserDetailsService, UserService{
	
	@Autowired
	private UserDaoImpl userDaoImpl;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
				UserEntity user = userDaoImpl.findUserById(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	public List<UserEntity> getUsers() {
		return userDaoImpl.getAllUsers();
	}

}
