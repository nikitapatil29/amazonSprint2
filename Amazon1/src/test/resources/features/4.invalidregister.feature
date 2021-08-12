
Feature: User registering
@Launch5

Scenario: New user invalid registration
Given when the the user is in the registration page
When the user enters in the Your name field "<name>"
And the user enters in the  Mobile number field"<mobile>"
And the user enters in the  Email field "<email>"
And the user enters in the  Password field "password"
Then the System gives error message as expected "msg"

Examples:
	|name 			 |mobile	 |email					|password	|msg								|
	|Nikita Patil|123456789|abc@gmail.com |nikita		|There was a problem|