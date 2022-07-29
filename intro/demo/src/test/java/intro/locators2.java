package intro;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class locators2 {

  public static void main(String[] args) throws InterruptedException {
    String ime = "Dejan";

    System.setProperty(
      "webdriver.chrome.driver",
      //  "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
      "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    );
    WebDriver driver = new ChromeDriver(); //uvek pisem WebDriver

    // System.setProperty(                       pokretanje preko MS EDGE
    //   "webdriver.edge.driver",
    //   "C:/Users/dst/Documents/edgedriver_win64/msedgedriver.exe"
    // );
    // WebDriver driver = new EdgeDriver();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait - koliko da selenium ceka

    String sifra = getPassword(driver);

    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    driver.findElement(By.id("inputUsername")).sendKeys(ime);

    driver.findElement(By.name("inputPassword")).sendKeys(sifra);
    driver.findElement(By.className("signInBtn")).click();
    Thread.sleep(2000); // sacekaj 2 sekunde
    System.out.println(driver.findElement(By.tagName("p")).getText());
    Assert.assertEquals( //Asertacija
      driver.findElement(By.tagName("p")).getText(),
      "You are successfully logged in."
    );
    Assert.assertEquals(
      driver.findElement(By.tagName("h2")).getText(),
      "Hello " + ime + "," // kreirao sam varijablu  String ime = "Dejan";   zbog asertacije
    );
    driver.findElement(By.xpath("//button[text()='Log Out']")).click(); // XPATH preko konkretne reci
    // mogao sam i ovako selektovani //*[text()='Log Out'   zvezdica zamenjuje TAG name

    driver.close(); //zatvaram browser
  }

  public static String getPassword(WebDriver driver)
    throws InterruptedException {
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    driver.findElement(By.linkText("Forgot your password?")).click();
    Thread.sleep(2000); // sacekaj 2 sekunde
    driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

    String passwordText = driver
      .findElement(By.cssSelector("form p"))
      .getText(); // stavljam teks u varijablu

    //Please use temporary password 'rahulshettyacademy' to Login.   - ovo je tekst

    String[] passwordArray = passwordText.split("'"); //koristim ' da splitujem
    String password = passwordArray[1].split("'")[0];

    return password;
  }
}
