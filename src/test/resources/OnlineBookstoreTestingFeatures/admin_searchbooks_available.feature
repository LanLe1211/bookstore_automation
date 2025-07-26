Feature: Search books by admin
  Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"
  
  Scenario Outline: AT03_Search for a book with keyword having available result(s)
  When user click on the admin link
  Then user is on login page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/login"
  And user enters the username as "admin" 
  And user enter the password as "admin" 
  And user clicks on the login button
  Then user is navigated to admin details page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book"
  When user enters admin search keyword as "<keyword>"
  Then user is directed to admin search page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book/search"
  Then user enters the admin search number of results as <resultcount>
  Then user sees admin search result contain "<title>"
  When user clicks on Logout button 
  Then user is navigated to home page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/" 
    
    Examples:
    |keyword          |resultcount|title    						|                   
    |Rings            |1					|The Lord of the Rings|
    |The							|4					|The Lord of the Rings,The Da Vinci Code,The Hunger Games,The Last Olympian|
    |Harry            |1					|Harry Potter and the Half-Blood Prince|
    |the 							|2					|The Lord of the Rings,Harry Potter and the Half-Blood Prince|
