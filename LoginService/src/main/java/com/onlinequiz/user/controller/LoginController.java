package com.onlinequiz.user.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.onlinequiz.user.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController 
{
     @Autowired
     UserService userService;
     
     @GetMapping("/username/{username}/password/{password}")
     public HttpStatus authenticateUser(@PathVariable String username,@PathVariable String password)
     {
    	 if(userService.authenticateUser(username, password))
    		 return HttpStatus.OK;
    	 return HttpStatus.NOT_FOUND;
     }
    /* @GetMapping
 	public ResponseEntity<List<User>> getAllSubscriptions() {
 		return new ResponseEntity<List<User>>(userService.getUser(), HttpStatus.OK);
 	}*/
     
     
}