package com.valtech.training.registerservice.vos;

import com.valtech.training.registerservice.entites.Subscription;
import com.valtech.training.registerservice.entites.User;

public record UserVO(long id,String name,int age,String mobile,String email,Boolean kid,long subscriptionId) {
	
	public static UserVO from(User u) {
		return new UserVO(u.getId(),u.getName(),u.getAge(),u.getMobile(),u.getEmail(),u.getKid(),u.getSubscription().getId());
	}
	
	public User to(Subscription sub) {
		User user = new User(id,name,age,mobile,email,kid);
		user.setSubscription(sub);
		return user;
	}
}
