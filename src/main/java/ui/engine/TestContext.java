package ui.engine;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class TestContext {

    private WebDriver driver;
    private Bot bot;

    private String patientEmail;
    private String patientPassword;

    private String actualUserRegistrationSuccessMsg;
    private String actualPatientBookAppointmentSuccessMsg;
    private String patientAppointmentStatus;
    private String addDoctorAlertSuccessMsg;
}
