
Feature: Login to the application

@Launch4
Scenario: Testing the login functionality with the invalid user credentials
	Given when the user on the login page
	When the user enters the valid username "<username>" and invalid password "<password>"
	Then the system gives error message
	
	Examples:
	|username 								 |password|
	|nikittapatil6841@gmail.com|111111|