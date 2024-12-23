@Login 
Feature: Log out of Online Book Store
	As an admin
	I want to log out of Online Book Store web app 
	
	Background: User logged in with valid credentials 
	Given I am on the login page URL login "http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com/login"
	Then I see Login page logout
	When I enter username as logout "admin"
	When I enter password as logout "admin"
	When I click Login button as logout
	Then I see page as logout
		
	
	Scenario: User is currently logged in 
		When I click logout button 
		Then I stay at home page "http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com/"
		
	
		
