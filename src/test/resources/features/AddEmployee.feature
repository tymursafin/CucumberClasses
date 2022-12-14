Feature: Add Employee

  Background:
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    And user clicks on Add Employee button

  @sprint3 @regression @test1
  Scenario: Adding one employee
    #Given user is navigated to HRMS application
    And user enter firstname and lastname
    And user clicks on save button
    Then employee added successfully

  @sprint3 @regression @test2
  Scenario: Adding one employee
    #Given user is navigated to HRMS application
    And user enter "Nesrin" and "Nergis"
    And user clicks on save button
    Then employee added successfully

    # Scenario Outline will execute code as many times as many lines of data we have (3 times here)
    @outline @regression @test3
    Scenario Outline: Adding multiple employees using feature file
      And user enters "<firstName>" and "<lastName>" for adding multiple employees
      And user clicks on save button
      Then employee added successfully
      Examples:
        | firstName | lastName  |
        | Mulikanu  | Nuzharu   |
        | Likeerua  | Zanurtash |
        | Moonkhan  | Marsee    |

  @datatable
  Scenario: Adding multiple employees using data table
    When user adds multiple employees and verify they are added successfully
      | firstName  | middleName |  lastName   |
      | zarabut    | MS         |  camiluslah |
      | birgules   | MS         |  ozginar    |
      | alinakot   | MS         |  bobus      |


  @excel
  Scenario: Adding multiple employees using excel file
    When user adds multiple employee from excel using "EmployeeData" and verify it