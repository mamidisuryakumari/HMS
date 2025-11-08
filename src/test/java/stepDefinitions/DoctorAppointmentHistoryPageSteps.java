package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.DoctorAppointmentHistoryPage;
import ui.engine.PropertiesManager;
import ui.engine.TestContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class DoctorAppointmentHistoryPageSteps {
    private TestContext context;
    private DoctorAppointmentHistoryPage doctorAppointmentHistoryPage;

    public DoctorAppointmentHistoryPageSteps(TestContext context) {
        this.context = context;
        this.doctorAppointmentHistoryPage = new DoctorAppointmentHistoryPage(context);
    }


    @Then("I should see the doctor appointment history page")
    public void i_should_see_the_doctor_appointment_history_page() {
        try {
            String actualDoctorAppointmentHistoryPageTitle = doctorAppointmentHistoryPage.getDoctorAppointmentHistoryPageTitle();
            String expectedDoctorAppointmentHistoryPageTitle = PropertiesManager.getProperty("doctorAppointmentHistoryPage.title");
            assertEquals(expectedDoctorAppointmentHistoryPageTitle, actualDoctorAppointmentHistoryPageTitle);
            log.info("Doctor appointment history page title is matched");
        } catch (AssertionError ae) {
            log.error("Assertion failed while matching the doctor appointment history page title");
            throw (ae);
        } catch (Exception e) {
            log.error("An exception error occurred while seeing the doctor appointment history page");
            throw e;
        }
    }

    @When("I cancel the appointment")
    public void i_cancel_the_appointment() {
        try {
            doctorAppointmentHistoryPage.cancelPatientAppointment();
            log.info("Patient appointment cancel successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while cancel the appointment");
            throw e;
        }
    }

    @Then("I should see the patient appointment cancel successfully")
    public void i_should_see_the_patient_appointment_cancel_successfully() {
        try {
            String actualAppointmentCancelMsg = doctorAppointmentHistoryPage.getPatientAppointmentCancelMsgText();
            String expectedAppointmentCancelMsg = PropertiesManager.getProperty("appointmentCancelMsg");
            assertEquals(expectedAppointmentCancelMsg,actualAppointmentCancelMsg);
            log.info("Patient appointment cancel message is matched");
        } catch (AssertionError ae) {
            log.error("Assertion failed while matching the patient appointment cancel text");
            throw ae;
        }catch (Exception e) {
            log.error("An exception error occurred while seeing the patient cancel appointment");
            throw e;
        }
    }


}
