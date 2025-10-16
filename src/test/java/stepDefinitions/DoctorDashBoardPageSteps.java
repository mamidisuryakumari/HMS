package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.DoctorDashboardPage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

public class DoctorDashBoardPageSteps {
    private TestContext context;
    private DoctorDashboardPage doctorDashboardPage;
    public DoctorDashBoardPageSteps(TestContext context){
       this.context = context;
       this.doctorDashboardPage = new DoctorDashboardPage(context);
    }

    @Then("I should be navigated to the doctor dashboard page")
    public void iShouldBeNavigatedToTheDoctorDashboardPage(){
        try{
String actualDoctorDashboardPageTitle = doctorDashboardPage.getDoctorDashBoardPageTitle();
String expectedDoctorDashboardPageTitle = PropertiesManager.getProperty("doctorDashBoardPage.title");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
