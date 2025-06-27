Feature: Add new book by admin_success case
Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"

Scenario Outline: Add new book successfully
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
  When user clicks on Logout button 
  Then user is navigated to home page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"

Examples:
  |bookname  |price|author  |isbn      |publisher    |date    |
  |Baby Shark|15   |PingFong|4289376859|HarperCollins|2021-08-08|  
  #|Atomic Habits|24|James Clear|0735211299|Avery    |2022-05-05| 
  
  
  
  