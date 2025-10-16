package stepDefinitions;

import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import pages.AdminDashboardPage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Slf4j
public class AdminDashBoardPageSteps {

    private TestContext context;
    private AdminDashboardPage adminDashboardPage;

    public AdminDashBoardPageSteps(TestContext context) {
        this.context = context;
        this.adminDashboardPage = new AdminDashboardPage(context);
    }

    @Then("I should be navigated to the admin dashboard page")
    public void iShouldBeNavigatedToTheAdminDashboardPage() {
        try {
           String actualAdminDashBoardPageTitle =  adminDashboardPage.getAdminDashBoardPageTitle();
           String expectedAdminDashBoardPageTitle = PropertiesManager.getProperty("adminDashboardPage.title");
           assertEquals(expectedAdminDashBoardPageTitle, actualAdminDashBoardPageTitle);
           log.info("Admin dashboard page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the admin dashboard page title");
            throw e;
        }catch (Exception e) {
            log.error("An exception error occurred while navigating to the admin dashboard page title");
            throw e;
        }
    }
}
