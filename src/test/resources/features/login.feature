@login
Feature: Login Functionality

Scenario Outline: Validate login scenarios

Given  User is on login page
When user enters username "<Username>" and password "<Password>" and click on login button
Then login result should be "<ExpectedResultType>"
And error message should be "<ExpectedErrorMessage>"

Examples:
	  | TC_ID         | Username         | Password       | ExpectedResultType | ExpectedErrorMessage                                                                |
      | TC_LOGIN_001  | standard_user    | secret_sauce   | SUCCESS            |                                                                                     |
      | TC_LOGIN_002  | invalid_user     | secret_sauce   | ERROR              | Epic sadface: Username and password do not match any user in this service           |
      | TC_LOGIN_003  | standard_user    | wrong_pass     | ERROR              | Epic sadface: Username and password do not match any user in this service           |
      | TC_LOGIN_004  | invalid_user     | wrong_pass     | ERROR              | Epic sadface: Username and password do not match any user in this service           |
      | TC_LOGIN_005  |                  | secret_sauce   | ERROR              | Epic sadface: Username is required                                                  |
      | TC_LOGIN_006  | standard_user    |                | ERROR              | Epic sadface: Password is required                                                  |
      | TC_LOGIN_007  |                  |                | ERROR              | Epic sadface: Username is required                                                  |
      | TC_LOGIN_008  | locked_out_user  | secret_sauce   | ERROR              | Epic sadface: Sorry, this user has been locked out.                                 |
