package com.co.procomercio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.co.procomercio.model.OrderDetail;
import com.co.procomercio.model.Ticket;
import com.co.procomercio.service.TicketService;

//@RestController 
@Controller
@RequestMapping("ticket")
public class TicketCtrl {

	@Autowired
	private TicketService ticketService; 
	
	
	
//	public ResponseEntity<Void> addProduct(@RequestBody Map<List<Item>,UserAddress> data, 
//			@RequestBody UserAddress useraddress, 
//			UriComponentsBuilder builder) throws JsonParseException, JsonMappingException, IOException 
//	{
//		 ObjectMapper objectMapper = new ObjectMapper();		 
//		 List<Item> items = objectMapper.readValue("data", new TypeReference<List<Item>>(){});
//		 UserAddress usu = objectMapper.readValue("data",UserAddress.class);
	
	@PostMapping("c_tk")
	public ResponseEntity<Void> createOrder(@RequestBody OrderDetail order, UriComponentsBuilder builder) 
	{
		 
		Ticket flag = ticketService.createOrder(order.getItems(), order.getUseraddress());
		if (flag == null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		//        HttpHeaders headers = new HttpHeaders();
		//        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
		//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
}
