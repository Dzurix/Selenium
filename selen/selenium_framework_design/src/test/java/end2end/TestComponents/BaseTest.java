package end2end.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import end2endPOM.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  public WebDriver driver;
  public LandingPage landingPage; //kreiranje objekta kao public da bi sve klase mogle da pristupe

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
      ChromeOptions options = new ChromeOptions(); //kreiranje 'options' za HEADLESS mode

      WebDriverManager.chromedriver().setup(); //umemsto lokacije u pom.XML importujemo WebDriverManager
      // options.addArguments("headless"); // HEADLESS
      // driver = new ChromeDriver(options); // HEADLESS
      driver = new ChromeDriver();
      driver.manage().window().setSize(new Dimension(1440, 900)); //full screen
    } else if (browserName.equalsIgnoreCase("firefox")) {
      WebDriverManager.firefoxdriver().setup(); //umemsto lokacije u pom.XML importujemo WebDriverManager
      driver = new FirefoxDriver();
    } else if (browserName.equalsIgnoreCase("edge")) {
      WebDriverManager.edgedriver().setup(); //umemsto lokacije u pom.XML importujemo WebDriverManager
      driver = new EdgeDriver();
    }

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    return driver;
  }

  // OVO JE SAD MAXIMALNO GENERICKI NAPISANO I MOZE SE KORISTITI SVUDA
  public List<HashMap<String, String>> getJSONdataToMap(String filePath)
    throws IOException {
    //reading JSON to String
    String jsonContent = FileUtils.readFileToString(
      new File(filePath),
      StandardCharsets.UTF_8
    );
    //String to HashMap using Jackson Databind (from MVN repo)
    ObjectMapper mapper = new ObjectMapper();

    List<HashMap<String, String>> data = mapper.readValue(
      jsonContent,
      new TypeReference<List<HashMap<String, String>>>() {}
    );
    return data;
  }

  // SCREENSHOOT
  public String getScreenShoot(String testCaseName, WebDriver driver)
    throws IOException {
    TakesScreenshot slikajScreenshot = (TakesScreenshot) driver;
    File source = slikajScreenshot.getScreenshotAs(OutputType.FILE);

    File file = new File(
      System.getProperty("user.dir") + "//reports//" + testCaseName + ".png"
    );
    FileUtils.copyFile(source, file);

    return (
      System.getProperty("user.dir") + "//reports//" + testCaseName + ".png"
    );
  }

  @BeforeMethod(alwaysRun = true)
  public LandingPage launchApplication() throws IOException {
    driver = initializeDriver();
    landingPage = new LandingPage(driver);
    landingPage.goTo();
    return landingPage;
  }

  @AfterMethod(alwaysRun = true)
  public void teardown() {
    driver.close();
  }
}
