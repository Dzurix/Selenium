package utils_sveStoTrebaZaOdrzavanje;

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

    if (driver == null) { //da ne bi stalno pozivali i pokretali driver, stavljamo ovaj uslov
      if (prop.getProperty("browser").equalsIgnoreCase("chrome")) { //ignore case, znaci da nije caseSensitive
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
      } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
      } else {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
      }

      driver.get(url);
    }
    return driver; //ako je driver vec inicijalizovan, jednostavno vrati taj driver
  }
}
