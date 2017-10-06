package com.email.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.email.dto.Email;

@RestController
public class EmailWebService {
	
	@Autowired
	EmailServiceManager emailServiceManager;
	
	@RequestMapping(value="/email", method=RequestMethod.POST)
	public ResponseEntity<String> sendMail(@Valid @RequestBody(required=true) Email email) {
		
		System.out.println(email.toString());
		
		if(!emailServiceManager.sendMessage(email)) {
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
