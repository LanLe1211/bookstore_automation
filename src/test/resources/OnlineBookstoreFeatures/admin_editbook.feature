Feature: Edit book details by admin
Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"

Scenario Outline: Edit book details by admin
When user click on the admin link
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
 
  Then user clicks on edit book button of the book "<bookname>"
  Then user is navigated to edit book url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book/edit/"
  When user enters book name as "<booknameedit>" price as "<priceedit>" author as "<authoredit>" ISBN as "<isbnedit>" publisher as "<publisheredit>" date as "<dateedit>"
  And user tap on Add Book Save button
  Then user is navigated to admin details page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book"
  
  And a new row is seen with details book name as "<booknameedit>" price as "<priceedit>" author as "<authoredit>" ISBN as "<isbnedit>" publisher as "<publisheredit>" date as "<dateedit>" 
  Then user clicks on delete book button of the book "<booknameedit>"
  When user clicks on Logout button 
  Then user is navigated to home page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/" 

Examples:
  |bookname|price|author    |isbn      |publisher|date      |booknameedit|priceedit|authoredit|isbnedit  |publisheredit|dateedit  |
  |Book 1  |15   |Lan Le    |4289376859|TLL      |2025-07-28|Book 1 edit |25       |Lily Ng   |1234567892|LLN          |2022-07-07|
  |Book 2  |20   |Leo Nguyen|4728495038|LN       |2025-08-13|Book 2 edit |30       |Quang Ng  |2465939375|QNM          |1992-08-19 | 