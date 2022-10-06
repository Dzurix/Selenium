package end2end.ChromeDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.sql.Connection;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.network.Network;
import org.openqa.selenium.devtools.v102.network.model.ConnectionType;

public class NetworkSpeed {

  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();

    DevTools devTools = driver.getDevTools();

    // kreiranje sesije
    devTools.createSession();

    devTools.send(
      Network.enable(Optional.empty(), Optional.empty(), Optional.empty())
    );

    devTools.send(
      Network.emulateNetworkConditions(
        false,
        3000,
        20000,
        10000,
        Optional.of(ConnectionType.ETHERNET)
      )
    );

    //iskljucujemo internet
    devTools.addListener(
      Network.loadingFailed(),
      loadingFailed -> {
        System.out.println(loadingFailed.getErrorText());
        System.out.println(loadingFailed.getTimestamp());
      }
    );

    long startTime = System.currentTimeMillis();

    driver.get("https://www.google.com");
    driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);

    long endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime); //da proverimo koliko je sporiji test
  }
}
