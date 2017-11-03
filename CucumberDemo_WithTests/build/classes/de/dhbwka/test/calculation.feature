Feature: Celcius to Fahrenheit Calculation
	As logged in webapplication user
	The logged in user can perform a give a celcius value that
	will be converted to the corresponding fahrenheit value
	If the user wants to quit the application a logout can be
	performed
	
	Scenario Outline: Fahrenheit calculations
	Given User is logged in as <userLevel>
	When User provides celcius value <celcius>
	Then the shown Fahrenheit value should be <fahrenheit>
	
	Examples:
		| userLevel      | celcius  | fahrenheit |
		|  Administrator |   20     |     68     |
		|  Administrator |   45     |     113    |
		|  User          |   20     |     68     |

	Scenario: User logout
	Given User is logged in
	When User selects Logout
	Then User should be redirected to login page 
	