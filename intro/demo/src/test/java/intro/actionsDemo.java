package intro;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty(
      "webdriver.chrome.driver",
      //"C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
      "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    );
    WebDriver driver = new ChromeDriver();
    // driver.manage().window().maximize(); //maximiziranje prozora
    // driver.get("https://www.amazon.com/");
    // Actions a = new Actions(driver); // definisanje klase ACTIONS

    // // move to specific element
    // a
    //   .moveToElement(
    //     driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))
    //   )
    //   .contextClick()
    //   .build()
    //   .perform(); // sintaksa Actions klase

    // // koristim velika slova

    // a
    //   .moveToElement(
    //     driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))
    //   )
    //   .click()
    //   .keyDown(Keys.SHIFT)
    //   .sendKeys("hello")
    //   .doubleClick()
    //   .build()
    //   .perform();

    //CHILD WINDOWS vezba

    // driver.get("https://rahulshettyacademy.com/loginpagePractise/");

    // driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
    // Set<String> numOfWindows = driver.getWindowHandles(); // sad su dodeljeni ID od aktivnih prozora
    // Iterator<String> windowID = numOfWindows.iterator(); // skladistim ID od parenta i child

    // String parentID = windowID.next(); //skladistim ID od parenta
    // String childID = windowID.next(); // kada ga opet pozovem, prelazim na CHILD prozor

    // driver.switchTo().window(childID);

    // System.out.println(
    //   driver
    //     .findElement(By.cssSelector(".im-para.red"))
    //     .getText()
    //     .split("at")[1].trim()
    //     .split(" ")[0]
    // );
    // // izvlacim samo naziv email
    // String emailID = driver
    //   .findElement(By.cssSelector(".im-para.red"))
    //   .getText()
    //   .split("at")[1].trim()
    //   .split(" ")[0];

    // driver.switchTo().window(parentID); //prebacujem se na GLAVNI prozor

    // driver.findElement(By.id("username")).sendKeys(emailID);

    //FRAMES vezba

    // driver.get("https://jqueryui.com/droppable/");
    // driver
    //   .switchTo()
    //   .frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
    // System.out.println(driver.findElements(By.tagName("iframe")).size()); //da vidim koliko ima frejmova

    // Actions a = new Actions(driver);
    // WebElement source = driver.findElement(By.id("draggable"));
    // WebElement target = driver.findElement(By.id("droppable"));

    // a.dragAndDrop(source, target).build().perform();

    // driver.switchTo().defaultContent(); //ovako izlazim iz frejma

    // HOW TO PRINT THE LINKS COUNT IN THE PAGE

    // driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    // System.out.println(driver.findElements(By.tagName("a")).size()); //kako da pronadjem linkove preko 'a' href

    // // broj linkova u footeru - treba da smanjimo WebDriver SCOPE, da bi samo footer pregledao

    // WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //smanjivanje SCOPA preko WebElementa

    // System.out.println(footerDriver.findElements(By.tagName("a")).size());

    // WebElement columnDriver = footerDriver.findElement(
    //   By.xpath("//table/tbody/tr/td[1]/ul")
    // ); // da pronadjem jos manji SCOPE

    // System.out.println(columnDriver.findElements(By.tagName("a")).size());
    // // how to click on each link in the column adn check if the pages are opening

    // for (
    //   int i = 1;
    //   i < columnDriver.findElements(By.tagName("a")).size();
    //   i++
    // ) {
    //   String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER); // klik na tockic na misu (kao da je klikno)

    //   columnDriver
    //     .findElements(By.tagName("a"))
    //     .get(i)
    //     .sendKeys(clickOnLinkTab);
    // } // sa ovim FOR loopom otvaramo sve tabove (klikcemo na linkove)
    // Thread.sleep(5000);

    // Set<String> abc = driver.getWindowHandles();
    // Iterator<String> it = abc.iterator(); // iterator sluzi da menjamo tabove u browseru

    // while (it.hasNext()) { // dok god ima sledeci, predji na taj sledeci
    //   driver.switchTo().window(it.next());
    //   System.out.println(driver.getTitle());
    // }

    // WORKING WITH CALENDARS

    driver.get(
      "http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html"
    );
    // Avgust 27
    driver.findElement(By.id("datepicker")).click();

    // kako da klikce dugme dok ne bude zeljeni mesec preko WHILE LOOP-a
    while (
      !driver
        .findElement(By.className("ui-datepicker-month"))
        .getText()
        .contains("April")
    ) {
      driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
    }
    List<WebElement> dates = driver.findElements(
      By.className("ui-state-default")
    );

    //Grab common attribute => Put inot list => Iterate through it
    int count = driver.findElements(By.className("ui-state-default")).size();

    for (int i = 0; i < count; i++) {
      String text = driver
        .findElements(By.className("ui-state-default"))
        .get(i)
        .getText();

      if (text.equalsIgnoreCase("23")) {
        driver.findElements(By.className("ui-state-default")).get(i).click();
        break;
      }
    }
  }
}
