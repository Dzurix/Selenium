package utils_sveStoTrebaZaOdrzavanje;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;

public class GenericUtils {

  public WebDriver driver;

  public GenericUtils(WebDriver driver) { //konstruktor zbog drivera
    this.driver = driver;
  }

  public void SwithcWindowToChild() {
    Set<String> s1 = driver.getWindowHandles(); // hvatanje Indeksa od otvorenih prozora
    Iterator<String> i1 = s1.iterator(); // kreiram objekat
    String parentWindow = i1.next(); // hvatam indeks [0]
    String childWindow = i1.next();
    driver.switchTo().window(childWindow); // sad smo na drugom prozoru i sad je ceo fokus na tom prozoru
  }
}
