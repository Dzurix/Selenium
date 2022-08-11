package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

  public static void main(String[] args) {
    System.setProperty(
      "webdriver.chrome.driver",
      //  "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
      "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    );
    WebDriver driver = new ChromeDriver();

    driver.get("https://www.amazon.com/");
    Actions a = new Actions(driver); // definisanje klase ACTIONS
    a
      .moveToElement(
        driver.findElement(By.cssSelector("div[id='nav-flyout-accountList']"))
      )
      .build()
      .perform();
  }
}
