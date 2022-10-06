package end2end.ChromeDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogErrors {

  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();

    driver.get("https://rahulshettyacademy.com/angularAppdemo/");
    driver.findElement(By.linkText("Browse Products")).click();
    driver.findElement(By.linkText("Selenium")).click();
    driver.findElement(By.cssSelector(".add-to-cart")).click();
    driver.findElement(By.linkText("Cart")).click();
    driver.findElement(By.id("exampleInputEmail1")).clear();
    driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");

    LogEntries entry = driver.manage().logs().get(LogType.BROWSER); // Get LogEntries object

    //LogEntry object - getAll method return all logs

    List<LogEntry> logs = entry.getAll();

    //iterate through list and print each message
    for (LogEntry e : logs) {
      System.out.println(e.getMessage());
    }
  }
}
