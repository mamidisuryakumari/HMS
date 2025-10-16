package stepDefinitions;

import ui.engine.PropertiesManager;
import ui.engine.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.PatientLoginPage;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class PatientLoginPageSteps {

    private TestContext context;
    private PatientLoginPage patientLoginPage;

    public PatientLoginPageSteps(TestContext context) {
        this.context = context;
        this.patientLoginPage = new PatientLoginPage(context);
    }

    @Then("I should see the patient login page")
    public void i_should_see_the_patient_login_page() {
        try {
            String actualPatientLoginPageTitle = patientLoginPage.getPatientLoginPageTitle();
            String expectedPatientLoginPageTitle = PropertiesManager.getProperty("patientLoginPage.title");
            assertEquals(expectedPatientLoginPageTitle, actualPatientLoginPageTitle);
            log.info("Patient login page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the patient login page title");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the patient login page title");
            throw e;
        }
    }

    @When("I navigate to the patient registration page")
    public void i_navigate_to_the_patient_registration_page() {
        try {
            patientLoginPage.navigateToThePatientRegistrationPage();
            log.info("Navigate to the patient registration page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the registration page");
            throw e;
        }
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
        try {
            Map<String, String> patientLoginDetails = dataTable.asMap();
            patientLoginPage.patientLogin(patientLoginDetails.get("EmailId")
                    , patientLoginDetails.get("Password"));
            log.info("Patient logged successfully ");
        } catch (Exception e) {
            log.error("An exception error occurred While entering login credentials");
            throw e;
        }
    }

    @When("I login with invalid {string} and {string}")
    public void i_login_with_invalid_and(String emailId, String password) {
        try {
            patientLoginPage.patientLogin(emailId, password);
            log.info("EmailId and password entered successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while entering emailid and password");
            throw e;
        }
    }

    @Then("I should see error message {string}")
    public void i_should_see_error_message(String expectedMessage) {
        try {
            String actualMsgText ;

            if (expectedMessage.contains("Please fill out")) {
                actualMsgText = patientLoginPage.getEmailFormatErrorMsg();
                assertEquals(expectedMessage, actualMsgText, "Error message s not matched");
                log.info(actualMsgText);
            } else if (expectedMessage.contains("@ is missing")) {
                actualMsgText = patientLoginPage.getEmailFormatErrorMsg();
                assertEquals(expectedMessage, actualMsgText, "Actual and Expected error message are not matched");
                log.info(actualMsgText);
            }else if(expectedMessage.contains("Invalid username")){
              actualMsgText = String.valueOf(patientLoginPage.getErrorMsg());
              assertEquals(expectedMessage, actualMsgText);
            }
        } catch (Exception e) {
            log.error("An exception error occurred while matching the error message");
            throw e;
        }
    }
}

