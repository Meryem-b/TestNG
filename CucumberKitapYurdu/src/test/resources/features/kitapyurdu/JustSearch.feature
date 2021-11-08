Feature: Successful Login Test

	Background: Click Search Box
		Given Click Search Box
		
	Scenario: Kitap Yurdu Finding The Product
		When Enter the search true word
		And Click the search button
		Then Happen Show Product
		
	Scenario Outline: Kitap Yurdu Don't Finding The Product
		When Enter the search false word
		And Click the search button
		Then Don't Happen Show Product
