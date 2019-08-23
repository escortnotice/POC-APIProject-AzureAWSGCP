package com.poc.service;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.constantsandenums.CustomErrorCodeAndMessages;
import com.poc.customexception.CustomRepositoryException;
import com.poc.customexception.CustomServiceException;
import com.poc.repository.TestErrorRepository;

@Service
public class TestErrorService {

	@Autowired
	TestErrorRepository testErrorRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(TestErrorService.class);

	
	// 1. Here exception occurs in this layer(which is the business layer)
	public void testBusinessServiceException() throws CustomServiceException {

		try {
			// this is to simulate the error thrown
			throw new FileNotFoundException("xyz.txt file not found.");
		}

		/*
		 * 1. Print the stack trace of the error occured in business service layer 
		 * 2. Throw a custom exception with custom message to be 
		 *     propogated or displayed
		 */
		catch (FileNotFoundException e) {
			LOGGER.error(CustomErrorCodeAndMessages.INVALID_INPUT_DATA.getErrorCodeAndMessage(), e.getMessage(), e);
			throw new CustomServiceException(CustomErrorCodeAndMessages.INVALID_INPUT_DATA);
		}
	}
	
	
	/*
	 * 2. DB exception occurs when db layer is called, so the exception propogation is shown
	 */
	public void testRepoServiceException() throws CustomRepositoryException {

		testErrorRepo.getDataFromDBonError();

	}
}
