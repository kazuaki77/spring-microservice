package com.in28minutes.rest.webservices.restful_web_services.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserMapper userMapper;

	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public List<User> findAll() {
		return userMapper.findAll();

	}

	public User findUserById(Long id) {
		return userMapper.findById(id);

	}

	public void save(User user) {
		userMapper.insert(user);
	}

	public void delete(Long id) {
		userMapper.delete(id);

	}

}
