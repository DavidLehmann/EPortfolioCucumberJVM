@web
Feature: Login
	As a webapplication user
	In order to use the web application the user
	needs to log in
	
	If the user provides valid information he will be
	redirected to the application page. Otherwise
	an error message will be shown.
	
	Scenario: valid admin login
	Given User is on Login page
	When User provides username "Admin" and password "admin"
	Then User should be successfully logged in as Admin
	
	Scenario: valid user login
	Given User is on Login page
	When User provides username "User" and password "1234"
	Then User should be successfully logged in as User
	
	Scenario Outline: invalid logins
	Given User is on Login page
	When User provides username <username> and User provides password <password>
	Then User should not be logged in 
	And User should be shown an error message
	
	Examples:
		| username      | password |
		| tester		| test     |
		| Admin			| wrong    |
	