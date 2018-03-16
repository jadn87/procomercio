package co.com.procomercio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.procomercio.dao.ProductDao;
import co.com.procomercio.model.Category;
import co.com.procomercio.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	

	@Override
	public List<Category> getListCategories(String parent) {
		// TODO Auto-generated method stub
		return productDao.getListCategories(parent);
	}

	@Override
	public List<Product> getProductsXCategory(String category) {
		// TODO Auto-generated method stub
		return productDao.getProductsXCategory(category);
	}
	
	@Override
	public synchronized boolean addProduct(Product product){
       if (productDao.productExists(product.getEan(), product.getName())) {
    	   return false;
       } else {
    	   productDao.addProduct(product);
    	   return true;
       }
	}
	
	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}
	
}
