package pages;

import org.openqa.selenium.By;
import ui.engine.BasePage;
import ui.engine.TestContext;

public class AdminManageDoctorPage extends BasePage {
    private TestContext context;

    public AdminManageDoctorPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By deleteFld = By.xpath("//i[@class='fa fa-times fa fa-white']");
    private By doctorDeleteMsgLabel = By.xpath("//p[normalize-space(text())='data deleted !!']");

    public String getAdminManageDoctorPageTitle() {
        return context.getBot().getTitle();
    }

    public AdminManageDoctorPage deleteDoctor() {
        context.getBot().click(deleteFld)
                .acceptAlert();
        return this;
    }

    public String getDoctorDeletedSuccessmsg(){
       return context.getBot().getText(doctorDeleteMsgLabel);
    }


}
