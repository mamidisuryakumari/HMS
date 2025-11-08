package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.PatientProfilePage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class PatientProfilePageSteps {
    private TestContext context;
    private PatientProfilePage patientProfilePage;

    public PatientProfilePageSteps(TestContext context) {
        this.context = context;
        this.patientProfilePage = new PatientProfilePage(context);
    }

    @Then("I should see the patient profile page")
    public void i_should_see_the_patient_profile_page() {
        try {
            String actualPatientProfilePageTitle = patientProfilePage.getPatientProfilePageTitle();
            String expectedPatientProfilePageTitle = PropertiesManager.getProperty("patientProfilePage.title");
            assertEquals(expectedPatientProfilePageTitle, actualPatientProfilePageTitle);
            log.info("Patient profile page title is matched");
        } catch (AssertionError ae) {
            log.error("Assertion failed while matching the patient profile page title");
            throw new RuntimeException(ae);
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the patient profile page title");
            throw e;
        }
    }

    @When("I update the patient profile details")
    public void i_update_the_patient_profile_details() {
        try {
            patientProfilePage.updatePatientProfileDetails(PropertiesManager.getProperty("patientAddress"));
            log.info("Patient profile details updated successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while updating the patient profile details");
            throw new RuntimeException(e);
        }
    }

    @Then("I should see success message as {}")
    public void i_should_see_success_message_as_your_profile_updated_successfully(String expectedMsg) {
        try {
            String actualSuccessMsg = patientProfilePage.getPatientProfileUpdateSuccessMsg();
            String expectedSuccessMsg = expectedMsg;
            assertEquals(expectedMsg, actualSuccessMsg);
            log.info("Patient success msg is matched");
        } catch (AssertionError ae) {
            log.error("Assertion failed while matching the patient profile update success message");
            throw new RuntimeException(ae);
        }catch (Exception e) {
            log.error("An exception error occurred while seeing the patient profile success message");
            throw new RuntimeException(e);
        }
    }


}
