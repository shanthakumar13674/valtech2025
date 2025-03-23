package com.valtech.training.registerservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.services.SubscriptionService;
import com.valtech.training.registerservice.vos.SubscriptionVO;

@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;
    
    @GetMapping("/{id}")
    public SubscriptionVO getSubscription(@PathVariable("id") long id) {
    	return subscriptionService.getSubscription(id);
    }
    @GetMapping("/")
    public List<SubscriptionVO> getAllSubscriptions(){
    	return subscriptionService.getAllSubscriptions();
    }
    
    @PostMapping("/")
    public SubscriptionVO createSubscription(@RequestBody SubscriptionVO vo) {
    	return subscriptionService.createSubscription(vo);
    }
    
}
