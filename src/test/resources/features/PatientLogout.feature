Feature: Patient logout functionality

  Background:
    Given The user is on "Patient login page"

  @PatientLogout
  Scenario: Verify that the patient can successfully log out
    When I login with valid credentials
      | EmailId  | surya@gmail.com |
      | Password | surya@123       |
    Then I should be navigated to the patient dashboard page
    When I click on profile image
    And I click on logout button
    Then I should see logout successfully
    And I navigate to the home page