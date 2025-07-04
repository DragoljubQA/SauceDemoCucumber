package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features =
        {"src/test/resources/login.feature", "src/test/resources/cart.feature"},
        glue = {"Steps"})


public class TestRunner extends AbstractTestNGCucumberTests {
}
