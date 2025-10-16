Feature: Admin login functionality

  @AdminLogin
  Scenario: Verify that the admin login with valid credentials
    Given I am on the home page
    When I navigate to the login page
    Then I should see the login page
    When I navigate to the login page as a admin
    Then I should see the admin login page
    When I login with admin valid credentials
      | UserName  | admin      |
      | Password | Test@12345 |
    Then I should be navigated to the admin dashboard page
