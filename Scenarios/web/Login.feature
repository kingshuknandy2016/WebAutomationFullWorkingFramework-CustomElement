Feature: www.williams-sonoma.com basic flow

Scenario: Basic End To End Flow
	Given Launch Application and Navigate to sign-In page
	When User enters "kingshuknandy1990@gmail.com" and "9007438097kingshuk" and clicks on signIn
	And User selects Tea Kettle from CookWare
	And User selects Kettle "Breville Variable-Temperature Tea & Coffee Kettle"
	And User add the items to cart
	And User clicks on check out
	Then User clicks on save for later and verify the item is saved
