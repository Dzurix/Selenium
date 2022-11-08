package pageObjects;

import org.openqa.selenium.WebDriver;

public class pageObjectManager {

  public LandingPage landingPage; //objekat za landing page
  public OffersPage offersPage; //objekat za offers page
  public WebDriver driver;

  public pageObjectManager(WebDriver driver) { //KONSTRUKTOR
    this.driver = driver;
  }

  public LandingPage getLandingPage() { //posto returnujemo OBJEKAT, onda umesto 'public void' ide public "IME OBJEKTA"
    landingPage = new LandingPage(driver);
    return landingPage;
  }

  public OffersPage getOffersPage() {
    offersPage = new OffersPage(driver);
    return offersPage;
  }
}
