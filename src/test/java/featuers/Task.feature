#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: SeamLabs Task	
  I want to check the total price is equal to the item price that added to my cart

  Scenario Outline: User navigate to the Outdoors page
    Given The user in the home page
    When I hover to Furniture Menu
    And I hover and clicks on Outdoors sub menu
    And I adds the second item to my cart
    And I clicks on checkout
    Then validate the total price is equal to the item price
 

    Examples: 
      | menuItem  | subMenuItem |
      |	Furniture |	Outdoors	  |	
     
