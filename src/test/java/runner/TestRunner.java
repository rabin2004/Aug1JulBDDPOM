package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\User\\Desktop\\eclipse\\Aug1JulBDDPOM\\src\\main\\java\\features",
				 glue = "step_definitions",
				 plugin = {"pretty", "html:target/DemoTours-reports"},
				 monochrome = true)

public class TestRunner {

}
