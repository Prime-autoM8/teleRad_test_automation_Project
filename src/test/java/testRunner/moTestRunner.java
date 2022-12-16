package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Features",
        glue = "",
        plugin = {"pretty", "html:target/cucumber-reports.html",
        },
        tags = "@TE0019" +
                "",
        monochrome = true
)
public class moTestRunner {


}
