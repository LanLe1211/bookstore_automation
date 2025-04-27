Feature: Home Page UI verification
Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com"
  	
Scenario: Validate home page text
	
  	Then homepage title is "<title>"
  	
  	Examples:
		|title					|
		|Online Books 		|											
		
