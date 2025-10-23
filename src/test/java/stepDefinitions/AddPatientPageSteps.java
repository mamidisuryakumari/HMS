package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.AddPatientPage;
import ui.engine.Common;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class AddPatientPageSteps {
    private TestContext context;
    private AddPatientPage addPatientPage;

    public AddPatientPageSteps(TestContext context) {
        this.context = context;
        this.addPatientPage = new AddPatientPage(context);
    }


    @Then("I should see the add patient page")
    public void i_should_see_the_add_patient_page() {
        try {
            String actualAddPatientPageTitle = addPatientPage.getAddPatientPageTitle();
            String expectedAddPatientPageTitle = PropertiesManager.getProperty("addPatientpage.title");
            assertEquals(actualAddPatientPageTitle, expectedAddPatientPageTitle);
            log.info("Add patient page title is matched");
        } catch (AssertionError ae) {
            log.error("Assertion failed while matching the title");
            throw ae;
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the add patient page");
            throw e;
        }
    }

    @When("I enter the following add patient details")
    public void i_enter_the_following_add_patient_details(io.cucumber.datatable.DataTable dataTable) {
        try {
            Map<String, String> patientDetails = dataTable.asMap();
            addPatientPage.enterAddPatientDetails(patientDetails.get("Patient Name")
                            .replace("${random}", Common.random()),
                    patientDetails.get("Patient Contact no"),
                    patientDetails.get("Patient Email").replace("${random}",Common.random()),
                    patientDetails.get("Patient Address"),
                    patientDetails.get("Patient Age"),
                    patientDetails.get("Medical History"));
            log.info("Patient details entered successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while entering patient details");
            throw e;
        }
    }

    @Then("I should see add patient success message as {}")
    public void i_should_see_a_add_patient_success_message_as_patient_info_added_successfully(
            String exceptedSuccessMsg) {
        try {
            addPatientPage.getAddPatientSuccessMsg();
            String actualAddPatientSuccessMsg = context.getAddPatientAlertSuccessMsg();
            String expectedAddPatientSuccessMsg = exceptedSuccessMsg;
            assertEquals(expectedAddPatientSuccessMsg, actualAddPatientSuccessMsg);
            log.info("Add patient success message is matched");
        } catch (Exception e) {
            log.error("An exception error occurred while seeing add patient success message");
            throw e;
        }
    }
}
