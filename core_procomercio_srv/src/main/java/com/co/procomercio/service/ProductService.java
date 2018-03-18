package com.co.procomercio.service;

import java.util.List;

import com.co.procomercio.model.Category;
import com.co.procomercio.model.Product;

public interface ProductService {

	List<Category> getListCategories(String parent);
	List<Product> getProductsXCategory(String category);
	boolean addProduct(Product product);
	void updateProduct(Product product);
}
