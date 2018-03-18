package com.co.procomercio.service;

import com.co.procomercio.model.User;

public interface UserService {

	User getUserById(String id);
	boolean addUser(User user);
}
