package end2end.stepDefinitions;

import end2end.TestComponents.BaseTest;
import end2endPOM.CartPage;
import end2endPOM.CheckoutPage;
import end2endPOM.ConfirmationPage;
import end2endPOM.LandingPage;
import end2endPOM.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class StepDefinitionImpl extends BaseTest {

  public LandingPage landingPage;
  public ProductCatalogue productCatalogue;
  public CartPage cartPage;
  public CheckoutPage checkoutPage;
  public ConfirmationPage confirmationPage;

  @Given("I landed on Ecommerce Page")
  public void I_landed_on_Ecommerce_Page() throws IOException {
    launchApplication();
  }

  // @Given ("Logged in with username <name> and password <password>")
  @Given("^Logged in with username (.+) and password (.+)$") //ne mogu koristiti parametre iz .feature fajla vec samo ' (.+) '
  // a na pocetku stavljam ^ i na kraju $
  public void logged_in_with_username_and_password(
    String username,
    String password
  ) {
    productCatalogue = landingPage.loginApplication(username, password);
  }

  @When("^I add product (.+) to Cart$")
  public void i_add_product_to_Cart(String productName)
    throws InterruptedException {
    List<WebElement> products = productCatalogue.getProductList();

    productCatalogue.addProductToCart(productName);
  }

  @And("^Checkout (.+) and submit the order$")
  public void checkout_and_submit_the_order(String productName) {
    cartPage = productCatalogue.goToCartPage();

    //Provera sta imamo u korpi

    Boolean match = cartPage.VerifyProductDisplay(productName);

    Assert.assertTrue(match);
    // Odlazak na checkout
    checkoutPage = cartPage.goToCheckout();
    checkoutPage.selectCountry("Yugo");
    confirmationPage = checkoutPage.submitOrder();
  }

  @Then("{string} message is displayed on ConfirmationPage")
  //ovako zamenjujemo iz stepDefinitionsa
  public void message_is_displayed_on_confirmationPage(String string) {
    String confirmMessage = confirmationPage.getConfirmationMessage();

    Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
  }

  @Then("^\"([^\"]*)\" message is displayed$")
  public void something_message_is_displayed(String strArg1) throws Throwable {
    Assert.assertEquals(strArg1, landingPage.getErrorMessage());
  }
}
