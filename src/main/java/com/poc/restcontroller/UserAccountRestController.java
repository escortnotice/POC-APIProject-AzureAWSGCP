package com.poc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.model.APIResponse;
import com.poc.model.UserAccount;
import com.poc.repository.UserAccountRepository;
import com.poc.util.BuildResponseUtil;

@RestController
public class UserAccountRestController {
	
	@Autowired
	UserAccountRepository userAccountRepo;
	
	@GetMapping("/useraccount")
	public APIResponse getUsers() {
		List<UserAccount> userAccountList = userAccountRepo.findAll();
		return BuildResponseUtil.buildSuccessResponseObject(userAccountList, "UserAccount List Fetched Successfully");
	}

}
