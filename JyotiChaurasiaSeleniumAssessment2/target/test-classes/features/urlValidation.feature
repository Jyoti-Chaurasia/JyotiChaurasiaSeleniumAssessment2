@URLValidate
Feature: Validating Links
  Scenario: We are extracting Links and validate the status
    Given URL current page
    Then extracting urls
    Then Validating Link