package stepDefinitions;

import enums.UserType;
import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.LoginPage;
import ui.engine.Common;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.PatientLoginPage;
import pages.PatientRegistrationPage;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class PatientRegistrationPageSteps {

    private TestContext context;
    private HomePage homePage;
    private LoginPage loginPage;
    private PatientLoginPage patientLoginPage;
    private PatientRegistrationPage patientRegistrationPage;

    public PatientRegistrationPageSteps(TestContext context) {
        this.context = context;
        this.patientLoginPage = new PatientLoginPage(context);
        this.patientRegistrationPage = new PatientRegistrationPage(context);
        this.homePage = new HomePage(context);
        this.loginPage = new LoginPage(context);
    }

    @Given("the user is on \"Registration\" page")
    public void userIsOnRegistrationPage() {
        homePage.navigateToLoginPage();
        loginPage.navigateToPage(UserType.PATIENT);
        patientLoginPage.navigateToThePatientRegistrationPage();
    }

    @Then("I should see the patient registration page")
    public void i_should_see_the_patient_registration_page() {
        try {
            String actualPatientRegistrationPageTitle = patientLoginPage.getPatientLoginPageTitle();
            String expectedPatientRegistrationPageTitle = PropertiesManager.getProperty("patientRegistrationPage.title");
            assertEquals(expectedPatientRegistrationPageTitle, actualPatientRegistrationPageTitle);
            log.info("Patient registration page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the patient registration page title");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the patient registration page title");
            throw e;
        }
    }

    @When("I enter the following patient valid details")
    public void i_enter_the_following_patient_details(io.cucumber.datatable.DataTable dataTable) {
        try {
            Map<String, String> patientRegistrationDetails = dataTable.asMap();
            patientRegistrationPage.userRegistration(patientRegistrationDetails.get("Full Name").replace("${random}", Common.random()),
                    patientRegistrationDetails.get("Address"),
                    patientRegistrationDetails.get("City"),
                    patientRegistrationDetails.get("Email").replace("${random}", Common.random()),
                    patientRegistrationDetails.get("Password"),
                    patientRegistrationDetails.get("Confirm Password"));
            log.info("Patient registration details entered successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while entering patient registration details");
            throw e;
        }
    }

    @Then("I should see a success message as {}")
    public void i_should_see_a_success_message_successfully_registered_you_can_login_now(String expectedUserRegistrationMsg) {
        try {
            patientRegistrationPage.getUserRegistrationSuccessMsg();
            assertEquals(context.getActualUserRegistrationSuccessMsg(), expectedUserRegistrationMsg);
            log.info("Registration success message is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the user registration success message");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the success message");
            throw e;
        }
    }

    @When("I login with email and password")
    public void i_login_with_email_and_password() {
        try {
            patientLoginPage.patientLogin(context.getPatientEmail(), context.getPatientPassword());
            log.info("Login successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while login with email and password");
            throw e;
        }
    }

    @When("I enter the following patient invalid details")
    public void i_enter_the_following_patient_invalid_details(io.cucumber.datatable.DataTable dataTable) {
        try {
            Map<String, String> patientInvalidDetails = dataTable.asMap();
            patientRegistrationPage.userRegistration(patientInvalidDetails.get("FullName"),
                    patientInvalidDetails.get("Address"),
                    patientInvalidDetails.get("City"),
                    patientInvalidDetails.get("Email").replace("${random}",Common.random()),
                    patientInvalidDetails.get("Password"),
                    patientInvalidDetails.get("Confirm Password"));
            log.info("Patient invalid registration details entered successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while entering patient invalid details");
            throw e;
        }
    }

    @Then("I should an error message as {}")
    public void i_should_an_error_message_as(String expectedMsg) {
        String actualErrorMsg;
        try {
            if (expectedMsg.contains("Please fill out")) {
                actualErrorMsg = patientRegistrationPage.getFullNameErrorMsg();
                assertEquals(expectedMsg, actualErrorMsg);
            }else if (expectedMsg.contains("Please include an '@' in the email address.")) {
                actualErrorMsg = String.valueOf(patientRegistrationPage.getEmailFormatErrorMsg());
                assertEquals(expectedMsg, actualErrorMsg);

            }else if (expectedMsg.contains("Password and Confirm Password Field do not match  !! ")) {
                actualErrorMsg = patientRegistrationPage.getAlertErrorMsg();
                assertEquals(expectedMsg, actualErrorMsg);
            }else if (expectedMsg.contains("'.' is used at a wrong position in '.com'.")) {
                actualErrorMsg = patientRegistrationPage.getFullNameErrorMsg();
                assertEquals(expectedMsg, actualErrorMsg);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
