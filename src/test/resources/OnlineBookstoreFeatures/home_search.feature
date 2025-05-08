Feature: Search bookstore
  Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com"
  
  Scenario Outline: Search for a book with keyword with no available result(s)
  
  
  
  Scenario Outline: Search for a book with keyword with available result(s)
    When I enter keyword as "<keyword>"
    Then I see the number of results as <resultcount>
    Then I see search result contain "<title>"
    
    Examples:
    |keyword          |resultcount|title    						|                   
    |Rings            |1					|The Lord of the Rings|
    |The							|4					|The Lord of the Rings,The Da Vinci Code,The Hunger Games,The Last Olympian|
    |Harry Potter     |1					|Harry Potter and the Half-Blood Prince|
    |the 							|2					|The Lord of the Rings,Harry Potter and the Half-Blood Prince|
