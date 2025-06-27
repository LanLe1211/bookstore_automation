Feature: Login into admin page 
  Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"

Scenario Outline: AT01_Login to admin page with incorrect credentials
	When user click on the admin link
	Then user is on login page as "<admin_login_url>"
	And user enters the username as "<username>" 
	And user enter the password as "<password>" 
	And user clicks on the login button
	Then user is presented with the following message "<message>"
	
	Examples:
	| admin_login_url 				        																													|username 	|password			|message		 |
	|http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/login			|adm				|adm 					|Invalid username or password.|
	|http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/login			|admin			| 						|Invalid username or password.|
	|http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/login			|						|adm 					|Invalid username or password.|


Scenario Outline: AT02_Login to admin page with correct credentials
	When user click on the admin link
	Then user is on login page as "<admin_login_url>"
	And user enters the username as "<username>" 
	And user enter the password as "<password>" 
	And user clicks on the login button
	Then user is navigated to admin details page in url as "<destinationurl>"
	When user clicks on Logout button 
  Then user is navigated to home page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"
  
	
Examples:
	|admin_login_url 				        																					|username |password|destinationurl|
	|http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/login|admin		|admin	|http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book|