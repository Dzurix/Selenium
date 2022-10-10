package end2end.ChromeDevTools;

import com.google.common.base.Predicate;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.URI;
import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthentication {

  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();

    // //Ovako se resava WINDOW POP UP (tj. BASIC AUTH kod svakog logovanja na neki environment)
    Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");

    ((HasAuthentication) driver).register(
        uriPredicate,
        UsernameAndPassword.of("foo", "bar")
      );

    driver.get("http://httpbin.org/basic-auth/foo/bar");

    // DRUGI nacin resavanja preko URL   =>    http://Username:Password@SiteURL

    driver.get("https://foo:bar@httpbin.org/basic-auth/foo/bar");
    driver.findElement(By.linkText("Basic Auth")).click();
  }
}
