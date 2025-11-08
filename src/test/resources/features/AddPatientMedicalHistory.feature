Feature: Add Patient medical history

@AddMedicalHistory
Scenario: Verify that the doctor can add patient medical history successfully
Given I am on the home page
When I navigate to the login page
Then I should see the login page
When I navigate to the login page as a doctor
Then I should see the doctor login page
When I login with doctor valid credentials
| EmailId  | kumar@gmail.com |
| Password | kumar@123       |
Then I should be navigated to the doctor dashboard page
When I navigate to doctor manage patient page
Then I should be navigated to the doctor manage patient page
When I enter the following add patient medical details
| Blood Pressure   | 120/80                    |
| Blood Sugar      | 90                        |
| Weight           | 63                        |
| Body Temperature | 98.6                      |
| Prescription     | Take medicine twice daily |
Then I should see medical success message as Medicle history has been added.