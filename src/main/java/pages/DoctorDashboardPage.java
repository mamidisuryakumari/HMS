package pages;

import org.aspectj.weaver.ast.Test;
import ui.engine.BasePage;
import ui.engine.TestContext;

public class DoctorDashboardPage extends BasePage {
    private TestContext context;
    public DoctorDashboardPage(TestContext context) {
        super(context);
        this.context = context;
    }

    public String getDoctorDashBoardPageTitle(){
       return context.getBot().getTitle();
    }

}
