package com.example.webProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webProject.model.Subscription;
import com.example.webProject.service.SubscriberService;


@RestController
@RequestMapping("/library")
public class SubscriberController {

	
	@Autowired
	SubscriberService subscriberService;
	
	@GetMapping("/subscriptions")
	public List<Subscription> getAllSubscriber() throws Exception {
		return subscriberService.findAllSubscribers();
	}
	
	@PostMapping("/addsubscription")
	public void saveSubscription(@RequestBody Subscription subscription) {
		subscriberService.insertSubscription(subscription);
	}
	
	@GetMapping("/subscription/{subscriptionId}")
	public Subscription getSubscriberById(@PathVariable Integer subscriptionId) {
		return subscriberService.findSubscriberByName(subscriptionId);
	}
}
