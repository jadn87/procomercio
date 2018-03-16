package co.com.procomercio.service;

import java.util.List;
import co.com.procomercio.model.Category;

public interface ProductService {

	List<Category> getListCategories(String parent);
}
