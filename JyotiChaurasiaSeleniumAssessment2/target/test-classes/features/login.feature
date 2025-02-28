@LoginValidation
Feature: Login validation
  Scenario: Login with username and password and validate it
    Given Login WebPage
    Then I test Valid Login
    And I test Invalid Login

