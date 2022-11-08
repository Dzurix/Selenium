package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Iterator;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import utils_sveStoTrebaZaOdrzavanje.utils; // ovo je za konstruktor

public class landingPage {

  public WebDriver driver; // napravim ga public, kako bih mogao da ga koristim svuda
  public String landingPageProductName; // isto i sa ovim varijablama
  public String offerPageProductName;
  utils testContextSetup; //ovako sam izvezao varijablu iz konstruktora i onda ubacujem ispred svakog drivera

  public landingPage(utils testContextSetup) {
    this.testContextSetup = testContextSetup;
  } // OVO JE KONSTRUKTOR

  @Given("^user is on GreenKart landing page$")
  public void user_is_on_greenkart_landing_page() {}

  @When(
    "^user searched with Shortname \"([^\"]*)\" and extracted actual name of product$"
  )
  public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(
    String shortName
  ) throws InterruptedException {
    LandingPage landingP = testContextSetup.PageObjectManager.getLandingPage(); //kreiram objekat od klase LangingPage zbog drivera
    landingP.searchItem(shortName);

    Thread.sleep(2000);
    testContextSetup.landingPageProductName =
      landingP.getProductName().split("-")[0].trim(); //Izvlacim rec "Tomato"
    System.out.println(landingPageProductName + " is extracted from Home page");
  }
}
