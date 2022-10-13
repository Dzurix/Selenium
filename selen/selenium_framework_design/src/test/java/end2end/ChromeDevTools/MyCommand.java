package end2end.ChromeDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class MyCommand {

  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();

    DevTools devTools = driver.getDevTools();

    // kreiranje sesije
    devTools.createSession();

    // kreiranje hashMap

    Map deviceMetrics = new HashMap();
    deviceMetrics.put("width", 600);
    deviceMetrics.put("height", 1000);
    deviceMetrics.put("deviceScaleFactor", 50);
    deviceMetrics.put("mobile", true);

    //kreiranje custom komande da menjam dimenzije browsera (npr mobilni)

    driver.executeCdpCommand(
      "Emulation.setDeviceMetricsOverride",
      deviceMetrics
    );

    driver.get("https://rahulshettyacademy.com/angularAppdemo/");
    driver.findElement(By.cssSelector(".navbar-toggler")).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText("Library")).click();
  }
}
