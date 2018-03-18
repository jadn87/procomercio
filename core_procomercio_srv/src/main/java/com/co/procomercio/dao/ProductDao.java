package com.co.procomercio.dao;

import java.util.List;

import com.co.procomercio.model.Category;
import com.co.procomercio.model.Product;
import com.co.procomercio.model.ProductPK;

public interface ProductDao {

	List<Category> getListCategories(String parent);
	List<Product> getProductsXCategory(String category);
	void addProduct(Product product);
	boolean productExists(String ean, String name);
	Product getProductById(ProductPK prd);
	void updateProduct(Product product);
}
