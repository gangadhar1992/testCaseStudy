package com.example.webProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.webProject.model.Book;
import com.example.webProject.model.Subscription;
import com.example.webProject.repository.SubscriptionRepository;

@Service
public class SubscriberService	 {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	SubscriptionRepository subscriptionRepository;
	

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public List<Subscription> findAllSubscribers() throws Exception {
		
		List<Subscription> subscriberList = subscriptionRepository.findAll();
		if(subscriberList == null || subscriberList.size() == 0) {
			throw new Exception("No sunscriptions found!!!!!!!");
		}
		return subscriberList;
	}

	
	public void insertSubscription(Subscription subscription) {
		subscriptionRepository.save(subscription);
		Subscription existingSubscription = subscriptionRepository.findSubscriberByBookId(subscription.getSubscriptionId());
			if(existingSubscription == null) {
			if(doesBookExist(subscription.getBookId()) > 0) {
				subscriptionRepository.save(subscription);
			}
		}
		}
	
	public Subscription findSubscriberByName(Integer subscriptionId) {

		Optional<Subscription> subscriberList = subscriptionRepository.findById(subscriptionId);
		return subscriberList.isPresent() ? subscriberList.get() : null;
	}
	
	private Integer doesBookExist(Integer bookId) {
		
		String execuiteUrl = "http://localhost:8080/books/getbook/id/" + bookId;
		ResponseEntity<Book> reponseEntity = restTemplate.exchange(execuiteUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<Book>() {
				});
		Book book = reponseEntity.getBody();
		return book.getAvailableCount();
	}
}
