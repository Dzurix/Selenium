package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

  public WebDriver driver;

  public OffersPage(WebDriver driver) { //kreiram KONSTRUKTOR zbog drivera
    this.driver = driver;
  }

  private By search = By.xpath("//input[@type='search']"); // OVO SU PAGE OBJECTS
  private By productName = By.cssSelector("tr td:nth-child(1)"); // kada ih napravimo PRIVATE, nijedna druga klasa ih ne moze modifikovati

  public void searchItem(String name) {
    driver.findElement(search).sendKeys(name);
  }

  public void getSearchText() {
    driver.findElement(search).getText();
  }

  public String getProductName() {
    return driver.findElement(productName).getText();
  }
}
