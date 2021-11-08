Feature: Successful Login Test

	Background: Click Giris Yap Button
		Given Click Giris Yap Button
		
	Scenario: Kitap Yurdu Successful Login Test
		When Hit the email box and Write true email address in the email box
		And Hit the password box and Write true password in the password box
		And Click login button
		Then Happen Successful Login
		
	Scenario Outline: Kitap Yurdu Unsuccessful Login Test
		When Hit the email box and Write false <emailaddress> in the email box
		And Hit the password box and Write false <password> in the password box
		And Click login button
		Then Happen UnSuccessful Login
		
	Examples:
	| emailaddress | password |
	| mekrmmf@gmail.com | kdomklm |
	| msemaa1@hotmail.com | Meryem12345 |