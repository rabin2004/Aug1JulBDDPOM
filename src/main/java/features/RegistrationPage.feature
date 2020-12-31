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

Feature: Registration functionality
  New user should be able to register to the application

  Scenario Outline: Postive registration functionality test of new user with valid credentials
    Given user is already in registration page
    When user provide "<username>", "<password>" and "<confirmPassword>"
    And user clicks submit
    Then user should be registered and should see confirmation of "<username>"
    
    Examples:
    	|username|password|confirmPassword|
    	|Tom|tom123|tom123|
    #	|Harry|harry123|harry123|
    #	|John|john123|john123|
    	
   Scenario Outline: Negative registration functionality test of registered user with valid credentials 	
			Given user is already in registration page
			When registered user provides "<username>", "<password>" and "<confirmPassword>"
			And user clicks submit
			Then user should not be allowed to register and should see error message as registered already
      
      Examples:
    	|username|password|confirmPassword|
    	|Tom|tom123|tom123|
    #	|Harry|harry123|harry123|
    #	|John|john123|john123|
