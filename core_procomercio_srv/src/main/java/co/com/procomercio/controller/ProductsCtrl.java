package co.com.procomercio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import co.com.procomercio.model.Category;
import co.com.procomercio.service.ProductService;

//@RestController 
@Controller
@RequestMapping("products")
public class ProductsCtrl {

	@Autowired
	private ProductService productService; 
		
	@GetMapping("getCategories/{parent}")
	public ResponseEntity<List<Category>> getCategories(@PathVariable("parent") String parent) {
		List<Category> list = productService.getListCategories(parent);
		return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
	}
	
	
}
