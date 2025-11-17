package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
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
        if (fullName == null || fullName.isEmpty()) {
            context.setFieldName("FullName");
        }
        context.getBot().pressTabUsingActions(addressTextFld);
        context.getBot().enterText(addressTextFld, address);
        if (address == null || address.isEmpty()) {
            context.setFieldName("Address");
        }
        context.getBot().enterText(cityTextFld, city);
        if (city == null || city.isEmpty()) {
            context.setFieldName("City");
        }
        context.getBot().jsClick(maleRadioBtn);
        context.getBot().enterText(emailTextFld, emailId);
        context.getBot().enterText(passwordTextFld, password);
        if (password == null || password.isEmpty()) {
            context.setFieldName("Password");
        }
        context.getBot().enterText(passwordAgainTextFld, againPassword);
        if (againPassword == null || againPassword.isEmpty()) {
            context.setFieldName("ConfirmPassword");
        }

        if((password == null || password.isEmpty() && (againPassword == null || againPassword.isEmpty()) ))
        {
            context.setFieldName("Password");
        }

        context.getBot().click(submitBtn);
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

    public String getEmailFormatErrorMsg() {
        context.getBot().click(submitBtn);
        return context.getBot().getValidationMessage(emailTextFld);
    }


    public String getActualErrorMessageAtFields(String fieldName) {
        By errorLocator;
        switch (fieldName.toLowerCase()) {
            case "fullname":
                errorLocator = fullNameTextFld;
                break;
            case "address":
                errorLocator = addressTextFld;
                break;
            case "city":
                errorLocator = cityTextFld;
                break;
            case "email":
                errorLocator = emailTextFld;
                break;
            case "password":
                errorLocator = passwordTextFld;
                break;
            case "passwordagain":
                errorLocator = passwordAgainTextFld;
                break;

            default:
                throw new IllegalArgumentException("Invalid field name " + fieldName);

        }
        return context.getBot().getValidationMessage(errorLocator);
    }

    public String getAlertErrorMsg() {
        String alertMsg = context.getBot().getAlertMessage();
        context.getBot().acceptAlert();
        return alertMsg;
    }

    public boolean isAlertPresent() {
        try {
            context.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
