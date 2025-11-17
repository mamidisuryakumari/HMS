package stepDefinitions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import reports.ReportManager;
import ui.engine.Bot;
import ui.engine.BrowserFactory;
import ui.engine.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Hooks {
    private TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    private final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void initDriver(Scenario scenario) throws IOException {

        BrowserFactory browserFactory = new BrowserFactory();

        WebDriver driver = browserFactory.theTargetBrowserisOpen();
        Bot bot = browserFactory.getBot();

        context.setDriver(driver);
        context.setBot(bot);
// Retrieve tags from the scenario and pass to createTest
        String[] tags = scenario.getSourceTagNames().toArray(new String[0]);
        ReportManager.createTest(scenario.getName(), tags);
    }

    @After
    public void tearDown() {
        WebDriver driver = context.getDriver();
	if (driver != null) {
			driver.quit();

}

        //	ReportManager.flush();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) context.getDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

                scenario.attach(screenshot, "image/png", "Failed Screenshot");

                String base64Screenshot = java.util.Base64.getEncoder().encodeToString(screenshot);

                ReportManager.getTest().log(Status.FAIL, "Step failed",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

            } catch (Exception e) {
                System.out.println("Screenshot capture failed: " + e.getMessage());
            }
        }
    }
}
