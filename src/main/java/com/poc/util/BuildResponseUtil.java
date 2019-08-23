package com.poc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.poc.constantsandenums.CustomErrorCodeAndMessages;
import com.poc.customexception.CustomBaseException;
import com.poc.model.APIErrorResponse;
import com.poc.model.APIResponse;

@Component
public class BuildResponseUtil {
	
	private static final String RESPONSE_DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

	// private constructor
	private BuildResponseUtil() {
	}

	// Build the success Response
	public static final APIResponse buildSuccessResponseObject(Object result, String message) {
		APIResponse apiResponse = new APIResponse();
		apiResponse.setMessage(message);
		apiResponse.setSuccess(true);

		DateFormat dateFormat = new SimpleDateFormat(RESPONSE_DATE_FORMAT);
		Date date = new Date();
		apiResponse.setTimestamp(dateFormat.format(date)); // example: 2016/11/16 12:08:43

		apiResponse.setData(result);

		return apiResponse;

	}

	// Build the Error Response
	public static final APIResponse buildErrorResponseObject(CustomBaseException customBaseException,
			String genericErrorMessage) {

		APIResponse apiResponse = new APIResponse();
		apiResponse.setMessage(genericErrorMessage); // a generic error message
		apiResponse.setSuccess(false);

		DateFormat dateFormat = new SimpleDateFormat(RESPONSE_DATE_FORMAT);
		Date date = new Date();
		apiResponse.setTimestamp(dateFormat.format(date)); // example: 2016/11/16 12:08:43

		APIErrorResponse<Object> apiError = new APIErrorResponse<>();
		apiError.setErrorCode(customBaseException.getCustomErrorCodeAndMessages().getErrorCode());
		apiError.setErrorMessage(customBaseException.getCustomErrorCodeAndMessages().getErrorMessage());
		apiResponse.setError(apiError);

		return apiResponse;

	}
	
	//Build the Error Response on conditions like (incorrect arguments, validation failed for request parameters, HTTP method not supported, etc)
	public static final   APIResponse buildErrorResponseObject(Object errorData, CustomErrorCodeAndMessages customErrorCode) {
		APIResponse apiResponse = new APIResponse();
		apiResponse.setMessage(customErrorCode.getErrorMessage()); // a generic error message
		apiResponse.setSuccess(false);

		DateFormat dateFormat = new SimpleDateFormat(RESPONSE_DATE_FORMAT);
		Date date = new Date();
		apiResponse.setTimestamp(dateFormat.format(date)); // example: 2016/11/16 12:08:43

		APIErrorResponse<Object> apiError = new APIErrorResponse<>();
		apiError.setErrorCode(customErrorCode.getErrorCode());
		apiError.setErrorMessage(customErrorCode.getErrorMessage());
		apiError.setErrorData(errorData);
		apiResponse.setError(apiError);
		
		return apiResponse;
		
	}

}
