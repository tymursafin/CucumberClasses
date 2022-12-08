Feature: Login functionality
  @sprint1 @regression @tc1101
  Scenario: Valid admin login
    Given user is navigated to HRMS application
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in

    @regression @tc1102
    Scenario: Valid ess login
      Given user is navigated to HRMS application
      When user enters ess username and ess password
      And user clicks on login button
      Then user is successfully logged in

      @regression @tc1103
      Scenario: Invalid Admin login
        Given user is navigated to HRMS application
        When user enters invalid username and password
        And user clicks on login button
        Then error message displayed

