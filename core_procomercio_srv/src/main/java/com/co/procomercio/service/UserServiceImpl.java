package com.co.procomercio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.procomercio.dao.UserDao;
import com.co.procomercio.model.User;
import com.co.procomercio.model.UserAddress;

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

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}


	@Override
	public void addUserAddress(UserAddress useraddress) {
		// TODO Auto-generated method stub
		userDao.addUserAddress(useraddress);
	}


	@Override
	public List<UserAddress> getUserAddress(String username) {
		// TODO Auto-generated method stub
		return userDao.getUserAddress(username);
	}


	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	
}
