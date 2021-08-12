
Feature: Login to the application

@Launch3
Scenario: Testing the login functionality with the valid user credentials
	Given when the user is in the login page
	When the user enters the valid username "<username>" and password "<password>"
	Then the system allows the user to navigate to the HOME page
	
	Examples:
	|username 								 |password|
	|nikittapatil6841@gmail.com|nikita|