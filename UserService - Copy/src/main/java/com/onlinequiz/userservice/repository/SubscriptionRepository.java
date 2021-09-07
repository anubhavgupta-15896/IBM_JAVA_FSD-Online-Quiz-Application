package com.onlinequiz.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinequiz.userservice.entity.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Integer> {

}
