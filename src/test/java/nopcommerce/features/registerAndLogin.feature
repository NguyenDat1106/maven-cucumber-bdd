
@parameter
Feature: Register/ Login and new Menu


  @register_login 
  Scenario: Register to system and login
    Given Click Register link
    And Submit value infor to register form
    And Click to Register button
    Then Click to Logout
    Given Click to Logout link
    When Intput to Email and Password testbox
    Then Click to Login button
    When Home page displayed
    
   @home_menu
      Scenario: Home page new Menu 
      Given Open "Computers" to Menu home pag
      And Open "Electronics" to Menu home pag
      And Open "Apparel" to Menu home pag
      And Open "Digital downloads" to Menu home pag
      And Open "Books" to Menu home pag
      And Open "Jewelry" to Menu home pag
      And Open "Gift Cards" to Menu home pag

