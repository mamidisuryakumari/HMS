package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.DoctorDashboardPage;
import pages.DoctorManagePatientPage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class DoctorManagePatientSteps {
    private TestContext context;
    private DoctorManagePatientPage doctorManagePatientPage;

    public DoctorManagePatientSteps(TestContext context) {
        this.context = context;
        this.doctorManagePatientPage = new DoctorManagePatientPage(context);
    }

    @Then("I should be navigated to the doctor manage patient page")
    public void navigateToTheManagePatientPage() {
        try {
            String actualManagePatientPageTitle = doctorManagePatientPage.getManagePatientPageTitle();
            String expectedManagePatientPageTitle = PropertiesManager.getProperty("managePatientPage.title");
            assertEquals(expectedManagePatientPageTitle, actualManagePatientPageTitle);
            log.info("Manage patient page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the manage patient page title");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while navigate to the manage patient page");
            throw e;
        }
    }


    @When("I enter the following add patient medical details")
    public void i_enter_the_following_add_patient_medical_details(io.cucumber.datatable.DataTable dataTable) {
        try {
            doctorManagePatientPage.managePatients();
            Map<String, String> patientMedicalDetails = dataTable.asMap();
            doctorManagePatientPage.enterPatientMedicalDetails(patientMedicalDetails.get("Blood Pressure")
                    , patientMedicalDetails.get("Blood Sugar")
                    , patientMedicalDetails.get("Weight")
                    , patientMedicalDetails.get("Body Temperature"), patientMedicalDetails.get("Prescription"));
            log.info("Patient medical details entered successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while entering the patient medical details");
            throw e;
        }
    }

    @Then("I should see medical success message as {}")
    public void i_should_see_success_message_as_medicle_history_has_been_added(String expectedMsg) {
        try {
            doctorManagePatientPage.getSuccessPatientMedicalMessage();
            String actualSuccessMsg = context.getAddPatientMedicalSuccessMsg();
            String expectedSuccessMsg = expectedMsg;
            assertEquals(expectedSuccessMsg, actualSuccessMsg);
            log.info("Medical success message is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the medical success message");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the medical success message");
            throw e;
        }
    }

}
