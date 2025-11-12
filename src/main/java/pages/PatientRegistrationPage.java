package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import ui.engine.BasePage;
import ui.engine.Bot;
import ui.engine.TestContext;
import org.openqa.selenium.By;

public class PatientRegistrationPage extends BasePage {
    private TestContext context;

    public PatientRegistrationPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By fullNameTextFld = By.name("full_name");
    private By addressTextFld = By.name("address");
    private By cityTextFld = By.name("city");
    private By femaleRadioBtn = By.id("rg-female");
    private By maleRadioBtn = By.xpath("//label[@for='rg-male']");
    private By emailTextFld = By.id("email");
    private By passwordTextFld = By.id("password");
    private By passwordAgainTextFld = By.id("password_again");
    private By submitBtn = By.id("submit");

    public String getUserRegistrationPageTitle() {
        return context.getBot().getTitle();
    }

    public PatientDashBoardPage userRegistration(String fullName, String address, String city, String emailId, String password,
                                                 String againPassword) {
        context.getBot().enterText(fullNameTextFld, fullName);
        context.getBot().pressTabUsingActions(addressTextFld);
                context.getBot().enterText(addressTextFld, address)
                .enterText(cityTextFld, city)
                .jsClick(maleRadioBtn)
                .enterText(emailTextFld, emailId)
                .enterText(passwordTextFld, password)
                .enterText(passwordAgainTextFld, againPassword)
                .click(submitBtn);
        context.setPatientEmail(emailId);
        context.setPatientPassword(password);
        return new PatientDashBoardPage(context);
    }

    public PatientRegistrationPage getUserRegistrationSuccessMsg() {
        String actualUserRegistrationSuccessMsg = context.getBot().getAlertMessage();
        context.setActualUserRegistrationSuccessMsg(actualUserRegistrationSuccessMsg);
        context.getBot().acceptAlert();
        context.getDriver().get("http://localhost/hospital/hms/user-login.php");
        return this;
    }

    public String getFullNameErrorMsg() {
        context.getBot().click(submitBtn);
        return context.getBot().getValidationMessage(fullNameTextFld);

    }

    public Bot getEmailFormatErrorMsg() {
        context.getBot().click(submitBtn);
        return context.getBot().click(emailTextFld);
    }

    public String getAlertErrorMsg() {
        return context.getBot().getAlertMessage();
    }
}
