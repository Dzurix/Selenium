package utils_sveStoTrebaZaOdrzavanje;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import pageObjects.pageObjectManager;

public class utils {

  public WebDriver driver; // napravim ga public, kako bih mogao da ga koristim svuda
  public String landingPageProductName; // isto i sa ovim varijablama
  public String offerPageProductName;
  public pageObjectManager PageObjectManager;
  public TestBase testBase;
  public GenericUtils genericUtils;

  public utils() throws IOException { //konstruktor
    testBase = new TestBase();
    PageObjectManager = new pageObjectManager(testBase.WebDriverManager()); // ovako je sad objekat spreman za kreiranje
    genericUtils = new GenericUtils(testBase.WebDriverManager()); // ovo je sad DRIVER (testBase.WebDriverManager()) iz TEST BASE i mozemo kreirati objekat
  }
}
