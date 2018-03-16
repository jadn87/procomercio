package co.com.procomercio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.procomercio.model.Category;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao{

	@PersistenceContext	
	private EntityManager entityManager;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getListCategories(String parent) {
		// TODO Auto-generated method stub
		String hql = "from Category where upper(parent) = ?1 and eliminated = ?2";
		List<Category> results = entityManager.createQuery(hql)
				.setParameter(1, parent.toUpperCase())
				.setParameter(2, false).getResultList();
		
        return results;		
	}

}
