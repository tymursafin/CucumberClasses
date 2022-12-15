package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "@target/failed.txt",
        glue = "steps",
        //to remove irrelevant information from console, you need to set monochrome to true
        monochrome = true,
        //pretty keywords prints the steps in the console to increase readability
        plugin = {"pretty"}
)

public class FailedRunner {
}
