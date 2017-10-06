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

* Requirements:
  1. Java 8
  2. Maven
  3. curl or postman
  4. A browser (if postman)

* Build:
  1. Enther the com.email directory of the repo
  2. Enter `mvn clean install`
  3. Application will be located under the target directory and will be named com.email-2.2.jar. You can rename it.
  3. The resulting jar contains all the libraries needed and an embedded server and servlet container (Jetty) so it's a standalone application

* In order to run it:
  1. Download application.properties and app.jar
  2. Execute `java -Dsping.config.location=<full_path_to_file>/application.properties -jar <full_path_to_jar>/app.jar`
  
* In order to test it, open a terminal and enter the command bellow filling in the sender and recipients fields:

  	`curl -H "Content-Type: application/json" -X POST -d '{"sender":"youremail@mailservice","recipients":["recipient@mailservice"], "subject":"Hello World", "body":"Example email"}' http://localhost:8080/email`
  
  


