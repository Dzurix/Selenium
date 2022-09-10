package AbstractComponents;

import end2endPOM.CartPage;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

  WebDriver driver;

  public AbstractComponent(WebDriver driver) {
    this.driver = driver; //ovako dajemo zivot driver-u
    PageFactory.initElements(driver, this);
  }

  public void waitForElementToAppear(By findBy) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
  }

  @FindBy(css = "[routerlink='/dashboard/cart']")
  WebElement cartHeader;

  public CartPage goToCartPage() {
    cartHeader.click();
    CartPage cartPage = new CartPage(driver);
    return cartPage;
  }

  public void waitForElementToDisappear(WebElement elem) {
    //Thread.sleep(1000);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    //cekamo da se skloni ona animacija nakon narucivanja proizvoda
    wait.until(ExpectedConditions.invisibilityOf(elem)); //kad koristimo INVISIBILITY, onda treba cela putanja sa driver.....
  }
}
