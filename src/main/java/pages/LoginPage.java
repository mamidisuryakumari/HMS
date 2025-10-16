package pages;

import ui.engine.BasePage;
import ui.engine.TestContext;
import enums.UserType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class LoginPage extends BasePage {
    private TestContext context;

    public LoginPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By loginsLabel = By.xpath("//h2[text()='Logins']");
    private By patientLoginBtn = By.xpath("(//button[text()='Click Here'])[1]");
    private By doctorLoginBtn = By.xpath("(//button[text()='Click Here'])[2]");
    private By adminLoginBtn = By.xpath("(//button[text()='Click Here'])[3]");

    public String getLoginsText() {
        return context.getBot().getText(loginsLabel);
    }

    public void navigateToPage(UserType user) {
        String currentWindow = context.getDriver().getWindowHandle();
        switch (user) {
            case PATIENT:
                context.getBot().click(patientLoginBtn);
                log.info("Navigate to patient login page");
                break;
            case DOCTOR:
                context.getBot().click(doctorLoginBtn);
                log.info("Navigate to doctor login page");
                break;
            case ADMIN:
                context.getBot().click(adminLoginBtn);
                log.info("Navigate to admin login page");
                break;
            default:
                log.info("Please pass a correct usertype value");
                throw new IllegalArgumentException("I am unable to navigate to page");

        }
        for (String handle : context.getDriver().getWindowHandles()) {
            if (!handle.equals(currentWindow)) {
                context.getDriver().switchTo().window(handle);
                log.info("Switched to new window");
                break;
            }
        }
    }

}
