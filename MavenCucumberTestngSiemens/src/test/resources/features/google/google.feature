Feature: Google Search

	Background: To Launch the browser
		Given Launch the browser
	
	Scenario: Search for Cucumber in Google
		When Hit Google on the browser
		Then Enter "Cucumber" in the search box
		And Search it
		
		
