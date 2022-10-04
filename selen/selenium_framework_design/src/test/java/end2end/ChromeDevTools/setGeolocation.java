package end2end.ChromeDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class setGeolocation {

  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();

    DevTools devTools = driver.getDevTools();

    devTools.createSession();

    Map<String, Object> coordinates = new HashMap<String, Object>();
    coordinates.put("latitude", 40);
    coordinates.put("longitude", 3);
    coordinates.put("accuracy", 1);

    driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

    driver.get("https://www.google.com");
    driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
  }
}
