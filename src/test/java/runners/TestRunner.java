package runners;

import static com.mongodb.QueryOperators.AND;
import static io.cucumber.junit.platform.engine.Constants.*;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@IncludeTags("AddDoctor")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "pretty,html:target/cucumber-reports/reports.html, " +
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
@ConfigurationParameter(key = "cucumber.glue", value = "stepDefinitions")
@ConfigurationParameter(key = "cucumber.execution.verbose", value = "true")
public class TestRunner {
}
