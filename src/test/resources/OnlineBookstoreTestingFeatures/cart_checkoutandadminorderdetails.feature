Feature: Checkout cart and check order details
Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"

Scenario Outline: AT14A+AT14B_Check out by user when there is one book in cart and check order details by admin
 When user enters keyword as "<title>"
 Then user is directed to search page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/search"
 Then user sees search result contain "<title>"
 When user clicks button Add To Cart the book having title as "<title>"
 Then user is directed to cartpage as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/cart"
 When user clicks button Checkout button 
 Then user is directed to checkout page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/checkout?"
 And book title is seen in checkout page as "<title>" and price as <price>
 And delivery cost is seen in checkout page as "6.00 $"
 And total cost is seen in checkout as "<cost>"
 When user enters name as "<name>" surname as "<sur>" country region as "<country>" street as "<street>" city as "<city>" postal code as "<postal>" phone as "<phone>" email as "<email>"
 And user clicks on Place Order button
 Then user is directed to cartpage as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/cart"
 Then the checkout message displays as "The order is confirmed, check your email."
 When user click on the admin link
 Then user is on login page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/login"
 When admin logs in with username as "admin" and password as "admin"
 Then user is navigated to admin details page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book"
 
 When user clicks on button Orders
 Then user is navigated to orders details page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/orders"
 And user clicks on the most recent orderID
 Then user is directed to order details page "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/orders/"
 Then user see details name as "<name>" surname as "<sur>" country region as "<country>" street as "<street>" city as "<city>" postal code as "<postal>" phone as "<phone>" email as "<email>"
 And user see details title as "<title>" and price as <price>
 When user clicks OrdersDirectory button
 Then user is directed to order details page "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/orders"
 When user clicks AdminDirectory button
 Then user is navigated to admin details page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book"
 When user clicks on Logout button 
 Then user is navigated to home page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"
 
 
 Examples:     
|title   |price|cost |name|sur|country|street          |city     |postal|phone     |email         |
|Hannibal|66.60|72.60 $|Lan |Le |US     |32 Bentley Chase|Buford   |30519 |4255227287|lan@gmail.com |
|Twilight|38.00|44.00 $|Lily |Nguyen |Canada     |118 Gravel Ridge Trail|Kitchener   |N2J0E8 |2267528282|lily@gmail.com |


Scenario Outline: AT14C+AT14D_Check out by user when there is two book in cart and check order details by admin
 When user enters keyword as "<booktitle1>"
 Then user is directed to search page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/search"
 Then user sees search result contain "<booktitle1>"
 When user clicks button Add To Cart the book having title as "<booktitle1>"
 Then user is directed to cartpage as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/cart"
 And book title is seen in cart page as "<booktitle1>"
 When user clicks Online Book Store textbutton
 Then user is directed back to homepage as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"
 When user enters keyword as "<booktitle2>"
 Then user is directed to search page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/search"
 Then user sees search result contain "<booktitle2>"
 When user clicks button Add To Cart the book having title as "<booktitle2>"
 Then user is directed to cartpage as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/cart"
 When user clicks button Checkout button 
 Then user is directed to checkout page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/checkout?"
 And book title is seen in checkout page as "<booktitle1>" and price as <price1>
 And book title is seen in checkout page as "<booktitle2>" and price as <price2>
 And delivery cost is seen in checkout page as "6.00 $"
 And total cost is seen in checkout as "<cost>"
 When user enters name as "<name>" surname as "<sur>" country region as "<country>" street as "<street>" city as "<city>" postal code as "<postal>" phone as "<phone>" email as "<email>"
 And user clicks on Place Order button
 Then user is directed to cartpage as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/cart"
 Then the checkout message displays as "The order is confirmed, check your email."
 When user click on the admin link
 Then user is on login page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/login"
 When admin logs in with username as "admin" and password as "admin"
 Then user is navigated to admin details page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book"
 
 When user clicks on button Orders
 Then user is navigated to orders details page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/orders"
 And user clicks on the most recent orderID
 Then user is directed to order details page "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/orders/"
 Then user see details name as "<name>" surname as "<sur>" country region as "<country>" street as "<street>" city as "<city>" postal code as "<postal>" phone as "<phone>" email as "<email>"
 And user see details title as "<booktitle1>" and price as <price1>
 And user see details title as "<booktitle2>" and price as <price2>
 When user clicks OrdersDirectory button
 Then user is directed to order details page "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/orders"
 When user clicks AdminDirectory button
 Then user is navigated to admin details page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/book"
 When user clicks on Logout button 
 Then user is navigated to home page in url as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"
 
 
 Examples:     
|booktitle1   |price1 |booktitle2   |price2 |cost   |name|sur|country|street          |city     |postal|phone     |email         |
|Hannibal     |66.60  |Life of Pi   |26.95  |99.55 $|Nga |Vu |US     |54 Lawrenville  |Duluth   |31456 |4255227287|nga@gmail.com |
 
