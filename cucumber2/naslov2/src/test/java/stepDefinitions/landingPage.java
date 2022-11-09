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
  public LandingPage landingP;
  utils testContextSetup; //ovako sam izvezao varijablu iz konstruktora i onda ubacujem ispred svakog drivera

  public landingPage(utils testContextSetup) {
    this.testContextSetup = testContextSetup;
    this.landingP = testContextSetup.PageObjectManager.getLandingPage(); // ovde kreiram objekat od klase LangingPage zbog drivera jer ga svi koriste
  } // OVO JE KONSTRUKTOR

  @Given("^user is on GreenKart landing page$")
  public void user_is_on_greenkart_landing_page() {
    Assert.assertTrue(landingP.getTitleLandingPage().contains("GreenKart"));
  }

  @When(
    "^user searched with Shortname (.+) and extracted actual name of product$"
  )
  public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(
    String shortName
  ) throws InterruptedException {
    landingP.searchItem(shortName);

    // Thread.sleep(2000);
    testContextSetup.landingPageProductName =
      landingP.getProductName().split("-")[0].trim(); //Izvlacim rec "Tomato"
    System.out.println(landingPageProductName + " is extracted from Home page");
  }

  @And("^added \"([^\"]*)\" items of the selected product to cart$")
  public void added_something_items_of_the_selected_product_to_cart(
    String quantity
  ) {
    landingP.IncrementQuantity(Integer.parseInt(quantity));
    landingP.AddToCart();
  }
}
