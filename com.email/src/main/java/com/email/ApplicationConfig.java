package com.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.email.service.EmailService;
import com.email.service.MailGunService;
import com.email.service.SendGridService;

@Configuration
@ConfigurationProperties(value="file://config/email_credentials.props")
public class ApplicationConfig {
	
	@Bean
	public EmailService fallbackEmailService(@Value("${mailgun.key}") String key) {
		return new MailGunService(key);
	}
	
	@Bean
	public EmailService mainEmailService(@Value("${sendgrid.key}") String key) {
		return new SendGridService(key);
	}
	
	
}
