Feature: Login into admin page 

Scenario Outline: Login to admin page with correct credentials
	Given user is on login page "<url>" 
	When user enters the username as "<username>" 
	And user enter the password as "<password>" 
	And user clicks on the login button
	Then user is navigated to books details page in url as "<destinationurl>"
	
Examples:
	| url 				        																													|username 	|password			|destinationurl|
	|http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com/login			|admin			|admin				|http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com/book|