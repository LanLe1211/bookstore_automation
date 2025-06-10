Feature: Add to Cart
Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com"
  	
 Scenario Outline: Add more than 1 book
 When user clicks button Add To Cart the book having title as "<booktitlehomepage>"
 Then user is directed to cartpage as "<cartpageurl>"
 And book title is seen in cart page as "<booktitlecartpage>"
 When user clicks remove button of the book with title as "<booktitlecartpage>"
 Then user sees success message as "Your basket is currently empty."
 Examples:     
  |booktitlehomepage      |cartpageurl                                                                    |booktitlecartpage|
  |The Lord of the Rings  |http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com/cart      |The Lord of the Rings|
  |The Da Vinci Code      |http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com/cart      |The Da Vinci Code|
 

  	
 Scenario Outline: Add more than 1 book
 When user clicks button Add To Cart the book having title as "<booktitle1homepage>"
 Then user is directed to cartpage as "<cartpageurl>"
 And book title is seen in cart page as "<booktitle1cartpage>"
 When user clicks Online Book Store textbutton
 Then user is directed back to homepage as "<homepageurl>"
 When user clicks button Add To Cart the book having title title as "<booktitle2homepage>"
 Then user is directed to cartpage as "<cartpageurl>"
 And book title is seen in cart page as "<booktitle2cartpage>"
 
   Examples:     
  |booktitle1homepage |cartpageurl                                           |booktitle1cartpage|booktitle2homepage|booktitle2cartpage|
  |Twilight |http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com/cart |Twilight|Hannibal|Hannibal|
  |The Da Vinci Code |http://bookstore-uat-env.eba-jmtjiqks.us-east-2.elasticbeanstalk.com/cart |The Da Vinci Code|Fifty Shades of Grey|Fifty Shades of Grey|
 

  	
  	
	
	
