package com.externalApi.EA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.externalApi.EA.model.ApiUser;
import com.externalApi.EA.model.User;

@Service
public class ServiceLayer {
//	private final RestTemplate restTemplate;
//	
//	@Autowired
//	public ServiceLayer(RestTemplate restTemplate) {
//		this.restTemplate = restTemplate;
//	}
	@Autowired
	RestTemplate restTemplate = new RestTemplate();

	public User consumeApi() {
		return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/4",User.class);
	}

	public ApiUser consumePostApi(ApiUser apiUser) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Token", "njreuhknjNMBHGEHEB737683B");
		System.out.println(headers);
		String url = "https://reqres.in/api/users";
		HttpEntity<ApiUser> entity = new HttpEntity<ApiUser>(apiUser, headers);
		ResponseEntity<ApiUser> responseEntity = restTemplate.postForEntity(url, entity, ApiUser.class);

		return responseEntity.getBody();

	}

}
