Feature: Update patient profile details

  Scenario: Verify that the patient can successfully update their profile details
    Given I am on the home page
    When I navigate to the login page
    Then I should see the login page
    When I navigate to the login page as a patient
    Then I should see the patient login page
    When I login with valid credentials
      | EmailId  | surya@gmail.com |
      | Password | surya@123       |
    Then I should be navigated to the patient dashboard page
    When I navigate to patient profile page
    Then I should see the patient profile page
    When I update the patient profile details
    Then I should see success message as Your Profile updated Successfully
