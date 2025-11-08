Feature: Cancel patient appointment

  @CancelPatientAppointment
  Scenario: Verify that the doctor can successfully cancel a patient appointment
    Given I am on the home page
    When I navigate to the login page
    Then I should see the login page
    When I navigate to the login page as a doctor
    Then I should see the doctor login page
    When I login with doctor valid credentials
      | EmailId  | kumar@gmail.com |
      | Password | kumar@123       |
    Then I should be navigated to the doctor dashboard page
    When I navigate to the doctor appointment history page
    Then I should see the doctor appointment history page
    When I cancel the appointment
    Then I should see the patient appointment cancel successfully