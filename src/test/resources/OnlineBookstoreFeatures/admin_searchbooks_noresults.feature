Feature: Search books by admin
  Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"
  
  Scenario Outline: AT04_Search for a book with keyword having no available result(s)
  When user click on the admin link
  Then user is on login page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/login"
  And user enters the username as "admin" 
  And user enter the password as "admin" 
  And user clicks on the login button
  Then user is navigated to admin details page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book"
  When user enters admin search keyword as "<keyword>"
  Then user is directed to admin search page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book/search"
  Then user sees error message "There are no books in stock"
  When user clicks on Logout button 
  Then user is navigated to home page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/" 
  
  
 Examples:
    |invalidkeyword  |
    |abcxyz          |
    |invalidkey      |
 
  