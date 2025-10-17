Feature: Add Patient Functionality

  Scenario: Verify that the doctor can add patient successfully
    Given I am on the home page
    When I navigate to the login page
    Then I should see the login page
    When I navigate to the login page as a doctor
    Then I should see the doctor login page
    When I login with doctor valid credentials
      | EmailId  | kumar@gmail.com |
      | Password | kumar@123       |
    Then I should be navigated to the doctor dashboard page
    When I navigate to the add patient page
    Then I should see the add patient page
    When I enter the following add patient details
    Then

