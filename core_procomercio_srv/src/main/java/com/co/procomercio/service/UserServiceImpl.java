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
	public synchronized boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
//	public synchronized boolean addArticle(Article article){
//	       if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
//	    	   return false;
//	       } else {
//	    	   articleDAO.addArticle(article);
//	    	   return true;
//	       }
//		}

	
}
