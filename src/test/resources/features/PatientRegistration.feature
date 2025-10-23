Feature: Patient Registration functionality

  @PatientRegistration
  Scenario: Verify that a patient can successfully register
    Given I am on the home page
    When I navigate to the login page
    Then I should see the login page
    When I navigate to the login page as a patient
    Then I should see the patient login page
    When I navigate to the patient registration page
    Then I should see the patient registration page
    When I enter the following patient details
      | Full Name        | M Ram${random}         |
      | Address          | Hanuman Nagar          |
      | City             | Hyderabad              |
      | Email            | ram${random}@gmail.com |
      | Password         | ram@123                |
      | Confirm Password | ram@123                |
    Then I should see a success message as Successfully Registered. You can login now
    When I login with email and password
    Then I should be navigated to the patient dashboard page



