package end2endPOM;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// inheritance se postize preko 'extends'
public class LandingPage extends AbstractComponent {

  WebDriver driver;

  public LandingPage(WebDriver driver) {
    // OVO JE KONSTRUKTOR koji nam pomaze da importujemo driver
    //- ima isto ime kao i ime klase
    // - OVO JE prvi metod koji se izvrsava ko koristi ovu klasu
    // - najbolje mesto da se napise kod za inicijalizaciju

    this.driver = driver; // inicijalizacija
    //ovo je za PageFactory
    PageFactory.initElements(driver, this);
  }

  // WebElement userEmail = driver.findElement(By.id("userEmail"));

  //PageFactory - kraci nacin pisanja

  @FindBy(id = "userEmail")
  WebElement userEmail;

  // @FindBy(className (ili css , ili xpath) = "userEmail")
  // WebElement userEmail;

  @FindBy(id = "userPassword")
  WebElement userPassword;

  @FindBy(id = "login")
  WebElement submit;

  //ACTION metods

  public void goTo() {
    driver.get("https://rahulshettyacademy.com/client");
  }

  public void loginApplication(String email, String password) {
    userEmail.sendKeys(email);
    userPassword.sendKeys(password);
    submit.click();
  }
}
