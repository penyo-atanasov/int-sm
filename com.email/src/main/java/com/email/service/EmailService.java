package com.email.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.email.dto.Email;

public abstract class EmailService {
	
	public boolean sendEmail(Email email) {
		UsernamePasswordCredentials credentials
			= new UsernamePasswordCredentials("api", getKey());

		CredentialsProvider provider = new BasicCredentialsProvider();
		provider.setCredentials(AuthScope.ANY, credentials);
		
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3 * 1000).build();
		
		CloseableHttpClient httpClient = HttpClientBuilder.create()
	    		.setDefaultCredentialsProvider(provider)
	    		.setDefaultRequestConfig(requestConfig)
	    		.build();
		
	    try {
	    	CloseableHttpResponse response = httpClient.execute(createRequest(email));
	    	if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK) {
	    		String content = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
	    				.lines().collect(Collectors.joining("\n"));
	    		
	    		//TODO add logging...
	    		System.out.println(content);
	    		return false;
	    	}
	    	
	    } catch (IOException e) {
	    	//TODO add logging...
	    	e.printStackTrace();
	    	return false;
		}
	    
	    return true;
		
	}
	
	protected abstract String getKey();
	
	protected abstract HttpUriRequest createRequest(Email email);
	
}
