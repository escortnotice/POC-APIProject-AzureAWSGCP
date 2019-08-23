package com.poc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class APIErrorResponse<T> {
	
	@JsonProperty("error-message")
	private String errorMessage;
	
	@JsonProperty("error-code")
	private int errorCode;
	
	
	@JsonProperty("error-data")
	@JsonInclude(Include.NON_NULL)
	private T errorData;
	
	//getters and setters
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public T getErrorData() {
		return errorData;
	}
	public void setErrorData(T errorData) {
		this.errorData = errorData;
	}
	@Override
	public String toString() {
		return "APIErrorResponse [errorMessage=" + errorMessage + ", errorCode=" + errorCode + "]";
	}
	
	
	
	
}
