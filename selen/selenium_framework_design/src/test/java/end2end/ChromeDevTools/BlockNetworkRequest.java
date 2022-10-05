package end2end.ChromeDevTools;

import com.google.common.collect.ImmutableList;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v103.network.Network;

public class BlockNetworkRequest {

  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();

    DevTools devTools = driver.getDevTools();

    // kreiranje sesije
    devTools.createSession();

    devTools.send(
      Network.enable(Optional.empty(), Optional.empty(), Optional.empty())
    );
    // devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));

    long startTime = System.currentTimeMillis();

    driver.get("https://rahulshettyacademy.com/angularAppdemo/");
    driver.findElement(By.linkText("Browse Products")).click();
    driver.findElement(By.linkText("Selenium")).click();
    driver.findElement(By.cssSelector(".add-to-cart")).click();

    System.out.println(driver.findElement(By.cssSelector("p")).getText());

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime); //da proverimo koliko je brži test sad kad smo blokirali sve slike i CSS
  }
}
