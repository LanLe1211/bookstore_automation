Feature: Add new book by admin_failure case
Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"
  
Scenario Outline: AT06_Add new book with failure
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
  And error message is seen as "<addbookerrormsg>" in element with html id "<addbookerrormsgid>"
  When user click on the admin link
  Then user is navigated to admin details page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book"
  When user clicks on Logout button 
  Then user is navigated to home page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"
  
  Examples:
|bookname        |price|author       |isbn      |publisher|date    |addbookerrormsg                |addbookerrormsgid| 
|                |28   |Kevin Horsley|1631611356|TCK      |2021-08-24|Name cannot be empty.          |bookname_error   |
|Unlimited Memory|     |Kevin Horsley|1631611356|TCK      |2021-08-24|Price cannot be empty.         | bookprice_error |      
|Unlimited Memory|28   |             |1631611356|TCK      |2021-08-24|Authors cannot be empty.       | bookauthor_error | 
|Unlimited Memory|28   |Kevin Horsley|123       |TCK      |2021-08-24|ISBN can have 10 or 13 digits. |bookisbn_error        |
|Unlimited Memory|28   |Kevin Horsley|123       |         |2021-08-24|Publisher cannot be empty.     |bookpublisher_error   |
|Unlimited Memory|28   |Kevin Horsley|123       |TCK      |        |Date cannot be empty.          |bookPublishedOn_error |
                          
  
  
  
  