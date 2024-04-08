
Feature: Property Insurance 

  @smoke
  Scenario: Verify that property insurance button is present and working
    Given user is on login page
    When user clicks on insurance button
    Then user is navigated to "PROPERTY DETAILS"
  
  