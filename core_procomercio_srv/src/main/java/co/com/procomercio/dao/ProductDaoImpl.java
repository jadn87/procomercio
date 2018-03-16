package co.com.procomercio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.procomercio.model.Category;
import co.com.procomercio.model.Product;

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


	@Override
	public List<Product> getProductsXCategory(String category) {
		// TODO Auto-generated method stub
		String hql = "from ProductCategories where upper(root) = ?1 and eliminated = ?2";
		List<Product> results = entityManager.createQuery(hql)
				.setParameter(1, category.toUpperCase())
				.setParameter(2, false).getResultList();
		return null;
	}

}
