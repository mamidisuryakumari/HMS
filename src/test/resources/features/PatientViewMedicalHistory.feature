Feature: Patient view medical history

  @PatientMedicalHistory
  Scenario: Verify that the patient can view their medical history
    Given I am on the home page
    When I navigate to the login page
    Then I should see the login page
    When I navigate to the login page as a patient
    Then I should see the patient login page
    When I login with valid credentials
      | EmailId  | surya@gmail.com |
      | Password | surya@123       |
    Then I should be navigated to the patient dashboard page
    When I navigate to patient medical history page
    Then I should see the patient medical history page
    When I click on view details button
    Then I should see the patient medical history details
