package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils_sveStoTrebaZaOdrzavanje.utils;

public class Hooks {

  public utils testContextSetup;

  public Hooks(utils testContextSetup) { //kreiranje konstruktora preko dependency injection
    this.testContextSetup = testContextSetup;
  }

  @After
  public void AfterScenario() throws IOException {
    testContextSetup.testBase.WebDriverManager().quit(); //izlazimo iz browsera
  }

  @AfterStep
  public void AddScreenShoot(Scenario scenario) throws IOException {
    WebDriver driver = testContextSetup.testBase.WebDriverManager(); //ovde sam definisao 'driver'
    if (scenario.isFailed()) {
      File sourcePath =
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
      scenario.attach(fileContent, "image/png", "failedStep");
    }
  }
}
