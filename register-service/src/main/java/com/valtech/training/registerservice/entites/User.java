package com.valtech.training.registerservice.entites;

import java.time.LocalDate;

import org.hibernate.annotations.GeneratedColumn;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user-seq")
	@SequenceGenerator(name = "user-seq", sequenceName = "user-seq", allocationSize = 1)
	private long id;
	private String name;
	private int age;
	private String mobile;
	private String email;
	private Boolean kid;
	
	@ManyToOne(targetEntity = Subscription.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id",name = "subscription_id")
	private Subscription subscription;
	public User() {
	}

	public User(long id, String name, int age, String mobile, String email,Boolean kid) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.kid = kid;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setKid(Boolean kid) {
		this.kid = kid;
	}
	public Boolean getKid() {
		return kid;
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
}
