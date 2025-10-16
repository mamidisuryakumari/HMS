package stepDefinitions;

import ui.engine.PropertiesManager;
import ui.engine.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.PatientBookAppointmentPage;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class PatientBookAppointmentPageSteps {

    private TestContext context;
    private PatientBookAppointmentPage patientBookAppointmentPage;
    private PatientAppointmentHistoryPageSteps patientAppointmentHistoryPageSteps;

    public PatientBookAppointmentPageSteps(TestContext context) {
        this.context = context;
        this.patientBookAppointmentPage = new PatientBookAppointmentPage(context);
    }

    @Then("I should be on the patient book appointment page")
    public void iShouldBeOnThePatientBookAppointmentPage() {
        try {
            String actualPatientBookAppointmentPage = patientBookAppointmentPage.getPatientBookAppointmentPageTitle();
            String expectedPatientBookAppointmentPage = PropertiesManager.getProperty("patientBookAppointmentPage.title");
            assertEquals(expectedPatientBookAppointmentPage, actualPatientBookAppointmentPage);
            log.info("Patient book appointment page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the patient book appointment page title");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred seeing the patient book appointment page");
            throw e;
        }
    }

    @When("I enter the appointment details")
    public void iEnterTheAppointmentDetails(DataTable dataTable) {
        try {
            Map<String, String> appointmentDetails = dataTable.asMap();
            patientBookAppointmentPage.enterBookAppointmentDetails(appointmentDetails.get("Doctor Specialization"),
                    appointmentDetails.get("Doctor Name"), appointmentDetails.get("Date")
                    , appointmentDetails.get("Time"));
            log.info("Appointment details entered successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while entering appointment details");
            throw e;
        }
    }

    @Then("I should see book appointment success message as {}")
    public void iShouldSeeBookAppointmentSuccessMessageAs(String expectedBookAppointmentSuccessMessage) {
        try {
            patientBookAppointmentPage.getPatientBookAppointmentSuccessMessage();
            String actualPatientBookAppointmentSuccessMsg = context.getActualPatientBookAppointmentSuccessMsg();
            String expectedPatientBookAppointmentSuccessMsg = expectedBookAppointmentSuccessMessage;
            assertEquals(expectedPatientBookAppointmentSuccessMsg, actualPatientBookAppointmentSuccessMsg);
            log.info("Patient book appointment message is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the patient appointment message");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred seeing the patient book appointment success message");
            throw e;
        }
    }


}
