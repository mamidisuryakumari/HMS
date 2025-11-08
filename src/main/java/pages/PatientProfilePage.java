package pages;

import org.openqa.selenium.By;
import ui.engine.BasePage;
import ui.engine.TestContext;

public class PatientProfilePage extends BasePage {
    private TestContext context;

    public PatientProfilePage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By patientAddressTextFld = By.name("address");
    private By patientCityTextFld = By.name("city");
    private By patientProfileUpdateSuccessMsgLabel = By.xpath("//h5[contains(text(),'Your Profile updated Successfully')]");
    private By patientUpdateBtn = By.name("submit");

    public String getPatientProfilePageTitle() {
        return context.getBot().getTitle();
    }

    public void updatePatientProfileDetails(String patientAddress) {
        context.getBot().enterText(patientAddressTextFld, patientAddress)
                .click(patientUpdateBtn);
    }

    public String getPatientProfileUpdateSuccessMsg() {
        return context.getBot().getText(patientProfileUpdateSuccessMsgLabel);
    }

}
