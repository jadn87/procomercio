package co.com.procomercio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.procomercio.model.Category;
import co.com.procomercio.model.Product;
import co.com.procomercio.model.ProductPK;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao{

	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public Product getProductById(ProductPK prd) {
		return entityManager.find(Product.class, prd);
	}
	
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


	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductsXCategory(String category) {
		// TODO Auto-generated method stub
		String hql ="select p.pricelist, p.ean, p.name, p.supplier, p.amount, p.tax,";
		hql = hql + " p.updated, p.eliminated, p.promodatefrom, p.promodatevto, p.amountpromo ";
		hql = hql + " from Product p, ProductCategories c where p.eliminated = ?2 and p.ean = c.product ";
		hql = hql + " and upper(c.root) = ?1 and c.eliminated= ?2 ";
		List<Product> results = entityManager.createQuery(hql)
				.setParameter(1, category.toUpperCase())
				.setParameter(2, false).getResultList();
		
		return results;
	}
	
	
	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);
	}
	
	
	@Override
	public boolean productExists(String ean, String name) {
		String hql = "from Product where ean = ?1 and name = ?2";
		int count = entityManager.createQuery(hql)
				.setParameter(1, ean)
				.setParameter(2, name).getResultList().size();
		return count > 0 ? true : false;
	}
	
	@Override
	public void updateProduct(Product product) {
		ProductPK pk = new ProductPK(product.getEan(),product.getPricelist());
		Product objProduct = getProductById(pk);
		objProduct.setAmount(product.getAmount());
		objProduct.setName(product.getName());
		entityManager.flush();
	}

}
