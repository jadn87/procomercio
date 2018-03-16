package co.com.procomercio.service;

import java.util.List;
import co.com.procomercio.model.Category;
import co.com.procomercio.model.Product;

public interface ProductService {

	List<Category> getListCategories(String parent);
	List<Product> getProductsXCategory(String category);
	boolean addProduct(Product product);
	void updateProduct(Product product);
}
