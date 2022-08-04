package intro;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class greenKartApp {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty(
      "webdriver.chrome.driver",
      //  "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
      "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    );
    WebDriver driver = new ChromeDriver(); //uvek pisem WebDriver

    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// definisanje IMPLICIT WAIT-a

    WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5)); //definisanje EXPLICIT WAIT-a

    String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" }; //deklaracija ARRAY

    driver.get("https://rahulshettyacademy.com/seleniumPractise/");

    Thread.sleep(3000);

    addItems(driver, itemsNeeded); //pozivam metod
    //ovako izgleda kreiranje objekta ove klase

    // // greenKartApp b = new greenKartApp();

    // // b.addItems(driver, itemsNeeded);

    driver.findElement(By.cssSelector("img[alt='Cart']")).click(); // klik na korpu
    driver
      .findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]"))
      .click();
    //EXPLICIT WAIT
    w.until(
      ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector("input.promoCode")
      )
    );

    driver
      .findElement(By.cssSelector("input.promoCode"))
      .sendKeys("rahulshettyacademy");

    driver.findElement(By.cssSelector("button.promoBtn")).click();

    //EXPLICIT WAIT
    w.until(
      ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector("span.promoInfo")
      )
    );

    System.out.println(
      driver.findElement(By.cssSelector("span.promoInfo")).getText()
    );
  }

  //kreiranje metoda izvan MAIN-a

  public static void addItems(WebDriver driver, String[] itemsNeeded) {
    List<WebElement> products = driver.findElements(
      // List<WebElement> pisem posto ima vise od jednog elementa (inace bi bio samo jedan WebElement)
      By.cssSelector("h4.product-name")
    );

    int j = 0; //ovo je da vidim koliko puta se petlja ponavlja

    for (int i = 0; i < products.size(); i++) {
      //format it to get actual vegetable name
      String name = products.get(i).getText().split("-")[0].trim();

      //check if name you extracted is present in array or not
      // convert array into array list for easy search

      List itemsNeededList = Arrays.asList(itemsNeeded);

      if (itemsNeededList.contains(name)) {
        j++;

        //click on "ADD TO CART"
        driver
          .findElements(By.xpath("//div[@class='product-action']/button"))
          .get(i)
          .click();
        //PAZI NA findElementSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS  mnozina
        //  break; //uvek prekini kad nadjes
        //break NE MOZE da se koristi kod ArrayList, jer nece ici dalje od prvog nadjenog elementa

        if (j == itemsNeeded.length) break; //ako se tri (posto imamo tri povrca koja trazimo) puta petlja ponovila, break
      }
    }
  }
}
