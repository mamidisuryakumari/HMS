package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.AddDoctorPage;
import pages.AdminDashboardPage;
import ui.engine.Common;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class AddDoctorPageSteps {
    private TestContext context;
    private AdminDashboardPage adminDashboardPage;
    private AddDoctorPage addDoctorPage;

    public AddDoctorPageSteps(TestContext context) {
        this.context = context;
        this.addDoctorPage = new AddDoctorPage(context);
        this.adminDashboardPage = new AdminDashboardPage(context);
    }

    @When("I navigate to the admin add doctor page")
    public void iNavigateToTheAdminAddDoctorPage() {
        try {
            adminDashboardPage.navigateToAddDoctorPage();
            log.info("Navigate to the add doctor page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the add doctor page");
            throw e;
        }
    }

    @Then("I should see the admin add doctor page")
    public void iShouldSeeTheAdminAddDoctorPage() {
        try {
            String actualAddDoctorPageTitle = adminDashboardPage.getAdminDashBoardPageTitle();
            String expectedAddDoctorPageTitle = PropertiesManager.getProperty("addDoctorPage.title");
            assertEquals(expectedAddDoctorPageTitle, actualAddDoctorPageTitle);
            log.info("Add doctor page title is matched");
        } catch (AssertionError e) {
            log.error("An exception error occurred while matching the page title");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the add doctor page title");
            throw e;
        }
    }

    @When("I enter the following doctor details")
    public void iEnterTheFollowingDoctorDetails(DataTable dataTable) {
        try {
            Map<String, String> doctorDetails = dataTable.asMap();
            addDoctorPage.enterDoctorDetails(doctorDetails.get("Doctor Specialization"),
                    doctorDetails.get("Doctor Name").replace("${random}", Common.random()),
                    doctorDetails.get("Doctor Clinic Address"),
                    doctorDetails.get("Doctor Consultancy Fees"),
                    doctorDetails.get("Doctor Contact no"),
                    doctorDetails.get("Doctor Email").replace("${random}", Common.random()),
                    doctorDetails.get("Password"),
                    doctorDetails.get("Confirm Password"));
            log.info("Doctor details entered successfully");
        } catch (Exception e) {
            log.info("An exception error occurred while entering the doctor details");
            throw e;
        }
    }

    @Then("I should see a doctor add success message as {}")
    public void iShouldSeeSuccessMessage(String exceptedSuccessMsg) {
        try {
            addDoctorPage.getAddDoctorSuccessMsg();
            String actualAddDoctorAlertSuccessMsg = context.getAddDoctorAlertSuccessMsg();
            String expectedAddDoctorAlertSuccessMsg = exceptedSuccessMsg;
            assertEquals(expectedAddDoctorAlertSuccessMsg, actualAddDoctorAlertSuccessMsg);

            log.info("Add doctor success message is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the doctor add success message");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the success message");
            throw e;
        }
    }

    @When("I navigate to the doctor login page")
    public void iNavigateToTheDoctorLoginPage(){
        try{
            addDoctorPage.navigateToDoctorLoginPage();
            log.info("Navigate to the doctor login page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the doctor login page");
            throw e;
        }
    }
}
