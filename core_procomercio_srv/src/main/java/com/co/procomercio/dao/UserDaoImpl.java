package com.co.procomercio.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.co.procomercio.model.User;
import com.co.procomercio.model.UserAddress;
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
	
	@Override
	public void updateUser(User user) {
		User usu = new User();
		usu.setName(user.getName());
		usu.setEmail(user.getEmail());
		usu.setBlocked(user.isBlocked());
		entityManager.flush();
	}
	
	@Override
	public void addUserAddress(UserAddress useraddress) {
		entityManager.persist(useraddress);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserAddress> getUserAddress(String username) {
		String hql = "FROM UserAddress where email = ?1 ORDER BY updated desc";
		return (List<UserAddress>) entityManager.createQuery(hql).setParameter(1, username).getResultList();
	}	
	
	public boolean passValidate(String pwdInput, String pwdUser ){
        DesEncrypter encryp = new DesEncrypter();
        String result = encryp.decrypt(pwdUser);
        System.out.println("clave del usuario "+encryp.encrypt(pwdInput));
        return result.equals(pwdInput);
    }
	
	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		String hql = "from User where email = ?1 and blocked = ?2";
		User login = (User) entityManager.createQuery(hql)
				.setParameter(1, user.getEmail())
				.setParameter(2, false).getSingleResult();
		
		if(login!=null)
			return passValidate(user.getPassword(), login.getPassword());
		
		return false;		
	}

}
