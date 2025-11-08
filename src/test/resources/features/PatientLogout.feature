Feature: Patient logout functionality

  Scenario: Verify that the patient can successfully log out
    Given I am on the home page
    When I navigate to the login page
    Then I should see the login page
    When I navigate to the login page as a patient
    Then I should see the patient login page
    When I login with valid credentials
      | EmailId  | surya@gmail.com |
      | Password | surya@123       |
    Then I should be navigated to the patient dashboard page
    When I click on profile image
    And I click on logout button
    Then I should see logout successfully
    And I navigate to the home page