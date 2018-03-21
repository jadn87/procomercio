package com.co.procomercio.service;

import java.util.List;

import com.co.procomercio.model.User;
import com.co.procomercio.model.UserAddress;

public interface UserService {

	User getUserById(String id);
	boolean addUser(User user);
	void updateUser(User user);
	void addUserAddress(UserAddress useraddress);
	List<UserAddress> getUserAddress(String username);
	boolean login(User user);
}
