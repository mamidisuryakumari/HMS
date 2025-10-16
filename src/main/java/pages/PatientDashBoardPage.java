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


}
