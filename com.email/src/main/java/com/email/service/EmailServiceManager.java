package com.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.dto.Email;

@Service
public class EmailServiceManager {
	
	@Autowired
	private EmailService mainEmailService;
	
	@Autowired
	private EmailService fallbackEmailService;
	
	public boolean sendMessage(Email email) {
		if(!mainEmailService.sendEmail(email)) {
			return fallbackEmailService.sendEmail(email);
		}
		return true;
	}
	
}
