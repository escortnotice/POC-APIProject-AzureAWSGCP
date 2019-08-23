package com.poc.customexception;

import com.poc.constantsandenums.CustomErrorCodeAndMessages;

@SuppressWarnings("serial")
public class CustomServiceException extends CustomBaseException {
	
	public CustomServiceException ( CustomErrorCodeAndMessages customErrorCodesAndMessages, Throwable cause) {
		super(customErrorCodesAndMessages, cause);
	}
	
	public CustomServiceException ( CustomErrorCodeAndMessages customErrorCodesAndMessages) {
		super(customErrorCodesAndMessages);
	}


}
