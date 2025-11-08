package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.AdminManageDoctorPage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class AdminManageDoctorPageSteps {

    private TestContext context;
    private AdminManageDoctorPage adminManageDoctorPage;

    public AdminManageDoctorPageSteps(TestContext context) {
        this.context = context;
        this.adminManageDoctorPage = new AdminManageDoctorPage(context);
    }

    @Then("I should be navigated to the admin manage doctor page")
    public void iNavigateToAdminManageDoctorPage() {
        try {
            String actualAdminManageDoctorPageTitle = adminManageDoctorPage.getAdminManageDoctorPageTitle();
            String expectedAdminManageDoctorPageTitle = PropertiesManager.getProperty("adminManageDoctor.title");
            assertEquals(expectedAdminManageDoctorPageTitle, actualAdminManageDoctorPageTitle);
            log.info("Admin manage doctor page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the admin manage doctor page title");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the ");
            throw e;
        }

    }

    @When("I delete the doctor")
    public void iDeleteTheDoctor() {
        try {
            adminManageDoctorPage.deleteDoctor();
            log.info("Doctor deleted successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while deleting the doctor");
            throw e;
        }
    }

    @Then("I should see doctor deleted message as {}")
    public void iShouldSeeDoctorDeletedMessage(String expectedMsg) {
        try {
            String actualDoctorDeleteSuccessMsg = adminManageDoctorPage.getDoctorDeletedSuccessmsg();
            assertEquals(expectedMsg, actualDoctorDeleteSuccessMsg);
            log.info("Doctor delete success message is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the doctor delete success message");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the doctor delete success message");
            throw e;
        }
    }
}
