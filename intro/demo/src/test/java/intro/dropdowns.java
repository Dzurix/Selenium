package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdowns {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty(
      "webdriver.chrome.driver",
      //  "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
      "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    );
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
    // driver.findElement(By.xpath("//a[@value='MAA']")).click();
    driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
  }
}
