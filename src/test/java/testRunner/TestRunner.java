package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features/", //Path of feature file
                 glue = "stepDefinitions", // Package name for step definitions
//                 dryRun = true, // Let the user know if the step-definition exists for each step in a feature file.
                 monochrome = true, // If set to true, console output for the Cucumber test are much more readable
                 tags = ("@sanity and @regression"), // Helps in grouping the scenarios
                 plugin = {"pretty","html:target/test-output.html"} // To Generate Test Report
                )
public class TestRunner {

}
