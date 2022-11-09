package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

  public WebDriver driver;

  public LandingPage(WebDriver driver) { //kreiram KONSTRUKTOR zbog drivera
    this.driver = driver;
  }

  By search = By.xpath("//input[@type='search']"); // OVO SU PAGE OBJECTS
  By productName = By.cssSelector("h4.product-name");
  private By topDeals = By.linkText("Top Deals"); // kada ih napravimo PRIVATE, nijedna druga klasa ih ne moze modifikovati
  By increment = By.cssSelector("a.increment");
  By addToCart = By.cssSelector(".product-action button");

  public void searchItem(String name) {
    driver.findElement(search).sendKeys(name);
  }

  public void getSearchText() {
    driver.findElement(search).getText();
  }

  public String getProductName() {
    return driver.findElement(productName).getText();
  }

  public void selectTopDealsPage() {
    driver.findElement(topDeals).click();
  }

  public String getTitleLandingPage() {
    return driver.getTitle();
  }

  public void IncrementQuantity(int quantity) {
    int i = quantity - 1; // oduzeli smo jedan, posto je jedan proizvod vec po defaultu podesen na sajtu
    while (i > 0) {
      driver.findElement(increment).click();
      i--; // da klikce dok se i ne smanji
    }
  }

  public void AddToCart() {
    driver.findElement(addToCart).click();
  }
}
