package stepDefinitions;

import enums.UserType;
import io.cucumber.java.en.Given;
import pages.*;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class PatientDashboardPageSteps {

    private TestContext context;
    private HomePage homePage;
    private LoginPage loginPage;
    private PatientLoginPage patientLoginPage;
    private PatientDashBoardPage patientDashboardPage;
    private PatientBookAppointmentPage patientBookAppointmentPage;
    private PatientAppointmentHistoryPage patientAppointmentHistoryPage;


    public PatientDashboardPageSteps(TestContext context) {
        this.context = context;
        this.homePage = new HomePage(context);
        this.loginPage = new LoginPage(context);
        this.patientLoginPage = new PatientLoginPage(context);
        this.patientDashboardPage = new PatientDashBoardPage(context);
        this.patientBookAppointmentPage = new PatientBookAppointmentPage(context);
        this.patientAppointmentHistoryPage = new PatientAppointmentHistoryPage(context);

    }

    @Given("The patient is on the patient dashboard page")
    public void thePatientIsOnThePatientDashboardPage(String userName, String password) {
        try {
            homePage.navigateToLoginPage();
            loginPage.navigateToPage(UserType.PATIENT);

        } catch (Exception e) {
            throw e;
        }
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

    @When("I click on profile image")
    public void i_click_on_profile_image() {
        try {
            patientDashboardPage.clickOnPatientProfileImage();
            log.info("Patient profile image clicked successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while clicking on the patient login button");
            throw e;
        }
    }

    @When("I click on logout button")
    public void i_click_on_logout_button() {
        try {
            patientDashboardPage.clickOnPatientLogoutBtn();
            log.info("Patient logout button clicked successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while clicking on the logout button");
            throw e;
        }
    }

    @Then("I should see logout successfully")
    public void i_should_see_logout_successfully() {
        try {
            log.info("Logout successfully");
        } catch (Exception e) {
            log.info("An exception error occurred while seeing logout successfully");
            throw e;
        }
    }

    @When("I navigate to patient medical history page")
    public void i_navigate_to_patient_medical_history_page() {
        try {
            patientDashboardPage.clickOnMedicalHistoryMenu();
            log.info("Navigate to medical history page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the patient medical history page");
            throw e;
        }
    }

    @When("I navigate to patient profile page")
    public void i_navigate_to_patient_profile_page() {
        try {
            patientDashboardPage.navigateToPatientProfilePage();
            log.info("Navigate to patient profile page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the patient profile page");
            throw e;
        }
    }

    @When("I navigate to patient change password page")
    public void i_navigate_to_patient_change_password_page() {
        try {
            patientDashboardPage.navigateToPatientChangePasswordPage();
            log.info("Navigate to patient change password page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the patient change password page");
            throw e;
        }
    }

}
