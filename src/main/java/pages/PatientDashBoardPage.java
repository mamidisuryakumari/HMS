package pages;

import ui.engine.BasePage;
import ui.engine.TestContext;
import org.openqa.selenium.By;

public class PatientDashBoardPage extends BasePage {
    private TestContext context;

    public PatientDashBoardPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By bookAppointmentMenu = By.xpath("//span[text()=' Book Appointment ']");
    private By appointmentHistoryMenu = By.xpath("//span[text()=' Appointment History ']");
    private By patientProfileImage = By.xpath("//img[@src='assets/images/images.jpg']");
    private By patientLogoutBtn = By.xpath("//a[normalize-space(text())='Log Out']");
    private By medicalHistoryMenu = By.xpath("//span[text()=' Medical History ']");
    private By patientMyProfileLink = By.xpath("//a[normalize-space(text())='My Profile']");
    private By patientChangePasswordLink = By.xpath("//a[normalize-space(text())='Change Password']");


    public String getPatientDashBoardPageTitle() {
        return context.getBot().getTitle();
    }

    public PatientBookAppointmentPage navigateToPatientBookAppointmentPage() {
        context.getBot().click(bookAppointmentMenu);
        return new PatientBookAppointmentPage(context);
    }

    public PatientAppointmentHistoryPage navigateToPatienAppointmentHistoryPage() {
        context.getBot().click(appointmentHistoryMenu);
        return new PatientAppointmentHistoryPage(context);
    }

    public PatientDashBoardPage clickOnPatientProfileImage() {
        context.getBot().click(patientProfileImage);
        return this;
    }

    public PatientDashBoardPage clickOnPatientLogoutBtn() {
        context.getBot().click(patientLogoutBtn);
        return this;
    }

    public PatientMedicalHistoryPage clickOnMedicalHistoryMenu() {
        context.getBot().click(medicalHistoryMenu);
        return new PatientMedicalHistoryPage(context);
    }

    public PatientProfilePage navigateToPatientProfilePage() {
        context.getBot().click(patientProfileImage)
                .click(patientMyProfileLink);
        return new PatientProfilePage(context);
    }

    public PatientChangePasswordPage navigateToPatientChangePasswordPage() {
        context.getBot().click(patientProfileImage).click(patientChangePasswordLink);
        return new PatientChangePasswordPage(context);
    }


}
