Feature: Verify admin details page (book list)

Scenario: 
	Given I log in to admin page successfully
	Then I verify the HTML table contains following values
	
	|The Lord of the Rings	|J. R. R. Tolkien|Allen & Unwin	|1954-07-29|9780261103207|99.99|
	Harry Potter and the Half-Blood Prince	|J. K. Rowling|Bloomsbury Publishing (UK)|2005-07-16|9780439784542|55.00|
	The Da Vinci Code|Dan BrownDoubleday|2003-04-02|0385504209|250.89|
	Fifty Shades of Grey|E. L. James|Vintage Books|2012-04-17|9781612130286|26.95|
	Twilight|Stephenie Meyer|Little, Brown and Company|2005-10-050316160172|38.00|
	