package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/java/features",
  glue = "stepDefinitions",
  // tags = "@PlaceOrder", //SAMO OVI TESTOVI SE POKRECU
  monochrome = true,
  plugin = {
    "pretty",
    "html:target/cucumber.html", // ovo je generisanje HTML
    "json:target/cucumber.json", // ovo je JSON file
    "junit:target/cucumber.xml", // ovo koristim za JENKINS
  }
)
public class jUnitTestRunnerTest {}
