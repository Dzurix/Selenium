package end2end.Tests;

import end2end.TestComponents.BaseTest;
import end2endPOM.CartPage;
import end2endPOM.CheckoutPage;
import end2endPOM.ConfirmationPage;
import end2endPOM.LandingPage;
import end2endPOM.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.Action;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTestSubmitOrder extends BaseTest {

  @Test
  public void submitOrder() throws IOException, InterruptedException {
    String productName = "ZARA COAT 3";

    LandingPage landingPage = launchApplication();

    ProductCatalogue productCatalogue = landingPage.loginApplication(
      "anshika@gmail.com",
      "Iamking@000"
    );

    // ProductCatalogue productCatalogue = new ProductCatalogue(driver);  OVO SADA NE TREBA JER SMO KREIRALI OBJEKAT U METODU KOD LandingPage klase
    List<WebElement> products = productCatalogue.getProductList();

    productCatalogue.addProductToCart(productName);

    CartPage cartPage = productCatalogue.goToCartPage();

    //Provera sta imamo u korpi

    Boolean match = cartPage.VerifyProductDisplay(productName);

    Assert.assertTrue(match);
    // Odlazak na checkout
    CheckoutPage checkoutPage = cartPage.goToCheckout();

    checkoutPage.selectCountry("Yugo");
    ConfirmationPage confirmationPage = checkoutPage.submitOrder();

    String confirmMessage = confirmationPage.getConfirmationMessage();

    Assert.assertTrue(
      confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER.")
    );
  }
}
