package com.example.webProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webProject.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

	@Query(value = "select * from Subscription where subscription_id = :subscription_id", nativeQuery = true)
	public Subscription findSubscriberByBookId(@Param(value = "subscription_id") Integer subscription_id);
	

}