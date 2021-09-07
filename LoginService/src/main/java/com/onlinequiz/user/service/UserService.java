package com.onlinequiz.user.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinequiz.user.entity.Subscription;
import com.onlinequiz.user.entity.User;
import com.onlinequiz.user.repository.UserRepository;
@Service
public class UserService 
{
    @Autowired
    UserRepository userRepository;
    
    @Transactional(readOnly=true)
    public boolean authenticateUser(String username,String password)
    {
    	return userRepository.getUserByUsernameAndPassword(username, password)==1 ? true : false;
    }

	/*public List<User> getUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}*/
    
    
    
}