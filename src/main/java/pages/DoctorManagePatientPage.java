package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.engine.BasePage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import java.util.List;

@Slf4j
public class DoctorManagePatientPage extends BasePage {
    private TestContext context;

    public DoctorManagePatientPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By patientBloodPressureTextFld = By.name("bp");
    private By patientBloodSugarTextFld = By.name("bs");
    private By patientWeightTextFld = By.name("weight");
    private By patientBodyTemperatureTextFld = By.name("temp");
    private By prescriptionTextFld = By.name("pres");
    private By submitBtn = By.xpath("//button[text()='Submit']");
    private By viewDetailsBtn = By.xpath("//a[text()='View Details']");
    private By addMedicalHistoryBtn = By.xpath("//button[text()='Add Medical History']");

    private By allPatientNames = By.xpath("//table/tbody/tr/td[2]");

    public String getManagePatientPageTitle() {
        String title = context.getBot().getTitle();
        context.setManagePatientPageTitle(title);
        return title;
    }

    public DoctorManagePatientPage getSuccessPatientMedicalMessage() {
        String actualSuccessMessage = context.getBot().getAlertMessage();
        context.setAddPatientMedicalSuccessMsg(actualSuccessMessage);
        context.getBot().acceptAlert();
        return this;
    }

    public DoctorManagePatientPage enterPatientMedicalDetails(String bloodPressure,
                                                              String bloodSugar, String patientWeight,
                                                              String patientBodyTemperature, String prescription) {


        context.getBot().enterText(patientBloodPressureTextFld, bloodPressure)
                .enterText(patientBodyTemperatureTextFld, patientBodyTemperature)
                .enterText(patientBloodSugarTextFld, bloodSugar)
                .enterText(patientWeightTextFld, patientWeight)
                .enterText(prescriptionTextFld, prescription)
                .jsClick(submitBtn);
        return this;
    }

    public DoctorManagePatientPage managePatients() {
        List<WebElement> allPatientNames = context.getDriver().findElements(By.xpath("//table/tbody/tr/td[2]"));
        String patientName = PropertiesManager.getProperty("patientName").trim();
        for (WebElement name : allPatientNames) {
            String actualName = name.getText().trim();
           // System.out.println(actualName);
            if (actualName.equalsIgnoreCase(patientName)){
               context.getBot().click(viewDetailsBtn);
                break;
            }
        }


       context.getBot().switchToWindowByTitle(context.getManagePatientPageTitle());
        context.getBot().jsClick(addMedicalHistoryBtn);
        return this;


    }

}



