package pages;

import org.openqa.selenium.By;
import ui.engine.BasePage;
import ui.engine.TestContext;

public class PatientChangePasswordPage extends BasePage {
    private TestContext context;

    public PatientChangePasswordPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By patientCurrentPasswordTextFld = By.name("cpass");
    private By patientNewPasswordTextFld = By.name("npass");
    private By patientConfirmPasswordTextFld = By.name("cfpass");
    private By patientSubmitBtn = By.name("submit");
    private By patientChangePasswordSuccessMsgLabel = By.xpath("//p[contains(text(),'Password Changed Successfully !!')]");

    public String getPatientPasswordPageTitle() {
        return context.getBot().getTitle();
    }

    public PatientChangePasswordPage enterPatientChangePasswordDetails(String patientCurrentPassword, String patientNewPassword, String patientConfirmPassword) {
        context.getBot().enterText(patientCurrentPasswordTextFld, patientCurrentPassword)
                .enterText(patientNewPasswordTextFld, patientNewPassword)
                .enterText(patientConfirmPasswordTextFld, patientConfirmPassword)
                .click(patientSubmitBtn);
        context.getDriver().navigate().refresh();
        return this;
    }

    public String getPatientChangePasswordSuccessMsgText() {
        return context.getBot().getText(patientChangePasswordSuccessMsgLabel);
    }
}




