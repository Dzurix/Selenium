package selen;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.Action;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class standAloneTest {

  public static void main(String[] args) {
    String productName = "ZARA COAT 3";
    WebDriverManager.chromedriver().setup(); //umemsto lokacije u pom.XML importujemo WebDriverManager

    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://rahulshettyacademy.com/client");

    driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
    driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
    driver.findElement(By.id("login")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    wait.until(
      ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector(".card-body")
      )
    );

    List<WebElement> products = driver.findElements(
      By.cssSelector(".card-body")
    );

    WebElement prod = products
      .stream()
      .filter(
        product ->
          product.findElement(By.tagName("b")).getText().equals(productName)
      )
      .findFirst()
      .orElse(null);

    prod.findElement(By.cssSelector(".card-body button:last-of-type")).click(); //dodavanje proizvoda u korpu
    //cekamo da se pojavi poruka da smo ubacili proizvod u korpu

    wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.id("toast-container"))
    );

    //cekamo da se skloni ona animacija nakon narucivanja proizvoda
    wait.until(
      ExpectedConditions.invisibilityOf(
        driver.findElement(By.cssSelector(".ng-animating"))
      )
    ); //kad koristimo INVISIBILITY, onda treba cela putanja sa driver.....

    driver
      .findElement(By.cssSelector("[routerlink='/dashboard/cart']"))
      .click();

    //Provera sta imamo u korpi

    List<WebElement> listaKorpa = driver.findElements(
      By.cssSelector(".cartSection h3")
    );

    Boolean poklapanje = listaKorpa
      .stream()
      .anyMatch(p -> p.getText().equalsIgnoreCase(productName));

    Assert.assertTrue(poklapanje);

    // Odlazak na checkout
    driver.findElement(By.cssSelector(".totalRow button")).click();

    Actions a = new Actions(driver);

    a
      .sendKeys(
        driver.findElement(By.cssSelector("[placeholder = 'Select Country']")),
        "Yugo"
      )
      .build()
      .perform();

    wait.until(
      ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector(".ta-results")
      )
    );

    driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
    driver.findElement(By.cssSelector("action__submit")).click();

    String confirmMessage = driver
      .findElement(By.cssSelector(".hero-primary"))
      .getText();

    Assert.assertTrue(
      confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER.")
    );
  }
}
