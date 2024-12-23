Feature: Search bookstore
	Background: 
  	Given User is on bookstore homepage "http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com"
	
	
	Scenario: Search for a book with keyword
		When I enter keyword as "<keyword>"
		Then I see search result contain "<title>"
		
		Examples:
		|keyword					|title		|											
		|Rings						|The Lord of the Rings|
		
