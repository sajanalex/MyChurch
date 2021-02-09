package com.mychurch.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Family {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@org.hibernate.validator.constraints.NotEmpty
	private String name;
	@Embedded
	private Address address;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "family")
	private Set<Member> members = new HashSet<>();

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Member> getMembers() {
		return members;
	}
	public void setMembers(Set<Member> members) {
		this.members = members;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	

	

}
