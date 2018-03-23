package com.co.procomercio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.co.procomercio.model.Category;
import com.co.procomercio.model.Item;
import com.co.procomercio.model.Product;
import com.co.procomercio.model.ProductPK;
import com.co.procomercio.model.Ticket;
import com.co.procomercio.model.UserAddress;
import com.co.procomercio.service.ProductService;
import com.co.procomercio.service.TicketService;

//@RestController 
@Controller
@RequestMapping("ticket")
public class TicketCtrl {

	@Autowired
	private TicketService ticketService; 
		
	
	@PostMapping("c_tk")
	public ResponseEntity<Void> addProduct(@RequestBody List<Item> items, 
			@RequestBody UserAddress useraddress, 
			UriComponentsBuilder builder) 
	{
		Ticket flag = ticketService.createOrder(items, useraddress);
		if (flag == null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		//        HttpHeaders headers = new HttpHeaders();
		//        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
		//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
}
