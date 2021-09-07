package com.onlinequiz.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinequiz.userservice.entity.Subscription;
import com.onlinequiz.userservice.entity.User;
import com.onlinequiz.userservice.service.SubscriptionService;
import com.onlinequiz.userservice.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	SubscriptionService subscriptionService;
	
	
	
	@GetMapping(value = "/{userName}", produces = "application/json")
	public ResponseEntity<User> getUserName(@PathVariable String userName) {
		User s = userService.getUserName(userName);
		if (s != null) {
			return new ResponseEntity<User>(s, HttpStatus.OK);
		}
		return new ResponseEntity<User>(s, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(consumes="application/json")
    public HttpStatus insertUserDetails(@RequestBody User user)
    {
		System.out.println(user.toString());
   	 return userService.insertUser(user) ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
    }
    
    @PutMapping(consumes="application/json")
    public HttpStatus modifyUserDetails(@RequestBody User user)
    {
   	 return userService.modifyUser(user) ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
    }
    
    @PostMapping(value = "/subscribe", consumes="application/json")
    public HttpStatus insertSubscription(@RequestBody Subscription subscription)
    {
    	try
    	{
    		subscriptionService.insertSubscription(subscription);
    		return HttpStatus.OK;
    	}
    	catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}
    	return HttpStatus.NOT_MODIFIED;
    }
    
    @GetMapping(value = "/subscribe/{subcriptionId}", produces = "application/json")
	public ResponseEntity<Subscription> getSubscription(@PathVariable int subcriptionId) {
		Subscription s = subscriptionService.getSubscriptionById(subcriptionId);
		if (s != null) {
			return new ResponseEntity<Subscription>(s, HttpStatus.OK);
		}
		return new ResponseEntity<Subscription>(s, HttpStatus.NOT_FOUND);
	}
}
