package co.com.procomercio.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.procomercio.model.User;

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

}
