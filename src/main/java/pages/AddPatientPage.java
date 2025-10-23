package pages;

import org.openqa.selenium.By;
import ui.engine.BasePage;
import ui.engine.TestContext;

public class AddPatientPage extends BasePage {
    private TestContext context;

    public AddPatientPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By patientNameTextFld = By.name("patname");
    private By patientContactNumberTextFld = By.name("patcontact");
    private By patientEmailIdTextFld = By.name("patemail");
    private By patientAddressTextFld = By.name("pataddress");
    private By patientAgeTextFld = By.name("patage");
    private By patientMedicalHistoryTextFld = By.name("medhis");
    private By addBtn = By.name("submit");
    private By femaleRadioBtn = By.xpath("//label[@for='rg-female']");

    public String getAddPatientPageTitle() {
        return context.getBot().getTitle();
    }

    public AddPatientPage enterAddPatientDetails(String patientName, String patientConcatNumber, String patientEmailId,
                                       String patientAddress, String patientAge, String medicalHistory) {
        context.getBot().enterText(patientNameTextFld, patientName)
                .enterText(patientContactNumberTextFld, patientConcatNumber)
                .enterText(patientEmailIdTextFld, patientEmailId)
                .jsClick(femaleRadioBtn).enterText(patientAddressTextFld, patientAddress)
                .enterText(patientAgeTextFld, patientAge)
                .enterText(patientMedicalHistoryTextFld, medicalHistory)
                .click(addBtn);
        return this;
    }

    public ManagePatientPage getAddPatientSuccessMsg(){
       String addPatientSuccessMsg =  context.getBot().getAlertMessage();
        context.setAddPatientAlertSuccessMsg(addPatientSuccessMsg);
        context.getBot().acceptAlert();
        return new ManagePatientPage(context);
    }

}
