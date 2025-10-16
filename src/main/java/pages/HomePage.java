package pages;

import ui.engine.BasePage;
import ui.engine.TestContext;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private TestContext context;

    public HomePage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By loginLink = By.xpath("(//a[text()='Logins'])[1]");


    public String getHomePageTitle() {
        System.out.println(context.getBot().getTitle());
        return context.getBot().getTitle();
    }

    public LoginPage navigateToLoginPage() {
        context.getBot().click(loginLink);
        return new LoginPage(context);
    }
}
