package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.engine.BasePage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import java.util.List;

public class DoctorAppointmentHistoryPage extends BasePage {
    private TestContext context;

    public DoctorAppointmentHistoryPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By allPatientNamest = By.xpath("//table[@id='sample-table-1']/tbody/tr/td[2]");
    private By patientCancelBtn = By.xpath("//a[text()='Cancel']");
    private By patientAppointmentCancelMsg = By.xpath("//p[normalize-space(text())='Appointment canceled !!']");

    public String getPatientAppointmentCancelMsgText(){
       return context.getBot().getText(patientAppointmentCancelMsg);
    }
    public String getDoctorAppointmentHistoryPageTitle() {
        return context.getBot().getTitle();
    }

    public DoctorAppointmentHistoryPage cancelPatientAppointment() {
        List<WebElement> allPatientNames = context.getDriver().findElements(allPatientNamest);
        String patientName = PropertiesManager.getProperty("cancelPatientName").trim();
        for (WebElement name : allPatientNames) {
            String actualName = name.getText().trim();
            if (actualName.equalsIgnoreCase(patientName)) {
                context.getBot().click(patientCancelBtn);
                break;
            }
        }
        context.getBot().acceptAlert();
        return this;
    }

}
