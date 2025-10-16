package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.AdminDashboardPage;
import pages.AdminLoginPage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class AdminLoginPageSteps {

    private TestContext context;
    private AdminLoginPage adminLoginPage;

    public AdminLoginPageSteps(TestContext context) {
        this.context = context;
        this.adminLoginPage = new AdminLoginPage(context);
    }

    @Then("I should see the admin login page")
    public void iShouldSeeTheAdminLoginPage() {
        try {
            String actualAdminLoginPageTitle = adminLoginPage.getAdminLoginPageTitle();
            String expectedAdminLoginPageTitle = PropertiesManager.getProperty("adminLoginPage.title");
            assertEquals(expectedAdminLoginPageTitle, actualAdminLoginPageTitle);
            log.info("Admin login page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the admin login page title");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the admin login page title");
            throw e;
        }
    }

    @When("I login with admin valid credentials")
    public void iLoginWithAdminValidCredentials(DataTable dataTable) {
        try {
            Map<String, String> adminLoginDetails = dataTable.asMap();
            adminLoginPage.adminLogin(adminLoginDetails.get("UserName"),
                    adminLoginDetails.get("Password"));
            log.info("Admin login details entered successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while entering admin login details");
            throw e;
        }
    }
}
