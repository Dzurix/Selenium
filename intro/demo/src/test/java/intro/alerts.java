package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class alerts {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty(
      "webdriver.chrome.driver",
      //  "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
      "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    );
    WebDriver driver = new ChromeDriver(); //uvek pisem WebDriver
    // String ime = "Upoje";

    //driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    // driver.findElement(By.id("name")).sendKeys(ime);

    // driver.findElement(By.cssSelector("[id='alertbtn']")).click();

    // //kako da se prebacim na alerts sa jednom opcijom
    // System.out.println(driver.switchTo().alert().getText()); //da vidim poruku iz alerta
    // driver.switchTo().alert().accept(); //klik na alert

    // //kako da se prebacim na alerts sa dve opcije

    // driver.findElement(By.id("confirmbtn")).click();

    // System.out.println(driver.switchTo().alert().getText()); //da vidim poruku iz alerta
    // driver.switchTo().alert().dismiss(); //da odbacim poruku (klik na cancel, no, ...)

    //Asignment 1

    // driver.findElement(By.id("checkBoxOption1")).click();
    // System.out.println(
    //   driver.findElement(By.id("checkBoxOption1")).isSelected()
    // );
    // driver.findElement(By.id("checkBoxOption1")).click();
    // System.out.println(
    //   driver.findElement(By.id("checkBoxOption1")).isSelected()
    // );

    //Assignment 2

    // driver.get("https://rahulshettyacademy.com/angularpractice/");

    // driver.findElement(By.name("name")).sendKeys("Upoje");
    // driver.findElement(By.name("email")).sendKeys("upoje@upojevic.com");
    // driver.findElement(By.id("exampleInputPassword1")).sendKeys("321Upoje");
    // driver.findElement(By.id("exampleCheck1")).click();

    // WebElement staticDropdown = driver.findElement(
    //   By.id("exampleFormControlSelect1")
    // );

    // Select dropdown = new Select(staticDropdown);

    // dropdown.selectByVisibleText("Male");

    // driver.findElement(By.id("inlineRadio1")).click();
    // driver
    //   .findElement(By.cssSelector("input[name='bday']"))
    //   .sendKeys("04/04/2040");

    // driver
    //   .findElement(By.cssSelector("input[class='btn btn-success']"))
    //   .click();

    // System.out.println(
    //   driver
    //     .findElement(
    //       By.cssSelector("div[class='alert alert-success alert-dismissible']")
    //     )
    //     .getText()
    // );
    // ASIGNMENT 3

    driver.get("https://rahulshettyacademy.com/loginpagePractise/");

    driver
      .findElement(By.cssSelector("#username"))
      .sendKeys("rahulshettyacademy");

    driver.findElement(By.cssSelector("#password")).sendKeys("learning");
    driver.findElement(By.xpath("//label[2]/span[2]")).click();

    driver.findElement(By.cssSelector("div.modal-content")).click();
    driver.switchTo().alert().accept();
  }
}
