package co.com.procomercio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import co.com.procomercio.model.User;
import co.com.procomercio.service.UserService;

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


	
}
