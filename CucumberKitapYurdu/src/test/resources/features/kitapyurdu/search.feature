Feature: Search Feature
To enter in the System
User must be able to
Access software when login is successful

	Background: To Launch the browser
		Given Launch the browser
	
	Scenario: Search for Cucumber in Kitapyurdu
		Given Found pages
		When  Click the book
		Then  Navigate back
		When  Rate star
		Then  Cart button
		When Buy
		And Log out
		
