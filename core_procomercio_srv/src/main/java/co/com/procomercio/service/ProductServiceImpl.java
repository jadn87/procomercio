package co.com.procomercio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.procomercio.dao.ProductDao;
import co.com.procomercio.model.Category;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	

	@Override
	public List<Category> getListCategories(String parent) {
		// TODO Auto-generated method stub
		return productDao.getListCategories(parent);
	}

	
}
