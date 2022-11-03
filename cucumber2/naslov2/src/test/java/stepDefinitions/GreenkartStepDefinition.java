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

public class GreenkartStepDefinition {

  public WebDriver driver; // napravim ga public, kako bih mogao da ga koristim svuda
  public String landingPageProductName; // isto i sa ovim varijablama
  public String offerPageProductName;

  @Given("^user is on GreenKart landing page$")
  public void user_is_on_greenkart_landing_page() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
  }

  @When(
    "^user searched with Shortname \"([^\"]*)\" and extracted actual name of product$"
  )
  public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(
    String shortName
  ) throws InterruptedException {
    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
    Thread.sleep(2000);
    landingPageProductName =
      driver
        .findElement(By.cssSelector("h4.product-name"))
        .getText()
        .split("-")[0].trim(); //Izvlacim rec "Tomato"
    System.out.println(landingPageProductName + " is extracted from Home page");
  }

  @Then("^user searched for \"([^\"]*)\" Shortname in offers page")
  public void user_searched_for_something_shortname_in_offers_page_to_check_if_product_exist_with_same_name(
    String shortName
  ) throws InterruptedException {
    driver.findElement(By.linkText("Top Deals")).click();

    Set<String> s1 = driver.getWindowHandles(); // hvatanje Indeksa od otvorenih prozora
    Iterator<String> i1 = s1.iterator(); // kreiram objekat
    String parentWindow = i1.next(); // hvatam indeks [0]
    String childWindow = i1.next();
    driver.switchTo().window(childWindow); // sad smo na drugom prozoru i sad je ceo fokus na tom prozoru
    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
    Thread.sleep(2000);
    offerPageProductName =
      driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
  }

  @Then(
    "^validate product name in offers page matches with product name on landing Page$"
  )
  public void validate_product_name_in_offers_page_matches_with_product_name_on_landing_page() {
    Assert.assertEquals(offerPageProductName, landingPageProductName);
  }
}
