package utils_sveStoTrebaZaOdrzavanje;

import io.cucumber.messages.types.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {

  public WebDriver driver;

  public WebDriver WebDriverManager() throws IOException { // OVAKO returnujemo driver za sve POM fajlove koji ga trebaju pa ga saljemo utils.java
    //necemo da koristimo driver u StepDefinitions jer optimizujemo arhitekturu projekta, pa ga oni ni ne trebaju

    FileInputStream fis = new FileInputStream(
      System.getProperty("user.dir") + "/src/test/resources/global.properties"
    );
    Properties prop = new Properties(); // ovo kreiram objekat da bi mogao da koristim global.properties fajl
    prop.load(fis); //loadujem sve stavke iz .properties fajla

    String url = prop.getProperty("QAurl");
    String browser_properties = prop.getProperty("browser");
    String browser_maven = System.getProperty("browser"); // POMOCU OVOG MOGU U TERMINALU DA ZAJADEM KOMANDU DA BIRAM KOJI HOCU BROWSER

    // posto prioritet imaju cucumber opcije, onda moram da dam prioritet MAVEN komandi ovako
    String browser = browser_maven != null ? browser_maven : browser_properties;

    if (driver == null) { //da ne bi stalno pozivali i pokretali driver, stavljamo ovaj uslov
      if (browser.equalsIgnoreCase("chrome")) { //ignore case, znaci da nije caseSensitive
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
      } else if (browser.equalsIgnoreCase("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
      } else {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
      }
      driver
        .manage()
        .timeouts()
        .implicitlyWait(java.time.Duration.ofSeconds(5));
      driver.get(url);
    }
    return driver; //ako je driver vec inicijalizovan, jednostavno vrati taj driver
  }
}
