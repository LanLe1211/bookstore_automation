Feature: Delete book details by admin
Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"

Scenario Outline: Delete book
  When user click on the admin link
  Then user is on login page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/login"
  And user enters the username as "admin" 
  And user enter the password as "admin" 
  And user clicks on the login button
  Then user is navigated to admin details page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book"
  When user clicks on button New book 
  Then user is navigated to books form page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book/add"
  When user enters book name as "<bookname>" price as "<price>" author as "<author>" ISBN as "<isbn>" publisher as "<publisher>" date as "<date>"
  And user tap on Add Book Save button
  Then user is navigated to admin details page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book"
  And a new row is seen with details book name as "<bookname>" price as "<price>" author as "<author>" ISBN as "<isbn>" publisher as "<publisher>" date as "<date>"
  Then user clicks on delete book button of the book "<bookname>"
  Then success message is displayed as "Deleted book successfully!"
  Then there is no books with details book name as "<bookname>"
  When user clicks on Logout button 
  Then user is navigated to home page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"
  

Examples:
  |bookname           |price|author     |isbn      |publisher    |date      |
  |Test Delete Book 1 |15   |Lan Le     |4289376859|TLL          |2025-09-19|  
  |Test Delete Book 2 |20   |Leo Nguyen |4728495038|LN           |2024-08-13|