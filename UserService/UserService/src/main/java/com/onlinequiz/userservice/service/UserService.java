package com.onlinequiz.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinequiz.userservice.entity.Subscription;
import com.onlinequiz.userservice.entity.User;
import com.onlinequiz.userservice.repository.SubscriptionRepository;
import com.onlinequiz.userservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired UserRepository userRepository;
	
	@Autowired SubscriptionRepository subscriptionRepository;
	
	
	@Transactional(readOnly = true)
	public User getUserName(String userName) {
		Optional<User> s = userRepository.findById(userName);
		if (s.isPresent()) {
			return s.get();
		}
		return null;

	}
	@Transactional
    public boolean insertUser(User userDetails)
    {
		System.out.println(userDetails.toString());
    	return userRepository.save(userDetails) !=null ? true : false;
    }
    
    @Transactional
    public boolean modifyUser(User user)
    {
    	User qs = userRepository.save(user);
        System.out.println(qs.toString());
        if(qs != null) {    
            for(Subscription uqh : user.getSubscriptions()) {
            	System.out.println(uqh);
                uqh.setUserName(qs.getUsername());
                System.out.println(uqh);
                //subscriptionRepository.save(uqh);
                System.out.println(subscriptionRepository.save(uqh));
            }
            return true;
        }
        return false;
    	//return userRepository.save(user)!=null ? true : false;
    }
    
  
	
	

}
