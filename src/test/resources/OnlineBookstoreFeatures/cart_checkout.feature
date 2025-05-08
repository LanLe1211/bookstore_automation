Feature: 
Background: 
  	Given User is on cart page
  	
  	Scenario Outline:	no books in cart
  	Given there is no books in cart
  	When user clicks checkout button
  	Then user sees alert message as "cartemptyalert>"
  	Examples:
	|cartemptyalert 				       	|
	|Your basket is currently empty.|
	
	
		Scenario Outline:	there are products in cart 
		Given there are books in cart
  	When user clicks checkout button
  	Then user is navigated to billing details page