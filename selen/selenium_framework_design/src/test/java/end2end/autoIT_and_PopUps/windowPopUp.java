package end2end.autoIT_and_PopUps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowPopUp {

  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();

    // sintaksa URL za basic auth je http://Username:Password@SiteURL
    driver.get("https://admin:admin@the-internet.herokuapp.com/");
    driver.findElement(By.linkText("Basic Auth")).click();
  }
}
