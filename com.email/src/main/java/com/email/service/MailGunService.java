package com.email.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;

import com.email.dto.Email;

public class MailGunService extends EmailService {
	
	private String key;
	
	public MailGunService(String key) {
		this.key = key;
	}
	
	protected String getKey() {
		return key;
	}
	
	@Override
	protected HttpPost createRequest(Email email) {
		URIBuilder builder = new URIBuilder();
	    builder.setScheme("https").setHost("api.mailgun.net")
	    .setPath("v3/sandbox9f1f250c126a450cb59646ab5f18b63b.mailgun.org/messages")
	    .setParameter("from", email.getSender())
	    .setParameter("to", String.join(",", email.getRecepients()))
	    .setParameter("subject", email.getSubject())
	    .setParameter("text", email.getBody());
	    
	    if(email.getCc()!= null) {
	    	builder.setParameter("cc", String.join(",", email.getCc()));
	    }
	    if(email.getBcc()!=null) {
	    	builder.setParameter("bcc", String.join(",", email.getBcc()));
	    }
	    
	    URI uri = null;
		try {
			uri = builder.build();
		} catch (URISyntaxException e) {
			//should never happen, since we are passing the parameters
			//TODO add logging just in case
			e.printStackTrace();
		}
	    
	    return new HttpPost(uri); 
	    
	}

}
