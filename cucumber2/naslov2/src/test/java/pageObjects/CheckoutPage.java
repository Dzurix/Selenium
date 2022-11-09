package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

  public WebDriver driver;

  public CheckoutPage(WebDriver driver) { //kreiram KONSTRUKTOR zbog drivera
    this.driver = driver;
  }

  By cartBag = By.cssSelector("[alt='Cart']");
  By checkOutButton = By.xpath(
    "//button[contains(text(),'PROCEED TO CHECKOUT')]"
  );
  By promoBtn = By.cssSelector(".promoBtn");
  By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

  public void CheckoutItems() {
    driver.findElement(cartBag).click();
    driver.findElement(checkOutButton).click();
  }

  public Boolean VerifyPromoBtn() {
    return driver.findElement(promoBtn).isDisplayed(); //posto ovo returnuje TRUE ili FALSE, moram da promenim type metoda u BOOLEAN
  }

  public Boolean VerifyPlaceOrder() {
    return driver.findElement(placeOrder).isDisplayed();
  }
}
