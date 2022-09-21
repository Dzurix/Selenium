package end2end.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

//postavke za cucumber
@CucumberOptions(
  features = "src/test/java/end2end/cucumber",
  glue = "end2end.stepDefinitions",
  monochrome = true,
  tags = "@Regression",
  plugin = { "html:target/cucumber.html" }
)
// AbstractTestNGCucumberTests ovo mora ako koristim TestNG
@Test
public class TestNGTestRunner extends AbstractTestNGCucumberTests {}
