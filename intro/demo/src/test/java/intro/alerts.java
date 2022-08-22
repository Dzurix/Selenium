package intro;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.naming.directory.DirContext;
import org.apache.commons.exec.ProcessDestroyer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class alerts {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty(
      "webdriver.chrome.driver",
      // "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
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

    //   WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

    //   driver.get("https://rahulshettyacademy.com/loginpagePractise/");

    //   driver
    //     .findElement(By.cssSelector("#username"))
    //     .sendKeys("rahulshettyacademy");

    //   driver.findElement(By.cssSelector("#password")).sendKeys("learning");
    //   driver.findElement(By.xpath("//label[2]/span[2]")).click();

    //   w.until(
    //     ExpectedConditions.visibilityOfElementLocated(
    //       By.cssSelector("div.modal-content")
    //     )
    //   );

    //   driver.findElement(By.cssSelector("#okayBtn")).click();

    //   WebElement staticDropdown = driver.findElement(
    //     By.cssSelector("select.form-control")
    //   ); //hvatamo dropdown listu

    //   Select dropdown = new Select(staticDropdown); //kreirali smo objekat od te klase

    //   dropdown.selectByValue("consult"); //selektovanje opcije "Consultant"

    //   driver.findElement(By.id("terms")).click(); //Accept terms

    //   driver.findElement(By.id("signInBtn")).click(); // sign in button

    //   //secekamo da se stranica ucita
    //   w.until(
    //     ExpectedConditions.urlMatches(
    //       "https://rahulshettyacademy.com/angularpractice/shop"
    //     )
    //   );

    //   //kupujem proizvod

    //   buyProduct(driver);

    //   driver
    //     .findElement(By.cssSelector("a[class='nav-link btn btn-primary']"))
    //     .click();
    // }

    // //kreiranje metoda izvan MAIN-a

    // public static void buyProduct(WebDriver driver) {
    //   List<WebElement> products = driver.findElements(
    //     // List<WebElement> pisem posto ima vise od jednog elementa (inace bi bio samo jedan WebElement)
    //     By.cssSelector("div.card-footer button")
    //   );

    //   for (int i = 0; i < products.size(); i++) {
    //     products.get(i).click();
    //   }

    //ASIGNMENT 4

    // driver.get("https://the-internet.herokuapp.com/");

    // driver.findElement(By.cssSelector("a[href='/windows']")).click();
    // driver.findElement(By.cssSelector("a[href='/windows/new']")).click();

    // Set<String> numOfWindows = driver.getWindowHandles(); // sad su dodeljeni ID od aktivnih prozora
    // Iterator<String> windowID = numOfWindows.iterator(); // skladistim ID od parenta i child

    // String parentID = windowID.next(); //skladistim ID od parenta
    // String childID = windowID.next(); // kada ga opet pozovem, prelazim na CHILD prozor

    // driver.switchTo().window(childID);

    // String childText = driver.findElement(By.tagName("h3")).getText();
    // System.out.println(childText);

    // driver.switchTo().window(parentID);
    // String parentText = driver.findElement(By.tagName("h3")).getText();
    // System.out.println(parentText);

    //ASSIGNMENT 5

    // driver.get("https://the-internet.herokuapp.com/");

    // driver.findElement(By.linkText("Nested Frames")).click();
    // driver.switchTo().frame("frame-top");
    // driver
    //   .switchTo()
    //   .frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));

    // System.out.println(driver.findElement(By.id("content")).getText());

    //ASSIGNMENT 6

    driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    WebElement nameCheckBox = driver.findElement(By.id("checkBoxOption3"));
    nameCheckBox.click();

    String imeCheck = nameCheckBox.getText();

    System.out.println(imeCheck);
    // WebElement staticDropdown = driver.findElement(
    //   By.id("dropdown-class-example")
    // );

    // Select dropdown = new Select(staticDropdown);

    // dropdown.selectByValue(imeCheck);
  }
}
