package co.com.procomercio.dao;

import java.util.List;

import co.com.procomercio.model.Category;
import co.com.procomercio.model.Product;

public interface ProductDao {

	List<Category> getListCategories(String parent);
	List<Product> getProductsXCategory(String category);
}
