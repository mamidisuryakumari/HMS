Feature: Add Patient Functionality

  @AddPatient
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
      | Patient Name       | M Sita${random}         |
      | Patient Contact no | 995864512               |
      | Patient Email      | sita${random}@gmail.com |
      | Patient Address    | Gudiwada                |
      | Patient Age        | 30                      |
      | Medical History    | Health checkup          |
    Then I should see add patient success message as Patient info added Successfully
    And I should be navigated to the doctor manage patient page




