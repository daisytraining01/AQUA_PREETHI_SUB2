Feature: Test for TechFish Bank


Background:
Given I have url
When I enter the login credentails

@tag1
Scenario:  Fund Transfer between Accounts
When Click the transfer tab and select accounts
And Fill fund transfer details and submit
And Able to see the amount changes in accounts
Then signout from application

@tag2
Scenario: Add Receiptent
When Click the transfer tab and select Add Receipts
And Fill the details of Receipt and click on Add Receipt
And Able to see the successfull List of Receipts
Then signout from application



