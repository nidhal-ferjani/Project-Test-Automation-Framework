#Author: nidhal.ferjani@gmail.com
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

  Feature: Automed End2End Tests
    Description: The prupose of this feature is to test End 2 End integration.
    I want to use this template for my feature file

 
  Scenario Outline: Customer place an order by purchasing an item from search
    Given User is on Home page
    When He search for "<ProductName>"
    And  Choose to buy two items
    And  Moves to checkout cart and enter personal details on checkout page and place the order
    Then He can view the order and download the novice

  
   Examples: 
      | ProductName |
      | Apple MacBook Pro 13-inch |
     
