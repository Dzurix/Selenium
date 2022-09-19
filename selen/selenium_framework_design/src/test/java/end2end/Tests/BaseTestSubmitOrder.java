package end2end.Tests;

import end2end.TestComponents.BaseTest;
import end2endPOM.CartPage;
import end2endPOM.CheckoutPage;
import end2endPOM.ConfirmationPage;
import end2endPOM.LandingPage;
import end2endPOM.OrderPage;
import end2endPOM.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.Action;
import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.util.Asserts;
import org.asynchttpclient.exception.PoolAlreadyClosedException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaseTestSubmitOrder extends BaseTest {

  String productName = "ZARA COAT 3";

  @Test(dataProvider = "getData")
  // public void submitOrder(String email, String password, String productName)  //zbog dataProvidera smo ubacili vrstu podataka
  //   throws IOException, InterruptedException {
  public void submitOrder(HashMap<String, String> input)  //primer za HashMap
    throws IOException, InterruptedException {
    // ProductCatalogue productCatalogue = landingPage.loginApplication(
    //   email,
    //   password // zbog dataProvidera ubacujem varijable email i password
    // );

    ProductCatalogue productCatalogue = landingPage.loginApplication(
      input.get("email"),
      input.get("password") // zbog HashMap ubacujem varijable email i password
    );

    // ProductCatalogue productCatalogue = new ProductCatalogue(driver);  OVO SADA NE TREBA JER SMO KREIRALI OBJEKAT U METODU KOD LandingPage klase
    List<WebElement> products = productCatalogue.getProductList();

    // productCatalogue.addProductToCart(productName);
    productCatalogue.addProductToCart(input.get("productName")); // HashMap

    CartPage cartPage = productCatalogue.goToCartPage();

    //Provera sta imamo u korpi

    // Boolean match = cartPage.VerifyProductDisplay(productName);
    Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));

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

  //Verifikacija da se ZARA COAT 3 prikazuje na ORDERS stranici
  @Test(dependsOnMethods = { "submitOrder" }) //ovaj ce se uvek izvrsiti posle onog kojeg definisemo u zagradi
  public void OrderHistoryTest() {
    ProductCatalogue productCatalogue = landingPage.loginApplication(
      "anshika@gmail.com",
      "Iamking@000"
    );

    OrderPage orderPage = productCatalogue.goToOrderPage();
    Assert.assertTrue(orderPage.VerifyOrdersDisplay(productName));
  }

  //Extent reports

  //Data provider

  //        PRVI nacin

  // @DataProvider
  // public Object[][] getData() {
  //   return new Object[][] {
  //     { "anshika@gmail.com", "Iamking@000", "ZARA COAT 3" },
  //     { "shetty@gmail.com", "Iamking@000", "ADIDAS ORIGINAL" },
  //   };
  // }

  //          DRUGI nacin

  // @DataProvider //preko hashMap-a
  // public Object[][] getData() {
  //   HashMap<String, String> map = new HashMap<String, String>();
  //   map.put("email", "anshika@gmail.com");
  //   map.put("password", "Iamking@000");
  //   map.put("productName", "ZARA COAT 3");

  //   HashMap<String, String> map1 = new HashMap<String, String>();
  //   map1.put("email", "shetty@gmail.com");
  //   map1.put("password", "Iamking@000");
  //   map1.put("productName", "ADIDAS ORIGINAL");

  // return new Object[][] { { map }, { map1 } };}

  //          TRECI nacin

  @DataProvider
  public Object[][] getData() throws IOException {
    List<HashMap<String, String>> data = getJSONdataToMap(
      System.getProperty("user.dir") +
      "//src//test//java//end2end//podaci//podaciJSON.json"
    );

    return new Object[][] { { data.get(0) }, { data.get(1) } };
  }
}
