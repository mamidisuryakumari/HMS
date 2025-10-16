package stepDefinitions;

import ui.engine.PropertiesManager;
import ui.engine.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.PatientAppointmentHistoryPage;
import pages.PatientBookAppointmentPage;
import pages.PatientDashBoardPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class PatientDashboardPageSteps {

    private TestContext context;
    private PatientDashBoardPage patientDashboardPage;
    private PatientBookAppointmentPage patientBookAppointmentPage;
    private PatientAppointmentHistoryPage patientAppointmentHistoryPage;

    public PatientDashboardPageSteps(TestContext context) {
        this.context = context;
        this.patientDashboardPage = new PatientDashBoardPage(context);
        this.patientBookAppointmentPage = new PatientBookAppointmentPage(context);
        this.patientAppointmentHistoryPage = new PatientAppointmentHistoryPage(context);
    }

    @Then("I should be navigated to the patient dashboard page")
    public void i_should_be_navigated_to_the_patient_dashboard_page() {
        try {
            String actualPatientDashboardPageTitle = patientDashboardPage.getPatientDashBoardPageTitle();
            String expectedPatientDashboardPageTitle = PropertiesManager.getProperty("patientDashBoardPage.title");
            assertEquals(expectedPatientDashboardPageTitle, actualPatientDashboardPageTitle);
            log.info("Patient dashboard page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the patient dashboard page title");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the patient dashboard page");
            throw e;
        }
    }

    @When("I navigate to the patient book appointment page")
    public void iNavigateThePatientBookAppointmentPage() {
        try {
            patientDashboardPage.navigateToPatientBookAppointmentPage();
            log.info("Navigate to patient book appointment page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the patient book appointment page");
            throw e;
        }
    }

    @When("I navigate to the patient appointment history page")
    public void iNavigateToThePatientAppointmentHistoryPage() {
        try {
            patientDashboardPage.navigateToPatienAppointmentHistoryPage();
            log.info("Navigate to the patient appointment history page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the patient appointment history page");
            throw e;
        }
    }

}
