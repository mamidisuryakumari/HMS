Feature: Patient Login functionality

  @PatientLogin
  Scenario: Verify that the user can login with valid emailId and password
    Given I am on the home page
    When I navigate to the login page
    Then I should see the login page
    When I navigate to the login page as a patient
    Then I should see the patient login page
    When I login with valid credentials
      | EmailId  | surya@gmail.com |
      | Password | surya@123       |
    Then I should be navigated to the patient dashboard page


  @ErrorCase
  Scenario Outline: Verify that the patient cannot log in with an invalid email and password
    Given I am on the home page
    When I navigate to the login page
    Then I should see the login page
    When I navigate to the login page as a patient
    Then I should see the patient login page
    When I login with invalid "<emailId>" and "<password>"
    Then I should see error message "<exceptedMessage>"
    Examples:
      | emailId         | password    | exceptedMessage                                                       |
      | surya@gmail.com | surya@12345 | Invalid username or password                                          |
      | surya           | surya@123   | Please include an '@' in the email address. 'surya' is missing an '@' |
      |                 |             | Please fill out this field.                                           |