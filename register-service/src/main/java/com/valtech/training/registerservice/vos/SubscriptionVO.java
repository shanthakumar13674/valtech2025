package com.valtech.training.registerservice.vos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.registerservice.entites.Subscription;
import com.valtech.training.registerservice.entites.User;

public record SubscriptionVO(long id,int amount,String subscriptionStart,String subscriptionEnd,java.util.List<Long> userIds) {
	
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public static SubscriptionVO from(Subscription s) {
		String startDate = s.getSubscriptionStart().format(FORMATTER);
		String endDate = s.getSubscriptionEnd().format(FORMATTER);
		List<Long> userIds=s.getUsers().stream().map(User::getId).collect(Collectors.toList());
		return new SubscriptionVO(s.getId(), s.getAmount(), startDate, endDate,userIds);
	}
	public Subscription to(List<User> users) {
		LocalDate startDate = LocalDate.parse(subscriptionStart, FORMATTER);
		LocalDate endDate = LocalDate.parse(subscriptionEnd, FORMATTER);
		
		
		Subscription subs=new Subscription(id,amount,startDate,endDate);
		subs.setUsers(users);
		return subs;
	}
	
	
}
