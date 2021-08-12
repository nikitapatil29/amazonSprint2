
Feature: Login to the application

@Launch4
Scenario: Testing the login functionality with the invalid user credentials
	Given when the user on the login page
	When the user enters the valid username and invalid password "<sheetname>",<rownumber>
	Then the system gives error message
	
	Examples:
	|sheetname		| rownumber|
	|Sheet1				|0|