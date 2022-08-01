package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators3 {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty(
      "webdriver.chrome.driver",
      //  "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
      "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    );
    WebDriver driver = new ChromeDriver(); //uvek pisem WebDriver
    // Sibling - CHild to parent traverse

    driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
    System.out.println(
      driver
        .findElement(
          By.xpath("//header/div/button[1]/following-sibling::button[1]")
        )
        .getText() //ovako se krecem na istom nivou izmedju ‘siblinga’ pomocu XPATH
    );

    System.out.println(
      driver
        .findElement(By.xpath("//header/div/button[1]/parent::div/button[2]"))
        .getText() // ovako se krecem od child ka parrentu   pomocu XPATH (ovo preko CSS nije moguce)
    );
  }
}
