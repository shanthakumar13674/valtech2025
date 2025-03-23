package com.valtech.training.registerservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.registerservice.entites.Subscription;
import com.valtech.training.registerservice.entites.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public SubscriptionVO getSubscription(long id) {
		return SubscriptionVO.from(subscriptionRepo.getReferenceById(id));
	}

	@Override
	public List<SubscriptionVO> getAllSubscriptions() {
		return subscriptionRepo.findAll().stream().map(SubscriptionVO::from).toList();
	}

	@Override
	public SubscriptionVO createSubscription(SubscriptionVO vo) {
		List<User> users = userRepo.findAllById(vo.userIds());
		Subscription sc = vo.to(users);
		sc = subscriptionRepo.save(sc);
		return SubscriptionVO.from(sc);
	}
	
	
	
}
