package end2end.ChromeDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.emulation.Emulation;

public class MobileEmulatorTest {

  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver(); // kada koristim Dev tools, onda samo ChromeDriver ili EdgeDriver

    DevTools devTools = driver.getDevTools();

    // kreiranje sesije
    devTools.createSession();
    //send comands
    devTools.send(
      Emulation.setDeviceMetricsOverride(
        600,
        1000,
        50,
        true,
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty()
      )
    );

    driver.get("https://rahulshettyacademy.com/angularAppdemo/");
    driver.findElement(By.cssSelector(".navbar-toggler")).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText("Library")).click();
  }
}
