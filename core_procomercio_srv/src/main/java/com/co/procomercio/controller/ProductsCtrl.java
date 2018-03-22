package com.co.procomercio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.co.procomercio.model.Category;
import com.co.procomercio.model.Product;
import com.co.procomercio.model.ProductPK;
import com.co.procomercio.service.ProductService;

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
	
	@GetMapping("getProducts/{category}")
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") String category) {
		List<Product> list = productService.getProductsXCategory(category);
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<Void> addProduct(@RequestBody Product product, UriComponentsBuilder builder) {
        boolean flag = productService.addProduct(product);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("upd") 
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	
	@PostMapping("get")
	public ResponseEntity<Product> getProduct(@RequestBody ProductPK prd) {
		Product product = productService.getProductById(prd);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
}
