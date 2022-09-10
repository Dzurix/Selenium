package intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert; //importovanje preko depencency umesto importovanje TestNG JAR-a

public class dropdowns {

  public static void main(String[] args) throws InterruptedException {
    // System.setProperty(
    //   "webdriver.chrome.driver",
    //   //  "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
    //   "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    // );

    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver(); //uvek pisem WebDriver

    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    //select dropdown with 'select' tag

    WebElement staticDropdown = driver.findElement(
      By.id("ctl00_mainContent_DropDownListCurrency") //hvatamo dropdown listu
    );

    //Staticni dropdown

    Select dropdown = new Select(staticDropdown); //kreirali smo objekat od te klase

    dropdown.selectByIndex(3); //selektovanje staticnog dropdowna preko zero-indeks
    System.out.println(dropdown.getFirstSelectedOption().getText()); // provera sta smo selektovali, tj da li smo selektovali 3 element
    dropdown.selectByVisibleText("AED"); //selektujemo direktno preko opcije iz liste
    System.out.println(dropdown.getFirstSelectedOption().getText()); // provera sta smo selektovali, tj da li smo selektovali AED
    dropdown.selectByValue("INR"); // value je atribut
    System.out.println(dropdown.getFirstSelectedOption().getText());

    //Dinamicni dropdown

    driver.findElement(By.id("divpaxinfo")).click();
    Thread.sleep(2000);

    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

    // primer kako da kliknemo vise puta na jedan element
    //PREKO WHILE LOOP
    // int i = 1;
    // while (i < 5) {
    //   driver.findElement(By.id("hrefIncAdt")).click(); // 4 puta se izvrsilo
    //   i++;
    // }

    //Preko FOR LOOP
    for (int i = 1; i < 5; i++) {
      driver.findElement(By.id("hrefIncAdt")).click(); // 4 puta se izvrsilo
    }

    driver.findElement(By.id("btnclosepaxoption")).click();
    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    // DINAMICNI DROPDOWN sa indeksima - drugi primer

    driver
      .findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"))
      .click();
    driver.findElement(By.xpath("//a[@value='BLR']")).click();
    Thread.sleep(2000);

    // driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

    // na drugi nacin napisano
    driver
      .findElement(
        By.xpath(
          "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']" //parent child relationship XPATH
        )
      )
      .click();
    //AUTOSUGESTIVE DROPDOWNS

    driver.findElement(By.id("autosuggest")).sendKeys("ind");
    Thread.sleep(2000);

    List<WebElement> options = driver.findElements(
      By.cssSelector("li[class ='ui-menu-item'] a")
    );

    // petlja za autosugestive dropdowns
    for (WebElement option : options) {
      if (option.getText().equalsIgnoreCase("India")) {
        option.click();
        break; // kad nadjemo, izadji iz petlje
      }
    }
    //CHECKBOX

    driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
    System.out.println(
      driver
        .findElement(By.cssSelector("input[id*='friendsandfamily']"))
        .isSelected()
    ); // da li smo selektovali

    System.out.println(
      driver.findElements(By.cssSelector("input[type='checkbox']")).size()
    ); //da prebrojimo koliko ima checkbox

    //ASSERTIONS

    Assert.assertTrue( //ocekujem TRUE da je selektovan
      driver
        .findElement(By.cssSelector("input[id*='friendsandfamily']"))
        .isSelected()
    );
    Assert.assertFalse( // Ocekujem FALSE da je selektovan
      driver
        .findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"))
        .isSelected()
    );

    Assert.assertEquals( //proveri koliko sam uneo putnika
      driver.findElement(By.id("divpaxinfo")).getText(),
      "5 Adult"
    );

    //selektovanje radio button-a
    System.out.println(
      driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled()
    ); //false
    driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
    System.out.println(
      driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled()
    ); //true

    //kako proveriti da li je nesto disabled ili highlighted pomocu seleniuma

    if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
      System.out.println("it's enabled");
      Assert.assertTrue(true);
    } else {
      System.out.println("it's not enabled");
      Assert.assertFalse(false);
    }

    //kliknemo na 'submit'
    driver
      .findElement(
        By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']")
      )
      .click();
  }
}
