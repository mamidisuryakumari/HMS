package pages;

import org.openqa.selenium.By;
import ui.engine.BasePage;
import ui.engine.TestContext;

public class DoctorLoginPage extends BasePage {
    private TestContext context;
    public DoctorLoginPage(TestContext context) {
        super(context);
        this.context = context;
    }
    private By userNameTextFld = By.name("username");
    private By passwordTextFld = By.name("password");
    private By submitBtn = By.name("submit");

    public String getDoctorLoginPageTitle(){
       return context.getBot().getTitle();
    }

    public DoctorDashboardPage doctorLogin(String userName, String password){
        context.getBot().enterText(userNameTextFld,userName)
                .enterText(passwordTextFld,password)
                .click(submitBtn);

        return new DoctorDashboardPage(context);
    }
}
