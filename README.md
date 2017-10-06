# Simple email sender service

* `http://<hostname>:8080/email` - a rest service accepting a POST request with a JSON
	
```
{
	"sender": <username>@,
	"recipients": [<user1@>, <user2@>, <user3@>],
	"cc": [<user1@>, <user2@>, <user3@>],
	"bcc": [<user1@>, <user2@>, <user3@>],
	"subject": <string>,
	"body": <string>
}
```

sender, recipients and subject fields should not be null

* In order to run it:
  1. Download application.properties and app.jar
  2. Execute `java -Dsping.config.location=<full_path_to_file>/application.properties -jar <full_path_to_jar>/app.jar`
  
* In order to test it, open a terminal and enter the command bellow filling in the sender and recipients fields:
  	`curl -H "Content-Type: application/json" -X POST -d '{"sender":"youremail@mailservice","recipients":["recipient@mailservice"], "subject":"Hello World", "body":"Example email"}' http://localhost:8080/email`
  
  


