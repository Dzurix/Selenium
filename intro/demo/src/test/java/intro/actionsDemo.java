package intro;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

  public static void main(String[] args) {
    System.setProperty(
      "webdriver.chrome.driver",
      "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
      // "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    );
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize(); //maximiziranje prozora
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

    driver.get("https://jqueryui.com/droppable/");
    driver
      .switchTo()
      .frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
    System.out.println(driver.findElements(By.tagName("iframe")).size()); //da vidim koliko ima frejmova

    Actions a = new Actions(driver);
    WebElement source = driver.findElement(By.id("draggable"));
    WebElement target = driver.findElement(By.id("droppable"));

    a.dragAndDrop(source, target).build().perform();

    driver.switchTo().defaultContent(); //ovako izlazim iz frejma
  }
}
