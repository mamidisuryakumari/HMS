Feature: Add doctor functionality

  @AddDoctor
  Scenario: Verify that the admin can successfully add a new doctor
    Given I am on the home page
    When I navigate to the login page
    Then I should see the login page
    When I navigate to the login page as a admin
    Then I should see the admin login page
    When I login with admin valid credentials
      | UserName | admin      |
      | Password | Test@12345 |
    Then I should be navigated to the admin dashboard page
    When I navigate to the admin add doctor page
    Then I should see the admin add doctor page
    When I enter the following doctor details
      | Doctor Specialization   | Dermatology              |
      | Doctor Name             | M Kumar${random}         |
      | Doctor Clinic Address   | Near manikonda,Hyderabad |
      | Doctor Consultancy Fees | 300                      |
      | Doctor Contact no       | 9963512385               |
      | Doctor Email            | kumar${random}@gmail.com |
      | Password                | kumar@123                |
      | Confirm Password        | kumar@123                |
    Then I should see a doctor add success message as Doctor info added Successfully
    When I login with doctor emailId and password
    Then I should be navigated to the doctor dashboard page
