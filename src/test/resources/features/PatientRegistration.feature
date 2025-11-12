Feature: Patient Registration functionality

  Background:
    Given the user is on "Registration" page

  @PatientRegistration
  Scenario: Patient registration with valid details
    When I enter the following patient valid details
      | Full Name        | M Ram${random}         |
      | Address          | Hanuman Nagar          |
      | City             | Hyderabad              |
      | Email            | ram${random}@gmail.com |
      | Password         | ram@123                |
      | Confirm Password | ram@123                |
    Then I should see a success message as Successfully Registered. You can login now

  @Error-case
  Scenario Outline: Patient registration with invalid details
    When I enter the following patient invalid details
      | FullName         | <fullName>        |
      | Address          | <address>         |
      | City             | <city>            |
      | Email            | <email>           |
      | Password         | <password>        |
      | Confirm Password | <confirmPassword> |
    Then I should an error message as <errorMessage>
    Examples:
      | fullName | address     | city     | email                     | password | confirmPassword | errorMessage                                                                    |
      |          | 123 Main St | New York | john${random}@example.com | Pass123! | Pass123!        | Please fill out this field.                                                     |
      | John Doe |             | New York | john${random}@example.com | Pass123! | Pass123!        | Please fill out this field.                                                     |
      | John Doe | 123 Main St |          | john${random}@example.com | Pass123! | Pass123!        | Please fill out this field.                                                     |
      | John Doe | 123 Main St | New York | johnexample.com           | Pass123! | Pass123!        | Please include an '@' in the email address. 'johnexample.com' is missing an '@' |
      | John Doe | 123 Main St | New York | john${random}@example.com | Pass123! | Pass321!        | Password and Confirm Password Field do not match  !!                            |
      | John Doe | 123 Main St | New York | john@.com                 | Pass123! | Pass123!        | '.' is used at a wrong position in '.com'.                                      |
      | John Doe | 123 Main St | New York | john${random}@example.com |          |                 | Please fill out this field.                                                     |




