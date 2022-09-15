package end2endPOM;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// inheritance se postize preko 'extends'
public class LandingPage extends AbstractComponent {

  // AbstractComponet je parrent , a ova klasa je child
  WebDriver driver;

  // OVO JE KONSTRUKTOR koji nam pomaze da importujemo driver
  // samo konstruktori mogu da hvataju varijable
  //- ima isto ime kao i ime klase
  // - OVO JE prvi metod koji se izvrsava ko koristi ovu klasu
  // - najbolje mesto da se napise kod za inicijalizaciju
  public LandingPage(WebDriver driver) {
    // pomocu 'super' saljemo driver (varijablu) to parrentu
    // ali da bi parrent uhvatio taj driver (varijablu) moramo to da radimo u KONSTRUKTORU
    super(driver);
    this.driver = driver; // inicijalizacija
    //ovo je za PageFactory
    PageFactory.initElements(driver, this);
    //add for commit
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

  @FindBy(css = "[class*='flyInOut']")
  WebElement errorMessage;

  //ACTION metods

  public void goTo() {
    driver.get("https://rahulshettyacademy.com/client");
  }

  public String getErrorMessage() {
    waitForWebElementToAppear(errorMessage);
    return errorMessage.getText();
  }

  public ProductCatalogue loginApplication(String email, String password) {
    userEmail.sendKeys(email);
    userPassword.sendKeys(password);
    submit.click();
    //kreiranje novog objekta od te klase
    // da ne moramo stalno da pisemo svaki put objekat
    ProductCatalogue productCatalogue = new ProductCatalogue(driver);
    return productCatalogue;
  }
}
