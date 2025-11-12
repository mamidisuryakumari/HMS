package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.PatientChangePasswordPage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class PatientChangePasswordPageSteps {
    private TestContext context;
    private PatientChangePasswordPage patientChangePasswordPage;

    public PatientChangePasswordPageSteps(TestContext context) {
        this.context = context;
        this.patientChangePasswordPage = new PatientChangePasswordPage(context);
    }


    @Then("I should see the patient change password page")
    public void i_should_see_the_patient_change_password_page() {
        try {
            String actualPatientChangePasswordPageTitle = patientChangePasswordPage.getPatientPasswordPageTitle();
            String expectedPatientChangePasswordPageTitle = PropertiesManager.getProperty("patientChangePasswordPage.title");
            assertEquals(expectedPatientChangePasswordPageTitle, actualPatientChangePasswordPageTitle);
            log.info("Patient change password page title is matched");
        } catch (AssertionError ae) {
            log.error("Assertion failed while matching the patient change password page title");
            throw ae;
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the patient change password page");
            throw e;
        }
    }

    @When("I enter the following patient change password details")
    public void i_enter_patient_change_password_details(io.cucumber.datatable.DataTable dataTable) {
        try {
            Map<String, String> patientChangePasswordDetails = dataTable.asMap();
            patientChangePasswordPage.enterPatientChangePasswordDetails(patientChangePasswordDetails.get("Current Password")
                    , patientChangePasswordDetails.get("New Password"), patientChangePasswordDetails.get("Confirm Password"));
            log.info("Entered patient change password details successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while entering the patient change password details");
            throw e;
        }
    }

    @Then("I should see change password success message as {}")
    public void i_should_see_patient_change_password_successfully(String expectedMsg) {
        try {
            String actualPatientChangePasswordSuccessMsg = patientChangePasswordPage.getPatientChangePasswordSuccessMsgText();
            String expectedPatientChangePasswordSuccessMsg = expectedMsg;
            assertEquals(expectedPatientChangePasswordSuccessMsg, actualPatientChangePasswordSuccessMsg);
            log.info("Patient change password success message is matched");
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the change password success message");
            throw new RuntimeException(e);
        }
    }


}
