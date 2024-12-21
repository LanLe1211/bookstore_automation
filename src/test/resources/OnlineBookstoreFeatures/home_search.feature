Feature: Search bookstore
	Background: 
  	Given User is on bookstore homepage "http://localhost:8080"
	
	
	Scenario: Search for a book with keyword
		When I enter keyword as "<keyword>"
		Then I see search result contain "<title>
		
		Examples:
		|keyword					|title		|											
		|Rings						|abcd			|
		
