package pages;

import org.openqa.selenium.By;
import ui.engine.BasePage;
import ui.engine.TestContext;

public class PatientMedicalHistoryPage extends BasePage {
    private TestContext context;
    public PatientMedicalHistoryPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By viewDetailsLink = By.xpath("//a[text()='View Details']");

    public String getPatientMedicalHistoryPageTitle(){
        return context.getBot().getTitle();
    }

    public PatientMedicalHistoryPage clickOnViewDetails(){
        context.getBot().click(viewDetailsLink);
        return this;
    }
}
