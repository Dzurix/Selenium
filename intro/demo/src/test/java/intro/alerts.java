package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alerts {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty(
      "webdriver.chrome.driver",
      //  "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
      "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    );
    WebDriver driver = new ChromeDriver(); //uvek pisem WebDriver

    String ime = "Upoje";

    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    driver.findElement(By.id("name")).sendKeys(ime);

    driver.findElement(By.cssSelector("[id='alertbtn']")).click();

    //kako da se prebacim na alerts sa jednom opcijom
    System.out.println(driver.switchTo().alert().getText()); //da vidim poruku iz alerta
    driver.switchTo().alert().accept(); //klik na alert

    //kako da se prebacim na alerts sa dve opcije

    driver.findElement(By.id("confirmbtn")).click();

    System.out.println(driver.switchTo().alert().getText()); //da vidim poruku iz alerta
    driver.switchTo().alert().dismiss(); //da odbacim poruku (klik na cancel, no, ...)
  }
}
