Feature: Add to and Remove from cart
Background: 
    Given User is on bookstore homepage "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/"
  	
 Scenario Outline: AT12A+AT12B_Add and delete 1 book from cart
 When user enters keyword as "<keyword>"
 Then user is directed to search page as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/search"
 Then user sees search result contain "<searchresult>"
 When user clicks button Add To Cart the book having title as "<booktitle>"
 Then user is directed to cartpage as "http://bookstore-uat-env.eba-26p4nuxx.us-east-2.elasticbeanstalk.com/cart"
 And book title is seen in cart page as "<booktitle>"
 When user clicks remove button of the book with title as "<booktitle>"
 Then user sees success message as "Your basket is currently empty."
 Examples:     
  |keyword|searchresult|booktitle    |
  |The|The Lord of the Rings,The Da Vinci Code,The Hunger Games,The Last Olympian|The Last Olympian|
  |Pi|Life of Pi|Life of Pi|
 

  	
 Scenario Outline: AT13A+AT13B_Add more than 1 book and delete all book from cart
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
 And book title is seen in cart page as "<booktitle2>"
 When user clicks delete all button
 Then user sees success message as "Your basket is currently empty."
 
   Examples:     
  |booktitle1 |booktitle2|
  |Twilight   |Hannibal             |
  |The Hunger Games  |Fifty Shades of Grey |
 

    
    
	
	
