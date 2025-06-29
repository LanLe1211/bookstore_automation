Feature: Checkout cart and check order details
Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"

Scenario Outline: AT14A+AT14B_Check out by user when there is one book in cart and check order details by admin
 When user clicks button Add To Cart the book having title as "<title>"
 Then user is directed to cartpage as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/cart"
 When user clicks button Checkout button 
 Then user is directed to checkout page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/checkout?"
 And book title is seen in checkout page as "<title>" and price as <price>
 And delivery cost is seen in checkout page as "6.00 $"
 And total cos is seen in checkout as "<cost>"
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
 
