Feature: US-321 Searching the employee

  @sprint4 @test1
  Scenario: Search employee by ID
    Given user is navigated to HRMS application
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    And user clicks on Employee List option
    When user enters valid employee ID
    And user clicks on search button
    Then user see employee information is displayed

    @sprint4 @test2
    Scenario: Search employee by Name
      Given user is navigated to HRMS application
      When user enters username and password
      And user clicks on login button
      Then user is successfully logged in
      When user clicks on PIM option
      And user clicks on Employee List option
      When user enters valid employee name
      And user clicks on search button
      Then user see employee information is displayed