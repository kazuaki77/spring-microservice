package com.in28minutes.rest.webservices.restful_web_services.user;

import java.time.LocalDate;

public class ErrorDetails {

	private LocalDate timestamp;

	private String meddage;

	private String details;

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public String getMeddage() {
		return meddage;
	}

	public void setMeddage(String meddage) {
		this.meddage = meddage;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ErrorDetails(LocalDate timestamp, String meddage, String details) {
		super();
		this.timestamp = timestamp;
		this.meddage = meddage;
		this.details = details;
	}

}
