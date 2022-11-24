
@datatable
Feature: DataTable Feature
  
  #Background:
  #Given Open Facebook application
  	
  @datatable_step
  Scenario Outline: Create new Customer with email <Username>
   
    When Input to Username and Password
    | Username   | Password   |
    | <Username> | <Password> |

  	And Click to Submit button
  	
  	
  	Examples:
  	| Username                 | Password | 
   
  	
  	
  @datatable_scenario
  Scenario Outline: Data Table in scenatio
  	
  	When Input to Username textbox with "<Username>"
    And Input to Password textbox with "<Password>"
  	And Click to Submit button
  	
  	
  		Examples:
  	| Username               | Password | 
    | automationfc@gmail.com | 123456   |
