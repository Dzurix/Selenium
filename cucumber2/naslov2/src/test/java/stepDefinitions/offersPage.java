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
import utils_sveStoTrebaZaOdrzavanje.utils;

public class offersPage {

  public WebDriver driver; // napravim ga public, kako bih mogao da ga koristim svuda
  public String landingPageProductName; // isto i sa ovim varijablama
  public String offerPageProductName;
  utils testContextSetup;

  public offersPage(utils testContextSetup) {
    this.testContextSetup = testContextSetup;
  } // OVO JE KONSTRUKTOR

  @Then("^user searched for \"([^\"]*)\" Shortname in offers page")
  public void user_searched_for_something_shortname_in_offers_page_to_check_if_product_exist_with_same_name(
    String shortName
  ) throws InterruptedException {
    switchToOffersPage();

    testContextSetup.driver
      .findElement(By.xpath("//input[@type='search']"))
      .sendKeys(shortName);
    Thread.sleep(2000);
    offerPageProductName =
      testContextSetup.driver
        .findElement(By.cssSelector("tr td:nth-child(1)"))
        .getText();
  }

  public void switchToOffersPage() {
    //checking are we already on offersPage

    if (
      !testContextSetup.driver
        .getCurrentUrl()
        .equalsIgnoreCase(
          "https://rahulshettyacademy.com/seleniumPractise/#/offers"
        )
    ) {
      testContextSetup.driver.findElement(By.linkText("Top Deals")).click();

      Set<String> s1 = testContextSetup.driver.getWindowHandles(); // hvatanje Indeksa od otvorenih prozora
      Iterator<String> i1 = s1.iterator(); // kreiram objekat
      String parentWindow = i1.next(); // hvatam indeks [0]
      String childWindow = i1.next();
      testContextSetup.driver.switchTo().window(childWindow); // sad smo na drugom prozoru i sad je ceo fokus na tom prozoru
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
