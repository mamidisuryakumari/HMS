package pages;

import org.openqa.selenium.By;
import ui.engine.BasePage;
import ui.engine.TestContext;

public class AdminLoginPage extends BasePage {
    private TestContext context;

    public AdminLoginPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By userNameTextFld = By.name("username");
    private By passwordTextFld = By.name("password");
    private By loginBtn = By.name("submit");

    public String getAdminLoginPageTitle() {
        return context.getBot().getTitle();
    }

    public AdminDashboardPage adminLogin(String userName, String password) {
        context.getBot().enterText(userNameTextFld, userName)
                .enterText(passwordTextFld, password)
                .click(loginBtn);
        return new AdminDashboardPage(context);
    }
}
