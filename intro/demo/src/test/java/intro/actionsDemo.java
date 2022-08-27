package intro;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class actionsDemo {

  /**
   * @param args
   * @throws InterruptedException
   * @throws IOException
   * @throws MalformedURLException
   */
  public static void main(String[] args)
    throws InterruptedException, IOException, MalformedURLException {
    System.setProperty(
      "webdriver.chrome.driver",
      "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
      //"C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
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

    // // WORKING WITH CALENDARS

    // driver.get(
    //   "http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html"
    // );
    // // Avgust 27
    // driver.findElement(By.id("datepicker")).click();

    // // kako da klikce dugme dok ne bude zeljeni mesec preko WHILE LOOP-a
    // while (
    //   !driver
    //     .findElement(By.className("ui-datepicker-month"))
    //     .getText()
    //     .contains("April")
    // ) {
    //   driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
    // }
    // List<WebElement> dates = driver.findElements(
    //   By.className("ui-state-default")
    // );

    // //Grab common attribute => Put inot list => Iterate through it
    // int count = driver.findElements(By.className("ui-state-default")).size();

    // for (int i = 0; i < count; i++) {
    //   String text = driver
    //     .findElements(By.className("ui-state-default"))
    //     .get(i)
    //     .getText();

    //   if (text.equalsIgnoreCase("23")) {
    //     driver.findElements(By.className("ui-state-default")).get(i).click();
    //     break;
    //   }
    // }

    // //SCROLLING
    // //Uvek je dobro da se pozicioniramo na deo web stranice na kojoj vrsimo testove
    // // na primer da u HEADLESS modu mozemo pokrenuti testove (posto pravi probleme ako nije pozicioniran na taj deo stranice)

    // driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    // JavascriptExecutor js = (JavascriptExecutor) driver; // pozivam ovu klasu kako bi mogao da radim sa JS

    // js.executeScript("window.scrollBy(0,500)");
    // Thread.sleep(3000);

    // js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000"); //hvatam manju tabelu i skrolujem isto kao preko Cypress

    // // Rad sa tabelama
    // List<WebElement> values = driver.findElements(
    //   By.cssSelector(".tableFixHead td:nth-child(4)")
    // );
    // int sum = 0;
    // for (int i = 0; i < values.size(); i++) {
    //   Integer.parseInt(values.get(i).getText()); //ovako text prebacujem u ceo broj

    //   sum = sum + Integer.parseInt(values.get(i).getText());
    // }
    // System.out.println(sum);

    // // poredjenje dve vrednosti

    // int total = Integer.parseInt(
    //   driver
    //     .findElement(By.cssSelector(".totalAmount"))
    //     .getText()
    //     .split(":")[1].trim()
    // );

    // Assert.assertEquals(sum, total); //asertacija za poredjenje vrednosti

    // // HANDLING HTTPS certifications
    // ChromeOptions options = new ChromeOptions();

    // // ubacivanje Proxy- ja
    // Proxy proxy = new Proxy();

    // proxy.setHttpProxy("ipaddress:4444");

    // options.setCapability("proxy", proxy);

    // // set downloading directory
    // Map<String, Object> prefs = new HashMap<String, Object>();

    // prefs.put("download.default_directory", "/directory/path");

    // options.setExperimentalOption("prefs", prefs);
    // // FirefoxOptions options2 = new FirefoxOptions();
    // // EdgeOptions options3 = new EdgeOptions();

    // options.setAcceptInsecureCerts(true); // prihvati nesigurne sajtove
    // System.setProperty(
    //   "webdriver.chrome.driver",
    //   //"C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
    //   "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    // );
    // WebDriver driver = new ChromeDriver(options); // setuj options kao argument
    // driver.get("https://expired.badssl.com/");
    // System.out.println(driver.getTitle());

    // //TAKING SCREENSHOTS

    // driver.get(
    //   "https://mvnrepository.com/artifact/commons-io/commons-io/2.11.0"
    // );

    // File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    // FileUtils.copyFile(src, new File("C:/Users/dst/Documents/screenshot.png"));

    // CHECKING BROKEN LINKS

    // Java methods will call URL's and gets you the status code
    //Step 1 - get all URL's and gets status code

    // Step 2 - if status code > 400 then that URL is not working => link which tied to URL is broken
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    List<WebElement> links = driver.findElements(
      By.cssSelector("li[class='gf-li'] a")
    );

    SoftAssert softAss = new SoftAssert();

    for (WebElement link : links) {
      String url = link.getAttribute("href");

      HttpURLConnection conn = (HttpURLConnection) new URL(url)
        .openConnection();

      conn.setRequestMethod("HEAD");

      conn.connect();

      int respCode = conn.getResponseCode();

      System.out.println(respCode);

      softAss.assertTrue( // pozivam SOFT asertaciju
        respCode < 400,
        "The link with name " +
        link.getText() +
        " is broken with status code " +
        respCode
      );
      // if (respCode > 400) {
      //   System.out.println("The link with name " +
      //   link.getText() +
      //   " is broken with status code " +
      //   respCode
      //   );
      //   Assert.assertTrue(false); // ovo ce prekinuti izvrsavanje skripte jer je HARD asertacija
      //   // Zato uvodimo SOFT ASERTACIJU kako bi skripta nastavila da se izvrsava
      // }
    }
    softAss.assertAll(); // OVO MORAM DA POZOVEM DA BI SE IZVRSILA ASERTACIJA
  }
}
