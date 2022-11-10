package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "@target/failed_scenarios.txt", //OVDE NAGLASIM GDE SE NALAZI SCENARIO KOJI JE PAO
  glue = "stepDefinitions",
  // tags = "@PlaceOrder", //SAMO OVI TESTOVI SE POKRECU
  // tags = "@PlaceOrder or @OffersPage", // ILI ovi ILI ovi se pokrecu, ako ima oba onda se oba pokrecu
  monochrome = true,
  plugin = {
    "pretty",
    "html:target/cucumber.html", // ovo je generisanje HTML
    "json:target/cucumber.json", // ovo je JSON file
    "junit:target/cucumber.xml", // ovo koristim za JENKINS
    //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", //ovo je za extent report
    //"rerun:target/failed_scenarios.txt", // ovo je da prvo kreira spisak scenarija koji su pali
  }
)
public class failedTestRunnerTest {}
