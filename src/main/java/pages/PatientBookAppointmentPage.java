package pages;

import ui.engine.BasePage;
import ui.engine.TestContext;
import org.openqa.selenium.By;

public class PatientBookAppointmentPage extends BasePage {
    private TestContext context;

    public PatientBookAppointmentPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By doctorSpecializationDropdownFld = By.name("Doctorspecialization");
    private By selectDoctorDropdownFld = By.xpath("//select[@id='doctor']");
    private By dateFld = By.name("appdate");
    private By timeFld = By.id("timepicker1");
    private By submitBtn = By.name("submit");


    public String getPatientBookAppointmentPageTitle() {
        return context.getBot().getTitle();
    }

    public PatientBookAppointmentPage enterBookAppointmentDetails(String specialization, String doctorName, String date, String time) {
        context.getBot().selectByValue(doctorSpecializationDropdownFld, specialization)
                .selectByVisibleText(selectDoctorDropdownFld, doctorName)
                .enterText(dateFld, date)
                .pressTabUsingActions(dateFld)
                .jsSendKeys(timeFld, time)
                //  .pressTabUsingActions(timeFld)
                .click(submitBtn);
        return this;
    }


    public PatientBookAppointmentPage getPatientBookAppointmentSuccessMessage() {
        String patientBookAppointment = context.getBot().getAlertMessage();
        context.setActualPatientBookAppointmentSuccessMsg(patientBookAppointment);
        context.getBot().acceptAlert();
        return this;
    }

}
