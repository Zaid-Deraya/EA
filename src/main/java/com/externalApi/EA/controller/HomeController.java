package com.externalApi.EA.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.externalApi.EA.model.ApiUser;
import com.externalApi.EA.model.User;
import com.externalApi.EA.service.ServiceLayer;

@RestController
public class HomeController {

//	private final ServiceLayer serviceLayer;
//
//	public HomeController(ServiceLayer serviceLayer) {
//		this.serviceLayer = serviceLayer;
//	}
	@Autowired
	private ServiceLayer serviceLayer;

	@GetMapping("/")
	public ResponseEntity<User> getUser() {
		return new ResponseEntity<>(this.serviceLayer.consumeApi(), HttpStatus.OK); 	
	}
	
	@PostMapping("/ApiUser")
	public ApiUser getApiUser(@RequestBody ApiUser apiUser){
		return serviceLayer.consumePostApi(apiUser);
		
	}
} 
