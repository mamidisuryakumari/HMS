package stepDefinitions;

import io.cucumber.java.en.Then;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class HomePageSteps {
    private TestContext context;
    private HomePage homePage;

    public HomePageSteps(TestContext context) {
        this.context = context;
        this.homePage = new HomePage(context);
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        try {
            String actualHomePageTitle = homePage.getHomePageTitle();
            String expectedHomePageTitle = PropertiesManager.getProperty("homepage.title");
            assertEquals(expectedHomePageTitle, actualHomePageTitle);
            log.info("Homepage title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the homepage title");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while matching the homepage title");
            throw e;
        }
    }

    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() {
        try {
            homePage.navigateToLoginPage();
            log.info("Navigate to the login page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the login page");
            throw e;
        }
    }

    @Then("I navigate to the home page")
    public void i_navigate_to_the_home_page() {
        try {
            String actualHomePageTitle = homePage.getHomePageTitle();
            String expectedHomePageTitle = PropertiesManager.getProperty("homepage.title");
            assertEquals(expectedHomePageTitle, actualHomePageTitle);
            log.info("Homepage title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed while matching the homepage title");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while matching the homepage title");
            throw e;
        }
    }
}
