package com.valtech.training.registerservice.services;



import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entites.Subscription;
import com.valtech.training.registerservice.entites.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.UserVO;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	@Override
	public UserVO addUserToSubscription(UserVO vo, long sub) {
		Subscription sc= subscriptionRepo.getReferenceById(sub);
		User user=vo.to(sc);
		user=userRepo.save(user);
		return UserVO.from(user);
		
	}
	
	@Override
	public UserVO getUser(long id) {
		return UserVO.from(userRepo.getReferenceById(id));
	}

	@Override
	public UserVO signIn(UserVO vo) {
		Subscription sc = new Subscription();
//		sc.setAmount();
		sc.setSubscriptionStart(LocalDate.now());
		sc.setSubscriptionEnd(LocalDate.now().plusYears(1));
		sc= subscriptionRepo.save(sc);
		User user =vo.to(sc);
		sc.addUser(user);
		user = userRepo.save(user);
		return UserVO.from(user);
	}

	@Override
	public void deleteUserFromSubscription(long userId) {
		User u = userRepo.getReferenceById(userId);
		Subscription  sub = u.getSubscription();
		sub.removeUser(u);
		userRepo.delete(u);
	}

	

}
