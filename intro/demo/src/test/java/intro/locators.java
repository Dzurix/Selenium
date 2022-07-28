package intro;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class locators {

  public static void main(String[] args) {
    System.setProperty(
      "webdriver.chrome.driver",
      "C://Users/dst/Documents/chromedriver_win32/chromedriver.exe"
    );

    WebDriver driver = new ChromeDriver(); //uvek pisem WebDriver

    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    driver.findElement(By.id("inputUsername")).sendKeys("Upoje");
    driver.findElement(By.name("inputPassword")).sendKeys("upoje");
    driver.findElement(By.className("signInBtn")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait - koliko da selenium ceka
    System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
    driver.findElement(By.linkText("Forgot your password?")).click();

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
    driver
      .findElement(By.cssSelector("input[type='text']:nth-child(4)")) //CSS selektor preko indeksiranja
      .sendKeys("12354658");
  }
}
