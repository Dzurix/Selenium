package end2end.TestComponents;

import end2endPOM.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

  public WebDriver driver;

  public WebDriver initializeDriver() throws IOException {
    // U JAVI postoji jedna PROPERTIES klasa koja cita GLOBALNE properties koje mi definisemo
    Properties prop = new Properties();
    FileInputStream fis = new FileInputStream(
      System.getProperty("user.dir") + //user.dir je dinamicko, jer nije svakom korisniku isto
      "//src//main//java//Resources//GlobalData.properties"
    );

    prop.load(fis);
    String browserName = prop.getProperty("browser");

    if (browserName.equalsIgnoreCase("chrome")) {
      WebDriverManager.chromedriver().setup(); //umemsto lokacije u pom.XML importujemo WebDriverManager
      driver = new ChromeDriver();
    } else if (browserName.equalsIgnoreCase("firefox")) {
      WebDriverManager.firefoxdriver().setup(); //umemsto lokacije u pom.XML importujemo WebDriverManager
      driver = new FirefoxDriver();
    } else if (browserName.equalsIgnoreCase("edge")) {
      WebDriverManager.edgedriver().setup(); //umemsto lokacije u pom.XML importujemo WebDriverManager
      driver = new EdgeDriver();
    }

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driver;
  }

  public LandingPage launchApplication() throws IOException {
    driver = initializeDriver();
    LandingPage landingPage = new LandingPage(driver);
    landingPage.goTo();
    return landingPage;
  }
}
