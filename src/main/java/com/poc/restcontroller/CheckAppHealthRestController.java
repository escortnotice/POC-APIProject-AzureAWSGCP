package com.poc.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckAppHealthRestController {

	@GetMapping("/health")
	@ResponseStatus(HttpStatus.OK)
	public String checkAppHealth() {
		return "{\"status\":\"ok\"}";
	}
}
