package com.co.procomercio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.procomercio.dao.UserDao;
import com.co.procomercio.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	
	@Override
	public synchronized boolean addUser(User user){
       if (userDao.userExists(user.getId())) {
    	   return false;
       } else {
    	   userDao.addUser(user);
    	   return true;
       }
	}

	
}
