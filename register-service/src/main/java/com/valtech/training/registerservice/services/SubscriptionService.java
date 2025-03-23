package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.SubscriptionVO;

public interface SubscriptionService {

	SubscriptionVO getSubscription(long id);

	List<SubscriptionVO> getAllSubscriptions();

	SubscriptionVO createSubscription(SubscriptionVO vo);

}