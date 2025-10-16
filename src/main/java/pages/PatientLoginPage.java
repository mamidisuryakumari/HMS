package pages;

import ui.engine.BasePage;
import ui.engine.TestContext;
import org.openqa.selenium.By;

public class PatientLoginPage extends BasePage {
    private TestContext context;

    public PatientLoginPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By emailTextFld = By.name("username");
    private By passwordTextFld = By.name("password");
    private By loginBtn = By.name("submit");
    private By createAnAccountLink = By.xpath("//a[normalize-space(text())='Create an account']");

    public String getPatientLoginPageTitle() {
        return context.getBot().getTitle();
    }

    public void navigateToThePatientRegistrationPage() {
        context.getBot().click(createAnAccountLink);
    }

    public PatientDashBoardPage patientLogin(String userName, String password) {
        context.getBot().enterText(emailTextFld, userName)
                .enterText(passwordTextFld, password)
                .click(loginBtn);
        if(true)
        {
            return new PatientDashBoardPage(context);
        }

        return null;
    }

    public String getEmailFormatErrorMsg(){
        context.getBot().click(loginBtn);
       return context.getBot().getValidationMessage(emailTextFld);
    }

    public String getErrorMsg() {
      return  context.getBot().getAlertMessage();
    }
}
