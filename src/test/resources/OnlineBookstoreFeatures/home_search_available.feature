Feature: Search books with available results
  Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com"
  
  Scenario: Search for a book with keyword
    When user enters keyword as "<keyword>"
    Then user is directed to search page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/search"
    Then user sees the number of results as <result_count>
    Then user sees search result contain "<title>"
    
    Examples:
    |keyword          |result_count|title    |                     
    |The              |4          |The Lord of the Rings,The Da Vinci Code,The Hunger Games,The Last Olympian|
    |Harry            |1           |Harry Potter and the Half-Blood Prince|