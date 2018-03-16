package co.com.procomercio.dao;

import java.util.List;

import co.com.procomercio.model.Category;
import co.com.procomercio.model.Product;
import co.com.procomercio.model.ProductPK;

public interface ProductDao {

	List<Category> getListCategories(String parent);
	List<Product> getProductsXCategory(String category);
	void addProduct(Product product);
	boolean productExists(String ean, String name);
	Product getProductById(ProductPK prd);
	void updateProduct(Product product);
}
