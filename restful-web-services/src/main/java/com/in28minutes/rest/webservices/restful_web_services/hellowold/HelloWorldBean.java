package com.in28minutes.rest.webservices.restful_web_services.hellowold;

public class HelloWorldBean {


	private String message ;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HelloWorldBean(String message,String name) {
		this.message =message;
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
