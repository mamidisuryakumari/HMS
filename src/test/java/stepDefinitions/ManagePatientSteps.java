package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.it.Ma;
import lombok.extern.slf4j.Slf4j;
import pages.ManagePatientPage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Slf4j
public class ManagePatientSteps {
    private TestContext context;
    private ManagePatientPage managePatientPage;

    public ManagePatientSteps(TestContext context) {
        this.context = context;
        this.managePatientPage = new ManagePatientPage(context);
    }

    @Then("I should be navigated to the manage patient page")
    public void navigateToTheManagePatientPage() {
        try {
            String actualManagePatientPageTitle = managePatientPage.getManagePatientPageTitle();
            String expectedManagePatientPageTitle = PropertiesManager.getProperty("managePatientPage.title");
            assertEquals(expectedManagePatientPageTitle, actualManagePatientPageTitle);
            log.info("Manage patient page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the manage patient page title");
            throw e;
        }catch (Exception e) {
            log.error("An exception error occurred while navigate to the manage patient page");
            throw e;
        }
    }
}
