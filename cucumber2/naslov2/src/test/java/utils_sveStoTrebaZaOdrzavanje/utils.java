package utils_sveStoTrebaZaOdrzavanje;

import org.openqa.selenium.WebDriver;
import pageObjects.pageObjectManager;

public class utils {

  public WebDriver driver; // napravim ga public, kako bih mogao da ga koristim svuda
  public String landingPageProductName; // isto i sa ovim varijablama
  public String offerPageProductName;
  public pageObjectManager PageObjectManager;

  public utils() { //konstruktor
    PageObjectManager = new pageObjectManager(driver); // ovako je sad objekat spreman za kreiranje
  }
}
