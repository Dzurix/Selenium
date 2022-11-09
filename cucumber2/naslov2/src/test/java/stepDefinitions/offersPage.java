package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.pageObjectManager;
import utils_sveStoTrebaZaOdrzavanje.GenericUtils;
import utils_sveStoTrebaZaOdrzavanje.utils;

public class offersPage {

  public WebDriver driver; // napravim ga public, kako bih mogao da ga koristim svuda
  public String landingPageProductName; // isto i sa ovim varijablama
  public String offerPageProductName;
  utils testContextSetup;
  pageObjectManager PageObjectManager;

  public offersPage(utils testContextSetup) {
    this.testContextSetup = testContextSetup;
  } // OVO JE KONSTRUKTOR

  @Then("^user searched for (.+) Shortname in offers page")
  public void user_searched_for_something_shortname_in_offers_page_to_check_if_product_exist_with_same_name(
    String shortName
  ) throws InterruptedException, IOException {
    switchToOffersPage();

    OffersPage offersP = testContextSetup.PageObjectManager.getOffersPage();

    offersP.searchItem(shortName);
    // Thread.sleep(2000);
    offerPageProductName = offersP.getProductName();
  }

  public void switchToOffersPage() throws IOException {
    //checking are we already on offersPage

    if (
      !testContextSetup.testBase
        .WebDriverManager()
        .getCurrentUrl()
        .equalsIgnoreCase(
          "https://rahulshettyacademy.com/seleniumPractise/#/offers"
        )
    ) {
      // PageObjectManager = new pageObjectManager(testContextSetup.driver);
      LandingPage landingP = testContextSetup.PageObjectManager.getLandingPage();

      landingP.selectTopDealsPage();

      testContextSetup.genericUtils.SwithcWindowToChild();
    }
  }

  @Then(
    "^validate product name in offers page matches with product name on landing Page$"
  )
  public void validate_product_name_in_offers_page_matches_with_product_name_on_landing_page() {
    Assert.assertEquals(
      offerPageProductName,
      testContextSetup.landingPageProductName
    );
  }
}
