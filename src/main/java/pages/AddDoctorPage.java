package pages;

import org.openqa.selenium.By;
import ui.engine.BasePage;
import ui.engine.TestContext;

public class AddDoctorPage extends BasePage {
    private TestContext context;

    public AddDoctorPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By doctorSpecializationTextFld = By.name("Doctorspecialization");
    private By doctorNameTextFld = By.name("docname");
    private By doctorClinicAddressTextFld = By.name("clinicaddress");
    private By doctorConsultancyFeesTextFld = By.name("docfees");
    private By doctorContactNumberTextFld = By.name("doccontact");
    private By doctorEmailTextFld = By.id("docemail");
    private By doctorPasswordTextFld = By.name("npass");
    private By doctorConfirmPasswordFld = By.name("cfpass");
    private By submitBtn = By.id("submit");

    public String getAddDoctorPageTitle() {
        return context.getBot().getTitle();
    }

    public AddDoctorPage enterDoctorDetails(String doctorSpecialization, String doctorName, String doctorClinicAddress, String consutancyFees,
                                            String contactNumber, String doctorEmailId, String doctorPassword, String confirmPassword) {
        context.getBot().selectByVisibleText(doctorSpecializationTextFld, doctorSpecialization)
                .enterText(doctorNameTextFld, doctorName)
                .enterText(doctorClinicAddressTextFld, doctorClinicAddress)
                .enterText(doctorConsultancyFeesTextFld, consutancyFees)
                .enterText(doctorContactNumberTextFld, contactNumber)
                .enterText(doctorEmailTextFld, doctorEmailId)
                .enterText(doctorPasswordTextFld, doctorPassword)
                .enterText(doctorConfirmPasswordFld, doctorPassword)
                .click(submitBtn);
        return this;
    }

    public AddDoctorPage getAddDoctorSuccessMsg() {
        String addDoctorSuccessMsg = context.getBot().getAlertMessage();
        context.setAddDoctorAlertSuccessMsg(addDoctorSuccessMsg);
        context.getBot().acceptAlert();
        return this;
    }
}
