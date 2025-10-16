package pages;

import ui.engine.BasePage;
import ui.engine.TestContext;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Slf4j
public class PatientAppointmentHistoryPage extends BasePage {
    private TestContext context;

    public PatientAppointmentHistoryPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By statusListFld = By.xpath("//table[@id='sample-table-1']//tr/td[7]");
    private By cancelLink = By.xpath("//table[@id='sample-table-1']//tr/td[8]");

    public String getPatientAppointmentHistoryPageTitle() {
        return context.getBot().getTitle();
    }

    public PatientAppointmentHistoryPage verifyAppointmentStatus() {
        List<WebElement> statusList = context.getDriver().findElements(statusListFld);
        for (WebElement status : statusList) {
            String actualStatus = status.getText().trim();
            context.setPatientAppointmentStatus(actualStatus);
        }
        return this;
    }

    public PatientAppointmentHistoryPage cancelAppointment() {
        List<WebElement> cancelList = context.getDriver().findElements(cancelLink);
        int totalAppointments = cancelList.size();
        for(int i=0;i<totalAppointments;i++){
            cancelList = context.getDriver().findElements(cancelLink);
            WebElement cancel = cancelList.get(i);
         String cancelText =  cancel.getText().trim();
         if(cancelText.equalsIgnoreCase("Cancel")){
            cancel.click();
            context.getBot().acceptAlert();
            break;
         }
        }
        return this;
    }

}

