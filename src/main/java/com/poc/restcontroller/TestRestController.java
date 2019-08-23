package com.poc.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.customexception.CustomBaseException;
import com.poc.model.APIResponse;
import com.poc.service.TestErrorService;

@RestController
public class TestRestController {
	
	@Autowired
	TestErrorService testErrorService;
	
	@GetMapping("/")
	public String test() {
		return "Spring Boot Application is Working Fine";
	}
	
	/*
	 * Handling exception occurred in Service layer
	 */
	@GetMapping("/test-error-service")
	public APIResponse testErrorService() throws CustomBaseException {
		
		testErrorService.testBusinessServiceException();
		
		//in case of success
		APIResponse apiResp = new APIResponse();
		apiResp.setSuccess(true);
		return apiResp;
		
	}
	
	/*
	 * Handling exception occurred in Repository Layer
	 */
	@GetMapping("/test-error-repo")
	public APIResponse testErrorRepo() throws CustomBaseException {
		
		testErrorService.testRepoServiceException();
		
		//in case of success ( the code will never reach here as intentionally exception thrown above, so ignore reading this line for understanding)
		APIResponse apiResp = new APIResponse();
		apiResp.setSuccess(true);
		return apiResp;
			
	}
	
}
