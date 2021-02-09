package com.mychurch.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String homePhone;
	private String firstLine;
	private String secondLine;
	private String postCode;
	private String county;
	private String state;
	private String country;
	
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getFirstLine() {
		return firstLine;
	}
	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}
	public String getSecondLine() {
		return secondLine;
	}
	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	

}
