package com.co.procomercio.dao;

import com.co.procomercio.model.User;

public interface UserDao {

	User getUserById(String id);

	void addUser(User user);
}
