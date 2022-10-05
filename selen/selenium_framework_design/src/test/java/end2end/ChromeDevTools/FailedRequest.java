package end2end.ChromeDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Arrays;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.fetch.Fetch;
import org.openqa.selenium.devtools.v102.fetch.model.RequestPattern;


public class FailedRequest {

  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();

    DevTools devTools = driver.getDevTools();

    // kreiranje sesije
    devTools.createSession();

    //prvo moramo kreirati patern koji hocemo
    //sa Optional.empty cemo blokirati sve requestove, ali to necemo  nego samo za GetBook cemo napraviti patern

 paterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));
    devTools.send(Fetch.enable(null, null))
  }
}
