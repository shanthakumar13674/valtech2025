package com.valtech.training.restapis.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.restapis.entities.Owner;

public class OwnerVO {
	
	private long id;
	private String name;
	private String mobile;
	private String email;
	private List<Long> watches;
	
	public OwnerVO() {}

	public OwnerVO(long id, String name, String mobile, String email,List<Long> watches) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.watches = watches;
	}

	public static OwnerVO from(Owner owner) {
		List<Long> watches = owner.getWatches() == null ? List.of() : owner.getWatches().stream().map(o -> o.getId()).collect(Collectors.toList());
		return new OwnerVO(owner.getId(), owner.getName(), owner.getEmail(),
				owner.getMobile(),watches);
	}
	
	public static List<OwnerVO> toOwnerVO(List<Owner> owners) {
		return owners.stream().map(owner -> OwnerVO.from(owner)).collect(Collectors.toList());
	}
	
	public void updateOwnerFromVO(Owner owner) {
		owner.setName(name);
		owner.setEmail(email);
		owner.setMobile(mobile);
	}
	
	@Override
	public String toString() {
		return "OwnerVO [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", watches="
				+ watches + "]";
	}

	public List<Long> getWatches() {
		return watches;
	}
	public void setWatches(List<Long> watches) {
		this.watches = watches;
	}
	
	public Owner toOwner() {
		Owner owner = new Owner(name, mobile,email);
		owner.setId(id);
		return owner;
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
	
	
	
}
