package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddDoctorPage;
import pages.AdminDashboardPage;
import ui.engine.TestContext;

public class AddDoctorPageSteps {
    private TestContext context;
    private AdminDashboardPage adminDashboardPage;
    private AddDoctorPage addDoctorPage;
    public AddDoctorPageSteps(TestContext context){
        this.context = context;
        this.addDoctorPage = new AddDoctorPage(context);
    }

    @When("I navigate to the admin add doctor page")
    public void iNavigateToTheAdminAddDoctorPage(){
try{

} catch (Exception e) {
    throw new RuntimeException(e);
}
    }

    @Then("I should see the admin add doctor page")
    public void iShouldSeeTheAdminAddDoctorPage(){

    }

    @When("I enter the following doctor details")
    public void iEnterTheFollowingDoctorDetails(DataTable dataTable){

    }

    @Then("I should see a doctor add success message as Doctor info added Successfully")
    public void iShouldSeeSuccessMessage(){

    }
}
