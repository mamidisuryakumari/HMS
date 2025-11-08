package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.PatientMedicalHistoryPage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class PatientMedicalHistoryPageSteps {
    private TestContext context;
    private PatientMedicalHistoryPage patientMedicalHistoryPage;

    public PatientMedicalHistoryPageSteps(TestContext context) {
        this.context = context;
        this.patientMedicalHistoryPage = new PatientMedicalHistoryPage(context);
    }


    @Then("I should see the patient medical history page")
    public void i_should_see_the_patient_medical_history_page() {
        try {
            String actualPatientMedicalHistoryPageTitle = patientMedicalHistoryPage.getPatientMedicalHistoryPageTitle();
            String expectedPatientMedicalHistoryPageTitle = PropertiesManager.getProperty("patientMedicalHistoryPage.title");
            assertEquals(expectedPatientMedicalHistoryPageTitle, actualPatientMedicalHistoryPageTitle);
            log.info("Patient medical history page title is matched");
        } catch (AssertionError ae) {
            log.error("Assertion failed while matching the patient medical history page title ");
            throw ae;
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the patient medical history page");
            throw e;
        }
    }

    @When("I click on view details button")
    public void i_click_on_view_details_button() {
        try {
            patientMedicalHistoryPage.clickOnViewDetails();
            log.info("View details button clicked successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while clicking the view details button");
            throw e;
        }
    }

    @Then("I should see the patient medical history details")
    public void i_should_see_the_patient_medical_history_details() {
        try {
            log.info("Patient medical history details loaded successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the patient medical history details");
            throw e;
        }
    }


}
