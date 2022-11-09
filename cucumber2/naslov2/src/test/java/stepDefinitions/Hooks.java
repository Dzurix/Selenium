package stepDefinitions;

import io.cucumber.java.After;
import java.io.IOException;
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
}
