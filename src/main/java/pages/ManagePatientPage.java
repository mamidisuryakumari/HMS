package pages;

import ui.engine.BasePage;
import ui.engine.TestContext;

public class ManagePatientPage extends BasePage {
    private TestContext context;
    public ManagePatientPage(TestContext context) {
        super(context);
        this.context = context;
    }

    public String getManagePatientPageTitle(){
        return context.getBot().getTitle();
    }
}
