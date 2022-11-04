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
}
