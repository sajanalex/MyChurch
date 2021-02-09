package com.mychurch.domain;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import net.minidev.json.annotate.JsonIgnore;

@Entity
public class Member {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	
	@Length(min = 1,max = 32,message = "First name should be between 1 and 32 characters")
	private String firstName;
	@Length(min = 1,max = 32,message = "Last name should be between 1 and 32 characters")
	private String lastName;
	@DateTimeFormat(iso = ISO.DATE)
	private Date dob;
	@org.hibernate.validator.constraints.Email
	private String email;
	
	private String mobile;
	
	@ManyToOne @JoinColumn(name="FAMILY_ID")
	private Family family;
	@Embedded
	private Consent consent;
	@ManyToOne @JoinColumn(name="ASSEMBLY_ID")
	private Assembly assembly;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Family getFamily() {
		return family;
	}
	@JsonIgnore
	public void setFamily(Family family) {
		this.family = family;
	}
	public Consent getConsent() {
		return consent;
	}
	public void setConsent(Consent consent) {
		this.consent = consent;
	}
	public Assembly getAssembly() {
		return assembly;
	}
	public void setAssembly(Assembly assembly) {
		this.assembly = assembly;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	

	
	
}
