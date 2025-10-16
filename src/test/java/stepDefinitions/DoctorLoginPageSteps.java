package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.DoctorLoginPage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class DoctorLoginPageSteps {
    private TestContext context;
    private DoctorLoginPage doctorLoginPage;

    public DoctorLoginPageSteps(TestContext context) {
        this.context = context;
        this.doctorLoginPage = new DoctorLoginPage(context);
    }

    @Then("I should see the doctor login page")
    public void iShouldSeeTheDoctorLoginPage() {
        try {
            String actualDoctorLoginPageTitle = doctorLoginPage.getDoctorLoginPageTitle();
            String expectedDoctorLoginPageTitle = PropertiesManager.getProperty("doctorLoginPage.title");
            assertEquals(expectedDoctorLoginPageTitle, actualDoctorLoginPageTitle);
            log.info("Doctor login page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the login page title");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred seeing the doctor login page title");
            throw e;
        }
    }

    @When("I login with doctor valid credentials")
    public void iLoginWithDoctorValidCredentials(DataTable dataTable){
       try{
           Map<String, String> doctorLoginDetails = dataTable.asMap();
           doctorLoginPage.doctorLogin(doctorLoginDetails.get("EmailId"),
                   doctorLoginDetails.get("Password"));
           log.info("Entered doctor login details successfully");
       } catch (Exception e) {
           log.error("An exception error occurred while entering the doctor login details");
           throw new RuntimeException(e);
       }
    }

}
