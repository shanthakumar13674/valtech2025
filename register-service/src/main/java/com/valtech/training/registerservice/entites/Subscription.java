package com.valtech.training.registerservice.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Subscription {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sub-seq")
	@SequenceGenerator(name = "sub-seq",sequenceName = "sub-seq",allocationSize = 1)
	private long id;
	private int amount;
	private LocalDate subscriptionStart;
	private LocalDate subscriptionEnd;
	
	@OneToMany(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<User> users;
	
	
	public Subscription() {}
	

	public Subscription(long id,int amount, LocalDate subscriptionStart, LocalDate subscriptionEnd) {
		this.id = id;
		this.amount = amount;
		this.subscriptionStart = subscriptionStart;
		this.subscriptionEnd = subscriptionEnd;
	}
	
	public void addUser(User u) {
		if(users==null) users= new ArrayList<User>();
		users.add(u);
		u.setSubscription(this);
	}
	
	public void removeUser(User u) {
		users.remove(u);
		u.setSubscription(null);
		
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalDate getSubscriptionStart() {
		return subscriptionStart;
	}
	public void setSubscriptionStart(LocalDate subscriptionStart) {
		this.subscriptionStart = subscriptionStart;
	}
	public LocalDate getSubscriptionEnd() {
		return subscriptionEnd;
	}
	public void setSubscriptionEnd(LocalDate subscriptionEnd) {
		this.subscriptionEnd = subscriptionEnd;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	

}
