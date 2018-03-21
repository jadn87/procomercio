package com.co.procomercio.dao;

import java.util.List;

import com.co.procomercio.model.User;
import com.co.procomercio.model.UserAddress;

public interface UserDao {

	User getUserById(String id);

	void addUser(User user);

	boolean userExists(String id);

	void updateUser(User user);

	void addUserAddress(UserAddress useraddress);

	List<UserAddress> getUserAddress(String username);

	boolean login(User user);
}
