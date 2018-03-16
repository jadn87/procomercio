package co.com.procomercio.service;

import co.com.procomercio.model.User;

public interface UserService {

	User getUserById(String id);
	boolean addUser(User user);
}
