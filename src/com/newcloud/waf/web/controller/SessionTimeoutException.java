package com.newcloud.waf.web.controller;

public class SessionTimeoutException extends Exception{
	private static final long serialVersionUID = 6833780018823155621L;
	
	private String message;
	
	public SessionTimeoutException(String message){
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
