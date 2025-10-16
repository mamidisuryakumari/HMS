package pages;

import org.openqa.selenium.By;
import ui.engine.BasePage;
import ui.engine.TestContext;

public class AdminDashboardPage extends BasePage {
    private TestContext context;

    public AdminDashboardPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private By doctorMenu = By.xpath("//span[normalize-space(text())='Doctors']");
    private By addDoctorMenu = By.xpath("//span[normalize-space(text())='Add Doctor']");

    public String getAdminDashBoardPageTitle() {
        return context.getBot().getTitle();
    }

    public AddDoctorPage navigateToAddDoctorPage() {
        context.getBot().click(doctorMenu)
                .click(addDoctorMenu);
        return new AddDoctorPage(context);
    }

}
