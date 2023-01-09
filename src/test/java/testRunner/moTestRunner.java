package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Features",
        glue = "",
        plugin = {"pretty", "html:target/cucumber-reports.html",
        },
        tags = "@TE001"
                ,
        monochrome = true
)
public class moTestRunner extends AbstractTestNGCucumberTests {


}
