Feature: Login into admin page
Scenario Outline: Login to admin with credentials
	Given user navigates to "<url>" 
	When user clicks on the login portal button
	And user enters the "<username>" username
	And user enter the "<password>" password
	When user clicks on the login button
	Then the user should be presented with the following prompt alert "<message>"
	
	Examples:
	| url 				        							|username 	|password			|message		 |
	|http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com/|adm				|adm 					|Invalid username or password.|
	|http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com/|admin	|admin	| validation succeeded     
	|http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com/|admin				| 					|Invalid username or password.|
	|http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com/|				|adm 					|Invalid username or password.|

