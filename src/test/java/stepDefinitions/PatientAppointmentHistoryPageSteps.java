package stepDefinitions;

import io.cucumber.java.en.When;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import pages.PatientAppointmentHistoryPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class PatientAppointmentHistoryPageSteps {

    private TestContext context;
    private PatientAppointmentHistoryPage patientAppointmentHistoryPage;

    public PatientAppointmentHistoryPageSteps(TestContext context) {
        this.context = context;
        this.patientAppointmentHistoryPage = new PatientAppointmentHistoryPage(context);
    }

    @Then("I should see the patient appointment history page")
    public void iShouldSeeThePatientAppointmentHistoryPage() {
        try {
            String actualPatientAppointmentHistoryPageTitle = patientAppointmentHistoryPage.getPatientAppointmentHistoryPageTitle();
            String expectedAppointmentHistoryPageTitle = PropertiesManager.getProperty("patientAppointmentHistoryPage.title");
            assertEquals(expectedAppointmentHistoryPageTitle, actualPatientAppointmentHistoryPageTitle);
            log.info("Patient appointment history page title is matched");
        } catch (Exception e) {
            log.error("An exception error occurred while matching the patient appointment history page title");
            throw e;
        }
    }

    @And("I should see the appointment booked successfully")
    public void iShouldSeeTheAppointmentBookedSuccessfully() {
        try {
            patientAppointmentHistoryPage.verifyAppointmentStatus();
            String actualAppointmentStatus = context.getPatientAppointmentStatus();
            String expectedAppointmentStatus = PropertiesManager.getProperty("patientAppointmentStatus");
            assertEquals(expectedAppointmentStatus, actualAppointmentStatus);
            log.info("Appointment status matched");
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the appointment");
            throw e;
        }

    }

    @When("I cancel the patient appointment")
    public void iCancelThePatientAppointment() {
        try {
            patientAppointmentHistoryPage.cancelAppointment();
            log.info("Patient appointment canceled successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while cancel the appointment");
            throw e;
        }
    }

    @Then("I should see the appointment cancel successfully")
    public void iShouldSeeTheAppointmentCancelSuccessfully() {
        try {
            patientAppointmentHistoryPage.verifyAppointmentStatus();
            String actualAppointmentCancelStatus = context.getPatientAppointmentStatus();
            String expectedAppointmentCancelStatus = PropertiesManager.getProperty("patientAppointmentCancelStatus");
            assertEquals(expectedAppointmentCancelStatus, actualAppointmentCancelStatus);
            log.info("Cancel appointment status matched");
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the cancel appointment");
            throw e;
        }
    }
}
