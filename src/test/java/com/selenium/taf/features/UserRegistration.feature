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
Feature: User Registration
I want to check that the user can register in our e-commerce website

  Scenario Outline: User Registration
  Given the user in the home page
  When I click on register link
  And I entred "<gender>" , "<firstName>" , "<lastName>" , "<email>" , "<password>"
  Then The registration page displayed successfully
  
  Examples:
  | gender | firstName | lastName | email | password |
  | female | salim     | nesmi    | nouxxx142@gmail.com | kkkkd12 |
  | female | salim     | nesmi    | noyyyxen7k2@gmail.com  | kkkkd12 |