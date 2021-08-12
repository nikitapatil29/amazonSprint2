Feature: Proceed to buy
@Launch6

Scenario: Placing order with address information and payment options
	Given when the user enter valid credentials "<username>","<password>" is on the users home page 
 		When The users proceeds to buy from the cart 
			And User select and confirms the delivery address
			And User verify payment options 
			Then User select one payment options 
			Then Verify  place order page
			
			
	Examples:
	|username 								 |password|
	|nikittapatil6841@gmail.com|nikita|