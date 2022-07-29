package intro;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class locators {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty(
      "webdriver.chrome.driver",
      //  "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
      "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    );

    WebDriver driver = new ChromeDriver(); //uvek pisem WebDriver

    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    driver.findElement(By.id("inputUsername")).sendKeys("Upoje");

    driver.findElement(By.name("inputPassword")).sendKeys("upoje");
    driver.findElement(By.className("signInBtn")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait - koliko da selenium ceka
    System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
    driver.findElement(By.linkText("Forgot your password?")).click();
    Thread.sleep(1000); //sacekaj 1 sekundu
    driver
      .findElement(By.xpath("//input[@placeholder='Name']")) // napisano kao XPATH  // i @
      .sendKeys("John");
    driver
      .findElement(By.cssSelector("input[placeholder='Email']")) // napisano kao CSS selektor
      .sendKeys("john@lolo.com");
    driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
    driver
      .findElement(By.xpath("//input[@type='text'][2]")) // XPATH napisano preko indeksiranja
      .sendKeys("john@gmail.com");
    // driver
    //   .findElement(By.cssSelector("input[type='text']:nth-child(4)")) //CSS selektor preko indeksiranja
    //   .sendKeys("12354658");

    driver.findElement(By.xpath("//form/input[3]")).sendKeys("5548682"); // XPATH preko Parent/Child opcije - kada nemamo atribute
    driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

    System.out.println(
      driver.findElement(By.cssSelector("form p")).getText() // CSS selektor preko Parent/Child opcije
    );

    driver
      .findElement(
        By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")
      )
      .click(); //XPATH kombinacija
    Thread.sleep(2000); //sacekaj dve sekunde
    driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Dejan");
    driver
      .findElement(By.cssSelector("input[type*='pass']"))
      .sendKeys("rahulshettyacademy"); //kako da trazim deo reci - pomocu * - CSS regular expression

    driver.findElement(By.id("chkboxOne")).click();
    driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); // XPATH - regular expression
  }
}
