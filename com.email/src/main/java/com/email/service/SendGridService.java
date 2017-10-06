package com.email.service;

import java.net.URISyntaxException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.email.dto.Email;

public class SendGridService extends EmailService {
	
	private String key;
			
	public SendGridService(String key) {
		this.key = key;
	}

	protected String getKey() {
		return key;
	}
	
	@Override
	protected HttpUriRequest createRequest(Email email) {
		URIBuilder builder = new URIBuilder();
	    builder.setScheme("https").setHost("api.sendgrid.com")
	    .setPath("/v3/mail/send");
		HttpPost post = null;
		try {
			post = new HttpPost(builder.build());
		} catch (URISyntaxException e) {
			//should never happen, since we are passing the parameters
			//TODO add logging just in case
			e.printStackTrace();
		}
    	post.setHeader("Authorization", key);
    	post.setHeader("Content-Type", "application/json");
    	post.setEntity(new ByteArrayEntity(getRequestData(email).getBytes()));
		return post;
	}	
	
	private String getRequestData(Email email) {
		{  
// 		   "personalizations":[  
// 		      {  
// 		         "to":[  
// 		            {  
// 		               "email":"test@example.com"
// 		            }
// 		         ]
// 		      }
// 		   ],
// 		   "from":{  
// 		      "email":"test@example.com"
// 		   },
// 		   "subject":"Sending with SendGrid is Fun",
// 		   "content":[  
// 		      {  
// 		         "type":"text/plain",
// 		         "value":"and easy to do anywhere, even with cURL"
// 		      }
// 		   ]
// 		}
			JSONObject data = new JSONObject();
			try {
				JSONArray personalizations = new JSONArray();
				JSONObject firstPersonalization = new JSONObject();
				personalizations.put(firstPersonalization);
				firstPersonalization.put("to", buildRecipients(email.getRecepients()));
				if(email.getCc() != null) {
					firstPersonalization.put("cc", buildRecipients(email.getCc()));
				}
				if(email.getBcc() != null) {
					firstPersonalization.put("bcc", buildRecipients(email.getBcc()));
				}
		    	data.put("personalizations", personalizations);
		    	JSONObject from = new JSONObject();
		    	from.put("email", email.getSender());
		    	data.put("from", from);
		    	data.put("subject", email.getSubject());
		    	JSONArray content = new JSONArray();
		    	JSONObject emailBody = new JSONObject();
		    	emailBody.put("type", "text/plain");
		    	emailBody.put("value", email.getBody());
		    	content.put(emailBody);
		    	data.put("content", content);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
	    	return data.toString();
		}
	}
	
	private JSONArray buildRecipients(String [] recipients) throws JSONException {
		JSONArray to = new JSONArray();
		for(String recepient : recipients){
			JSONObject r = new JSONObject();
			r.put("email", recepient);
			to.put(r);
		}
		
		return to;
	}

}
