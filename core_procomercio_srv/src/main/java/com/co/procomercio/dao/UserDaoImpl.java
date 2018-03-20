package com.co.procomercio.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.co.procomercio.model.User;
import com.co.procomercio.utilities.DesEncrypter;

@Transactional
@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return entityManager.find(User.class, id);		
	}
	
	@Override
	public boolean userExists(String id) {
		String hql = "from User where id = ?1 and blocked = ?2";
		int count = entityManager.createQuery(hql)
				.setParameter(1, id)
				.setParameter(2, false).getResultList().size();
		return count > 0 ? true : false;
	}
	
	@Override
	public void addUser(User user) {
		//encriptar password de usuario
		user.setPassword(new DesEncrypter().encrypt(user.getPassword()));
        user.setUpdated(new Date());
		entityManager.persist(user);
	}

}
