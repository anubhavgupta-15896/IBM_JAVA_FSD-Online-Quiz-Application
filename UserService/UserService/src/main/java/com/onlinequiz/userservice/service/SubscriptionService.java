package com.onlinequiz.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinequiz.userservice.entity.Subscription;
import com.onlinequiz.userservice.repository.SubscriptionRepository;

@Service

public class SubscriptionService {
	
	@Autowired SubscriptionRepository subscriptionRepository;
	
	
	
	@Transactional
    public boolean insertSubscription(Subscription subscription)
    {
   	 Subscription s = subscriptionRepository.save(subscription);
   	 if(s!=null) return true;
   	throw new RuntimeException("Subscription Insertion Failed");
    }
	
	@Transactional
	public Subscription getSubscriptionById(int subcriptionId) {
		Optional<Subscription> subcription = subscriptionRepository.findById(subcriptionId);
		if(subcription.isPresent())
			return subcription.get();
		return null;
			
	}

}
