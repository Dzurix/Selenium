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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils_sveStoTrebaZaOdrzavanje.utils; // ovo je za konstruktor

public class checkoutPage {

  public WebDriver driver; // napravim ga public, kako bih mogao da ga koristim svuda
  public String landingPageProductName; // isto i sa ovim varijablama
  public String offerPageProductName;
  public CheckoutPage checkoutPage;
  utils testContextSetup; //ovako sam izvezao varijablu iz konstruktora i onda ubacujem ispred svakog drivera

  public checkoutPage(utils testContextSetup) {
    this.testContextSetup = testContextSetup;
    this.checkoutPage = testContextSetup.PageObjectManager.getCheckoutPage(); // ovde ubacujem da bi se uvek izvrsio jer je preduslov za sve ove metode
  } // OVO JE KONSTRUKTOR

  @And("^verify user has ability to enter promo code and place the order$")
  public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
    Assert.assertTrue(checkoutPage.VerifyPromoBtn()); //posto ovi metodi vracaju TRUE ili FALSE, moram da dodam asertaciju);
    Assert.assertTrue(checkoutPage.VerifyPlaceOrder()); // pa ako slucajno padne test, da znamo gde je pao
  }

  @Then(
    "^user proceeds to Checkout and validate the (.+) items in checkout page$"
  )
  public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(
    String name
  ) throws InterruptedException {
    checkoutPage.CheckoutItems();
    // Thread.sleep(2000);
  }
}
