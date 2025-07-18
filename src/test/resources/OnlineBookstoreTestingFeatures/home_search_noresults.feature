Feature: Search books title with no results 
  Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"
  
  Scenario Outline: AT11_Search for a book with keyword having no available result(s)
   When user enters keyword as "<invalidkeyword>"
   Then user is directed to search page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/search"
   Then user sees error message "There are no books in stock"
   
 Examples:
    |invalidkeyword  |
    |abcxyz          |
    |invalidkey      |
 