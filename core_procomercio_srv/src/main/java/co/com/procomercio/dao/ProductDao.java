package co.com.procomercio.dao;

import java.util.List;

import co.com.procomercio.model.Category;

public interface ProductDao {

	List<Category> getListCategories(String parent);
}
