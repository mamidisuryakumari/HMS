package stepDefinitions;

import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import pages.DoctorDashboardPage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class DoctorDashBoardPageSteps {
    private TestContext context;
    private DoctorDashboardPage doctorDashboardPage;

    public DoctorDashBoardPageSteps(TestContext context) {
        this.context = context;
        this.doctorDashboardPage = new DoctorDashboardPage(context);
    }

    @Then("I should be navigated to the doctor dashboard page")
    public void iShouldBeNavigatedToTheDoctorDashboardPage() {
        try {
            String actualDoctorDashboardPageTitle = doctorDashboardPage.getDoctorDashBoardPageTitle();
            String expectedDoctorDashboardPageTitle = PropertiesManager.getProperty("doctorDashBoardPage.title");
            assertEquals(expectedDoctorDashboardPageTitle, actualDoctorDashboardPageTitle);
            log.info("Doctor dashboard page title matched successfully");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching doctor dashboard page title");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the doctor dashboard page title");
            throw e;
        }
    }
}
