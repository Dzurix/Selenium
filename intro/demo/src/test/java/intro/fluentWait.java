package intro;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fluentWait {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty(
      "webdriver.chrome.driver",
      //  "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
      "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    );
    WebDriver driver = new ChromeDriver(); //uvek pisem WebDriver

    driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    driver.findElement(By.tagName("button")).click();

    // ovo je primer kada cekamo da se neki element pojavi

    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
      .withTimeout(Duration.ofSeconds(30))
      .pollingEvery(Duration.ofSeconds(3))
      .ignoring(NoSuchElementException.class); //definisanje FLUENT WAIT-a

    WebElement poruka = wait.until(
      new Function<WebDriver, WebElement>() {
        public WebElement apply(WebDriver driver) {
          if (driver.findElement(By.id("finish")).isDisplayed()) {
            return driver.findElement(By.id("finish"));
          } else {
            return null; //sa 'NULL' varamo i produzavamo vreme dok se WebElement ne pojavi
          }
        }
      }
    );

    System.out.println(driver.findElement(By.id("finish")).getText());
  }
}
