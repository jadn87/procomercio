package com.co.procomercio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.co.procomercio.model.User;
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


	@PostMapping("addUser")
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
	
}
