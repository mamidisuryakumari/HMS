package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

public class ReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Initialize ExtentReports if it is null
    public static ExtentReports getExtent() throws IOException {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "/target/ExtentReport/";
            ExtentSparkReporter spark = new ExtentSparkReporter(new File(path));
            //    spark.loadXMLConfig("/src/test/resourses/extent-config.xml");
            extent = new ExtentReports();
            extent.attachReporter(spark);

        }
        return extent;
    }

    // Get the current test instance, throw an error if the test is not created
    public static ExtentTest getTest() {
        if (test == null) {
            throw new IllegalStateException("Test has not been created. Call createTest() first.");
        }
        return test;
    }

    // Create a new test, ensure ExtentReports is initialized first
    public static ExtentTest createTest(String testName, String[] tags) throws IOException {
        getExtent();  // Ensure that ExtentReports is initialized before creating a test
        test = extent.createTest(testName);

        // Adding tags to the test in the report
        for (String tag : tags) {
            test.assignCategory(tag);  // Assign tags to the ExtentTest instance
        }

        return test;
    }

    // Flush the ExtentReports
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
