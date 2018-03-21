package com.co.procomercio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.co.procomercio.model.User;
import com.co.procomercio.model.UserAddress;
import com.co.procomercio.service.UserService;

//@RestController 
@Controller
@RequestMapping("users")
public class UserCtrl {

	@Autowired
	private UserService userService; 
		
	@GetMapping("get/{userId}")
	public ResponseEntity<User> getIdByValue(@PathVariable("userId") String userId){
		User user = userService.getUserById(userId);		
		System.out.println("ID is "+userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}


	@PostMapping("add")
	public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder) {
        boolean flag = userService.addUser(user);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@PutMapping("upd") 
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("address")
	public ResponseEntity<Void> addUserAddress(@RequestBody UserAddress useraddress, UriComponentsBuilder builder) {
        userService.addUserAddress(useraddress);        
        return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("getAddress/{username}")
	public ResponseEntity<List<UserAddress>> getUserAddress(@PathVariable("username") String username){
		List<UserAddress> address = userService.getUserAddress(username);		
		return new ResponseEntity<List<UserAddress>>(address, HttpStatus.OK);
	}
	
	@GetMapping("login")
	public ResponseEntity<User> userLogin(@RequestBody User user){
		boolean login = userService.login(user);		
		if(login) System.out.println("User ID "+user.getName() + " login success");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
