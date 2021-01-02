Feature: Application Login with multiple users

Scenario Outline: Home page login
Given Initialize the Driver  
When User invokes home page URL
Then User clicks on login button 
And User proivdes two incorrect <username> and <password> and click on forgot password

Examples:
|username		|password	|
|abc@gmail.com	|123456		|	
|def@gmail.com	|12345		|


