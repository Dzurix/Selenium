package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sellintroduction {

  public static void main(String[] args) {
    // CHROME launch

    System.setProperty(
      "webdriver.chrome.driver",
      "C://Users/dst/Documents/chromedriver_win32/chromedriver.exe"
    );

    WebDriver driver1 = new ChromeDriver(); //uvek pisem WebDriver

    driver1.get("https://rahulshettyacademy.com");
    System.out.println(driver1.getTitle());
    System.out.println(driver1.getCurrentUrl());

    // FIREFOX launch
    //geckodriver

    System.setProperty(
      "webdriver.gecko.driver",
      "C:/Users/dst/Documents/geckodriver-v0.31.0-win64/geckodriver.exe"
    );
    WebDriver driver2 = new FirefoxDriver();

    driver2.get("https://rahulshettyacademy.com");
    System.out.println(driver2.getTitle());
    System.out.println(driver2.getCurrentUrl());

    //EDGE launch

    System.setProperty(
      "webdriver.edge.driver",
      "C:/Users/dst/Documents/edgedriver_win64/msedgedriver.exe"
    );
    WebDriver driver3 = new EdgeDriver();

    driver3.get("https://rahulshettyacademy.com");
    System.out.println(driver3.getTitle());
    System.out.println(driver3.getCurrentUrl());
    //driver.close(); // zatvaram samo trenutni browser
    // driver.quit(); // zatvara sve prozore koji su otvoreni preko Seleniuma

  }
}
