
@parameter
Feature: Parameter Feature
  
  
  #Background:
  #Given Open Facebook application

   @no_param
  Scenario: Scenario have no parameter
   
    When Input to Username application
    And Input to Password application
  	And Click to Submit button
  	
  	
  @param_mark
  Scenario: Scenario have no parameter
   
    When Input to Username textbox with "autoamtiontest@gmail.com"
    And Input to Password textbox with "123456"
  	And Click to Submit button
  
  	
  	
  @multiple_param
  Scenario: Scenario have no parameter
    
    When Input to Username textbox with "autoamtiontest@gmail.com" and Password with "123456"
  	And Click to Submit button
  