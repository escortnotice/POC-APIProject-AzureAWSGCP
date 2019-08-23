package com.poc.customexception;

import com.poc.constantsandenums.CustomErrorCodeAndMessages;

@SuppressWarnings("serial")
public class CustomRepositoryException  extends CustomBaseException {
	
	public CustomRepositoryException ( CustomErrorCodeAndMessages customErrorCodesAndMessages, Throwable cause) {
		super(customErrorCodesAndMessages, cause);
	}
	
	public CustomRepositoryException ( CustomErrorCodeAndMessages customErrorCodesAndMessages) {
		super(customErrorCodesAndMessages);
	}

	
}
