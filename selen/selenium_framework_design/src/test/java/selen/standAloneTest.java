package selen;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class standAloneTest {

  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://rahulshettyacademy.com/client");

    driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
    driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
    driver.findElement(By.id("login")).click();
  }
}
