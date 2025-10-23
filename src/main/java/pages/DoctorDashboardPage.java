package pages;

import org.aspectj.weaver.ast.Test;
import org.openqa.selenium.By;
import ui.engine.BasePage;
import ui.engine.TestContext;

public class DoctorDashboardPage extends BasePage {
    private TestContext context;

    public DoctorDashboardPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By patientMenu = By.xpath("//span[text()=' Patients ']");
    private By addPatientMenu = By.xpath("//span[text()=' Add Patient']");

    public String getDoctorDashBoardPageTitle() {
        return context.getBot().getTitle();
    }

    public AddPatientPage navigateToAddPatientPage() {
        context.getBot().click(patientMenu)
                .click(addPatientMenu);
        return new AddPatientPage(context);
    }

}
