package end2endPOM;

import AbstractComponents.AbstractComponent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue extends AbstractComponent {

  // AbstractComponet je parrent , a ova klasa je child

  WebDriver driver;

  public ProductCatalogue(WebDriver driver) {
    // OVO JE KONSTRUKTOR koji nam pomaze da importujemo driver
    //- ima isto ime kao i ime klase
    // - OVO JE prvi metod koji se izvrsava ko koristi ovu klasu
    // - najbolje mesto da se napise kod za inicijalizaciju

    super(driver);
    this.driver = driver; // inicijalizacija
    //ovo je za PageFactory
    PageFactory.initElements(driver, this);
  }

  // WebElement userEmail = driver.findElement(By.id("userEmail"));

  //PageFactory - kraci nacin pisanja

  @FindBy(css = ".card-body")
  List<WebElement> products; //posto je mnozina, koristim 'List'

  By productsBy = By.cssSelector(".card-body");

  //ACTION metods

  public List<WebElement> getProductList() {
    waitForElementToAppear(productsBy);
    return products;
  }
}
