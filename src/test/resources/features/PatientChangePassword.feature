Feature: Patient change password

  @PatientChangePassword
  Scenario: Verify that the patient can successfully change their password
    Given I am on the home page
    When I navigate to the login page
    Then I should see the login page
    When I navigate to the login page as a patient
    Then I should see the patient login page
    When I login with valid credentials
      | EmailId  | ramu@gmail.com |
      | Password | ramu@12        |
    Then I should be navigated to the patient dashboard page
    When I navigate to patient change password page
    Then I should see the patient change password page
    When I enter the following patient change password details
      | Current Password | ramu@12 |
      | New Password     | ramu@1  |
      | Confirm Password | ramu@1  |
    Then I should see change password success message as Password Changed Successfully !!
