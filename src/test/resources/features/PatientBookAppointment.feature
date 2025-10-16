Feature: Patient book appointment and cancel appointment

  @BookAppointment
  Scenario: Verify that the patient can successfully book an appointment
    Given I am on the home page
    When I navigate to the login page
    Then I should see the login page
    When I navigate to the login page as a patient
    Then I should see the patient login page
    When I login with valid credentials
      | EmailId  | surya@gmail.com |
      | Password | surya@123       |
    Then I should be navigated to the patient dashboard page
    When I navigate to the patient book appointment page
    Then I should be on the patient book appointment page
    When I enter the appointment details
      | Doctor Specialization | Orthopedics  |
      | Doctor Name           | Vipin Tayagi |
      | Date                  | 2025-10-15   |
      | Time                  | 1:15 PM      |
    Then I should see book appointment success message as Your appointment successfully booked
    When I navigate to the patient appointment history page
    Then I should see the patient appointment history page
    And I should see the appointment booked successfully

    @CancelAppointment
    Scenario: Verify that the patient can successfully cancel the appointment
      Given I am on the home page
      When I navigate to the login page
      Then I should see the login page
      When I navigate to the login page as a patient
      Then I should see the patient login page
      When I login with valid credentials
        | EmailId  | surya@gmail.com |
        | Password | surya@123       |
      Then I should be navigated to the patient dashboard page
      When I navigate to the patient appointment history page
      Then I should see the patient appointment history page
      When I cancel the patient appointment
      Then I should see the appointment cancel successfully


