package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserActivities {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty(
      "webdriver.chrome.driver",
      //  "C:/Users/deki2/OneDrive/Documents/chromedriver_win32/chromedriver.exe" // LAPTOP
      "C:/Users/dst/Documents/chromedriver_win32/chromedriver.exe" //POSO
    );
    WebDriver driver = new ChromeDriver(); //uvek pisem WebDriver
    driver.manage().window().maximize(); // podesavanje browsera na ceo ekran
    driver.get("https://www.google.com/"); //pokretanje stranice - get metod ima inbuild WAIT funkciju ,tj cekace da se stranica kompletno ucita
    driver
      .navigate()
      .to("https://www.rahulshettyacademy.com/AutomationPractice/"); // pokretanje druge stranice tokom testa,bez WAIT funkcije, odmah krece

    driver.navigate().back(); //vracanje nazad
    driver.navigate().forward(); //ponovno vracanje
  }
}
