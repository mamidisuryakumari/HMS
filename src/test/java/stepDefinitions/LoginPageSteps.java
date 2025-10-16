package stepDefinitions;

import ui.engine.PropertiesManager;
import ui.engine.TestContext;
import enums.UserType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class LoginPageSteps {
    private TestContext context;
    private LoginPage loginPage;

    public LoginPageSteps(TestContext context) {
        this.context = context;
        this.loginPage = new LoginPage(context);
    }

    @Then("I should see the login page")
    public void i_should_see_the_login_page() {
        try {
            String actualLoginsText = loginPage.getLoginsText();
            String expectedLoginText = PropertiesManager.getProperty("loginsText");
            assertEquals(expectedLoginText, actualLoginsText);
            log.info("Logins text matched successfully");
        } catch (AssertionError ae) {
            log.error("Assertion failed while matching the login page text");
            throw ae;
        } catch (Exception e) {
            log.error("An Exception occurred while seeing the login pag");
            throw e;
        }
    }

    @When("I navigate to the login page as a {}")
    public void i_navigate_to_the_patient_login_page(String user) {
        try {
            UserType userType = UserType.valueOf(user.toUpperCase());
            loginPage.navigateToPage(userType);
            log.info("Navigate to the patient login page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the patient login page");
            throw e;
        }
    }



}
