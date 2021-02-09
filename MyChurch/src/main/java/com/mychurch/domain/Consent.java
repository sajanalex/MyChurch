package com.mychurch.domain;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Consent {
	
	
	private Boolean email_consent;
	private Boolean phone_consent;
	private Boolean mobile_consent;
	private Boolean postal_consent;
	private Date date_consent;
	private byte[] image;

	public Boolean getEmail_consent() {
		return email_consent;
	}

	public void setEmail_consent(Boolean email_consent) {
		this.email_consent = email_consent;
	}

	public Boolean getPhone_consent() {
		return phone_consent;
	}

	public void setPhone_consent(Boolean phone_consent) {
		this.phone_consent = phone_consent;
	}

	public Boolean getMobile_consent() {
		return mobile_consent;
	}

	public void setMobile_consent(Boolean mobile_consent) {
		this.mobile_consent = mobile_consent;
	}

	public Boolean getPostal_consent() {
		return postal_consent;
	}

	public void setPostal_consent(Boolean postal_consent) {
		this.postal_consent = postal_consent;
	}

	public Date getDate_consent() {
		return date_consent;
	}

	public void setDate_consent(Date date_consent) {
		this.date_consent = date_consent;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}



	



	

}
